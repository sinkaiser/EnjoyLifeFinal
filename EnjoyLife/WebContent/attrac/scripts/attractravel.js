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
                 $("#auto").attr('download','download.png');
                 lnk = document.getElementById("auto");
                 lnk.click();
		    }
		});		
	})		
	$("#attracadd").click(function(){
		if(($("#attracinfo").has("img").length)!=0){
			$('div[name="default"]').remove();
			var alltitle=$('span[name="attractitle"]').text();
			var addtitle=$("#labelid").text();
			var list=document.getElementsByName("newattrac");
			if(list.length<9){
				if(alltitle.indexOf(addtitle)==-1){
				$("#travel").append("<div name='newattrac' class='traveldiv'><img  class='attracpic'src="+$("#imgid").attr('src')+">"+
									"<div  class='attracdiv'><input class='delbut'type='button'value='移除'><span name='attractitle' class='attracdata' >"+$("#labelid").text()+"</span><br>"+
									"<span name='attracaddr' class='attracdata'>地址:"+$('#addr').val()+"</span><br><span name='nextdirection' class='nextdirection'></span><br>"+
									"<span name='distance' class='distance'></span><br><span name='duration' class='duration'></span></div></div>");	
				}else{
					var text=document.createTextNode("該景點已加入");
					$('.modal-body').empty();
					$('.modal-body').prepend(text)
					$('#myModal').modal('toggle')	
				}
			}else{
				var text=document.createTextNode("景點最多9筆");
				$('.modal-body').empty();
				$('.modal-body').prepend(text);
				$('#myModal').modal('toggle');
			}
		}else{
			$('div[name="default"]').html("<h1>請選擇景點</h1>");
		}
		travelattrac();
	})
	$("#travel").on("click",".delbut",function(){
		$(this).parents('div[name="newattrac"]').remove();
		if(($("#travel").has("div").length)==0){
			$("#travel").append("<div name='default' style='text-align:center' class='traveldiv'><h1>請增加景點</h1></div>")
		}
		travelattrac();
	})
	$(function() {
	    $( "#travel" ).sortable({
	      placeholder: "traveldiv"
	    });
	    $( "#travel" ).disableSelection();

	});
	$("#travel").on("sortstop",function(){
		travelattrac();
	})
	attracarray=new Array() ;
	addrsize=0;
	function travelattrac(){
		var items = document.getElementsByName("attracaddr");
		addrsize=items.length;
		attracarray=new Array(items.length) ;
		$.each(items,function(index,value){	
				attracarray[index] = value.innerHTML.substr(3);			
		})	
		maps();
	}
	var map=$("#map");
	initmap();
	function initmap(modify){
		if(modify==undefined){
		map.tinyMap({
			'center': ['25.0330681', '121.543792'],
			'zoom': 15,
			'disableDefaultUI': true,
			'disableDoubleClickZoom': true,
			'scrollwheel': true,
			'streetViewControl': false,
			 'autoLocation': true,})
		}else if(modify==1){
			map.tinyMap('modify',{
				'center': [25.0330681, 121.543792],
				'zoom': 14,
				'disableDefaultUI': true,
				'disableDoubleClickZoom': true,
				'scrollwheel': true,
				'streetViewControl': false,})
		}
	}
	function maps(){	
		travelbegin=attracarray[0];
		travelend=attracarray[addrsize-1];
		if(addrsize>2){			
			travelway=attracarray.slice(1,addrsize-1);
		}else{
			travelway=null;
		}
		map.tinyMap('clear')
		if(addrsize==0){
			initmap(1);
		}else{
			map.tinyMap('modify',{
				'direction':[{	 	        
					'from': travelbegin,
					'to': travelend,		 	        
					'waypoint': travelway,		 	      
					'optimize': false,	 	        
					'travel': 'driving',// 使用的交通類型。可用 driving, walking, bicycling
					'autoViewport': true,
					'event':{
							'directions_changed':function(){
								mapinfo();
							}
					}
				}]
			});				
		}
		
	}	
	function mapinfo(){
		var m = map.data('tinyMap'),
        d = m.getDirectionsInfo(),
        i = 0,
        j = 0,
        distance = 0,
        duration = 0,
        attracdiv = $('.attracdiv'),
        at=document.getElementsByName("attractitle");
		nd=document.getElementsByName("nextdirection"),
		dt=document.getElementsByName("distance"),
		dr=document.getElementsByName("duration");
    for (i = 0; i < d.length; i++) {
        if (d[i]) {
            distance = 0;
            duration = 0;
            for (j = 0; j < d[i].length; j++) {
                if (d[i][j].hasOwnProperty('distance')) {
                	distance += Math.ceil(d[i][j].distance.value/ 1000, 10);
                	duration += Math.ceil(d[i][j].duration.value/ 60, 10);
                	if(at.length>1){
                		nd[j].innerHTML="下一目的地:"+at[j+1].innerHTML.substr(3);
                		dt[j].innerHTML="距離:"+Math.ceil(d[i][j].distance.value/ 1000, 10)+'公里';
                		dr[j].innerHTML="預計花費時間:"+Math.ceil(d[i][j].duration.value/ 60, 10)+'分鐘';              		              		
                	}
                	nd[nd.length-1].innerHTML="路程總計";
                	dt[dt.length-1].innerHTML="路程總計:"+distance+'公里';
                	if(duration<60){
                		dr[dr.length-1].innerHTML="總花費時間:"+duration+'分鐘';               		
                	}else{
                		dr[dr.length-1].innerHTML="總花費時間:"+Math.floor(duration/60)+'小時'+duration%60+'分鐘';  
                	}
                		
                }
            }

        }
    }
	}
})(jQuery);