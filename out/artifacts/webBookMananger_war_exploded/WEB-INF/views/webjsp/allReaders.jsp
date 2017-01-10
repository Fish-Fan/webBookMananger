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
    <link rel="stylesheet" href="/css/bootstrap.css">
    <style>
        .avatar{
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>读者信息表</h1>

        <a href="/list" class="btn btn-primary">返回上一级</a>

        <table class="table">
            <thead>
                <tr>
                    <th>头像</th>
                    <th>读者编号</th>
                    <th>读者姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>专业</th>
                    <th>所借图书总数</th>
                    <th>所欠金额</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${readerList}" var="reader">
                    <tr>
                        <td><img src="/avatar?key=${reader.ruuid}" alt="avatar" class="avatar"></td>
                        <td>${reader.rno}</td>
                        <td>${reader.rname}</td>
                        <td>${reader.rgender}</td>
                        <td>${reader.rage}</td>
                        <td>${reader.rspecialty}</td>
                        <td>${reader.rBorrowCount}</td>
                        <td>${reader.rBorrowFine}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>