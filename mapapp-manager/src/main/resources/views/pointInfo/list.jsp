<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<!DOCTYPE html>
<head>
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

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <![endif]-->
    <script src="/html5shiv/respond.min.js"></script>
    <script src="/html5shiv/html5shiv.min.js"></script>
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

            <a class="navbar-brand" href="/layout/main" onclick="writeBody('homePage.html', 'targetContainer')">主页</a>

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown active">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">景点管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="sightAdd.html">新增景点</a>
                        </li>
                        <li class="active">
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
            景点列表
        </h3>
    </div>
    <div class="panel-body">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">查询</h3>
            </div>
            <%--查询框--%>
            <div class="panel-body">
                <form action="/pointInfo/list">
                    <div class="col-md-6 form-horizontal">
                        <div class="form-group">
                            <label class="col-md-4 control-label">景点类型</label>

                            <div class="col-md-8">
                                <select class="form-control" name="query[pointType]">
                                    <option value="">请选择</option>
                                    <option value="0" <c:if test="${pager.query.pointType==0}">selected = selected</c:if>>景点</option>
                                    <option value="1" <c:if test="${pager.query.pointType==1}">selected = selected</c:if>>停车场</option>
                                    <option value="2" <c:if test="${pager.query.pointType==2}">selected = selected</c:if>>WC</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 form-horizontal">
                        <div class="form-group">
                            <label class="col-md-4 control-label">景点名称</label>

                            <div class="col-md-8">
                                <input class="form-control" type="text" name="query[name]" value="${pager.query.name}">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 form-horizontal">
                        <div class="form-group">
                            <label class="col-md-4 control-label">景点ID</label>

                            <div class="col-md-8">
                                <input class="form-control" type="text" name="query[id]" value="${pager.query.id}">
                            </div>
                        </div>
                    </div>
                    <!-- 实现Bootstrap居中 -->
                    <div class="col-md-12">
                        <div class="nav" style="text-align:center">
                            <div class="btn-group">
                                <%--<button type="button" class="btn btn-default btn-primary">搜索</button>--%>
                                <li><input type="submit" value="搜索" class="button"></li>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <table id="sightList" class="table table-bordered table-striped dataTable">
            <thead>
            <tr>
                <th data-name="ids" class="sorting_disabled"><input type='checkbox' id="select-all"/>ID</th>
                <th nowrap>名称</th>
                <th nowrap>图标</th>
                <th nowrap>短描述</th>
                <th nowrap>图片</th>
                <th nowrap>地址</th>

                <th nowrap>音频描述</th>
                <th nowrap>推荐指数</th>
                <th nowrap>困难指数</th>
                <th nowrap>趣味指数</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="model" items="${pointInfoList}">
                <tr role="row" class="odd">
                    <td><input type='checkbox' value="${model.id}" name="ids"/>${model.id}</td>
                    <td nowrap>${model.name}</td>
                    <td nowrap>${model.icon}</td>
                    <td nowrap>${model.shortDes}</td>
                    <td nowrap>${model.picture}</td>
                    <td nowrap>${model.address}</td>

                    <td nowrap>${model.recommendNum}</td>
                    <td nowrap>${model.difficultyNum}</td>
                    <td nowrap>${model.interestNum}</td>
                    <td nowrap>
                        <c:if test="${model.type==0}">景点</c:if>
                        <c:if test="${model.type==1}">停车场</c:if>
                        <c:if test="${model.type==2}">wc</c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- 在此之上编辑网页内容 -->

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

<!-- 引入Bootstrap Table 核心插件 -->
<script src="../js/bootstrap-table.js"></script>

<!-- 引入Bootstrap Table 汉化插件 -->
<script src="../js/bootstrap-table-zh-CN.js"></script>

<!-- 绘制Bootstrap Table -->
<%--<script>--%>
<%--$(document).ready(function () {--%>
<%--$("#sightList").bootstrapTable({--%>
<%--columns: [--%>
<%--{--%>
<%--field: "id",--%>
<%--title: "景点ID",--%>
<%--align: "center",--%>
<%--valign: "middle"--%>
<%--},--%>
<%--{--%>
<%--field: "type",--%>
<%--title: "景点类型",--%>
<%--align: "center",--%>
<%--valign: "middle"--%>
<%--},--%>
<%--{--%>
<%--field: "name",--%>
<%--title: "景点名称",--%>
<%--align: "center",--%>
<%--valign: "middle"--%>
<%--},--%>
<%--{--%>
<%--field: "address",--%>
<%--title: "景点地址",--%>
<%--align: "center",--%>
<%--valign: "middle"--%>
<%--},--%>
<%--{--%>
<%--field: "longitude",--%>
<%--title: "经度",--%>
<%--align: "center",--%>
<%--valign: "middle"--%>
<%--},--%>
<%--{--%>
<%--field: "latitude",--%>
<%--title: "纬度",--%>
<%--align: "center",--%>
<%--valign: "middle"--%>
<%--},--%>
<%--{--%>
<%--field: "note",--%>
<%--title: "备注",--%>
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
<%--id: "<a href='sightDetail.html'>000002</a>",--%>
<%--type: "1",--%>
<%--name: "玉泉院",--%>
<%--address: "-",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "华山主入口",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightDetail.html'>000002</a>",--%>
<%--type: "2",--%>
<%--name: "玉泉院停车场",--%>
<%--address: "游客中心向西300米",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "-",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightDetail.html'>000002</a>",--%>
<%--type: "1",--%>
<%--name: "玉泉院",--%>
<%--address: "-",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "华山主入口",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightDetail.html'>000002</a>",--%>
<%--type: "2",--%>
<%--name: "玉泉院停车场",--%>
<%--address: "游客中心向西300米",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "-",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightDetail.html'>000002</a>",--%>
<%--type: "1",--%>
<%--name: "玉泉院",--%>
<%--address: "-",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "华山主入口",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightDetail.html'>000002</a>",--%>
<%--type: "2",--%>
<%--name: "玉泉院停车场",--%>
<%--address: "游客中心向西300米",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "-",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightDetail.html'>000002</a>",--%>
<%--type: "1",--%>
<%--name: "玉泉院",--%>
<%--address: "-",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "华山主入口",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightAdd.html'>000002</a>",--%>
<%--type: "2",--%>
<%--name: "玉泉院停车场",--%>
<%--address: "游客中心向西300米",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "-",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightAdd.html'>000002</a>",--%>
<%--type: "1",--%>
<%--name: "玉泉院",--%>
<%--address: "-",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "华山主入口",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightDetail.html'>000002</a>",--%>
<%--type: "2",--%>
<%--name: "玉泉院停车场",--%>
<%--address: "游客中心向西300米",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "-",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightDetail.html'>000002</a>",--%>
<%--type: "1",--%>
<%--name: "玉泉院",--%>
<%--address: "-",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "华山主入口",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--{--%>
<%--id: "<a href='sightDetail.html'>000002</a>",--%>
<%--type: "2",--%>
<%--name: "玉泉院停车场",--%>
<%--address: "游客中心向西300米",--%>
<%--longitude: "30.102930",--%>
<%--latitude: "108.10928",--%>
<%--note: "-",--%>
<%--operation: "<a href='javascript:void(0);' data-toggle='modal' data-target='#deleteConfirmModal'><span class='glyphicon glyphicon-remove' title='删除'></span></a>&nbsp;<a href='sightAdd.html'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>"--%>
<%--},--%>
<%--],--%>
<%--pagination: true,--%>
<%--striped: true, //奇偶行使用不同的颜色--%>
<%--showColumns: true, //动态调整列--%>
<%--pageList: "[5, 10, 15]", //分页参数--%>
<%--search: true, //是否使用全局模糊搜索--%>
<%--toolbar: "#sightListAddButton"--%>
<%--});--%>
<%--});--%>
<%--</script>--%>
<%--<button type="button" class="btn btn-default" id="sightListAddButton" title="添加">--%>
<%--<span class="glyphicon glyphicon-plus"></span>--%>
<%--</button>--%>
</body>

<!-- 模态窗口 -->
<!-- 用于提示删除的模态窗口 -->
<%--<div class="modal fade" id="deleteConfirmModal" tabindex="-1" role="dialog">--%>
<%--<div class="modal-dialog modal-sm">--%>
<%--<div class="modal-content">--%>
<%--<div class="modal-header">--%>
<%--<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>--%>
<%--<h4 class="modal-title" id="myModalLabel">提示</h4>--%>
<%--</div>--%>
<%--<div class="modal-body">--%>
<%--确定删除该景点？--%>
<%--</div>--%>
<%--<div class="modal-footer">--%>
<%--<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>--%>
<%--<button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

</html>