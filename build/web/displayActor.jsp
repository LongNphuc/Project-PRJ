<%-- 
    Document   : displayActInfor
    Created on : Jul 1, 2023, 4:34:27 PM
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
            .actor-container {
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
            }

            .actor-item {
                width: 300px;
                margin: 10px;
                background-color: #f5f5f5;
                border-radius: 5px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            .actor-image {
                width: 100%;
                height: auto;
                object-fit: cover;
                border-top-left-radius: 5px;
                border-top-right-radius: 5px;
            }

            .actor-details {
                padding: 10px;
            }

            .actor-name {
                font-weight: bold;
                font-size: 16px;
                margin-bottom: 5px;
                color: black; /* Thay đổi màu chữ thành màu đen */
                text-decoration: none; /* Loại bỏ gạch chân */
            }

            .actor-info {
                font-size: 14px;
                margin-bottom: 3px;
                color: black; /* Thay đổi màu chữ thành màu đen */
            }

            .actor-description {
                font-size: 14px;
                margin-top: 10px;
                color: black; /* Thay đổi màu chữ thành màu đen */
            }

            .heading {
                position: fixed;
                bottom: 20px;
                left: 50%;
                transform: translateX(-50%);
            }


            .heading input[type="submit"] {
                padding: 10px 20px;
                font-size: 16px;
                background-color: #8a2be2;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .heading input[type="submit"]:hover {
                background-color: #6a1b9a;
            }


        </style>
    </head>
    <body>
        <%@include file="Basic.jsp" %>
        <div class="actor-container">
            <div class="heading">
                <form action="demo2" method="post">
                    <input type="submit" onclick="this.form.submit()" name="actor" value="ADD ACTOR">
                </form>
            </div>
            <c:forEach var="actor" items="${listActor}">
                <div class="actor-item">
                    <a href="demo2?actor=${actor.nameActor}">
                        <img class="actor-image" src="images/${actor.image}" alt="Actor Image"></a>
                    <div class="actor-details">
                        <p class="actor-name">${actor.nameActor}</p>
                        <p class="actor-info">Country: ${actor.convertNation(actor.idNational, "UnKnown!")}</p>
                        <p class="actor-info">Year of Birth: ${actor.birthYear}</p>
                        <p class="actor-description">${actor.description}</p>
                        <a href="demo3?updateActor=1&id=${actor.idActor}">Edit here</a><br>
                        <a href="demo3?deleteActor=${actor.idActor}">Delete Actor</a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <%@include file="footer.jsp" %>
    </body>
    <script>
        function displayMessage() {
            var message = "${mess}";
            if (message !== "") {
                alert(message);
            }
        }
        displayMessage();
    </script>
</html>
