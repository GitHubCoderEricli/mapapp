<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>华山地图</title>
    <link href="../css/style.css" rel="stylesheet">
</head>

<body>
<img class="upImage" src="../img/upImage.png"/>
<div id="container"></div>
<img class="downImage" src="../img/downImage.png"/>

<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=CGSinZGQB3hi9PNhkOXgjBRAlxU9jqbd">
    //v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
    //v1.4版本及以前版本的引用方式：src="http://api.map.baidu.com/api?v=1.4&key=您的密钥&callback=initialize"
</script>

<script type="text/javascript" src="http://api.map.baidu.com/library/AreaRestriction/1.2/src/AreaRestriction_min.js"></script>
<script type="text/javascript" src="../js/InfoBox_min.js"></script>

<script type="text/javascript" src="../js/script.js"></script>
</body>
</html>



