
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,Model.Film, Model.ListFilmUpdate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="Login.jsp">
        <link rel="stylesheet" href="LoginController.java">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- dung de truy cap thu vien font-awesome(lay cac icon) -->
        <title>Web Phim Lau IS</title>

    </head>
    <script>
        function displayMessage() {
            var message = "${mess}";
            if (message !== "") {
                alert(message);
            }
        }
        displayMessage();
    </script>
    <%Film f2 = new Film();
    ArrayList<Film> data = f2.getListFilmUpdate();
    %>
    <%
    String mess2Value = (String) session.getAttribute("mess2");
    String acc = (String) session.getAttribute("acc");
    session.setAttribute("mess2", mess2Value);
    session.setAttribute("acc", acc);
    %>
    <body>

        <%@include file="Basic.jsp"%>
        <br>
        <div id="main-content">
            <div id="content">
                <div style="display: none;">
                    <h1>Phim lau</h1>
                </div>
                <div class="container">
                    <div class="block">
                        <div class="heading">
                            <h2 class="caption" style="">Phim Cập Nhật</h2>
                        </div>
                        <ul class="list-film horizontal">
                            <% if (data.isEmpty()) { %>
                            <p>NO FILM</p>
                            <% } else { %>
                            <% for (Film filmU : data) { %>
                            <li class="item small">
                                <a title="" href="demo1?searchID=<%= filmU.getId() %>" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="<%= filmU.getImage() %>">
                                    <p><%= filmU.getName2()%></p></a>
                            </li>
                            <% } %>
                            <% } %>

                        </ul>
                    </div>
                    <div class="block">
                        <div class="heading">
                            <a href="demo1?type=1">
                                <h2 class="caption">Phim lẻ</h2>
                            </a>
                            <a style="color: antiquewhite" class="see-more" href="demo1?type=1">See all film
                                <i class="fa fa fa-caret-right"></i>
                            </a>
                        </div>
                        <ul class="list-film horizontal">
                            <li class="item small">
                                <a title="" href="demo1?searchID=21" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/imageHarry.jpg">
                                    <p>HARRY POTTER VÀ HÒN ĐÁ PHÙ THỦY</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=49" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/daquy.jpg">
                                    <p>DẠ QUỶ</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=37" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/Charlie1.jpg">
                                    <p>NGÔI NHÀ CHOCOLATE</p>
                                </a>
                            </li>
                            <li class="item small" class="no-underline"> 
                                <a title="" href="demo1?searchID=33">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/heaaler.jpg">
                                    <p>Healer</p>
                                </a>
                            </li>
                            <li class="item small" class="no-underline"> 
                                <a title="" href="demo1?searchID=18">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/Outlaw-King.jpg">
                                    <p>Out-LawKing</p>
                                </a>
                            </li>
                            <li class="item small" class="no-underline"> 
                                <a title="" href="demo1?searchID=8">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/venom.jpg">
                                    <p>Venom</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="block">
                        <div class="heading">
                            <a href="demo1?type=2">
                                <h2 class="caption">Phim Bộ</h2>
                            </a>
                            <a style="color: antiquewhite" class="see-more" href="demo1?type=2">See all film
                                <i class="fa fa fa-caret-right"></i>
                            </a>
                        </div>
                        <ul class="list-film horizontal">
                            <li class="item small">
                                <a title="" href="demo1?searchID=22" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/A-X-L.jpg">
                                    <p>A-X-L</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=54" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/onepiece.jpg">
                                    <p>ĐẢO HẢI TẶC(1997)</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=57" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/Spiritpact.jpg">
                                    <p>Spiract_Manwhua</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=55" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/serenity.jpg">
                                    <p>SỨ MỆNH NGUY HIỂM</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=53" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/Spqce.jpg">
                                    <p>Space Brother</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=20" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/Mouse.jpg">
                                    <p>CHUỘT PHIÊU LƯU</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="block">
                        <div class="heading">
                            <a href="demo1?type=1">
                                <h2 class="caption">Phim Chiếu Rạp</h2>
                            </a>
                            <a style="color: antiquewhite" class="see-more" href="demo1?type=3">See all film
                                <i class="fa fa fa-caret-right"></i>
                            </a>
                        </div>
                        <ul class="list-film horizontal">
                            <li class="item small">
                                <a title="" href="demo1?searchID=74" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/ipman.jpg">
                                    <p>Ip Man</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=73" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/mulan.jpg">
                                    <p>Mulan</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=56" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/p94.png">
                                    <p>Mission Impossible</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=68" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/p106.png">
                                    <p>Christopher Robin</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=71" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/p109.png">
                                    <p>Maquia: When the Promised Flower Blooms</p>
                                </a>
                            </li>
                            <li class="item small"> 
                                <a title="" href="demo1?searchID=63" class="no-underline">
                                    <img width="238px" height="134px" class="mg-2 ls-is-cached lazyloaded" src="images/p101.png">
                                    <p>Just A Breath Away</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>

    </body>


</html>