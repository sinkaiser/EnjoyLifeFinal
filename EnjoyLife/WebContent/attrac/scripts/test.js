window.onload=function(){
var oul=document.getElementById("ul1");
var oli=oul.getElementByTagName("li");
var lilen=oli.length;
var offset=0;
var door=true;
getlist();
function getlist(){	
	$.ajax({
 		url:"GetPhoto2.jsp",
 		type:"get",
 		dataType:"json",
 		data:{"offset":offset},
 		success:function(data){
 			if(data.length==0){
 				return;
 			}
 			$.each(data,function(){
 					var index=getShort();
 					var photoname=this.photoname;
 					var stitle=this.stitle;
 					var attracno=this.attracNo;
 					var addr=this.address;
 					var photodata=this.photodata;
 					if(photodata!=null){
 						var index=getShort();
 						var adddiv=document.createElement("div");
 						var addimg=document.createElement("img");
 						addimg.src=photodata;
 						addimg.style.width="280px";
 						addimg.style.height="210px";
 						adddiv.appendChild(addimg);
 						var addp=document.createElement("p");
 						addp.innerHTML=stitle;
 						adddiv.appendChild(addp);
 						oli[index].appendChild(adddiv);
 					}																						
 			})
 		}				
	})
	door=true;
}

window.onscroll=function(){
	var index=getShort();
	var ali=oli[index];
	var scrolltop=document.documentElement.scrollTop||document.body.scrollTop
	if(getTop(ali)+ali.offsetHeight<
	document.documentElement.clientHeight+scrolltop){
		if(door){
			door=false;
			ipage+=20;
			getlist();
		}	
	}
}


function getShort(){
	var index=0;
	var lih=oli[index].offsetHeight;
	for(var i=1;i<lilen;i++){
		if(oli[i].offsetHeight<lih){
			index=i;
			lih=oli[i].offsetHeight;
		}
	}
	return index;
}

function getTop(obj){
	var itop=0;
	while(obj){
		itop += obj.offsetTop;
		obj=obj.offsetParent;
	}
	return itop;
}

}