
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .container {
                width: 400px;
                margin: 0 auto;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                background-color: #f8f8f8;
                border: 1px solid #ddd;
            }

            th {
                background-color: #f2f2f2;
                padding: 10px;
                font-weight: bold;
                text-align: left;
            }

            th, td {
                padding: 10px;
                border-bottom: 1px solid #ddd;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #e0e0e0;
            }
            .add-button {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
                font-size: 16px;
            }

            .add-button:hover {
                background-color: #45a049;
            }


        </style>
    </head>
    <body>
        <%@include file="Basic.jsp" %>
        <div class="container">
            <table>
                <tr>
                    <th colspan="2">CATEGORY LIST</th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                </tr>
                <c:forEach var="cate" items="${cateList}">
                    <tr>
                        <td>${cate.cateid}</td>
                        <td>${cate.convertCate(cate.cateid,cate.cateName)}</td>
                    </tr>
                </c:forEach>
            </table>
            <form action="demo3" method="post">
                <label for="category">Category Name:</label>
                <input type="text" id="category" name="addCate" required>
                <button type="submit">Add Category</button>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
