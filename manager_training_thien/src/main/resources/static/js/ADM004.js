/**
 * Dùng cho trang ADM004
 */
$(document).ready(function(){
	loadCompany($('#defaultCompanyId').val());
	/**
	 * Dùng để chọn ngày bằng datepicker
	 */
	$( "#birthday").datepicker({
	      changeMonth: true,
	      changeYear: true,
	      yearRange: "-100:+0",
	      dateFormat: 'dd/mm/yy',
	      showOn: "button",
	      buttonImage: "images/calendar3.png",
	      buttonImageOnly: true
	});
	$( "#endDate,#startDate" ).datepicker({
	      changeMonth: true,
	      changeYear: true,
	      yearRange: "-50:+50",
	      dateFormat: 'dd/mm/yy',
	      showOn: "button",
	      buttonImage: "images/calendar3.png",
	      buttonImageOnly: true
	});
	/**
	 * Dùng để khi thay đổi radio button thì ẩn và hiện table company
	 */
	$('input[name=isChoseOld]').change(function() {
		//alert($('#oldCompany').css('display'));
		toggle('oldCompany');
		toggle('newCompany');
		$('input[name=companyName').val('');
		$('input[name=companyAddress').val('');
		$('input[name=companyEmail').val('');
		$('input[name=companyTel').val('');
	});
	/**
	 * Khi thay đổi khi chọn công ty khác thì gọi ajax để hiển thị công ty mới
	 */
	function loadCompany(companyId) {
		 $.ajax({
	            url:'/getCompany',
	            type:'GET',
	            data: {id: companyId },
	            dataType: 'json',
	            success: function(data) {
		            html = '<tr><td >Tên công ty</td><td>' + data.name + '</td></tr>';
					html+='<tr><td>Địa chỉ</td><td>' + data.address + '</td></tr>'
					html+='<tr><td>Email</td><td>' + ((data.email != null) ? data.email : '') + '</td></tr>'
					html+='<tr><td>Điện thoại</td><td>' + ((data.tel != null) ? data.tel : '') + '</td></tr>'
					$('#oldCompany tr:gt(0)').remove();
					$('#oldCompany').append(html);
	            }
	        });
	}
		$('#companySelect').change(function() {
			var companyId = $(this).val();
		       loadCompany(companyId);
		});

	/**
	 * Khi click vào back thì trở về ADM002 và giữ điều kiện tìm kiếm
	 */
	$('#back').click(function(){
		var tabID = $('input[name=tabID]').val();
		window.location.href = "/listUsers?notChange&tabID=" + tabID;
	});
});