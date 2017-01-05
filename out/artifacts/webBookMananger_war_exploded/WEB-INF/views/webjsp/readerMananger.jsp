<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <legend>读者管理表</legend>

        <table class="table">
            <thead>
                <tr>
                    <th>读者编号</th>
                    <th>读者姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>专业</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${readerList}" var="reader">
                    <tr>
                        <td>${reader.rno}</td>
                        <td>${reader.rname}</td>
                        <td>${reader.rgender}</td>
                        <td>${reader.rage}</td>
                        <td>${reader.rspecilty}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</body>
</html>