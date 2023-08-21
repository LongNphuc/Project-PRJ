<%-- 
    Document   : EditActor
    Created on : Jul 7, 2023, 9:40:54 PM
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
            .form-container {
                max-width: 500px;
                margin: 0 auto;
                padding: 20px;
                background-color: #f2f2f2;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .form-container img.actor-image {
                display: block;
                margin-bottom: 10px;
                width: 200px;
                height: auto;
            }

            .form-container input[type="text"],
            .form-container input[type="number"] {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            .film-description input[type="text"] {
                width: 100%;
                padding: 8px;
                border-radius: 3px;
                border: 1px solid #ccc;
                height: 80px;
            }

            .form-container select {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            .form-container input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 15px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
            }

            .form-container input[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <%@include file="Basic.jsp" %>
        <div class="form-container">
            <form action="demo3" method="get" id="myFormActor">
                <input type="hidden" name="hid" value="oke">
                <c:forEach var="actor" items="${listAct}">
                    <img class="actor-image" src="images/${actor.image}" alt="Actor Image">
                    ID<input type="text" name="id" value="${actor.idActor}" readonly>
                    Name<input type="text" value="${actor.nameActor}" name="name" required>
                    Quốc Gia<select name="natId">
                        <c:forEach var="nat" items="${listNat}">
                            <option value="${nat.idNation}">${nat.convertNation(nat.idNation,nat.nameNation)}</option>
                        </c:forEach>
                    </select>
                    Year<input type="number" id="year" name="year" value="${actor.birthYear}">
                    <p class="film-description">Description <input type="text" name="description" value="${actor.description}"></p>
                    Film<input type="text" name="fid" value="${actor.filmID}" required>
                    <input type="submit" value="UPDATE">
                </c:forEach>
            </form>
        </div>
        <%@include file="footer.jsp"%>
    </body>
    <script src="scriptCheck.js"></script>
</html>
