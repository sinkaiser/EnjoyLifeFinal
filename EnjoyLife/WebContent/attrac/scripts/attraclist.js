var sel = document.getElementById("select1"),
		sel2 =document.getElementById("select2"),
		sel3 =document.getElementById("select3"),
		sel4 =document.getElementById("select4"),
		xhr = null;
		ul=document.getElementById("menu");
		myDiv=document.getElementById("mydiv");
		window.addEventListener("load",load);
		sel.addEventListener("change",cate);
		sel3.addEventListener("change",county);
		sel2.addEventListener("change",addr);
		sel4.addEventListener("change",addr);
		function load(){			
			xhr = new XMLHttpRequest();
			if (xhr != null) {
				xhr.addEventListener("readystatechange", returncate);
				xhr.open("get", "GetCate1.jsp", true); //true表示同步
				xhr.send();			
			} else {
				alert("請升級您的瀏覽器!!");
			}			
		}
		function returncate() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {								
					var datas = xhr.responseText;
						data=JSON.parse(datas);
					for(var i=0,max=data.length;i<max;i++){	
						if(data[i].cate1no!=null){
							var cate1no =data[i].cate1no;
							var cate1name =data[i].cate1name;														
						    //顯示資料
							myOption = document.createElement("option");
							myOption.text = cate1name;
							myOption.value = cate1no;
							sel.appendChild(myOption);							
						}else if(data[i].countyno!=null){
							var countyno =data[i].countyno;
							var countyname =data[i].countyname;														
						    //顯示資料
							myOption = document.createElement("option");
							myOption.text = countyname;
							myOption.value = countyno;
							sel3.appendChild(myOption);	
						}
	
 					}					
					product();	
				} else {
					myDiv.innerHTML = xhr.status + ":" + xhr.statusText;
				}
			}

		}
	
		function product(){			
			xhr = new XMLHttpRequest();
			if (xhr != null) {
				xhr.addEventListener("load",function(){
					if (xhr.status == 200) {
						while(sel2.hasChildNodes()){
							sel2.removeChild(sel2.lastChild);
						}
						while(sel4.hasChildNodes()){
							sel4.removeChild(sel4.lastChild);
						}
						var datas = xhr.responseText; 
							data=JSON.parse(datas);
							console.log(data.length);
						for(var i=0,max=data.length;i<max;i++){		
							if(data[i].cate2no!=null){
								var cate2no =data[i].cate2no;
								var cate2name =data[i].cate2name;										
								//顯示資料
								myOption2 = document.createElement("option");
								myOption2.text = cate2name;
								myOption2.value = cate2no;
								sel2.appendChild(myOption2);
							}else if(data[i].distno!=null){
								var distno =data[i].distno;
								var distname =data[i].distname;										
								//顯示資料
								myOption2 = document.createElement("option");
								myOption2.text = distname;
								myOption2.value = distno;
								sel4.appendChild(myOption2);
							}
		  				}					
						addr();
					} else {
						myDiv.innerHTML = xhr.status + ":" + xhr.statusText;
					}			
					
				});
				xhr.open("get", "GetCateDist.jsp?cate1no="+sel.value+"&countyno="+sel3.value, true); //true表示同步
				xhr.send();
			} else {
				alert("請升級您的瀏覽器!!");
			}			
		}
		
		
		function cate(){			
			xhr = new XMLHttpRequest();
			if (xhr != null) {
				xhr.addEventListener("load",function(){
					if (xhr.status == 200) {
						while(sel2.hasChildNodes()){
							sel2.removeChild(sel2.lastChild);
						}						
						var datas = xhr.responseText; 
							data=JSON.parse(datas);
							console.log(data.length);
						for(var i=0,max=data.length;i<max;i++){		
							if(data[i].cate2no!=null){
								var cate2no =data[i].cate2no;
								var cate2name =data[i].cate2name;										
								//顯示資料
								myOption2 = document.createElement("option");
								myOption2.text = cate2name;
								myOption2.value = cate2no;
								sel2.appendChild(myOption2);
							}
		  				}					
						addr();
					} else {
						myDiv.innerHTML = xhr.status + ":" + xhr.statusText;
					}			
					
				});
				xhr.open("get", "GetCate2.jsp?cate1no="+sel.value, true); //true表示同步
				xhr.send();
			} else {
				alert("請升級您的瀏覽器!!");
			}			
		}
		
		function county(){			
			xhr = new XMLHttpRequest();
			if (xhr != null) {
				xhr.addEventListener("load",function(){
					if (xhr.status == 200) {
						while(sel4.hasChildNodes()){
							sel4.removeChild(sel4.lastChild);
						}
						var datas = xhr.responseText; 
							data=JSON.parse(datas);
							console.log(data.length);
						for(var i=0,max=data.length;i<max;i++){		
							if(data[i].distno!=null){
								var distno =data[i].distno;
								var distname =data[i].distname;										
								//顯示資料
								myOption2 = document.createElement("option");
								myOption2.text = distname;
								myOption2.value = distno;
								sel4.appendChild(myOption2);
							}
		  				}					
						addr();
					} else {
						myDiv.innerHTML = xhr.status + ":" + xhr.statusText;
					}			
					
				});
				xhr.open("get", "GetDist.jsp?countyno="+sel3.value, true); //true表示同步
				xhr.send();
			} else {
				alert("請升級您的瀏覽器!!");
			}			
		}
		
	
		function addr(){	
			xhr = new XMLHttpRequest();
			if (xhr != null) {
				xhr.addEventListener("load",function(){
					if (xhr.status == 200) {
 						while(ul.hasChildNodes()){
 							ul.removeChild(ul.lastChild);
 						}						
						var datas = xhr.responseText; 
							data=JSON.parse(datas);
							console.log("addr"+data.length);
						for(var i=0,max=data.length;i<max;i++){		
								var photodata =data[i].photodata;									
								//顯示資料
								//console.log("photodata:"+photodata);
								var cutphoto=photodata.substring(7,20);
								newli = document.createElement("li");
								newli.setAttribute("role","menuitem");
								newli.setAttribute("tabindex",-1);
								newli.setAttribute("id", "ui-id-"+(i+1));
								newli.setAttribute("Class","ui-menu-item");
								newlitext=document.createTextNode(photodata);
								newli.appendChild(newlitext);
								ul.appendChild(newli);				
		  				}					
					} else {
						myDiv.innerHTML = xhr.status + ":" + xhr.statusText;
					}
					 $(function() {
						    $( "#menu" ).menu();
						  });
					
				});
				xhr.open("get", "GetPhoto.jsp?cate1no="+sel.value+"&cate2no="+sel2.value+"&countyno="+sel3.value+"&distno="+sel4.value, true); //true表示同步
				xhr.send();
			} else {
				alert("請升級您的瀏覽器!!");
			}			
			
		}	