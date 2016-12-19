<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>华山路线景点系统管理后台</title>

    <!-- 引入用于生产环境的Bootstrap核心样式表 -->
    <!--<link href="../css/bootstrap.min.css" rel="stylesheet">-->

    <!-- 引入用于开发环境的Bootstrap核心样式表 -->
    <link rel="stylesheet" href="../css/bootstrap.css">

    <!-- Common Stylesheet Including -->
    <link rel="stylesheet" href="../css/common-style.css">

    <style>
        .vertical-center {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    </style>

    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>

<body style="">


<div class="vertical-center panel panel-default" style="width:500px">
    <div class="panel-heading">
        <h3 class="panel-title">登陆</h3>
    </div>
    <form id="loginForm" action="/adminUser/login" method="post">
        <div class="form-horizontal panel-body" role="form">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>

                <div class="col-sm-10">
                    <input type="username" id="userName" name="userName" class="form-control" id="inputEmail3" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">密码</label>

                <div class="col-sm-10">
                    <input type="password" id="password" name="password" class="form-control" id="inputPassword3" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <a href="homepage.html">
                        <button type="submit" class="btn btn-primary">登陆</button>
                    </a>
                </div>
            </div>
        </div>
    </form>
</div>


<!-- 页脚 -->
<div>
    <footer class="sig clearfix" style="position:absolute;bottom:0">
        <div class="copyright pull-left">
            &copy; 2016 华山旅游公司版权所有&nbsp;&nbsp;&nbsp;
        </div>
        <div class="contact pull-right">
            联系电话：0913-8888888
        </div>
    </footer>
</div>

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

<script>
    function alertDanger(message) {
        var div = $("<div>").addClass("alert alert-danger alert-dismissable");
        var html = '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><h4><i class="icon fa fa-ban"></i>错误！</h4>'+message;
        div.html(html);
        div.css({
            float: "none",
            position: "absolute",
            top: "10px",
            left: "41%"
        });
        $("body").prepend(div);
        setTimeout(function () {
            div.remove();
        }, 3000);
    }
    $(function () {
        function ajaxLogin() {
            var loginForm = $("#loginForm");
            $.ajax({
                type: 'POST',
                url: loginForm.attr("action"),
                data: loginForm.serialize(),
                dataType: "json",
                success: function (result) {
                    if (result.result) {
                        window.location.href = "/layout/main";
                    } else {
                        alertDanger(result.message);
                    }
                },
                error : function(result) {
                    alertDanger(result.message);
                }
            });
            return false;
        }

        $("#loginForm").submit(ajaxLogin);
    });
</script>
</body>

</html>