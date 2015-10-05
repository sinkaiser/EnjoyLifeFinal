(function($){
	$("#menu").on("click",".ui-menu-item",function(){
		$("#attracinfo").empty();
		var img=$("<img></img>").attr("src","Data/ajax-loader.gif").attr("height","262").attr("width","350");
		$("#attracinfo").append(img);
		$.ajax({
			url:"GetPhoto2.jsp",
			type:"get",
			dataType:"json",
			data:{"attracno":$(this).attr("id")},
			success:function(data){
				$.each(data,function(index){
					var photoname=this.photoname;
					var photodata=this.photodata;
					var stitle=this.stitle;
					var attracno=this.attracNo;
					var addr=this.address;
					$(".col-md-4 label").remove();
					$("#attracinfo").empty();
					var title=$("<label></label>").text("名稱:"+stitle).attr("id","labelid");
					$("#number").attr("value",attracno);
					$("#addr").attr("value",addr);
					if(null!=photoname){
						var img=$("<img></img>").attr("src",photodata).attr("height","262").attr("width","350").attr("id","imgid");					
					}else{
						 img=$("<img></img>").attr("src","Data/nopic.png").attr("height","262").attr("width","350").attr("id","imgid");
					}
					$("#attracinfo").after(title);
					$("#attracinfo").append(img);												
				})
			}
		})	
	})	
	$("#canvans").click(function(){
		html2canvas($("#travel"), {
			 useCORS: true,
             allowTaint:true,
		    onrendered: function(canvas) {
		    	 $("#auto").attr('href', canvas.toDataURL(canvas));
                 $("#auto").attr('download','行程.jpeg');
                 lnk = document.getElementById("auto");
                 lnk.click();
		    }
		});		
	})
	$("#mapimg").click(function(){
		html2canvas($("#panel"), {
			 useCORS: true,
             allowTaint:true,
		    onrendered: function(canvas) {
		    	 $("#auto").attr('href', canvas.toDataURL(canvas));
                 $("#auto").attr('download','路程.jpeg');
                 lnk = document.getElementById("auto");
                 lnk.click();
		    }
		});		
	})
	var redmark=["Data/marker/redA.png","Data/marker/redB.png","Data/marker/redC.png","Data/marker/redD.png","Data/marker/redE.png","Data/marker/redF.png","Data/marker/redG.png"]
	var greenmark=["Data/marker/greenA.png","Data/marker/greenB.png","Data/marker/greenC.png","Data/marker/greenD.png","Data/marker/greenE.png","Data/marker/greenF.png","Data/marker/greenG.png"]
	$(function() {
		$( "#travel" ).sortable({
			placeholder: "traveldiv"
		});
		$( "#travel" ).disableSelection();
		
	});

	
	//google map
	addrsize=0;
		 
	google.maps.event.addDomListener(window, 'load', initmap);
	$("#travel").on("click",".delbut",function(){
		$(this).parents('div[name="newattrac"]').remove();
		if(($("#travel").has("div").length)==0){
			$("#travel").append("<div name='default' style='text-align:center' class='traveldiv'><h1>請增加景點</h1></div>")
		}
		changemark();
		calculateAndDisplayRoute(directionsService, directionsDisplay);
	})
	$("#travel").on("sortstop",function(){
		changemark();
		calculateAndDisplayRoute(directionsService, directionsDisplay);
	})
	
	$("#attracadd").click(function(){
		if(($("#attracinfo").has("img").length)!=0){
			$('div[name="default"]').remove();
			var alltitle=$('span[name="attractitle"]').text();
			var addtitle=$("#labelid").text();
			var list=document.getElementsByName("newattrac");
			if(list.length<9){
				if(alltitle.indexOf(addtitle)==-1){
					var i=list.length;
					
					if(i<1){
						var marksrc=greenmark[i]						
					}else{
						var marksrc=redmark[i]
					}
				$("#travel").append("<div name='newattrac' class='traveldiv' style='background-color: white'><img name='marker' id='mark"+i+"' class='attracmark' src='"+marksrc+"'><img  class='attracpic'src="+$("#imgid").attr('src')+">"+
									"<div  class='attracdiv'><input class='delbut'type='button'value='移除'><span name='attractitle' class='attracdata' >"+$("#labelid").text()+"</span><br>"+
									"<span name='attracaddr' class='attracdata'>地址:"+$('#addr').val()+"</span><br><span name='nextdirection' class='nextdirection'></span><br>"+
									"<span name='distance' class='distance'></span><br><span name='duration' class='duration'></span></div></div>");	
				
					changemark(i);
				}else{
					//alert("該景點已加入")
					var text=document.createTextNode("該景點已加入");
					$('.modal-body').empty();
					$('.modal-body').prepend(text)
					$('#myModal').modal('toggle')
					return;
				}
			}else{
				var text=document.createTextNode("景點最多10筆");
				$('.modal-body').empty();
				$('.modal-body').prepend(text);
				$('#myModal').modal('toggle');
			}
		}else{
			$('div[name="default"]').html("<h1>請選擇景點</h1>");
		}			
	    calculateAndDisplayRoute(directionsService, directionsDisplay);
	});
	
	
	function changemark(i){
		if(i>1){
			$("#mark"+(i-1)+"").attr("src",greenmark[(i-1)])
		}else if(i==undefined){
			var list=document.getElementsByName("newattrac");
			var marker=document.getElementsByName("marker");
			console.log(list.length+";"+marker.length)			
			for(var i=0;i<marker.length;i++){
				marker[i].id="mark"+i;
			}
			for(var i=0;i<marker.length;i++){
				if(i==(marker.length-1)){
					if(marker.length==1){
						$("#mark"+i+"").attr("src",redmark[1])
					}else{						
						$("#mark"+i+"").attr("src",redmark[i])
					}
				}else{
					$("#mark"+i+"").attr("src",greenmark[i])								
				}
			}
			
		}
	}
	
	
	function initmap(){
		map = new google.maps.Map(document.getElementById('map'), {
			zoom: 15,
			center: {lat: 25.0330681, lng: 121.543792}
		});
		 directionsService = new google.maps.DirectionsService;
		 directionsDisplay = new google.maps.DirectionsRenderer({
			 map: map,	
			 
		 });	

	}
	
	function calculateAndDisplayRoute(directionsService, directionsDisplay){
		var items = document.getElementsByName("attracaddr");
		addrsize=items.length;
		attracarray=new Array(items.length) ;
		$.each(items,function(index,value){	
				attracarray[index] = value.innerHTML.substr(3);			
		})	
		var travelway=[];
		travelbegin=attracarray[0];
		travelend=attracarray[addrsize-1];
		if(addrsize>2){			
			 for (var i = 1; i < addrsize-1; i++) {
				 travelway.push({
				        location: attracarray[i],
				        stopover: true
				      });			    
			}
		}else{
			travelway=null;
		}
		
		if(addrsize==0){
			initmap();
		}else{
			directionsService.route({
			    origin: travelbegin,
			    destination: travelend,
			    waypoints: travelway,
			    optimizeWaypoints: false,
			    travelMode: google.maps.TravelMode.DRIVING
			  },function(response, status) {
				    if (status === google.maps.DirectionsStatus.OK) {
				        directionsDisplay.setDirections(response);
				        var route = response.routes[0];
				        var summaryPanel = document.getElementById('directions-panel');
				        at=document.getElementsByName("attractitle");
						nd=document.getElementsByName("nextdirection"),
						dt=document.getElementsByName("distance"),
						dr=document.getElementsByName("duration");
						distance = 0;
						duration = 0;
						console.log(response)
						$("#panel").empty();
				        for (var i = 0; i < route.legs.length; i++) {
				        	distance+=Math.ceil(route.legs[i].distance.value/ 1000, 10);
				        	duration+= Math.ceil(route.legs[i].duration.value/ 60, 10);
				        	$("#panel").append("<div style='text-align: center;'><span style='color:red;font-size:20px'>起始地："+at[i].innerHTML.substr(3)+"</span><br></div>")
				        	$("#panel").append("<hr>")
				        	for(var j=0;j< route.legs[i].steps.length;j++){		
				        		information=route.legs[i].steps[j].instructions.replace("<div","<br><span style='margin-left:40px'").replace("/div","/span");
				        		console.log(information.replace("<div","<br><span style='margin-left:40px'").replace("/div","/span"))
				        		$("#panel").append("<span style='display:inline-block;width:30px;margin-left:10px'>"+(j+1)+".</span>"+information.replace("<div","<br><span style='margin-left:40px'").replace("/div","/span")+"<br>")		        		
				        		$("#panel").append("<hr>")
				        	}
				        	$("#panel").append("<div style='text-align: center;'><span style='color:blue;font-size:20px'>目的地："+at[i+1].innerHTML.substr(3)+"</span><br></div>")
				        	$("#panel").append("<hr>")	
				        	
				        	if(at.length>1){
		                		nd[i].innerHTML="下一目的地:"+at[i+1].innerHTML.substr(3);
		                		dt[i].innerHTML="距離:"+Math.ceil(route.legs[i].distance.value/ 1000, 10)+'公里';
		                		dr[i].innerHTML="預計花費時間:"+Math.ceil(route.legs[i].duration.value/ 60, 10)+'分鐘';              		              		
		                	}
		                	nd[nd.length-1].innerHTML="路程總計";
		                	dt[dt.length-1].innerHTML="路程總計:"+distance+'公里';
		                	if(duration<60){
		                		dr[dr.length-1].innerHTML="總花費時間:"+duration+'分鐘';               		
		                	}else{
		                		dr[dr.length-1].innerHTML="總花費時間:"+Math.floor(duration/60)+'小時'+duration%60+'分鐘';  
		                	}				        	
				        }			    				    
				    } else {
				        window.alert('Directions request failed due to ' + status);
				    }				    
			});			
		}
		
	}	

})(jQuery);