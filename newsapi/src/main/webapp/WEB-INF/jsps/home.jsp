<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html lang="en" ng-app="app">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Worldwide News</title>
  <link rel="stylesheet" href="web/css/all.min.css">
  <link rel="stylesheet" href="web/css/adminlte.min.css">
  <link rel="stylesheet" href="web/css/select2.min.css">
  <link rel="stylesheet" href="web/css/toastr.min.css">
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <style type="text/css">
  	.m-t-30{margin-top: 30px}
  	.panel-heading{padding: 5px;border-radius:3px;background: #eee;cursor: pointer;border-bottom: 1px solid #9b9696;}
  	.panel-title{margin-left: 20px;margin-top: 5px}
  	.panel-body{padding: 10px;border: 2px solid #eee;}
  	.font-bold{font-weight: bold}
  </style>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
      </li>
    </ul>
  </nav>
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <a href="/newsapi" class="brand-link text-center">
      <span class="brand-text font-weight-light">Worldwide News</span>
    </a>
    <div class="sidebar">
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <li class="nav-item">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-address-card"></i>
              <p>
                News
              </p>
            </a>
          </li>
        </ul>
      </nav>
    </div>
  </aside>

  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
      	<h4>Search News Here</h4>
      </div>
    </div>
       <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-12">

            <div class="card card-primary card-outline">
				<script src="web/js/jquery.min.js"></script>
				<script src="web/js/bootstrap.bundle.min.js"></script>
				<script src="web/js/adminlte.min.js"></script>
				<script src="web/js/select2.full.min.js"></script>
				<script src="web/js/toastr.min.js"></script>
					            
	            <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
				<script src="web/angular/angular-route.min.js"></script>
				<script src="web/controllers/app.js"></script>
				<script src="web/controllers/news.controller.js"></script>
				<script type="text/javascript">
					localStorage.setItem("apiBaseUrl","http://localhost:8080/newsapi/");
				</script>
	            <div class="card-body">
					<div ng-view=""></div>		
	            </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <footer class="main-footer">
    <strong>Copyright &copy; 2020 <a href="/newsapi">Worldwide News</a>.</strong> All rights reserved.
  </footer>
</div>
</body>
</html>
