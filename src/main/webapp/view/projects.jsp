<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/06
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProjectList</title>
    <style>
        table{
            width: 60%;
            height: auto;
             box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px, rgb(51, 51, 51) 0px 0px 0px 3px;
        }
        thead,th{
            border: 1px solid black;
            text-align: center;
            background-color: blue;
            color: white;
        }
        td{
            border: 1px solid black;
            text-align: center;
        }
        h1{

            margin-left: 20%;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.0/css/all.min.css" integrity="sha512-DxV+EoADOkOygM4IR9yXP8Sb2qwgidEmeqAEmDKIOfPRQZOWbXCzLC6vjbZyy0vPisbH2SyW27+ddLVCN+OMzQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<h1>Danh sách dự án</h1>
<a href="/view/projectAdd.jsp" style="background-color: blue; color: white; text-decoration: none">Thêm sản phẩm</a>
<br>
<br>

<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>MÃ DỰ ÁN</th>
        <th>TÊN DỰ ÁN</th>
        <th>MÔ TẢ DỰ ÁN</th>
        <th>HÌNH ẢNH</th>
        <th>HOẠT ĐỘNG</th>
    </tr>
    </thead>
    <c:forEach var="p" items="${projects}" varStatus="loof">
        <tr>
            <td>${loof.index+1}</td>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.description}</td>
            <td><img width="150" height="150" src="${p.imageUrl}" alt="notFound"/></td>
            <td>
                <a href="/projects?id=${p.id}&action=Delete" onclick="return confirm('Bạn chắc chắn muốn xóa dự án này?')"><i class="fa-solid fa-trash"></i></a>
                <a href="/projects?id=${p.id}&action=initUpdate"><i class="fa-solid fa-pen-to-square"></i></a>
            </td>
        </tr>
    </c:forEach>

</table>


</body>
</html>
