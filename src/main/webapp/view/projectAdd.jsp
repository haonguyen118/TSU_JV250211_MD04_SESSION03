<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/06
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project Add</title>
    <style>
        form{
            width: 30%;
            height: auto;
            position: relative;
            margin-left: 20%;
            margin-top: 10%;
            box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px, rgb(51, 51, 51) 0px 0px 0px 3px;
        }
        input{
            width: 80%;
            height: 50px;
            padding: 20px;
            margin-left: 10%;

        }
        button{
            width: 80%;
            height: 50px;
            background-color: blue;
            color: white;
            margin-left: 10%;
            margin-bottom: 50px;
            margin-top: 20px;
        }
        label{
            margin-left: 10%;
        }
        h1{
            text-align: center;
        }
    </style>
</head>
<body>
<form action="/projects?action=add" method="post">
    <h1>Thêm mới dự án</h1>
    <label for="name">Name:</label><br>
    <input name="name" id="name" ><br>
    <label for="description">Descriptions:</label><br>
    <input name="description" id="description"><br>
    <label for="imageUrl">Name:</label><br>
    <input name="imageUrl" id="imageUrl"><br>
    <button type="submit" value="add"> Thêm dự án</button>
</form>
</body>
</html>
