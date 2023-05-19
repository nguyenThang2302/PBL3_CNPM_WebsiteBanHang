$(document).ready(function() {
  // Kiểm tra biến flagSuccessMsg
  if (typeof flagSuccessMsg !== 'undefined' && flagSuccessMsg) {
    // Hiển thị modal
    $('#exampleModal2').modal('show');
    
    // Đặt thời gian chờ (ví dụ: 3 giây)
    setTimeout(function() {
      // Tắt modal
      $('#exampleModal2').modal('hide');
      
      // Tải lại trang
      location.reload();
    }, 3000); // 3000 milliseconds = 3 seconds
  }
});
