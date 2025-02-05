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
    // 상품 가격을 가져옴 (천 단위 구분 제거)
    const pricePerUnit = parseInt($('.num_price').text().replace(/,/g, ''));

    // 수량 변경 시 총 금액 계산
    $('#optQuantity').change(function() {
        const quantity = $(this).val();
        const pricePerUnit = parseInt($('.num_price').text().replace(/,/g, '')); // 가격 가져오기
        const totalPrice = pricePerUnit * quantity;
        $(".total_price .num_price").text(totalPrice.toLocaleString()); // 총 금액 업데이트
    });

    // 장바구니 버튼 클릭 시 확인
    $("#addToCartBtn").click(function (e) {
        e.preventDefault();  // 기본 폼 제출 방지
        let prodNo = $("input[name='prodNo']").val();
        let quantity = $("#cartQuantity").val();

        // AJAX 요청: 장바구니에 상품 존재 여부 확인(전체적으로 재확인 필요)
//        $.ajax({
//            url: "/cart/check",
//            type: "POST",
//            data: { prodNo: prodNo },
//            success: function (exists) {
//                if (exists) {
//                    // 상품이 이미 장바구니에 있을 경우 confirm 메시지 출력
//                    if (confirm("장바구니에 해당 상품이 이미 있습니다. 장바구니로 이동하시겠습니까?")) {
//                        window.location.href = "/cart/list"; // 장바구니 페이지로 이동
//                    }
//                } else {
//                    // 상품이 장바구니에 없으면 장바구니에 추가
//                    $.ajax({
//                        url: "/cart/add",
//                        type: "POST",
//                        data: { prodNo: prodNo, cartQuantity: quantity },
//                        success: function () {
//                            alert("장바구니에 추가되었습니다.");
//                            window.location.href = "/cart/list"; // 장바구니 페이지로 이동
//                        },
//                        error: function () {
//                            alert("장바구니 추가 중 오류가 발생했습니다.");
//                        }
//                    });
//                }
//            },
//            error: function () {
//                alert("상품 존재 여부 확인 중 오류가 발생했습니다.");
//            }
//        });
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

});


