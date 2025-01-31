

$(document).ready(function() {
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

    // 수량 입력 값 변경 시 이벤트
    $('#quantity').change(function() {
        // 현재 수량 값을 가져옴
        const quantity = parseInt($(this).val());
        // 총 금액 계산
        const totalPrice = pricePerUnit * quantity;
        // 총 금액을 업데이트
        $(".total_price .num_price").text(totalPrice.toLocaleString()); // 천 단위로 포맷팅
    });


});


