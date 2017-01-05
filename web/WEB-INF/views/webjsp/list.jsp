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
    <link rel="stylesheet" href="../../css/bootstrap.css">
</head>
<body>
    <div class="container">
        <div class="well">

            <h1>Welcome,${account.username}</h1>
        </div>
        <div class="container-fluid">
            <a href="/new" class="btn bg-primary">新增图书</a>
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

                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td>${book.bisbn}</td>
                        <td>${book.bname}</td>
                        <td>${book.bauthor}</td>
                        <td>${book.bpublisher}</td>
                        <td>${book.bprice}</td>
                        <td>${book.bcategory}</td>
                        <td>${book.bnum}</td>
                        <td>
                            <a href="/update?isbn=${book.bisbn}">修改</a>
                            <a href="javascript:;" rel="${book.bisbn}" class="delete">删除</a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </div>
    <script src="../../js/jQuery%201.9.1.js"></script>
    <script>
        $(function () {
            $(".delete").click(function () {
                if(confirm("确定要删除吗？")){
                    var isbn = $(this).attr("rel");
                    window.location.href = "/delete?isbn=" + isbn;
                }
            })
        });
    </script>
</body>
</html>