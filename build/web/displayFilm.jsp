

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.Film"%>
<%@page import=" java.util.ArrayList"%>
<%@ page import="java.net.URLEncoder"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.ArrayList,Model.Comments" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cssFilm.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Film List</title>
        <style>
            .Comments {
                position: fixed;
                bottom: 0;
                left: 0;
                width: 100%;
                padding: 20px;
                background-color: #f5f5f5;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .Comments p {
                margin-bottom: 10px;
            }

            .Comments .Post-Cmmts {
                margin-top: 10px;
            }

            .Comments .Post-Cmmts form {
                display: flex;
                align-items: center;
            }

            .Comments .Post-Cmmts input[type="text"] {
                flex: 1;
                padding: 5px;
                margin-right: 5px;
            }

            .Comments .Post-Cmmts input[type="submit"] {
                padding: 5px 10px;
                background-color: #4CAF50;
                color: antiquewhite;
                border: none;
                cursor: pointer;
            }
        </style>
    </head>
    <body>       
        <c:set var="dataFilm" value="${sessionScope.listFilm}" />
        <c:set var="dataRating" value="${sessionScope.listRating}" />
        <c:set var="dataActor" value="${sessionScope.listActor}" />
        <%@include file="Basic.jsp" %> 
        <div class="film-info">
            <c:forEach var="item" items="${dataFilm}">
                <div><img class="film-image" src="${item.image}" alt="Film Image"></div>
                <div class="film-details">
                    <h2 class="film-title" style="color: antiquewhite">${item.name1}</h2>
                    <h3 class="film-title-english">${item.name2}</h3>
                    <p class="film-release-date">${item.year}</p>
                    <c:choose>
                        <c:when test="${item.type_Movie == 2}">
                            <p class="film-episode">Trạng thái: ${item.convertString(item.status)} tập</p>
                        </c:when>
                        <c:otherwise>
                            <p class="film-episode">Trạng thái: ${item.convertString(item.status)}</p>
                        </c:otherwise>
                    </c:choose>
                    <p class="film-duration">Thời lượng: ${item.duration} phút</p>
                    <p class="film-views">Lượt xem: ${item.num_view} lượt</p>
                    <p class="film-country">Quốc gia: ${item.convertNation(item.nation_id)}</p>
                    <p class="film-genre">Thể loại: ${item.convertCate(item.category_Id)}</p>
                    <div class="user-rating" <%
                            String mess2 = (String) request.getSession().getAttribute("mess2");
                            String mess3 = (String) request.getSession().getAttribute("mess3");
                            if ("1".equals(mess2)) {
                         %>
                         style="display: none;" 
                         <%          
                         } else {
                             if ("block".equals(mess3)) {
                         %>
                         style="display: block;" 
                         <%
                             } else {
                         %>
                         style="display: none;" 
                         <%
                             }
                         }
                         %>

                         >
                        <span class="rating-label">Đánh giá của bạn:</span>
                        <div class="rating-stars">
                            <form action="demo2" method="get">
                                <input type="hidden" name="searchID" value="${item.id}">
                                <input type="submit" class="star" name="star" value="1">
                                <input type="submit" class="star" name="star" value="2">
                                <input type="submit" class="star" name="star" value="3">
                                <input type="submit" class="star" name="star" value="4">
                                <input type="submit" class="star" name="star" value="5">
                                <input type="submit" class="star" name="star" value="6">
                                <input type="submit" class="star" name="star" value="7">
                                <input type="submit" class="star" name="star" value="8">
                                <input type="submit" class="star" name="star" value="9">
                                <input type="submit" class="star" name="star" value="10">
                                <p class="star-points">(Points)</p>
                            </form>
                        </div>
                    </div>
                    <div class="film-reviews" 

                         >
                        <c:forEach var="rating" items="${dataRating}">
                            <span class="reviews-count">Đánh giá phim (${rating.numReport} lượt)</span>
                            <span class="reviews-label">: ${rating.markReport}<p class="star-points">(Points)</p></span>
                        </c:forEach>
                    </div>

                    <div class="film-actors">
                        <p class="actors-label">Diễn viên:</p>
                        <ul class="actors-list">
                            <c:forEach var="actor" items="${item.actor}">
                                <li>
                                    <c:set var="actorTrim" value="${actor.trim()}" />
                                    <c:set var="foundActor" value="false" />
                                    <c:forEach var="acter" items="${dataActor}">
                                        <c:set var="acterTrim" value="${acter.nameActor.trim()}" />
                                        <c:if test="${actorTrim eq acterTrim}">
                                            <c:if test="${!foundActor}">
                                                <c:set var="foundActor" value="true" />
                                                <a href="demo2?actor=${actor}">
                                                    <img class="actor-image" src="images/${acter.image}" alt="Actor Image">
                                                    <p class="actor-name">${actor}</p>
                                                </a>                                               
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${!foundActor}" >
                                        <img class="actor-image" src="images/nothing.png" alt="Actor Image">
                                        <p class="actor-name">${actor}</p>                                
                                    </c:if>
                                </li>
                            </c:forEach>

                        </ul>
                        <p class="actors-label">Đạo Diễn:</p>
                        <ul class="actors-list">
                            <c:forEach var="director" items="${item.directorName}">
                                <li>                                       
                                    <img class="actor-image" src="images/nothing.png" alt="Actor Image">
                                    <p class="actor-name">${director}</p>                                          
                                </li>
                            </c:forEach>
                        </ul>
                    </div>                               
                    <p class="film-description" style="color: antiquewhite">Thông tin phim: ${item.description}</p>
                </div>
                <div class="Comments">
                    <% 
                        Comments c = new Comments();
                        String id = (String) request.getSession().getAttribute("IDF");
                        ArrayList<Comments> data = c.getListCmmt(id);
                        if (data.isEmpty()) { 
                    %>
                    <p>NO COMMENTS</p>
                    <% 
                        } else { 
                            for (Comments cmmt : data) { 
                    %>
                    <%= cmmt.getAcc() %>: <%= cmmt.getCmmt() %><br>
                    <% 
                            } 
                        } 
                    %>
                    <div class="Post-Cmmts" 
                         <%
                            if ("1".equals(mess2)) {    %>                                                
                         style="display: none;" 
                         <% } else {%>
                         style="display: block;"                      
                         <% } %>
                         >
                        <form action="demo2" method="get">
                            <input type="text" name="cmmt" placeholder="<%= request.getSession().getAttribute("acc")%>: ...">
                            <input type="hidden" name="searchID" value="<%= id%>" required>
                            <input type="submit">
                        </form>
                    </div>
                </div>

                <%@include file="editAndDelFilm.jsp" %>
            </c:forEach>

        </div>
        <%@include file="footer.jsp" %>



    </body>
</html>



















