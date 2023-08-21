<%-- 
    Document   : displayInfor
    Created on : Jun 20, 2023, 11:45:29 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="cssForInfoFilm.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script>
        function showButtons(itemId) {
            var buttons = document.getElementById(itemId).querySelector(".buttons");
            buttons.style.display = "block";
        }
    </script>
    <body>
        <c:set var="data" value="${listFilm}" />
        <%String mess2 = (String) request.getSession().getAttribute("mess2");%>
        <%@include file="Basic.jsp" %> 
        <div id="main-content">
            <div style="display: none;">
                <h1>Phim lau</h1>
            </div>
            <div class="container">
                <div class="heading">
                    <form action="demo2" method="post">
                        <input type="submit" onclick="this.form.submit()" name="film" value="ADD FILM">
                    </form>
                </div>
                <ul class="list-film horizontal">
                    <c:forEach var="item" items="${data}">
                        <li class="item small" id="item-${item.id}">
                            <div class="film-info" onclick="showButtons('item-${item.id}')">                              
                                <td><img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="${item.image}"></td>                                       
                                <p>${item.name1}</p>
                            </div>
                            <%@include file="editAndDelFilm.jsp" %>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </body>




    <%@include file="footer.jsp" %>
</body>
</html>
