<%-- 
    Document   : Basic
    Created on : Jun 13, 2023, 8:24:07 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet"  href="cssBasic.css">
<%@ page import="java.util.ArrayList,Model.Category ,Model.Film, Model.National, Model.typeMovie" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>JSP Page</title>
        <%
             Film film = new Film();
             ArrayList<Category> cateList = film.getCateList();
             ArrayList<National> nationList = film.getNationList();
             ArrayList<typeMovie> typeList = film.getTypeList();
        %>
        <style>
            #edit-select {
                position: fixed;
                top: 20px;
                right: 20px;
            }
            .logout-link {
                position: fixed;
                top: 40px;
                right: 40px;
                display: inline-block;
                padding: 10px 15px;
                background-color: black;
                color: white;
                text-decoration: none;
                border-radius: 4px;
                margin-left: 10px;
                transition: color 0.3s;
            }

            .logout-link:hover {
                background-color: #45a049;
                color: purple; /* Màu tím */
            }

        </style>
    </head>
    <body>
        <div id="header">
            <div class="container"> 
                <div id="logo" style="margin: 0;">
                    <a href="http://localhost:9999/Project_PRJ/" title="WEB PHIM">
                        <img src="images/image1.jpg">
                    </a>
                </div>
                <ul id="main-menu">
                    <li>
                        <a title="The loai" href="javascript:void(0)" rel="nofollow">Category</a>
                        <ul class="dropdown-content"> 
                            <% for (Category category : cateList) { %>
                            <li>
                                <a class="child-menu-link" href="demo1?param=<%= category.getCateid() %>"><%= category.convertCate(category.getCateid(),category.getCateName()) %></a>
                            </li>
                            <% } %>
                        </ul>
                    </li>
                    <% for (typeMovie type : typeList) { %>
                    <li>
                        <a title="WEB PHIM" href="demo1?type=<%= type.getId() %>"><%= type.convertType(type.getId()) %></a>
                    </li>
                    <% } %>

                    <li>
                        <a title="Trailer" href="#">National</a>
                        <ul class="dropdown-content">
                            <% for (National nati : nationList) { %>
                            <li>
                                <a class="child-menu-link" href="demo1?nationId=<%= nati.getIdNation() %>"><%= nati.convertNation(nati.getIdNation(),nati.getNameNation())%></a>
                            </li>
                            <% } %>
                        </ul>
                    </li>
                </ul>
                <form id="formSearch" action="demo1" method="get"> <!-- fix lai o search vi co spqce van oke --> 
                    <input type="text" name="search" placeholder="Search...NameFilm,Actor,Director" required>
                    <button id="searchSubmit" type="submit"><i class="fa fa-search"></i></button>
                </form>    
            </div>
        </div>
        <div id="edit-select">
            <select id="edit-options" <% if ("1".equals(request.getSession().getAttribute("mess2"))) { %>
                    style="display: block;"
                    <% } else { %>
                    style="display: none;"
                    <% } %>><option value="0">Chose</option>
                <option value="edit-film">Edit Film</option>
                <option value="edit-actor">Edit Actor</option>
                <option value="edit-cate">Edit Category</option>
                <option value="edit-nation">Edit National</option>
            </select>
        </div>
        <a href="logout" class="logout-link">LogOut</a>

    </body>
    <script>
        //  sự kiện onchange
        var editSelect = document.getElementById('edit-options');
        editSelect.onclick = function () {
            var selectedOption = editSelect.value;

            if (selectedOption === 'edit-film') {
                window.location.href = 'demo1?value=1';
            } else if (selectedOption === 'edit-actor') {
                window.location.href = 'demo1?value=2';
            } else if (selectedOption === 'edit-cate') {
                window.location.href = 'demo1?value=3';
            } else if (selectedOption === 'edit-nation') {
                window.location.href = 'demo1?value=4';
            }
        };
    </script>

</html>
