$(document).ready(function() {

    // CSRF 토큰 가져오기
    let csrfToken = $("meta[name='_csrf']").attr("content");
    let csrfHeader = $("meta[name='_csrf_header']").attr("content");


    // AJAX 요청 전에 CSRF 토큰을 추가
    $.ajaxSetup({
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token); // CSRF 헤더 설정
        }
    });

    var header = $("meta[name='_csrf_header']").attr('content');
    var token = $("meta[name='_csrf']").attr('content');

    //회원가입
    // 카카오 주소 검색 API
    $("#SignupfindAddress").click(function() {
        new daum.Postcode({
            oncomplete: function(data) {
                $("#SignupusersZipcode").val(data.zonecode); // 우편번호
                $("#SignupusersAddress1").val(data.roadAddress); // 도로명 주소
            }
        }).open();
    });

    //상품삭제 ajax
    $(".btn_remove").click(function() {
        const prodNo = $(this).data("prod-no"); // 버튼에서 prodNo 값 가져오기
        if (confirm("정말로 이 상품을 삭제하시겠습니까?")) {
            // 상품 삭제 요청
            $.ajax({
                url: "/admin/product/delete/" + prodNo,
                type: "GET",
                success: function(response) {
                    // 성공적으로 삭제된 경우 페이지를 새로 고침
                    location.reload();
                },
                error: function(xhr, status, error) {
                    alert("삭제 중 오류가 발생했습니다. 다시 시도해 주세요.");
                }
            });
        }
    });

    //상품수정
    $('.btn_modify').on('click', function() {
        const prodNo = $(this).data('prod-no');
        window.location.href = "/admin/product/modify/"+prodNo; // URL 결합
    });

    /* 상품 뷰 */

    // 수량 변경 시 총 금액 계산 및 hidden input 값 업데이트
    $('#optQuantity').on('input', function() {
        const quantity = parseInt($(this).val()) || 1; // NaN 방지
        const pricePerUnit = parseInt($('#unitPrice').text().replace(/,/g, '')) || 0; // NaN 방지
        const totalPrice = pricePerUnit * quantity;

        // UI 업데이트
        $("#totalPrice").text(totalPrice.toLocaleString());

        // Hidden input 값 업데이트
        $("#quantityInput").val(quantity);
        $("#totalPriceInput").val(totalPrice);
        $("#cartQuantity").val(quantity);
    });


    // 장바구니 버튼 클릭 시 확인
    $("#cartForm").on('submit', function(event) {
        event.preventDefault(); // 기본 폼 제출 방지

        // 수량 업데이트
        const quantity = $("#optQuantity").val();
        $("#cartQuantity").val(quantity); // 장바구니에 추가할 수량 업데이트

        // 폼 데이터 가져오기
        const formData = $(this).serialize();

        // AJAX 요청
        $.ajax({
            url: $(this).attr('action'),
            type: 'POST',
            data: formData,
            success: function(response) {
                alert(response); // 서버의 응답 메시지를 표시
                window.location.href = '/cart/list'; // 장바구니 페이지로 이동
            },
            error: function(xhr, status, error) {
                const errorMessage = xhr.responseText; // 서버에서 반환된 오류 메시지

                if (errorMessage.includes("해당 상품이 이미 장바구니에 있습니다.")) {
                    // 확인 대화상자 표시
                    const userConfirmed = confirm("해당 상품이 이미 장바구니에 있습니다. 장바구니로 이동하시겠습니까?");
                    if (userConfirmed) {
                        window.location.href = '/cart/list'; // 장바구니 페이지로 이동
                    }
                    // 취소를 선택한 경우 아무 행동도 하지 않음
                } else {
                    alert("장바구니 추가 중 오류가 발생했습니다: " + errorMessage);
                    console.error("Error:", errorMessage);
                }
            }
        });
    });

    // 주문 폼 제출 시 hidden input 업데이트
    $("#orderForm").submit(function(event) {
        const quantity = parseInt($("#quantityInput").val()) || 1;
        const totalPrice = parseInt($("#totalPriceInput").val()) || 0;

        console.log("quantity = " + quantity);
        console.log("totalPrice = " + totalPrice);

        if (isNaN(totalPrice) || totalPrice <= 0) {
            alert("총 금액이 올바르지 않습니다. 다시 시도해주세요.");
            event.preventDefault(); // 폼 제출 방지
            return;
        }

        // Hidden input 값 업데이트
        $("#quantityInput").val(quantity);
        $("#totalPriceInput").val(totalPrice);
    });




    /* 상품관리_상품추가 */
    $('#btnAddProduct').click(function() {
        $('.add_product').slideToggle(); // 슬라이드 다운/업
    });


    /* 장바구니 */
    // 전체 선택 체크박스
    $('#chkAll').change(function() {
        const isChecked = $(this).is(':checked');
        $('input[name="cartNo"]').prop('checked', isChecked);
    });

    // 각 상품 체크 시 전체 체크박스 업데이트
    $('input[name="cartNo"]').change(function() {
        const allChecked = $('input[name="cartNo"]').length === $('input[name="cartNo"]:checked').length;
        $('#chkAll').prop('checked', allChecked);
    });

    // 초기 가격 포맷팅 및 총합계 업데이트
    $('.product-price').each(function() {
        const price = parseInt($(this).text().replace(/,/g, '')) || 0;
        $(this).text(price.toLocaleString() + '원');
    });

    // 수량 변경 시 상품 가격 및 총 가격 업데이트
    $('.cart-quantity').on('change', function() {
        const quantity = parseInt($(this).val()) || 1;
        let pricePerUnit = $(this).data('prod-price');

        const totalPrice = pricePerUnit * quantity;
        $(this).closest("tr").find(".product-price").eq(0).text(totalPrice.toLocaleString() + '원');

        updateTotalPrice();
    });

    // 총합계 업데이트 함수
    function updateTotalPrice() {
        let total = 0;
        $('.cart-quantity').each(function() {
            const quantity = parseInt($(this).val()) || 1;
            let price = $(this).data('prod-price');

            total += quantity * price;
        });

        const shippingCost = total > 0 ? 3000 : 0; // 상품이 있을 때만 배송비 적용
        $('#total-price').text(total.toLocaleString() + '원');
        $('#shipping-cost').text(shippingCost.toLocaleString() + '원');
        $('#final-price').text((total + shippingCost).toLocaleString() + '원');
    }

    // 페이지 로드 시 총합 업데이트
    $('.cart-quantity').each(function() {
        const quantity = parseInt($(this).val()) || 1;
        const price = parseInt($(this).data('prod-price'));

        const totalPrice = quantity * price;
        $(this).closest("tr").find(".product-price").eq(0).text(totalPrice.toLocaleString() + '원');
    });

    // 개별 삭제 버튼 기능
     $(".btn-delete").off("click").click(function() {
        let cartNo = $(this).data("cart-no"); // 버튼에서 cartNo 값 가져오기

        if (confirm("해당 상품을 삭제하시겠습니까?")) {
            $.ajax({
                url: "/cart/delete",
                type: "POST",
                data: { cartNo: cartNo },
                beforeSend: function(xhr) {
                    // CSRF 토큰을 요청 헤더에 추가
                    xhr.setRequestHeader(csrfHeader, csrfToken);
                },
                success: function(response) {
                    alert("상품이 삭제되었습니다.");
                    location.reload(); // 삭제 후 페이지 새로 고침
                },
                error: function(xhr, status, error) {
                    alert("삭제 중 오류가 발생했습니다. 다시 시도해 주세요.");
                    console.error("Error:", xhr.responseText);
                }
            });
        }
    });

    // 선택한 상품 삭제 기능
    $("#btnSelectDelete").click(function () {
        let checkedItems = $("input[name='cartNo']:checked").map(function () {
            return $(this).val();
        }).get(); // 선택된 상품 ID 목록을 배열로 가져옴

        if (checkedItems.length === 0) {
            alert("삭제할 상품을 선택하세요.");
            return;
        }

        if (confirm("선택한 상품을 삭제하시겠습니까?")) {
            $.ajax({
                url: "/cart/deleteSelect",
                type: "POST",
                contentType: "application/json",  // ✅ JSON 형식으로 전송
                data: JSON.stringify(checkedItems),  // ✅ JSON 배열 형식으로 변환
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(csrfHeader, csrfToken);  // ✅ CSRF 토큰 추가
                },
                success: function (response) {
                    console.log("서버 응답:", response);  // ✅ 응답 확인
                    alert("선택한 상품이 삭제되었습니다.");
                    location.reload();  // 페이지 새로 고침
                },
                error: function (xhr) {
                    console.error("삭제 요청 오류:", xhr.responseText);  // ✅ 오류 메시지 출력
                    alert("삭제 중 오류가 발생했습니다. 다시 시도해 주세요.");
                }
            });
        }
    });

    // 페이지 로드 시 총합 업데이트
    updateTotalPrice();

    //상품뷰에서 주문
    // 수량 변경 시 hidden input 업데이트
    $("#optOrderQuantity").on("input", function() {
        let quantity = $(this).val();
        let pricePerUnit = parseInt($("#totalPriceInput").val());
        let totalPrice = quantity * pricePerUnit;

        $("#quantityInput").val(quantity);
        $("#totalPriceInput").val(totalPrice);
    });

    // 주문 폼 제출 시 hidden input 업데이트
    $("#orderForm").submit(function(event) {
        let quantity = $("#optOrderQuantity").val();
        let pricePerUnit = parseInt($("#totalPriceInput").val());
        let totalPrice = quantity * pricePerUnit;

        $("#quantityInput").val(quantity);
        $("#totalPriceInput").val(totalPrice);
    });

    //장바구니에서 주문
    // ✅ 체크박스 전체 선택 기능
    $("#chkAll").change(function() {
        $(".cartCheckbox").prop("checked", $(this).prop("checked"));
    });

    // ✅ 선택 상품 주문 처리
    $("#btnSelectOrder").click(function() {
        let selectedItems = $(".cartCheckbox:checked");
        if (selectedItems.length === 0) {
            alert("주문할 상품을 선택하세요.");
            return;
        }
        submitOrderForm(selectedItems);
    });

    // ✅ 전체 상품 주문 처리
    $("#btnAllOrder").click(function() {
        let allItems = $(".cartCheckbox");
        if (allItems.length === 0) {
            alert("장바구니에 상품이 없습니다.");
            return;
        }
        submitOrderForm(allItems);
    });

    // ✅ 주문 폼 데이터 설정 후 제출
    function submitOrderForm(items) {
        // 기존에 추가된 input들을 삭제
        $("#cartOrderForm input[name='prodNos']").remove();
        $("#cartOrderForm input[name='quantities']").remove();
        $("#cartOrderForm input[name='totalPrices']").remove();

        // 체크된 상품 데이터를 hidden input 형태로 추가
        items.each(function() {
            let prodNo = $(this).data("prodno");
            let quantity = $(this).data("quantity");
            let totalPrice = $(this).data("totalprice");

            $("#cartOrderForm").append(`<input type="hidden" name="prodNos" value="${prodNo}">`);
            $("#cartOrderForm").append(`<input type="hidden" name="quantities" value="${quantity}">`);
            $("#cartOrderForm").append(`<input type="hidden" name="totalPrices" value="${totalPrice}">`);
        });

        // 폼 제출
        $("#cartOrderForm").submit();
    }

    //주문페이지 주소 선택
    // "주문자 정보와 동일" 버튼 클릭 시 배송지 정보 자동 입력
    $("#copyUserInfo").click(function() {
        $("#ordersReceiverName").val($("#ordersUsersName").val());
        $("#ordersReceiverPhone").val($("#ordersUsersPhone").val());
    });

    // 카카오 주소 검색 API
    $("#findAddress").click(function() {
        new daum.Postcode({
            oncomplete: function(data) {
                $("#ordersReceiverZipcode").val(data.zonecode); // 우편번호
                $("#ordersReceiverAddress1").val(data.roadAddress); // 도로명 주소
            }
        }).open();
    });

    // ✅ 총 결제금액 계산 (배송비 3,000원 적용)
    function updateOrderTotalPrice() {
        let totalProductPrice = 0;
        $(".order-price").each(function() {
            totalProductPrice += parseInt($(this).text().replace(/,/g, '')) || 0;
        });

        let shippingCost = 3000;  // 🚀 배송비를 숫자로 직접 지정
        let finalPrice = totalProductPrice + shippingCost;

        $("#total-product-price").text(totalProductPrice.toLocaleString() + "원");
        $("#shipping-cost").text(shippingCost.toLocaleString() + "원");  // 🚀 배송비도 다시 설정
        $("#final-price").text(finalPrice.toLocaleString() + "원");
    }

    // 🚨 결제 버튼 클릭 시 배송지 정보 확인
    $("#orderSubmit").click(function(e) {
        if ($("#ordersReceiverName").val().trim() === "" ||
            $("#ordersReceiverPhone").val().trim() === "" ||
            $("#ordersReceiverZipcode").val().trim() === "" ||
            $("#ordersReceiverAddress1").val().trim() === "") {
            alert("🚨 배송지 정보를 입력해주세요!");
            e.preventDefault();
        }
    });

    // ✅ 페이지 로드 시 총 결제금액 업데이트 (배송비 포함)
    updateOrderTotalPrice();

});


