/**
 * Dùng cho trang ADM003
 */

$(document).ready(function(){
  
	/**
	 * Khi click button back thì dẫn tới trang ADM002 và giữ nguyên điều kiện tìm kiếm
	 */
	$('#back').click(function(){
		var tabID = $('input[name=tabID]').val();
		window.location.href = "/listUsers?notChange&tabID=" + tabID;
	});
	/**
	 * Khi click vào button update thì vào đường dẫn addNewUser để cập nhật
	 */
	$('#update').click(function(){
		var id = $('#id').val();
		var tabID=$('input[name=tabID').val();
		window.location.href = '/saveUser?tabID=' + tabID + '&id='+id;
	});
	/**
	 * Khi click vào button Xóa thì chuyển tới đường dẫn xóa user
	 */
	$('#deleteUser').click(function(){
		var id = $('#id').val();
		var tabID=$('input[name=tabID').val();
		window.location.href = '/deleteUser?userId='+id;
	});
});