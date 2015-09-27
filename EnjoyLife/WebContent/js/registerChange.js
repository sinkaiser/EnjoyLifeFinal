		$().ready(function(){						
		    $("#reset").click(function() {
		    	$("#form").validate().resetForm();
		    });	
		    
		    $('#birthday').datepicker(
                    {
                    	defaultDate : (new Date(new Date().getFullYear() - 40
                                + "/01/01") - new Date())
                                / (1000 * 60 * 60 * 24),
                    	changeYear : true,
                        changeMonth : true,
                        dateFormat : "yy-mm-dd",
                        yearRange : "-60:+60",
                        maxDate : '+0'
                    });
			$("#form").validate({
					submitHandler:function(form) {
						form.submit();
					},
					rules:{
						password:{
							required:true,
							minlength: 5
						},
						passwordCheck:{
							required:true,
							minlength: 5,
							equalTo:"#password"
						},
						memberName:{
							required:true,							
						},
						email:{
							required: true,
						    email: true
						},
						birthDay:{
							required: true,
							date:true
						},
						sex:{
							required: true
						}
					},//end of rules
					messages: {						
						password:{
							minlength:"密碼至少五個字"
						},
						passwordCheck:{
							minlength: "密碼至少五個字",
							equalTo:"兩次密碼不相同，請確認密碼"
						},
						memberName:{
							required: "請輸入名稱",
						},	
						email:{
							required: "請輸入E-mail",
						    email: "請輸入正確的E-mail格式"
						},
						birthDay:{
							required: "請輸入生日",
							date:"請輸入合法的日期"
						},
						sex:{
							required: "姓別欄未選擇"
						}
					}			
			});//end of validate
		})