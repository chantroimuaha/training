/**
 * Dùng cho trang ADM002
 */

$(document).ready(function(){
	/**
	 * Khi thay đổi công ty thì dữ liệu tìm kiếm bị reset
	 */
	$('#companyId').change(function() {
		$('input[name=fullNameKey]').val('');
		$('input[name=insuranceCodeKey]').val('');
		$('input[name=insurancePlaceRegisterKey]').val('');
		//$('#listUser').submit();
	});
	/**
	 * Khi click vào button addUser thì đi đến đường dẫn addNewUser với tabID và companyId
	 */
	$('#addUser').click(function(){
		var tabID = $('input[name=tabID]').val();
		var companyId = $('input[name=companyIdHidden]').val();
		window.location.href = "/saveUser?tabID=" + tabID + "&companyId=" + companyId;
	});
	/**
	 * Khi click vào button export CSV thì dẫn đường dẫn tới url để exportCSV kèm tabID
	 */
	$('#exportCSV').click(function(){
		var tabID = $('input[name=tabID]').val();
		window.location.href = "/exportListUserToCSV?tabID=" + tabID;
	});
});