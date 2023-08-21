<%-- 
    Document   : displayFilm
    Created on : Jun 14, 2023, 3:57:11 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.Film"%>
<%@page import=" java.util.ArrayList"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="cssListFilm.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Film List</title>

    </head>
    <body>
        <c:set var="mess" value="${sessionScope.mess1}" />
        <c:set var="data" value="${sessionScope.listFilm}" />
        <%@include file="Basic.jsp"%>

        <div id="main-content">
            <div style="display: none;">
                <h1>Phim lau</h1>
            </div>
            <div class="container">
                <div class="heading">
                    <a href="#">
                        <h2 class="caption">${mess1}</h2>
                    </a>
                </div>
                <ul class="list-film horizontal">
                    <c:forEach var="item" items="${data}">
                        <li class="item small">
                            <a title="" href="demo2?searchID=${item.id}">
                                <td><img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="${item.image}"></td>
                                <p>${item.name1}</p>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
