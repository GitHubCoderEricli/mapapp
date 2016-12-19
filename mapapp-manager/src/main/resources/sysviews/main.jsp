<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<head>
    <%--<meta charset="utf-8">--%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>华山路线景点系统管理后台</title>

    <!-- 引入用于生产环境的Bootstrap核心样式表 -->
    <!--<link href="../css/bootstrap.min.css" rel="stylesheet">-->

    <!-- 引入用于开发环境的Bootstrap核心样式表 -->
    <link rel="stylesheet" href="../css/bootstrap.css">

    <!-- Common Stylesheet Including -->
    <link rel="stylesheet" href="../css/common-style.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <!--<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>-->
    <!--<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>-->
    <script src="/html5shiv/respond.min.js"></script>
    <script src="/html5shiv/html5shiv.min.js"></script>
    <%--<![endif]-->--%>
</head>

<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="/layout/main" onclick="writeBody('homePage.html', 'targetContainer')">主页</a>

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">景点管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="sightAdd.html">新增景点</a>
                        </li>
                        <li>
                            <a href="/pointInfo/list">景点列表</a>
                        </li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">特殊点管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="specialPointAdd.html">新增特殊点</a>
                        </li>
                        <li>
                            <a href="specialPointList.html">特殊点列表</a>
                        </li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">路线管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="routeAdd.html">新增路线</a>
                        </li>
                        <li>
                            <a href="/pointInfo/list">路线列表</a>
                        </li>
                    </ul>
                </li>
            </ul>

            <!--Search Bar-->
            <!--<form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>-->

            <!--This part contains the right part of the navigator bar-->
            <!--<ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">Right</a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">Action</a>
                        </li>
                        <li>
                            <a href="#">Another action</a>
                        </li>
                        <li>
                            <a href="#">Something else here</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="#">Separated link</a>
                        </li>
                    </ul>
                </li>
            </ul>-->
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<div class="panel panel-default">
    <div class="panel-heading">
        欢迎使用！
    </div>
    <div class="panel-body">
        <div class="nav" style="text-align:center">
            <img src="../image/MountainHua.jpg" alt="华山">
        </div>
    </div>
</div>

<!-- 页脚 -->
<footer class="sig clearfix">
    <div class="copyright pull-left">
        &copy; 2016 华山旅游公司版权所有
    </div>
    <div class="contact pull-right">
        联系电话：0913-8888888
    </div>
</footer>

<!-- jQuery (Bootstrap依赖的JavaScript库) -->
<!-- 在线Jqery资源（CDN链接） -->
<!--<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>-->
<!-- 由以上环境下载得来的本地资源 -->
<script src="../js/jquery1.11.1_local.js"></script>

<!-- 引入用于生产环境的Bootstrap核心脚本，或者在此之下引入各个组件 -->
<!--<script src="../js/bootstrap.min.js"></script>-->

<!-- 引入用于开发环境的Bootstrap核心脚本 -->
<script src="../js/bootstrap.js"></script>

<!-- 用于插入页面顶部主题的方法 -->
<script type="text/javascript">
    $(document).ready(function () {
        var title = "华山路线景点管理系统";
        var discription = "";
        var developStatus = "";
        setHeader(title, discription, developStatus);
    })
</script>

<!-- 引入用于控制样式的公共脚本 -->
<script src="../js/common-script.js"></script>
</body>
</html>