<%@ page errorPage="/notFoundError.jsp" %>
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
        .borrowBtn{
            display: block;
            width: 20%;
            height: 40px;
            margin: 30px auto;
        }
    </style>
</head>
<body>
<div class="container">

    <c:if test="${param.success == '1'}">
        <div class="alert alert-success">借阅成功</div>
    </c:if>

    <div class="well">
        <h1 class="text-center">Welcome!${reader.rname}</h1>
        <a href="/signout" class="btn btn-primary right">退出登录</a>
    </div>


    <div class="well">
        <form method="get">
            <div class="form-group">
                <label for="search">搜索</label>
                <input type="text" class="form-control" name="searchValue" id="search" value="${searchValue}">
                <button class="btn btn-primary">Search</button>
            </div>
        </form>
    </div>

    <div class="bg-info">
        <h3 class="text-center">图书列表</h3>
        <table class="table">
            <thead>
            <tr>
                <th>ISBN</th>
                <th>名称</th>
                <th>作者</th>
                <th>出版社</th>
                <th>价格</th>
                <th>类别</th>
                <th>库存数量</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bookList}" var="item">
                <tr>
                    <td>${item.bisbn}</td>
                    <td>${item.bname}</td>
                    <td>${item.bauthor}</td>
                    <td>${item.bpublisher}</td>
                    <td>${item.bprice}</td>
                    <td>${item.bcategory}</td>
                    <td class="bookNumValue">
                        ${item.bnum}
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${item.bnum >= 1}">
                                <a href="/currentBorrow?bisbn=${item.bisbn}&bname=${item.bname}">借阅</a>
                            </c:when>
                            <c:otherwise>
                                <p>已借阅完</p>
                            </c:otherwise>
                        </c:choose>

                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>



    <div class="bg-warning">


        <h3 class="text-center">当前借阅</h3>
        <table class="table" id="currentBorrowTable">
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>名称</th>
                    <th>数量</th>
                    <th>操作</th>

                </tr>
            </thead>
            <tbody>
            <c:if test="${empty borrowList}">
                <p class="text-center">没有任何借阅记录</p>
            </c:if>

            <c:forEach items="${currentBorrows}" var="item">
                <tr>
                    <td>${item.bisbn}</td>
                    <td>${item.bname}</td>
                    <td class="borrowBookNum">${item.bnum}</td>
                    <td>
                        <a href="/deleteCurrent?rebisbn=${item.bisbn}">撤销</a>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
    </div>

    <form action="/borrow" method="post" class="container">
        <button class="btn btn-danger borrowBtn">立即借阅</button>
    </form>

    <div class="bg-success">


        <h3 class="text-center">历史借阅记录</h3>
        <table class="table">
            <thead>
            <tr>
                <th>ISBN</th>
                <th>名称</th>
                <th>起始日期</th>
                <th>还书日期</th>
                <th>应付金额</th>
                <th>支付状态</th>
            </tr>
            </thead>
            <tbody>

                <c:choose>
                    <c:when test="${empty borrowList}">
                        <p class="text-center">没有任何借阅记录</p>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${borrowList}" var="item">
                            <tr>
                                <td>${item.bisbn}</td>
                                <td>${item.bname}</td>
                                <td>${item.startdate}</td>
                                <td>${item.enddate}</td>
                                <td>${item.fine}</td>
                                <td>${item.ispay}</td>

                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>

            </tbody>
        </table>
    </div>


</div>
<script src="/js/jQuery%201.9.1.js"></script>
<script>
    $(function () {

    });

</script>
</body>
</html>