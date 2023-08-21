<%-- 
    Document   : editAndDelFilm
    Created on : Jul 3, 2023, 10:07:50 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .edit-button,
            .delete-button {
                display: inline-block;
                margin-right: 10px;
                padding: 8px 16px;
                background-color: #8a2be2; /* Màu tím */
                color: #fff;
                border: none;
                border-radius: 4px;
                font-size: 14px;
                cursor: pointer;
                text-decoration: none;
                transition: background-color 0.3s ease;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                outline: none;
            }

            .edit-button:hover,
            .delete-button:hover {
                background-color: #7b1fa2; /* Màu tím nhạt khi hover */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }

            .edit-button:focus,
            .delete-button:focus {
                box-shadow: 0 0 0 4px rgba(0, 123, 255, 0.3);
            }

            .edit-button:hover,
            .delete-button:hover,
            .edit-button:focus,
            .delete-button:focus {
                text-shadow: 0 0 5px rgba(0, 0, 0, 0.3); /* Tạo hiệu ứng màu nổi khi đưa chuột qua */
            }

        </style>
    </head>
    <body>
        <div class="buttons" <%
                            if ("1".equals(mess2)) {    %>                                                
                                 style="display: block;" 
                           <% } else {%>
                                 style="display: none;"                      
                            <% } %>>
            <a class="edit-button" href="demo2?searchIDForInfor=${item.id}">Edit</a>
            <a class="delete-button" href="demo2?deleteFilmByID=${item.id}&name=${item.name2}">Delete</a>

        </div>
    </body>

</html>
