(function($){
		$('#butt1').click(function(){
			$("[name='picmode']").val($('#butt1').val())			
		})
		$('#butt2').click(function(){
			$("[name='picmode']").val($('#butt2').val())			
		})
		$('#myModal').click(function(){
			$("[name='picmode']").val('')			
		})
		$('#file_input').change(function(){
			var result = document.getElementById("result"); 
			var input = document.getElementById("file_input"); 
			var files = this.files 
			console.log(files.length)
			var i=0;
			$('#result').empty();
			if(files.length>4){
				alert("請只能選擇四張照片")
			}else{
				while(i<files.length){
					var file=files[i];
					var reader = new FileReader(); 
					reader.readAsDataURL(file); 
					var j=1;
					reader.onload = function(e){ 
					result.innerHTML += '<img  height="150" width="200" src="'+this.result+'" id="img'+j+'" /><input type="hidden" name="picstring" value="['+this.result+']" />' 
					j++;
					} 		
					i++;
				}
			}
		})	
	
		$.ajax({
			url:"GetCate1.jsp",
			type:"get",
			dataType:"json",
			success:function(data){
				$.each(data,function(){
					if(this.cate1no!=null){
						var cate1no=this.cate1no;
						var cate1name=this.cate1name;
						var opt=$("<option></option>").val(cate1no).text(cate1name);
						$("#select1").append(opt);
					}else if(this.countyno!=null){
						var countyno=this.countyno;
						var countyname=this.countyname;
						var opt=$("<option></option>").val(countyno).text(countyname);
						$("#select3").append(opt);
					}			
				})							
		
				$.ajax({
					url:"GetCateDist.jsp",
					type:"get",
					dataType:"json",
					data:{"cate1no":$("#select1").val(),"countyno":$("#select3").val()},
					success:function(data){
						$.each(data,function(){
							if(this.cate2no!=null){
								var cate2no=this.cate2no;
								var cate2name=this.cate2name;
								var opt=$("<option></option>").val(cate2no).text(cate2name);
								$("#select2").append(opt);
							}else if(this.distno!=null){
								var distno=this.distno;
								var distname=this.distname;
								var opt=$("<option></option>").val(distno).text(distname);
								$("#select4").append(opt);
							}
									
						})
					}
				})
			}
		})
			
		$("#select1").change(function (){
			$.ajax({
				url:"GetCate2.jsp",
				type:"get",
				dataType:"json",
				data:{"cate1no":$("#select1").val()},
				success:function(data){
					$("#select2 option").remove();
					$.each(data,function(){
						var cate2no=this.cate2no;
						var cate2name=this.cate2name;
						var opt=$("<option></option>").val(cate2no).text(cate2name);
						$("#select2").append(opt);						
					})
				}
			})
	
		});
		$("#select3").change(function (){
			$.ajax({
				url:"GetDist.jsp",
				type:"get",
				dataType:"json",
				data:{"countyno":$("#select3").val()},
				success:function(data){
					$("#select4 option").remove();
					$.each(data,function(){
						var distno=this.distno;
						var distname=this.distname;
						var opt=$("<option></option>").val(distno).text(distname);
						$("#select4").append(opt);						
					})
				}
			})
	
		});
	
	})(jQuery);