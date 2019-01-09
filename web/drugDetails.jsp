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
        <title>Inventory Page</title>
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
                <!--<div class="content-area col-md-12">-->
                <!--<div class="row">-->
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
                    <button data-toggle="modal" data-target="#myModalSave" type="button" class="btn btn-success">Add New Product</button>
                    Search Item : <input type="text" ng-model="searchBox" placeholder="Search.....">
                    <br><br>
                    <div class="alert alert-success alert-dismissible" ng-show="message">
                        <a href="#" class="close" ng-click="messageClose()">&times;</a>
                        <strong>Success!</strong> {{message}}
                    </div>
                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Sl.No</th>
                                <th>ID</th>
                                <th>Product Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th colspan="3">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="product in products| filter: searchBox" required>
                                <td>{{$index + 1}}</td>
                                <td>{{product.pid}}</td>
                                <td>{{product.pname}}</td>
                                <td>{{product.price}}</td>
                                <td>{{product.qty}}</td>
                                <td><button data-toggle="modal" data-target="#myModalSale" type="button" class="btn btn-success" ng-click="selectProduct(product)">Sale</button></td>
                                <td><button data-toggle="modal" data-target="#myModalEdit" type="button" class="btn btn-primary" ng-click="selectProduct(product)">Update</button></td>
                                <td><button data-toggle="modal" data-target="#myModalDelete" type="button" class="btn btn-danger" ng-click="selectProduct(product)">Delete</button></td>
                            </tr>
                        </tbody>
                    </table>
                    <!-- Save Modal -->
                    <div id="myModalSave" class="modal fade" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Insert Product</h4>
                                </div>
                                <div class="modal-body">
                                    <form>
                                        <div class="form-group">
                                            <label for="pname">Product Name:</label>
                                            <input ng-model="newProduct.pname" type="text" class="form-control" id="pname">
                                        </div>
                                        <div class="form-group">
                                            <label for="price">Price :</label>
                                            <input ng-model="newProduct.price" type="text" class="form-control" id="price">
                                        </div>
                                        <div class="form-group">
                                            <label for="qty">Quantity :</label>
                                            <input ng-model="newProduct.qty" type="text" class="form-control" id="qty">
                                        </div>
                                        <button ng-click="saveProduct()" data-dismiss="modal" type="submit" class="btn btn-success">Submit</button>
                                    </form> 
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                     <!-- Sale Modal -->
                    <div id="myModalSale" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <!-- Content Modal -->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Sale Product</h4>
                                </div>
                                <div class="modal-body">
                                    <form>
                                        <div class="form-group">
                                            <label for="cname">Customer Name:</label>
                                            <input ng-model="clickedProduct.pname" type="text" class="form-control" id="pname">
                                        </div>
                                        <div class="form-group">
                                            <label for="pname">Product Name:</label>
                                            <input ng-model="clickedProduct.pname" type="text" class="form-control" id="pname">
                                        </div>
                                        <div class="form-group">
                                            <label for="price">Price :</label>
                                            <input ng-model="clickedProduct.price" type="text" class="form-control" id="price">
                                        </div>
                                        <div class="form-group">
                                            <label for="qty">Quantity :</label>
                                            <input ng-model="clickedProduct.qty" type="text" class="form-control" id="qty">
                                        </div>
                                        <button ng-click="saleProduct()" data-dismiss="modal" type="submit" class="btn btn-success">Sale</button>
                                    </form> 
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <!-- Update Modal -->
                    <div id="myModalEdit" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <!-- Content Modal -->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Update Product</h4>
                                </div>
                                <div class="modal-body">
                                    <form>
                                        <div class="form-group">
                                            <label for="pname">Product Name:</label>
                                            <input ng-model="clickedProduct.pname" type="text" class="form-control" id="pname">
                                        </div>
                                        <div class="form-group">
                                            <label for="price">Price :</label>
                                            <input ng-model="clickedProduct.price" type="text" class="form-control" id="price">
                                        </div>
                                        <div class="form-group">
                                            <label for="qty">Quantity :</label>
                                            <input ng-model="clickedProduct.qty" type="text" class="form-control" id="qty">
                                        </div>
                                        <button ng-click="updateProduct()" data-dismiss="modal" type="submit" class="btn btn-success">Update</button>
                                    </form> 
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <!-- Delete Modal -->
                    <div id="myModalDelete" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Update Product</h4>
                                </div>
                                <div class="modal-body">
                                    You are now deleting {{clickedProduct.pname}}
                                </div>
                                <div class="modal-footer">
                                    <button ng-click="deleteProduct()" type="button" class="btn btn-success" data-dismiss="modal">Ok</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--</div>-->
                <!--</div>-->
                <div class="footer-area col-md-12">
                    footer
                </div>
            </div>
        </div>
    </body>
</html>
