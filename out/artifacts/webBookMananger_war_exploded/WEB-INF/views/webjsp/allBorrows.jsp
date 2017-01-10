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
</head>
<body>
    <div class="container">
        <div class="well">
            <h1>书籍借阅记录表</h1>
        </div>

        <a href="/list" class="btn btn-primary">返回上一级</a>

        <table class="table">
            <thead>
                <tr>
                    <th>读者编号</th>
                    <th>ISBN号</th>
                    <th>书籍名称</th>
                    <th>借阅日期</th>
                    <th>还书日期</th>
                    <th>费用</th>
                    <th>支付状态</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${borrowList}" var="borrow">
                    <tr>
                        <td>${borrow.rno}</td>
                        <td>${borrow.bisbn}</td>
                        <td>${borrow.bname}</td>
                        <td>${borrow.startdate}</td>
                        <td>${borrow.enddate}</td>
                        <td>${borrow.fine}</td>
                        <td>${borrow.ispay}</td>
                        <td>
                            <a href="/updateBorrow?rno=${borrow.rno}&bisbn=${borrow.bisbn}">修改</a>
                            <a href="/deleteBorrow?rno=${borrow.rno}&bisbn=${borrow.bisbn}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>