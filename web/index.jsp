<%-- 
    Document   : index
    Created on : Oct 23, 2018, 10:31:49 PM
    Author     : Sakibul Haque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="myApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/angular.js" type="text/javascript"></script>
        <script src="js/app.js" type="text/javascript"></script>
        <style type="text/css">
        @import "css/custom_css.css";
        </style>

    </head>
    <body ng-controller="myCtrl">
        <div class="container">
            <div class="row">
                
                <div class="header col-md-12">
                    <div class="image">
                        <h1>Sakibul Drug House</h1>
                        
                    </div>
                </div>
                
                <div class="menu col-md-12">
                    <div class="row">
                        <nav class="navbar navbar-default">
                            <div class="container-fluid">
                                <ul class="nav navbar-nav">
                                    <li><a href="index.jsp">Home</a></li>
                                    <li><a href="drugDetails.jsp">Drug Details</a></li>
                                    <li><a href="companyProduct.jsp">Company Product</a></li>
                                    <li><a href="drugGroupName.jsp">Drug Group Name</a></li>
                                    <li><a href="drugCompany.jsp">Drug Company</a></li>
                                    <li><a href="aboutus.jsp">About Us</a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
                <!--                <div class="content-area col-md-12">
                                    <div class="row">-->
                <!--                        <div class="sidebar col-md-3">
                                            <ul class="">
                                                <li><a href="#">Link_1</a></li>
                                                <li><a href="#">Link_2</a></li>
                                                <li><a href="#">Link_3</a></li>
                                                <li><a href="#">Link_4</a></li>
                                                <li><a href="#">Link_5</a></li>
                                            </ul>
                                        </div>-->
                <div class="content col-md-12">
                    <h1>Home Page</h1>
                </div>
                <!--                    </div>
                                </div>-->
                <div class="footer-area col-md-12">
                    footer
                </div>
            </div>
        </div>
    </body>
</html>
