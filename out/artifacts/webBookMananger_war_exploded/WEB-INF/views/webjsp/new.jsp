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
    <style>
        .text-error{
            color: darkred;
        }
    </style>
</head>
<body>
    <div class="container">

        <div class="col-md-4">
            <form action="/new" method="post" id="newBookForm">
                <label>ISBN:</label>
                <input type="text" class="form-control" name="isbn">

                <label>名称:</label>
                <input type="text" class="form-control" name="name">

                <label>作者:</label>
                <input type="text" class="form-control" name="author">

                <label>出版社名称:</label>
                <input type="text" class="form-control" name="publisher">

                <label>价格:</label>
                <input type="text" class="form-control" name="price">

                <select name="bookType">

                    <c:forEach items="${bookTypeList}" var="bookType">
                        <option value="${bookType.book_type}">${bookType.book_type}</option>
                    </c:forEach>

                </select>

                <label>库存数量:</label>
                <input type="text" class="form-control" name="bookNum" placeholder="不填写此字段默认库存为0">
                <button class="btn btn-success">保存</button>
            </form>
        </div>
    </div>
    <script src="/js/jQuery%201.9.1.js"></script>
    <script src="/js/jquery.validate.js"></script>
    <script>
        $(function () {
            $("#newBookForm").validate({
                errorClass:"text-error",
                rules:{
                    isbn:{
                        required:true
                    },
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
                    },
                    bookNum:{
                        min:0
                    }
                },
                messages:{
                    isbn:{
                        required:"请输入添加图书的ISBN号"
                    },
                    name:{
                        required:"请输入添加图书的名称",
                        maxlength:"长度最多为10个字符"
                    },
                    author:{
                        required:"请输入添加图书的作者",
                        maxlength:"长度最多为10个字符"
                    },
                    publisher:{
                        required:"请输入添加图书的出版社名称",
                        maxlength:"长度最多为10个字符"
                    },
                    price:{
                        required:"请输入添加图书的价格",
                        min:"价格不能低于0"
                    },
                    bookNum:{
                        min:"最小数量不得低于0"
                    }

                }
            });
        });
    </script>
</body>
</html>