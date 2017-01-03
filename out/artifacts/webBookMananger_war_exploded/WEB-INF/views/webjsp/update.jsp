<%@ page import="entity.BookType" %>
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
    <style>
        .text-error{
            color: darkred;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            List<BookType> bookTypeList = (List<BookType>) request.getAttribute("bookTypeList");
            Book book = (Book) request.getAttribute("book");
        %>
        <div class="col-md-4">
            <form action="/update" method="post" id="updateBookForm">
                <label>ISBN:</label>
                <input type="hidden" class="form-control" name="isbn" value="<%=book.getBisbn()%>">

                <label>名称:</label>
                <input type="text" class="form-control" name="name" value="<%=book.getBname()%>">

                <label>作者:</label>
                <input type="text" class="form-control" name="author" value="<%=book.getBauthor()%>">

                <label>出版社名称:</label>
                <input type="text" class="form-control" name="publisher" value="<%=book.getBpublisher()%>">

                <label>价格:</label>
                <input type="text" class="form-control" name="price" value="<%=book.getBprice()%>">

                <select name="bookType">
                    <%
                        for(BookType bookType : bookTypeList){
                    %>
                    <option value="<%=bookType.getBook_type()%>" <%=book.getBcategory().equals(bookType.getBook_type()) ? "selected" : ""%>>
                        <%=bookType.getBook_type()%>
                    </option>
                    <%}%>
                </select>
                <button class="btn btn-success">保存</button>
            </form>
        </div>
    </div>
    <script src="/js/jQuery%201.9.1.js"></script>
    <script src="/js/jquery.validate.js"></script>
    <script>
        $(function () {
            $("#updateBookForm").validate({
                errorClass:"text-error",
                rules:{
                    name:{
                        required:true,
                        maxlength:10
                    },
                    author:{
                        required:true,
                        maxlength:10
                    },
                    publisher:{
                        required:true,
                        maxlength:10
                    },
                    price:{
                        required:true,
                        min:0
                    }
                },
                messages:{
                    name:{
                        required:"请输入更改图书的名称",
                        maxlength:"长度最多为10个字符"
                    },
                    author:{
                        required:"请输入更改图书的作者",
                        maxlength:"长度最多为10个字符"
                    },
                    publisher:{
                        required:"请输入更改图书的出版社",
                        maxlength:"长度最多为10个字符"
                    },
                    price:{
                        required:"请输入更改图书的价格",
                        min:"价格不能低于0"
                    }
                }
            });
        });
    </script>
</body>
</html>