(function($){	
		$("#select2").change(addr);
		$("#select4").change(addr);
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
						addr();
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
					addr();
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
					addr();
				}
			})
	
		});
		
		function addr(){
			$.ajax({
				url:"GetAttrac.jsp",
				type:"get",
				dataType:"json",
				data:{"cate1no":$("#select1").val(),
					"cate2no":$("#select2").val(),
					"countyno":$("#select3").val(),
					"distno":$("#select4").val()},
				success:function(data){
					$("#menu li").remove();
					$.each(data,function(index){
						var stitle=this.stitle;
						var attracno=this.attracno;
						var list=$("<li></li>").val(attracno).text(stitle);
						list.attr("role","menuitem")
						list.attr("tabindex",-1)
						list.attr("id","ui-id-"+(index+1))
						list.attr("Class","ui-menu-item")
						$("#menu").append(list);						
					})
				}
				
				
			})
			
		}
	
	})(jQuery);