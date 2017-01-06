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
            <p class="text-center"><b>在下表中键入修改信息</b></p>
        </div>

        <form action="/updateBorrow" method="post" class="col-md-4">
            <input type="hidden" name="rno" value="${borrow.rno}">
            <input type="hidden" name="bisbn" value="${borrow.bisbn}">
            <input type="hidden" name="bname" value="${borrow.bname}">

            <label>起始日期：</label>
            <input type="text" class="form-control" name="startdate" value="${borrow.startdate}">

            <label>截止日期：</label>
            <input type="text" class="form-control" name="enddate" value="${borrow.enddate}">

            <label>费用</label>
            <input type="text" class="form-control" name="fine" value="${borrow.fine}">

            <label>支付状态</label>
            是 <input type="radio" name="ispay" ${borrow.ispay != 0 ? "checked" : ""} value="1">
            否 <input type="radio" name="ispay" ${borrow.ispay == 0 ? "checked" : ""} value="0">

            <button class="btn btn-primary">保存</button>
        </form>
    </div>
</body>
</html>