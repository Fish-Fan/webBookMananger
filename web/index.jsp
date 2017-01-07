<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
        .text-error{
            color: darkred;
        }
    </style>
</head>
<body>
    <div class="container">

        <c:if test="${param.error == 1}">
            <div class="alert alert-danger">
                您输入的账号或密码错误！
            </div>
        </c:if>

        <c:if test="${param.state == 1}">
            <div class="alert alert-danger">
                请登录后完成操作
            </div>
        </c:if>

        <c:if test="${param.state == 2}">
            <div class="alert alert-success">
                退出登录成功
            </div>
        </c:if>

        <form action="/login" method="post" id="loginForm">
            <div class="col-md-4">
                <div>
                    <label for="username">账号：</label>
                    <input type="text" class="form-control" id="username" placeholder="请在此输入您的账号" name="username">
                </div>

               <div>
                   <label for="password">密码：</label>
                   <input type="password" class="form-control" id="password" placeholder="请在此输入您的密码" name="password">
               </div>

                <div class="form-actions">
                    <button class="btn btn-success">Login</button>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jQuery%201.9.1.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script>
        $(function () {
            $("#loginForm").validate({
                errorElement:'label',
                errorClass:'text-error',
                rules:{
                    username:{
                        required:true
                    },
                    password:{
                        required:true
                    }
                },
                messages:{
                    username:{
                        required:"请输入您的账号"
                    },
                    password:{
                        required:"请输入您的密码"
                    }
                }

            });


        });

    </script>
</body>
</html>