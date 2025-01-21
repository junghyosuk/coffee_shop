$(document).ready(function() {
    $(".btn_remove").click(function() {
        var prodNo = $(this).data("prod-no"); // 버튼에서 prodNo 값 가져오기
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
});