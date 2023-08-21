<%-- 
    Document   : EditFilm
    Created on : Jul 1, 2023, 8:43:51 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="cssforEditFilm.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Basic.jsp" %>
        <c:set var="dataFilm" value="${sessionScope.listFilm}" />
        <c:set var="dataNation" value="${sessionScope.listNation}" />
        <c:set var="dataCate" value="${sessionScope.listCate}" />
        <c:set var="dataType" value="${sessionScope.listType}" />
        <c:set var="dataRating" value="${sessionScope.listRating}" />
        <div class="film-info">
            <c:forEach var="item" items="${dataFilm}">               
                 <img class="film-image" src="${item.image}" alt="Film Image">                       
                <form action="demo1" method="post" id="myForm">
                    <input type="hidden" name="img" value="${item.image}">
                    <input type="hidden" name="updateFilm" value="okeoke">
                    <div class="film-id">
                        <p>ID Film</p>
                        <input type="number" name="id" value="${item.id}" readonly>
                    </div>
                    <div class="film-details">
                        <h2 class="film-title">NameVnamese<input type="text" name="name1" value="${item.name1}" required></h2>
                        <h3 class="film-title-english">NameEngs<input type="text" name="name2" value="${item.name2}" required></h3>
                        <p class="film-release-date">Năm sản xuất<input type="number" id="year" name="year" value="${item.year}" required></p>
                        <p id="error-messages3" style="color: red"></p>
                        <p class="film-release-date">Dòng Phim
                            <select name="type">
                                <c:forEach var="type" items="${dataType}">
                                    <option value="${type.id}" ${item.type_Movie == type.id ? 'selected' : ''}>
                                        ${type.name}
                                    </option>
                                </c:forEach>
                            </select>
                        <p class="film-episode">Trạng thái <input type="text" name="status" value="${item.status}" required></p>
                        <p class="film-duration">Thời lượng <input type="number" id="duration" name="duration" value="${item.duration}" required>phút</p>
                        <p id="error-messages4" style="color: red"></p>
                        <p class="film-views">Lượt xem <input type="number" id="view" name="views" value="${item.num_view}" required></p>
                        <p id="error-messages5" style="color: red"></p>
                        <p class="film-country">Quốc gia
                            <select name="nation">
                                <c:forEach var="nation" items="${dataNation}">
                                    <option value="${nation.idNation}" ${item.nation_id == nation.idNation ? 'selected' : ''}>
                                        ${nation.convertNation(nation.idNation,nation.nameNation)}
                                    </option>
                                </c:forEach>
                            </select>
                        </p>
                        <p class="film-genre">Thể loại
                            <select name="category">
                                <c:forEach var="cate" items="${dataCate}">
                                    <option value="${cate.cateid}" ${item.category_Id == cate.cateid ? 'selected' : ''}>
                                        ${cate.convertCate(cate.cateid,cate.cateName)}
                                    </option>
                                </c:forEach>
                            </select>
                        </p>
                        <div class="film-actors">

                            <p class="actors-label">Diễn viên</p>
                            <input type="text" name="actor" value="${item.actor}">
                            <p class="actors-label">Đạo Diễn</p>
                            <input type="text" name="director" value="${item.directorName}">
                            <p class="actors-label">Tác giả <input name="author" type="text" value="${item.author}"></p>
                        </div>
                        <div class="film-reviews">
                            <c:forEach var="rating" items="${dataRating}">
                                Đánh Giá Phim(lượt)<input type="number" id="rating-input" class="reviews-count" name="num" value="${rating.numReport}" readonly><p id="error-messages2" style="color: red"></p>
                                Điểm Đánh Giá(points)<input type="text" class="reviews-input" id="rating" name="mark" value="${rating.markReport}"pattern="[0-9]+([.,][0-9]+)?" readonly>
                            </c:forEach>
                                <p id="error-messages1" style="color: red"></p>
                        </div>
                        <p class="film-description">Thông tin phim <input type="text" name="description" value="${item.description}"></p>
                        <input type="submit" value="UPDATE">
                    </div>
                </form>
            </c:forEach>
        </div>
        <%@include file="footer.jsp" %>
        
    </body>
    <script src="myScript.js"></script>
</html> 
