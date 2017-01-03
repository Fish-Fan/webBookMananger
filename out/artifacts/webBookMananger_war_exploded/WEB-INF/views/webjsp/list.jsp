<%@ page import="java.util.List" %>
<%@ page import="entity.Book" %>
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
        <div class="container-fluid">
            <a href="/new" class="btn bg-primary">新增图书</a>
        </div>

        <%
            String searchValue = (String) request.getAttribute("searchValue");
            searchValue = searchValue == null ? "" : searchValue;
        %>

        <div class="well">
            <form method="get">
                <div class="form-group">
                    <label for="search">搜索</label>
                    <input type="text" class="form-control" name="searchValue" id="search" value="<%=searchValue%>">
                    <button class="btn btn-primary">Search</button>
                </div>
            </form>
        </div>

        <%
            List<Book> bookList = (List<Book>) request.getAttribute("bookList");
        %>
        <table class="table">
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>名称</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>价格</th>
                    <th>类别</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(Book book : bookList){
                %>
                <tr>
                    <td><%=book.getBisbn()%></td>
                    <td><%=book.getBname()%></td>
                    <td><%=book.getBauthor()%></td>
                    <td><%=book.getBpublisher()%></td>
                    <td><%=book.getBprice()%></td>
                    <td><%=book.getBcategory()%></td>
                    <td>
                        <a href="/update?isbn=<%=book.getBisbn()%>">修改</a>
                        <a href="javascript:;" rel="<%=book.getBisbn()%>" class="delete">删除</a>
                    </td>
                </tr>
                <%}%>
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
        })();
    </script>
</body>
</html>