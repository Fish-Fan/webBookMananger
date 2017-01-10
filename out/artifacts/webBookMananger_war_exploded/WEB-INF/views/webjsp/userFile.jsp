<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
    <div class="container">
        <div class="well">
            <h1>修改个人资料</h1>
        </div>
        <div class="col-md-4">
            <form action="/updateUserFile" method="post" enctype="multipart/form-data" >
                <label>头像：</label>
                <input type="file" name="uploadFile">

                <input type="hidden" value="${user.rno}" name="rno"> 
                <label>
                    姓名：
                </label>
                <input type="text" value="${user.rname}" class="form-control" name="rname">

                <label>性别</label>
                男：<input type="radio" value="${user.rgender}" name="rgender" ${user.rgender == "男" ? "checked" : ""}>
                女：<input type="radio" value="${user.rgender}" name="rgender" ${user.rgender == "女" ? "checked" : ""}>
                <br>
                <label>年龄:</label>
                <input type="text" value="${user.rage}" name="rage" class="form-control">

                <label>专业：</label>
                <input type="text" value="${user.rspecialty}" class="form-control" name="rspecialty">

                <label>密码：</label>
                <input type="text" value="${user.rpassword}" class="form-control" name="rpassword">

                <button class="btn btn-primary">保存修改</button>
            </form>

        </div>
    </div>
</body>
</html>