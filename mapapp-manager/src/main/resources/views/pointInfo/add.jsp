<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>华山路线景点系统管理后台</title>

    <!-- 引入用于生产环境的Bootstrap核心样式表 -->
    <!--<link href="../css/bootstrap.min.css" rel="stylesheet">-->

    <!-- 引入用于开发环境的Bootstrap核心样式表 -->
    <link rel="stylesheet" href="../css/bootstrap.css">

    <!-- 引入公用的样式表 -->
    <link rel="stylesheet" href="../css/common-style.css">

    <!-- 引入Bootstrap Table核心样式表 -->
    <link rel="stylesheet" href="../css/bootstrap-table.css">

    <!-- 引入用于控制样式的公共脚本 -->
    <script src="../js/common-script.js"></script>

    <!-- 引入Bootstrap Table 核心插件 -->
    <script src="../js/bootstrap-table.js"></script>

    <!-- 引入Bootstrap Table 汉化插件 -->
    <script src="../js/bootstrap-table-zh-CN.js"></script>

    <script type="text/javascript" src="/plugins/jQuery/jQuery-2.1.4.min.js"></script>

    <!-- jQuery (Bootstrap依赖的JavaScript库) -->
    <!-- 在线Jqery资源（CDN链接） -->
    <!--<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>-->
    <!-- 由以上环境下载得来的本地资源 -->
    <script src="../js/jquery1.11.1_local.js"></script>

    <!-- 引入用于生产环境的Bootstrap核心脚本，或者在此之下引入各个组件 -->
    <!--<script src="../js/bootstrap.min.js"></script>-->

    <!-- 引入用于开发环境的Bootstrap核心脚本 -->
    <script src="../js/bootstrap.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="/html5shiv/respond.min.js"></script>
    <script src="/html5shiv/html5shiv.min.js"></script>
    <![endif]-->

    <script src="/plugins/select2/select2.js"></script>
    <link rel="stylesheet" href="/plugins/select2/select2.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="homepage.html" onclick="writeBody('homePage.html', 'targetContainer')">主页</a>

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown active">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">景点管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="active">
                            <a href="/pointInfo/add">新增景点</a>
                        </li>
                        <li>
                            <a href="/pointInfo/list">景点列表</a>
                        </li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">特殊点管理 <span class="caret"></span></a>
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">路线管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="routeAdd.html">新增路线</a>
                        </li>
                        <li>
                            <a href="routeList.html">路线列表</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- 在此之下编辑网页内容 -->

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">
            景点管理
            /
            新增景点
        </h3>
    </div>
    <div class="panel-body">
        <form id="defaultForm" class="form-horizontal" action="/pointInfo/save" method="post"
              enctype="multipart/form-data">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="row">
                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">坐标点ID</label>
                                    <label for="pointId">
                                        <select class="js-example-basic-single js-states form-control" id="pointId"
                                                name="pointId">
                                            <option value="" selected="selected">请选择</option>
                                            <c:forEach items="${pointList}" var="point" varStatus="obj">
                                                <option value="${point.id}">${point.id}&nbsp;&nbsp;${point.note}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">名称</label>

                                    <div class="col-md-8">
                                        <input class="form-control" type="text" name="name">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">景点图标</label>
                                    <input id="sightIconFile" type="file" name="file">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">简短描述</label>

                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="shortDes">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">缩略图</label>
                                    <input id="picture" type="file" name="file">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">地址</label>

                                    <div class="col-md-8">
                                        <input class="form-control" type="text" name="address">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">音频</label>
                                    <input id="video" type="file" name="file">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">推荐指数</label>

                                    <div class="col-md-8">
                                        <select name="recommendNum" id="3" class="form-control">
                                            <option value="">请选择</option>
                                            <option value="1">一星</option>
                                            <option value="2">二星</option>
                                            <option value="3">三星</option>
                                            <option value="4">四星</option>
                                            <option value="5">五星</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">困难指数</label>

                                    <div class="col-md-8">
                                        <select name="difficultyNum" id="4" class="form-control">
                                            <option value="">请选择</option>
                                            <option value="1">一星</option>
                                            <option value="2">二星</option>
                                            <option value="3">三星</option>
                                            <option value="4">四星</option>
                                            <option value="5">五星</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">趣味指数</label>

                                    <div class="col-md-8">
                                        <select name="interestNum" id="5" class="form-control">
                                            <option value="">请选择</option>
                                            <option value="1">一星</option>
                                            <option value="2">二星</option>
                                            <option value="3">三星</option>
                                            <option value="4">四星</option>
                                            <option value="5">五星</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">类型</label>

                                    <div class="col-md-8">
                                        <select name="type" id="6" class="form-control">
                                            <option value="">请选择</option>
                                            <option value="0">景点</option>
                                            <option value="1">停车场</option>
                                            <option value="2">WC</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">备注</label>

                                    <div class="col-md-8">
                                        <textarea rows="3" class="form-control" type="text"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-horizontal">
                            <div class="col-md-6 form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">景点描述</label>

                                    <div class="col-md-8">
                                        <textarea rows="3" class="form-control" type="text" name="detailDis"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table id="sight-rolling-picutre-list"></table>
            <div class="nav" style="text-align:center">
                <div class="btn-group">
                    <button type="submit" class="btn btn-default btn-primary">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- 在此之上编辑网页内容 -->

<!-- 页脚 -->
<footer class="sig clearfix">
    <div class="copyright pull-left">
        &copy; 2016 华山旅游公司版权所有
    </div>
</footer>
<!-- 用于插入页面顶部主题的方法 -->
<script type="text/javascript">
    $(document).ready(function () {
        var title = "华山路线景点管理系统";
        var discription = "";
        var developStatus = "";
        setHeader(title, discription, developStatus);
    })

    $(document).ready(function () {
        $("#id_label_single").select2();
    });
</script>

<!-- 绘制景点轮播图列表的脚本 -->
<%--<script>--%>
<%--$(document).ready(function () {--%>
<%--$("#sight-rolling-picutre-list").bootstrapTable({--%>
<%--columns: [--%>
<%--{--%>
<%--field: "index",--%>
<%--title: "序号",--%>
<%--align: "center",--%>
<%--valign: "middle"--%>
<%--},--%>
<%--{--%>
<%--field: "file",--%>
<%--title: "文件",--%>
<%--align: "center",--%>
<%--valign: "middle"--%>
<%--},--%>
<%--{--%>
<%--field: "operation",--%>
<%--title: "操作",--%>
<%--align: "center",--%>
<%--valign: "middle"--%>
<%--}--%>
<%--],--%>
<%--data: [--%>
<%--{--%>
<%--index: "<input type='text' class='form-control' placeholder='1'>",--%>
<%--file: "<div class='input-group'><span type='text' class='form-control'>C://user//Administrator//desktop//icon.png</span><span class='input-group-addon btn btn-default' onclick='$(this).next().click();'>选择文件</span><input id='sightIconFile' class='form-control hidden' type='file'></div>",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--index: "<input type='text' class='form-control' placeholder='2'>",--%>
<%--file: "<div class='input-group'><span type='text' class='form-control'>C://user//Administrator//desktop//icon.png</span><span class='input-group-addon btn btn-default' onclick='$(this).next().click();'>选择文件</span><input id='sightIconFile' class='form-control hidden' type='file'></div>",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--index: "<input type='text' class='form-control' placeholder='3'>",--%>
<%--file: "<div class='input-group'><span type='text' class='form-control'>C://user//Administrator//desktop//icon.png</span><span class='input-group-addon btn btn-default' onclick='$(this).next().click();'>选择文件</span><input id='sightIconFile' class='form-control hidden' type='file'></div>",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--index: "<input type='text' class='form-control' placeholder='4'>",--%>
<%--file: "<div class='input-group'><span type='text' class='form-control'>C://user//Administrator//desktop//icon.png</span><span class='input-group-addon btn btn-default' onclick='$(this).next().click();'>选择文件</span><input id='sightIconFile' class='form-control hidden' type='file'></div>",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--index: "<input type='text' class='form-control' placeholder='5'>",--%>
<%--file: "<div class='input-group'><span type='text' class='form-control'>C://user//Administrator//desktop//icon.png</span><span class='input-group-addon btn btn-default' onclick='$(this).next().click();'>选择文件</span><input id='sightIconFile' class='form-control hidden' type='file'></div>",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>"--%>
<%--}--%>

<%--],--%>
<%--pagination: true,--%>
<%--striped: true, //奇偶行使用不同的颜色--%>
<%--showColumns: true, //动态调整列--%>
<%--pageList: "[5, 10, 15]", //分页参数--%>
<%--search: true, //是否使用全局模糊搜索--%>
<%--toolbar: "#sightRollingPictureListAddButton"--%>
<%--});--%>
<%--});--%>
<%--</script>--%>

<button id="sightRollingPictureListAddButton" type="button" class="form-control btn btn-default" title="添加">
    <span class="glyphicon glyphicon-plus"></span>
</button>

</body>

<!-- 模态窗口 -->
<!-- 用于提示删除的模态窗口 -->
<div class="modal fade" id="deleteConfirmModal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">提示</h4>
            </div>
            <div class="modal-body">
                确定删除该图片？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>
</html>