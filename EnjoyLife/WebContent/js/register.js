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
						memberId:{
							required:true,
							minlength: 5,
							remote: {
							    url: "checkMemberId",     //后台处理程序
							    type: "post",               //数据发送方式
							    dataType: "json",           //接受数据格式   
							    data: {                     //要传递的数据
							        username: function() {
							            return $("#memberId").val();
							        }
							    }
							}//end of remote							
						},//end of username
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
						birthday:{
							required: true,
							date:true
						},
						sex:{
							required: true
						}
					},//end of rules
					messages: {
						memberId:{
							minlength: "帳號至少五個字",
							remote:"帳號已重覆"
						},
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
						birthday:{
							required: "請輸入生日",
							date:"請輸入合法的日期"
						},
						sex:{
							required: "姓別欄未選擇"
						}
					}			
			});//end of validate
		})