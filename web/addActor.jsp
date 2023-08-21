<%-- 
    Document   : addActor
    Created on : Jul 4, 2023, 3:24:47 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            /* CSS cho form */
            #myFormActor {
                width: 400px;
                margin: 0 auto;
                padding: 20px;
                background-color: #f2f2f2;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            /* CSS cho các label */
            label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }

            /* CSS cho input và select */
            input[type="text"],
            input[type="number"],
            select {
                width: 100%;
                padding: 5px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            /* CSS cho textarea */
            textarea {
                width: 100%;
                height: 100px;
                padding: 5px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            /* CSS cho button */
            button[type="submit"] {
                display: block;
                width: 100%;
                padding: 10px;
                margin-top: 10px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }

            /* CSS cho thông báo lỗi */
            #error-messages1 {
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <c:set var="dataNation" value="${sessionScope.listNation}" />
        <c:set var="dataFilm" value="${sessionScope.listFilm}" />
        <%@include file="Basic.jsp" %>
        <form action="demo1" method="post" id="myFormActor">
            <input type="hidden" name="addactor" value="add">
            <label for="name1">Tên Actor:</label>
            <input type="text" id="name1" name="name1" required>

            <label for="nation_id">Quốc Tịch:</label>
            <select name="nation">
                <c:forEach var="nation" items="${dataNation}">
                    <option value="${nation.idNation}">${nation.convertNation(nation.idNation,nation.nameNation)} </option>                 
                </c:forEach>
            </select>
            <label for="year">Tuổi:</label>
            <input type="number" id="year" name="year" required>
            <p id="error-messages1" style="color: red"></p>

            <label for="image">Image:</label>
            <input type="file" id="image" name="img">

            <label for="description">Mô tả chi tiết:</label>
            <textarea id="description" name="description"></textarea>
            <select name="film">
                 <c:forEach var="film" items="${dataFilm}">
                    <option value="${film.id}">${film.name2} </option>                 
                </c:forEach>
                    <option value="0">Other</option>
            </select>
            <button type="submit">ADD</button>
        </form>
        <%@include file="footer.jsp" %>
    </body>
    <script src="scriptCheck.js"></script>
</html>
