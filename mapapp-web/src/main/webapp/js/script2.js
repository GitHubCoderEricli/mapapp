//所有点的信息
var pointsData = [{"id":46,"point":{"longitude":110.09214,"latitude":34.482053},"name":"南天门","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":1,"point":{"longitude":110.089966,"latitude":34.486382},"name":"天下第一洞房","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":5,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":44,"point":{"longitude":110.08878,"latitude":34.486516},"name":"西峰","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":2,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":43,"point":{"longitude":110.093164,"latitude":34.484999},"name":"中峰","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":42,"point":{"longitude":110.088528,"latitude":34.484537},"name":"巨灵足","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":40,"point":{"longitude":110.088492,"latitude":34.483436},"name":"炼丹炉","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":39,"point":{"longitude":110.09169,"latitude":34.482752},"name":"避诏崖","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":38,"point":{"longitude":110.09408,"latitude":34.485594},"name":"下棋亭","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":1,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":37,"point":{"longitude":110.09408,"latitude":34.485594},"name":"鹰嘴崖","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":34,"point":{"longitude":110.093685,"latitude":34.486561},"name":"引凤亭","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":33,"point":{"longitude":110.093236,"latitude":34.487781},"name":"金锁关","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":32,"point":{"longitude":110.094547,"latitude":34.49205},"name":"苍龙岭","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":29,"point":{"longitude":110.101931,"latitude":34.499369},"name":"望月桥","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":28,"point":{"longitude":110.093289,"latitude":34.49504},"name":"天梯","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":27,"point":{"longitude":110.093451,"latitude":34.498164},"name":"北峰","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":26,"point":{"longitude":110.091547,"latitude":34.494252},"name":"千尺幢","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":24,"point":{"longitude":110.087864,"latitude":34.501228},"name":"华山三大险","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":23,"point":{"longitude":110.087918,"latitude":34.50456},"name":"药王洞","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":22,"point":{"longitude":110.08763,"latitude":34.513425},"name":"青云洞天","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":4,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"},
	{"id":21,"point":{"longitude":110.09002,"latitude":34.527359},"name":"华山门","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":2,"interestNum":2,"audio":"../audio/ziguhuashanyitiaolu.mp3"},
	{"id":20,"point":{"longitude":110.088816,"latitude":34.531567},"name":"玉泉院","icon":"/icon/icon.jpg","shortDes":"玉泉院风景区","picture":"../img/photo.png","recommendNum":3,"difficultyNum":1,"interestNum":2,"audio":"../audio/zhiquhuashanlu.mp3"}];

var path = [{"id":20,"longitude":110.088816,"latitude":34.531567,"name":"玉泉院","icon":"/icon/icon.jpg","shortDes":"玉泉院风景区","picture":"/picture/20.jpg","routeNum":0,"route":1,"audio":null,"recommendNum":3,"difficultyNum":4,"interestNum":5},{"id":21,"longitude":110.09002,"latitude":34.527359,"name":"华山门","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":1,"route":1,"audio":null,"recommendNum":4,"difficultyNum":3,"interestNum":5},{"id":22,"longitude":110.08763,"latitude":34.513425,"name":"青云洞天","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":2,"route":1,"audio":null,"recommendNum":5,"difficultyNum":4,"interestNum":5},{"id":23,"longitude":110.087918,"latitude":34.50456,"name":"药王洞","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":3,"route":1,"audio":null,"recommendNum":4,"difficultyNum":3,"interestNum":5},{"id":24,"longitude":110.087864,"latitude":34.501228,"name":"华山三大险\n","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":4,"route":1,"audio":null,"recommendNum":5,"difficultyNum":5,"interestNum":5},{"id":26,"longitude":110.091547,"latitude":34.494252,"name":"千尺幢","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":5,"route":1,"audio":null,"recommendNum":4,"difficultyNum":3,"interestNum":5},{"id":27,"longitude":110.093451,"latitude":34.498164,"name":"北峰","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":6,"route":1,"audio":null,"recommendNum":5,"difficultyNum":4,"interestNum":5},{"id":28,"longitude":110.093289,"latitude":34.49504,"name":"天梯","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":7,"route":1,"audio":null,"recommendNum":4,"difficultyNum":5,"interestNum":4},{"id":32,"longitude":110.094547,"latitude":34.49205,"name":"苍龙岭","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":8,"route":1,"audio":null,"recommendNum":4,"difficultyNum":4,"interestNum":5},{"id":33,"longitude":110.093236,"latitude":34.487781,"name":"金锁关","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":9,"route":1,"audio":null,"recommendNum":5,"difficultyNum":4,"interestNum":3},{"id":43,"longitude":110.093164,"latitude":34.484999,"name":"中峰","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":10,"route":1,"audio":null,"recommendNum":5,"difficultyNum":5,"interestNum":5},{"id":37,"longitude":110.09408,"latitude":34.485594,"name":"鹰嘴崖","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":11,"route":1,"audio":null,"recommendNum":3,"difficultyNum":4,"interestNum":5},{"id":39,"longitude":110.09169,"latitude":34.482752,"name":"避诏崖","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":12,"route":1,"audio":null,"recommendNum":3,"difficultyNum":3,"interestNum":3},{"id":40,"longitude":110.088492,"latitude":34.483436,"name":"炼丹炉","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":13,"route":1,"audio":null,"recommendNum":4,"difficultyNum":4,"interestNum":4},{"id":42,"longitude":110.088528,"latitude":34.484537,"name":"巨灵足","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":14,"route":1,"audio":null,"recommendNum":3,"difficultyNum":3,"interestNum":3},{"id":44,"longitude":110.08878,"latitude":34.486516,"name":"西峰","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":15,"route":1,"audio":null,"recommendNum":5,"difficultyNum":5,"interestNum":5},{"id":45,"longitude":110.089966,"latitude":34.486382,"name":"天下第一洞房","icon":"/icon/icon.jpg","shortDes":"华山们风景区","picture":"/picture/20.jpg","routeNum":16,"route":1,"audio":null,"recommendNum":4,"difficultyNum":4,"interestNum":4}];



//*-----------------------------------------网络请求-----------------------------------*/
var netWorkManager = {
	//获取所有景点的信息
	"getAllPoints":function(){
		$.ajax({
			url:"/pointInfo/getAll",
			type:"get",
			contentType : 'application/json',
			dataType : 'json',
			success:function(newData){
				// data转换成本地的数据,储存起来
				pointsData = newData.data;
				//批量生成地标点
				mapBasic.buildPoint();
			},
			error:function(){
				alert("从服务器获取数据失败");
				mapBasic.buildPoint();
			}
		});
	},
	"drawLines":function(id){
		$.ajax({
			url:"/recommendLine/getLineAndGridById?id="+id,
			type:"post",
			contentType : 'application/json',
			success:function(data){
				// data转换成本地的数据,储存起来
				path = data.data;
				//批量生成地标点
				mapNavigation.mainNavgation(path);
			},
			error:function(){
				alert("从服务器获取数据失败");
				mapNavigation.mainNavgation(path);
			}
		});
	},
}


//*-----------------------------------------事件类对象-----------------------------------*/
var mapEvents = {
	"addEvent":function (obj,i,pointsData){   //添加弹窗事件
		var id = "test"+i;   //id测试用
		obj.addEventListener('touchend',function(){
			setTimeout(function(){    //弹窗内事件绑定
				mapWin.mainWin(id,pointsData);   //显示主弹窗
			},50);
			// 移动地图中心点到选择的景点
			map.panTo(new BMap.Point(pointsData.point.longitude,pointsData.point.latitude));

			setTimeout(function(){    //弹窗内事件绑定
				mapWin.audio('aud'+id,'playpause'+id);
				mapWin.details('details'+id,pointsData.id);
				mapWin.goto('toGo'+id,pointsData,map);
			},100);

		});
	},
	"zoomChange":function(){  //地图缩放监听
		map.addEventListener("zoomend", function (e) {
			var zoomVal = e.currentTarget.Ka;
			mapEvents.zoomUtil(zoomVal);
		});
	},
	"zoomUtil":function(zoomVal){  //地图缩放中转
		mapEvents.zoomParamFun(zoomVal);
	},
	"zoomParamFun":function(zoomVal) {  //地图缩放按钮算法
		switch (zoomVal) {
			case 17:
				mapBasic.updatePoint(30, 30);
				break;
			case 16:
				mapBasic.updatePoint(10, 10);
				break;
			case 15:
				mapBasic.updatePoint(5, 5);
				break;
			default:
				mapBasic.updatePoint(0, 0);
		}
	},
}


/*-----------------------------------------弹窗类对象-----------------------------------*/
var mapWin ={
	"mainWin":function (id,data){     //构建主弹窗
		// var content = [ " <div class='win-main' > <div class='win-title' >",data.name,"</div> <div class='win-submain'> <div class='win-img' > <img src='../img/photo.png'/> </div> <div class='win-info' > <ul class='win-subinfo' > <li>推荐指数: <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> </li>",
		// 	"<li>难度指数: <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> <img src='../img/starempty.png'/> </li> <li>乐趣指数: <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> <img src='../img/starfull.png'/> </li> </ul>",
		// 	"<div style='display:none;'><audio id='audid+' src='../audio/zhiquhuashanlu.mp3'></audio></div> </div> <div style='text-align: center;padding-bottom:10px;' > <span class='win-btn-main' > <input type='button' id='playpauseid+' class='win-sub-btn' value='播放' /> <input type='button' class='win-sub-btn' value='详情' /> <input type='button' id='id+' class='win-sub-btn' value='到这去' /> </span> </div> </div> </div>"];
		var recommendStar='',difficultyStar='',interestStar ='';

		for(var i=0;i<5;i++){
			if(i<data.recommendNum){
				recommendStar+="<img class='win-Star' src='../img/starfull.png'/>"
			}else{
				recommendStar+="<img class='win-Star' src='../img/starempty.png'/>"
			}
			if(i<data.difficultyNum){
				difficultyStar+="<img class='win-Star' src='../img/starfull.png'/>"
			}else{
				difficultyStar+="<img class='win-Star' src='../img/starempty.png'/>"
			}
			if(i<data.interestNum){
				interestStar+="<img class='win-Star' src='../img/starfull.png'/>"
			}else{
				interestStar+="<img class='win-Star' src='../img/starempty.png'/>"
			}
		}

		var content = [ " <div class='win-main' ><div class='winTopTitle'>",data.name,"</div><div class='winTopMiddleAll'><img class='win-img' src="+data.picture+"/><div><div class='winMiddleRight'><div class='winMiddleLine'><div class='winText'>推荐指数:</div>"+recommendStar+"</div><div class='winMiddleLine'><div class='winText'>难度指数:</div>"+difficultyStar+"</div><div class='winMiddleLine'><div class='winText'>趣味指数:</div>"+interestStar+"</div></div></div></div><div class='win-btn-view'><div style='display:none;'><audio id='aud"+id+"' src="+data.audio+"></audio></div><div class='win-btn-bg' id='playpause"+id+"'>播放语音</div><div class='win-btn-bg' id='details"+id+"'>查看详情</div><div class='win-btn-bg' id='toGo"+id+"'>到这去</div></div></div>"];
		var infoBox = new BMapLib.InfoBox(map,content.join(""),{
			closeIconMargin: "-1px -1px 0 0"
			,closeIconUrl:"../img/noview.png"
			,enableAutoPan: false
			,align: INFOBOX_AT_TOP
		});
		var poi = new BMap.Point(data.point.longitude,data.point.latitude);
		var marker = new BMap.Marker(poi);
		if(toastView){
			toastView.close();
		}
		infoBox.open(marker);
		toastView=infoBox;
		marker.enableDragging();
	},
	"audio":function (audId,btnId){   //音频绑定
		var aud = document.getElementById(audId);
		var btn = document.getElementById(btnId);
		btn.addEventListener('touchstart',function(){
			isClose = false;
			if (aud.paused) {
				aud.play();
				btn.innerHTML='暂停播放';
			} else {
				aud.pause();
				btn.innerHTML='播放语音';
			}
		});
		btn.addEventListener('touchend',function(){
			setTimeout(function(){    //延时执行
				isClose = true;
			},100);
		});
		// aud.addEventListener("play", function (e) {
		// 	//img.src="../img/pause.jpg";
		// }, false);
		// aud.addEventListener("pause", function (e) {
		// 	//img.src="../img/play.jpg";
		// }, false);
	},
	"details":function (btnId,sceneId) {
		var btn = document.getElementById(btnId);
		btn.addEventListener('touchstart',function(){
			window.location.href ='/huashan/ScenicDetail/'+sceneId;
		});
	},
	"goto":function (id,pointsData){  //弹窗按钮初始化
		var btn = document.getElementById(id);
		btn.addEventListener('touchstart',function(){
			var nowPoint = new BMap.Point(110.08884,34.532144);  // 创建点坐标
			var endPoint = new BMap.Point(pointsData.point.longitude,pointsData.point.latitude);  // 创建点坐标
			mapNavigation.goToOnePoint(nowPoint,endPoint);
		});
		// $("#"+id).on('click',function(){
        //
		// 	window.location.href ='http://localhost:3000';
		// });
	}

}

/*-----------------------------------------导航类对象-----------------------------------*/
//这个数组用来存储上次导航的所有marker,在下次规划路线的时候,就会把之前的marker清除掉
// var	mapNavigationMarkerArray = [];

var mapNavigation = {
	//手工导航
	"goToOnePoint":function (startPoint,endPoint) {
		// for (deleteNum in mapNavigationMarkerArray){
		// 	map.removeOverlay(mapNavigationMarkerArray[deleteNum]);
		// 	// alert(mapNavigationMarkerArray[deleteNum]);
		// }
		// mapNavigationMarkerArray = [];

		var walking = new BMap.WalkingRoute(map, {renderOptions:{map: map, autoViewport: true}});
		walking.search(startPoint, endPoint);
		//禁止地图自动进行缩放移动
		walking.disableAutoViewport();
        //
		walking.setSearchCompleteCallback(function (rs) {
			var abc = rs;
			var walkingRouteResult = walking.getResults();
			var pts = walkingRouteResult.getPlan(0).getRoute(0).getPath();
			map.addOverlay(new BMap.Polyline(pts, { strokeColor: "green", strokeWeight: 2, strokeOpacity: 1 }));
		});

		// walking.setMarkersSetCallback(function (array) {
		// 	var point0 = array[0].marker;
		// 	var point1 = array[1].marker;
		// 	mapNavigationMarkerArray.push(point0,point1);
		// })
		// walking.setPolylinesSetCallback(function (routes) {
		// 	var polyLine =  routes[0].getPolyline();
		// 	mapNavigationMarkerArray.push(polyLine);
		// })
	},
	//推荐路线
	"mainNavgation":function (pointArray) {
		// for (deleteNum in mapNavigationMarkerArray){
		// 	map.removeOverlay(mapNavigationMarkerArray[deleteNum]);
		// }
		// mapNavigationMarkerArray = [];
		for(num =0;num < pointArray.length-1; num++)
		{
			var nowPoint = new BMap.Point(pointArray[num].longitude,pointArray[num].latitude);  // 创建点坐标
			var nowPoint1 = new BMap.Point(pointArray[num+1].longitude,pointArray[num+1].latitude);  // 创建点坐标
			// var walking = new BMap.WalkingRoute(map, {renderOptions:{map: map, autoViewport: true}});
			// walking.search(nowPoint, nowPoint1);
			//禁止地图自动进行缩放移动

			// 这个是用来处理索道的重要!!!!!!
			// var polyline = new BMap.Polyline([nowPoint,nowPoint1], {strokeColor:"green", strokeWeight:2, strokeOpacity:1});  //定义折线
			// map.addOverlay(polyline);     //添加折线到地图上


			mapNavigation.showPath(nowPoint,nowPoint1,num);
			// //因为要多点导航出一条路,所以需要删除中间上面的起点,终点的marker
			// if(num==0){
			// 	walking.setMarkersSetCallback(function (array) {
			// 		var point1 = array[1].marker
			// 		map.removeOverlay(point1);
			// 		mapNavigationMarkerArray.push(point1);
			// 	})
			// }else if (num == pointArray.length-2){
			// 	walking.setMarkersSetCallback(function (array) {
			// 		var point0 = array[0].marker;
			// 		map.removeOverlay(point0);
			// 		mapNavigationMarkerArray.push(point0);
			// 	})
			// }else {
			// 	walking.setMarkersSetCallback(function (array) {
			// 		var point0 = array[0].marker;
			// 		var point1 = array[1].marker;
			// 		map.removeOverlay(point0);
			// 		map.removeOverlay(point1);
			// 		mapNavigationMarkerArray.push(point0,point1);
			// 	})
			// }
			// walking.setPolylinesSetCallback(function (routes) {
			// 	if(routes.length>0){
			// 		var polyLine =  routes[0].getPolyline();
			// 		mapNavigationMarkerArray.push(polyLine);
			// 	}
			// })
		}
	},
	"showPath":function (startPoint, EndPoint,num) {
		var walking = new BMap.WalkingRoute(map, { renderOptions: { map: map, autoViewport: true } });
		walking.search(startPoint, EndPoint);

		walking.setSearchCompleteCallback(function (rs) {
			var abc = rs;
			var pts = walking.getResults().getPlan(0).getRoute(0).getPath();
			map.addOverlay(new BMap.Polyline(pts, { strokeColor: "green", strokeWeight: 2, strokeOpacity: 1 }));
		});
		walking.disableAutoViewport();
		walking.setMarkersSetCallback(function (array) {
			var point0 = array[0].marker;
			var point1 = array[1].marker;
			map.removeOverlay(point0);
			map.removeOverlay(point1);
		})
		//var startIcon = new BMap.Icon("ic_map_location.png", new BMap.Size(45, 45));
		// //var m1 = new BMap.Marker(firstPoint, { icon: startIcon, offset: new BMap.Size(-8, -15) });

		var m1 = new BMap.Marker(startPoint);
		map.addOverlay(m1);
		var lab1 = new BMap.Label(num+1, { position: startPoint, offset: new BMap.Size(-17, -25) });
		lab1.setStyle({
			color: "#fff",
			fontSize: "16px",
			backgroundColor: "0.05",
			border: "0",
			fontWeight: "bold",
			width :"30px",
			textAlign:'center'
		});
		map.addOverlay(lab1);
	}
}

/*-----------------------------------------左上角控件-----------------------------------*/
// 定义一个控件类,即function
function chooseLinesController(){
	// 默认停靠位置和偏移量
	this.defaultAnchor = BMAP_ANCHOR_TOP_RIGHT;
	this.defaultOffset = new BMap.Size(20, 60);
}

// 通过JavaScript的prototype属性继承于BMap.Control
chooseLinesController.prototype = new BMap.Control();

// 自定义控件必须实现自己的initialize方法,并且将控件的DOM元素返回
// 在本方法中创建个div元素作为控件的容器,并将其添加到地图容器中
chooseLinesController.prototype.initialize = function(map){
	// 创建一个DOM元素
	var div = document.createElement("div");
	// 设置样式
	div.style.width = 60 + "px";
	div.style.height = 20 + "px";

	var img = new Image ();
	img.src = '../img/chooseLines.png';
	img.style.width = '100%';
	img.style.height = '100%';
	img.onload = function ()
	{
		div.style['background-image'] = "url(../img/chooseLines.png)";
		div.style.backgroundSize = "60px";
		div.style.backgroundRepeat = "no-repeat"
	}
	// 绑定事件,点击一次放大两级
	div.onclick = function(e){
		window.location.href ='/huashan/ChooseLines';
	}
	// 添加DOM元素到地图中
	map.getContainer().appendChild(div);
	// 将DOM元素返回
	return div;
}

/*-----------------------------------------左下角控件-----------------------------------*/
// 定义一个控件类,即function
function zoomLocationControll(){
	// 默认停靠位置和偏移量
	this.defaultAnchor = BMAP_ANCHOR_BOTTOM_LEFT;
	this.defaultOffset = new BMap.Size(20, 40);
}

// 通过JavaScript的prototype属性继承于BMap.Control
zoomLocationControll.prototype = new BMap.Control();

// 自定义控件必须实现自己的initialize方法,并且将控件的DOM元素返回
// 在本方法中创建个div元素作为控件的容器,并将其添加到地图容器中
zoomLocationControll.prototype.initialize = function(map){
	// 创建一个DOM元素
	var div = document.createElement("div");
	// 设置样式
	div.style.width = 50 + "px";
	div.style.height = 22 + "px";

	var img = new Image ();
	img.src = '../img/location.png';
	img.style.width = '100%';
	img.style.height = '100%';
	img.onload = function ()
	{
		div.style['background-image'] = "url(../img/location.png)";
		div.style.backgroundSize = "50px";
		div.style.backgroundRepeat = "no-repeat"
	}
	// 绑定事件,点击一次放大两级
	div.onclick = function(e){
		mapPosition.moveToNowPosition(true);
	}
	// 添加DOM元素到地图中
	map.getContainer().appendChild(div);
	// 将DOM元素返回
	return div;
}

/*-----------------------------------------右下角控件-----------------------------------*/
// 定义一个控件类,即function
function zoomSetControll(){
	// 默认停靠位置和偏移量
	this.defaultAnchor = BMAP_ANCHOR_BOTTOM_RIGHT;
	this.defaultOffset = new BMap.Size(20, 40);
}

// 通过JavaScript的prototype属性继承于BMap.Control
zoomSetControll.prototype = new BMap.Control();

// 自定义控件必须实现自己的initialize方法,并且将控件的DOM元素返回
// 在本方法中创建个div元素作为控件的容器,并将其添加到地图容器中
zoomSetControll.prototype.initialize = function(map){
	// 创建一个DOM元素
	var div = document.createElement("div");
	// 设置样式
	div.style.width = 50 + "px";
	div.style.height = 22 + "px";

	var img = new Image ();
	img.src = '../img/set.png';
	img.style.width = '100%';
	img.style.height = '100%';
	img.onload = function ()
	{
		div.style['background-image'] = "url(../img/set.png)";
		div.style.backgroundSize = "50px";
		div.style.backgroundRepeat = "no-repeat"
	}
	// 绑定事件,点击一次放大两级
	div.onclick = function(e){
		mapNavigation.mainNavgation(path);
	}
	// 添加DOM元素到地图中
	map.getContainer().appendChild(div);
	// 将DOM元素返回
	return div;
}
/*-----------------------------------------定位类对象-----------------------------------*/

translateCallback = function (data){
	if(data.status === 0) {
		var marker = new BMap.Marker(data.points[0]);
		bm.addOverlay(marker);
		var label = new BMap.Label("转换后的百度坐标（正确）",{offset:new BMap.Size(20,-10)});
		marker.setLabel(label); //添加百度label
		bm.setCenter(data.points[0]);
	}
}


var mapPosition={
	"moveToNowPosition":function (isMoveMap){   //实时定位
		if(navigator.geolocation){
			navigator.geolocation.watchPosition(function (pos) {
				var crd = pos.coords;
				var point = new BMap.Point(crd.longitude,crd.latitude);  // 创建点坐

				var convertor = new BMap.Convertor();
				var pointArr = [];
				pointArr.push(point);
				convertor.translate(pointArr, 1, 5, function (data){
					if(data.status === 0) {
						var iconFramePosition = mapBasic.moveIconPosition(data.points[0]);
						marker.setPosition(data.points[0]);   //移动图标
						iconMarker.setPosition(iconFramePosition);	//移动头像框架
						if(isMoveMap){
							map.panTo(data.points[0]);
							//只有点击定位才会触发移动地图,其他都不会
							isMoveMap = false;
						}
					}
				})
			}, function (err) {
				alert('定位失败');
			}, {enableHighAccuracy: true,timeout: 10000,maximumAge: 5000});

		}
	},
	"clickMoveToPositon":function(){    //点击定位
		var navigationControl = new BMap.NavigationControl({
			// 靠左上角位置
			anchor: BMAP_ANCHOR_TOP_LEFT,
			// LARGE类型
			type: BMAP_NAVIGATION_CONTROL_LARGE,
			// 启用显示定位
			enableGeolocation: false
		});
		// 添加定位控件
		var geolocationControl = new BMap.GeolocationControl({
			showAddressBar:false,
			locationIcon:new BMap.Icon("../img/point.jpg", new BMap.Size(30,30))
		});

		geolocationControl.addEventListener("locationSuccess", function(e){
			// 定位成功事件
			var address = '';
			address += e.addressComponent.province;
			address += e.addressComponent.city;
			address += e.addressComponent.district;
			address += e.addressComponent.street;
			address += e.addressComponent.streetNumber;
			alert("当前定位地址为：" + address);

		});
		geolocationControl.addEventListener("locationError",function(e){
			// 定位失败事件
			alert(e.message);
		});

		return geolocationControl;
	}
}
/*-----------------------------------------基础类对象-----------------------------------*/
//这个数组用来存储上次景点的所有btn,用来地图放大缩小时变化尺寸
var	mapBasicBtnArray = [];
//这个数组用来存储上次景点的所有btn旁边的景点名字,用来地图放大缩小时变化尺寸
var	mapBasicLabelArray = [];

var mapBasic={
	"addTileLayer":function (){   //添加图层
		var tileLayer = new BMap.TileLayer();
		tileLayer.getTilesUrl = function(tileCoord, zoom) {
			var x = tileCoord.x;
			var y = tileCoord.y;
			return '../tiles/' + zoom + '/tile' + x + '_' + y + '.png';
		}
		return tileLayer;
	},
	"addMarker":function(map){   //添加定位点标注
		var myIcon = new BMap.Icon("../img/point.jpg", new BMap.Size(30,30),{
			imageSize:new BMap.Size(30,30)
		});
		var marker = new BMap.Marker(point,{icon:myIcon});
		map.addOverlay(marker);   //初始化坐标

		return marker;
	},
	"addIconFrame":function(map){   //添加定位点标注
		var iconFramePosition = mapBasic.moveIconPosition(point);
		var iconFrame = new BMap.Icon("../img/menIconFrame.png", new BMap.Size(53,53), {
			imageSize:new BMap.Size(53,53),
			anchor:new BMap.Size(26.5,20)
		});

		var iconMarker = new BMap.Marker(iconFramePosition,{icon:iconFrame});
		map.addOverlay(iconMarker);   //初始化坐标

		return iconMarker;
	},
	"buildPoint":function(){   //构建地标点
		for (var i = 0; i < pointsData.length; i ++) {
			var point = new BMap.Point(pointsData[i].point.longitude,pointsData[i].point.latitude);  // 创建点坐标
			var myButton = new ButtonOverlay(point,30,30, "rgba(255, 0, 0, 0.44)",i);
			map.addOverlay(myButton);
			mapEvents.addEvent(myButton,i,pointsData[i],map);
			mapBasicBtnArray.push(myButton);

			var opts = {
				position : point,    // 指定文本标注所在的地理位置
				offset   : new BMap.Size(20, -13)    //设置文本偏移量
			}
			var label = new BMap.Label(pointsData[i].name, opts);  // 创建文本标注对象
			label.setStyle({
				color : "black",
				backgroundColor: 'white',
				fontSize : "12px",
				height : "20px",
				// lineHeight : "20px",
				fontFamily:"微软雅黑"
			});
			map.addOverlay(label);
			mapBasicLabelArray.push(label);
		}
	},
	"updatePoint":function(width,height){  //更新地标点
		for (deleteNum in mapBasicBtnArray){
			map.removeOverlay(mapBasicBtnArray[deleteNum]);
		}
		mapBasicBtnArray = [];
		for (var i = 0; i < pointsData.length; i ++) {
			var point = new BMap.Point(pointsData[i].point.longitude,pointsData[i].point.latitude);  // 创建点坐标
			var myButton = new ButtonOverlay(point,width,height, "rgba(255, 0, 0, 0.44)",i);
			map.addOverlay(myButton);
			mapEvents.addEvent(myButton,i,pointsData[i]);
			mapBasicBtnArray.push(myButton);
		}
	},
	//根据主角坐标算出来头像框坐标,抽象出来的大小
	"moveIconPosition":function(point){
		// var newPosition = new BMap.Point(point.lng-0.00004,point.lat-0.0001);  // 创建点坐标
		var newPosition = new BMap.Point(point.lng,point.lat);  // 创建点坐标
		return newPosition;
	},

}
/*-----------------------------------------自定义遮盖物-----------------------------------------------*/

//自定义按钮构造函数
function ButtonOverlay(point,width,height,color,num){
	this._point = point;
	this._color = color;
	this._width = width;
	this._height = height;
	this._num = num;
}

//继承百度接口
ButtonOverlay.prototype = new BMap.Overlay();

//初始化按钮
ButtonOverlay.prototype.initialize = function(map){

	this._map = map;

	var div = document.createElement("div");
	div.style.position = "absolute";

	div.style.width = this._width + "px";
	div.style.height = this._height + "px";
	div.style.background = this._color;
	var img = new Image ();
	img.src = pointsData[this._num].icon;
	img.width = div.style.width;
	img.height = div.style.height;
	var num = this._num;
	img.onload = function ()
	{
		div.style['background-image'] = "url" + "(" + pointsData[num].icon + ")";
		div.style.backgroundSize = "30px";
	}
	map.getPanes().markerPane.appendChild(div);

	this._div = div;

	return div;
}

// 实现绘制方法
ButtonOverlay.prototype.draw = function(){
// 根据地理坐标转换为像素坐标，并设置给容器
	var position = this._map.pointToOverlayPixel(this._point);

	this._div.style.left = position.x - this._width / 2 + "px";
	this._div.style.top = position.y - this._height / 2 + "px";
}

//显示
ButtonOverlay.prototype.show = function(){
	if (this._div){
		this._div.style.display = "";
	}
}

//隐藏
ButtonOverlay.prototype.hide = function(){
	if (this._div){
		this._div.style.display = "none";
	}
}

//事件绑定
ButtonOverlay.prototype.addEventListener = function(event,fun){
	this._div['on'+event] = fun;
}


//公共方法
/*function $$(id){
 return document.getElementById(id);
 }*/




/*------------------------主地图初始化-----------------------------------*/

var map = new BMap.Map("container",{minZoom:4,maxZoom:17});          // 创建地图实例
var point = new BMap.Point(110.08884,34.532144);  // 创建点坐标
map.centerAndZoom(point, 17);                 // 初始化地图，设置中心点坐标和地图级别

//主角添加
var marker = mapBasic.addMarker(map);
marker.disableMassClear();
//主角框添加
var iconMarker = mapBasic.addIconFrame(map);
iconMarker.setTop(true);
iconMarker.disableMassClear();
//是否关闭弹窗
var isClose = true;
//定义唯一弹窗,为了关闭使用
var toastView;
function closeToast(e) {
	if(toastView){
		if(isClose){
			toastView.close();
		}
	}
}
map.addEventListener("click", closeToast);


// mapPosition.moveToNowPosition(false);

//添加放大缩小按钮控件
var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_LEFT, type: BMAP_NAVIGATION_CONTROL_SMALL,offset: new BMap.Size(10, 40)}); //右上角
map.addControl(top_right_navigation);

//添加图层
map.addTileLayer(mapBasic.addTileLayer());

//添加点击定位
// map.addControl(mapPosition.clickMoveToPositon());

//添加比例尺
// map.addControl(new BMap.ScaleControl());

//监听地图缩放
mapEvents.zoomChange();

// 创建右下角设置控件
var myRightDownControll = new zoomSetControll();
// 添加到地图当中
map.addControl(myRightDownControll);

// 创建左下角定位控件
var myLeftDownControll = new zoomLocationControll();
// 添加到地图当中
map.addControl(myLeftDownControll);

// 创建左上角推荐路线控件
var myLeftUpControll = new chooseLinesController();
// 添加到地图当中
map.addControl(myLeftUpControll);

netWorkManager.getAllPoints();

if(GetQueryString("id")!=null){
	netWorkManager.drawLines(GetQueryString("id"));
}

function GetQueryString(name)
{
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)return  unescape(r[2]); return null;
}



//点到点绘图
/*var pointA = new BMap.Point(110.08884,34.532144);  // 创建点坐标A--华山站
 var pointB = new BMap.Point(110.088647,34.530261);  // 创建点坐标B--华山景区
 var polyline = new BMap.Polyline([pointA,pointB], {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.5});  //定义折线
 map.addOverlay(polyline);     //添加折线到地图上
 map.disableDragging();      //禁止拖动*/

/*边界限制(重要)*/
/*map.enableScrollWheelZoom();
 var b = new BMap.Bounds(new BMap.Point(110.08495, 34.529265),new BMap.Point(110.093556, 34.534019));
 try {
 BMapLib.AreaRestriction.setBounds(map, b);
 } catch (e) {
 alert(e);
 }*/

/*map.addEventListener("dragend", function(){
 var center = map.getCenter();
 console.log("地图中心点变更为：" + center.longitude + ", " + center.latitude);
 });

 //从事件对象中获取经纬度坐标点，可用于地图边界计算(重要)
 map.addEventListener("click", function(e){
 console.log(e.point.longitude + ", " + e.point.latitude);
 });*/