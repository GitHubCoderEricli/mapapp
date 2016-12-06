<%--
  Created by IntelliJ IDEA.
  User: lixu
  Date: 2016-08-14
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script type="text/javascript" src="../js/script.js ">
  </script>
  <script type="text/javascript" src="../js/jquery-3.1.0.min.js "></script>
</head>

<script>
  function test() {
    $.ajax({
      url:"/SceneryPoint/getAll",
      type:"get",
      contentType : 'application/json',
      dataType : 'json',
      success:function(data){
        alert(data[1].icon);
//        $(".abc").src(data[1].icon);
        $(".abc").attr("src", data[1].icon);
      },
      error:function(){
        alert("abcd");
      }
    });
  }
</script>

<body>
<span>----------------------------</span><br>
${user.nickname}<br>

<div class="abcd">
<img src="" class="abc">
</div>

<input type="button" onclick="test()"><br>

<div class="form-group">
  <label class="col-lg-3 control-label">上传文件</label>

  <div class="col-lg-5">
    <input class="form-control" type="file" name="file_url"/>

  </div>
</div>

</body>
</html>
