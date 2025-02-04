

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
    $('#optQuantity').change(function() {
        // 현재 수량 값을 가져옴
        const quantity = parseInt($(this).val());
        // 총 금액 계산
        const totalPrice = pricePerUnit * quantity;
        // 총 금액을 업데이트
        $(".total_price .num_price").text(totalPrice.toLocaleString()); // 천 단위로 포맷팅
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

   // 초기 가격 포맷팅
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
   updateTotalPrice();

   // 개별 삭제 버튼 기능
   $(".btn-delete").click(function () {
       let cartNo = $(this).data("cart-no");
       if (confirm("해당 상품을 삭제하시겠습니까?")) {
           $.ajax({
               url: "/cart/delete",
               type: "POST",
               data: { cartNo: cartNo },
               beforeSend: function(xhr) {
                   xhr.setRequestHeader("X-CSRF-TOKEN", $('meta[name="_csrf"]').attr('content'));
               },
               success: function() {
                   location.reload();
               },
               error: function() {
                   alert("삭제 중 오류가 발생했습니다. 다시 시도해 주세요.");
               }
           });
       }
   });

   // 전체 삭제 버튼 기능
   $(".btn-danger").click(function () {
       let checkedItems = $("input[name='cartNo']:checked").map(function() {
           return $(this).val();
       }).get();

       if (checkedItems.length === 0) {
           alert("삭제할 상품을 선택하세요.");
           return;
       }

       if (confirm("선택한 상품을 삭제하시겠습니까?")) {
           $.ajax({
               url: "/cart/deleteAll",
               type: "POST",
               data: { cartNos: checkedItems },
               beforeSend: function(xhr) {
                   xhr.setRequestHeader("X-CSRF-TOKEN", $('meta[name="_csrf"]').attr('content'));
               },
               success: function() {
                   location.reload();
               },
               error: function() {
                   alert("삭제 중 오류가 발생했습니다. 다시 시도해 주세요.");
               }
           });
       }
   });



//   // 수량 입력 값 변경 시 이벤트
//   $('.cart-quantity').on('input', function() {
//       const quantity = parseInt($(this).val()) || 0; // 유효성 검사
//       const price = parseInt($(this).data('prod-price')) || 0; // 유효성 검사
//       const totalPrice = quantity * price;
//
//       // 해당 행의 상품금액 업데이트 (콤마 추가)
//       $(this).closest('tr').find('.product-price').text(totalPrice.toLocaleString() + '원');
//
//       // 총합계 업데이트
//       updateTotalPrice();
//   });
//
//   // 총합계 계산
//   function updateTotalPrice() {
//       let total = 0;
//       $('.cart-quantity').each(function() {
//           const quantity = parseInt($(this).val()) || 0; // 유효성 검사
//           const price = parseInt($(this).data('prod-price')) || 0; // 유효성 검사
//           total += quantity * price;
//       });
//
//       const shippingCost = 3000; // 배송비
//       $('#total-price').text(total.toLocaleString() + '원'); // 총 상품금액 (콤마 추가)
//       $('#final-price').text((total + shippingCost).toLocaleString() + '원'); // 배송비 포함
//   }

    // 선택한 상품 삭제
//    $(".btn-delete").click(function () {
//        let cartNo = $(this).data("cart-no");
//            if (confirm("해당 상품을 삭제하시겠습니까?")) {
//                $.ajax({
//                    url: "/cart/delete",
//                    type: "POST",
//                    data: { cartNo: cartNo },
//                    beforeSend: function(xhr) {
//                        xhr.setRequestHeader("X-CSRF-TOKEN", $('meta[name="_csrf"]').attr('content'));
//                    },
//                    success: function() {
//                        location.reload();
//                    },
//                    error: function() {
//                        alert("삭제 중 오류가 발생했습니다. 다시 시도해 주세요.");
//                    }
//                });
//            }
//    });


});


