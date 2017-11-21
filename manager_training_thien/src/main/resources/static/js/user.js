$(document).ready(function(){
  
	/*$("#loginForm").validate({
		rules: {
			username: "required",
			password: "required"
		},
		messages: {
			username: "Ban hay nhap user name",
			password: "Ban hay nhap password"
		},
		submitHandler: function(form) {
            form.submit();
        }
	});*/
	$('#login').click(function(){
		var username = $('#username').val();
		var password = $('#password').val();
		var userNameEmpty=$('#userNameEmpty').val();
		var passwordEmpty=$('#passwordEmpty').val();
		var submit = true;
		if (username.length === 0) {
			$('[name=error]').text(userNameEmpty);
			submit = false;
		}else if (password.length === 0) {
			$('[name=error]').text(passwordEmpty);
			submit = false;
		}
		/*if (username.length === 0 && password.length === 0) {
			$('[name=error]').text("Hãy nhập tên đăng nhập và mật khẩu!");
			submit = false;
		}*/
		if(submit) {
			$('#loginForm').submit();
		}
	});
	/*$('#companyId').change(function() {
		$('input[name=fullNameKey]').val('');
		$('input[name=insuranceCodeKey]').val('');
		$('input[name=insurancePlaceRegisterKey]').val('');
	});*/
});
/**
 *  Dùng để ẩn và hiện tag html bằng id
 * @param id của tag muốn ẩn hoặc hiện
 */
function toggle(id) {
	//alert(($('#'+id).css('display') == 'block'));
   if($('#'+id).css('display') == 'block') $('#'+id).css('display','none');
   else {
	   $('#'+id).css('display','block');
   }
}
