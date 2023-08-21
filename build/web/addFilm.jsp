<%-- 
    Document   : addFilm
    Created on : Jul 2, 2023, 7:14:13 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="cssForAddFilm.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="Basic.jsp" %>
    <body>
        <c:set var="dataNation" value="${sessionScope.listNation}" />
        <c:set var="dataCate" value="${sessionScope.listCate}" />
        <c:set var="dataType" value="${sessionScope.listType}" />
        
        <form action="demo1" method="post" id="myForm">
            <input type="hidden" name="hidden" value="add">
            <label for="name1">NameVn:</label>
            <input type="text" id="name1" name="name1" required>

            <label for="name2">NameEngs:</label>
            <input type="text" id="name2" name="name2">

            <label for="status">Trạng thái:</label>
            <input type="text" id="status" name="status" required>

            <label for="director">Đạo diễn:</label>
            <input type="text" id="director" name="director">

            <label for="actor">Diễn viên:</label>
            <input type="text" id="actor" name="actor">

            <label for="category_id">Thể loại:</label>
            <select name="category">
                <c:forEach var="cate" items="${dataCate}">
                    <option value="${cate.cateid}">${cate.convertCate(cate.cateid,cate.cateName)}</option>                   
                </c:forEach>
            </select>

            <label for="type_movie">Dòng Phim:</label>
            <select name="type">
                <c:forEach var="type" items="${dataType}">
                    <option value="${type.id}">${type.name}</option>
                </c:forEach>
            </select>
            <label for="nation_id">Quốc Gia:</label>
            <select name="nation">
                <c:forEach var="nation" items="${dataNation}">
                    <option value="${nation.idNation}">${nation.convertNation(nation.idNation,nation.nameNation)} </option>                 
                </c:forEach>
            </select>

            <label for="year">Năm sản xuất:</label>
            <input type="number" id="year" name="year" required>
            <p id="error-messages3" style="color: red"></p>
            <label for="image">Image:</label>
            <input type="file" id="image" name="img">

            <label for="duration">Thời lượng:</label>
            <input type="number" id="duration" name="duration" required>
            <p id="error-messages4" style="color: red"></p>

            <label for="view">Lượt xem:</label>
            <input type="number" id="view" name="views" required>
            <p id="error-messages5" style="color: red"></p>
            <label for="author">Tác giả:</label>
            <input type="text" id="author" name="author">
            
            <label for="author">Lượt đánh giá:</label>
            <input type="number" id="rating-input" name="num" required>
            <p id="error-messages2" style="color: red"></p>
            
            <label for="author">Điểm Đánh Giá :</label>
            <input type="text" id="rating" name="mark" pattern="[0-9]+([.,][0-9]+)?" required>
            <p id="error-messages1" style="color: red"></p>
            
            <label for="description">Mô tả chi tiết:</label>
            <textarea id="description" name="description"></textarea>

            <button type="submit">Submit</button>
        </form>
        <%@include file="footer.jsp" %>
    </body>
    <script src="myScript.js"></script>
</html>
