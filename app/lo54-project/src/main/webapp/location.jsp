<%-- 
    Document   : Page
    Created on : 21 oct. 2018, 21:46:22
    Author     : Valentin Bourdier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="fragments/header.html" />

    <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="index.html">LO54 Project</a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

    </nav>

    <div id="wrapper">
        
      <jsp:include page="fragments/menu.html" />

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="#">Courses</a>
            </li>
            <li class="breadcrumb-item active">Location</li>
          </ol>

          <!-- Area Chart Example-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-chart-area"></i>
              Courses location</div>
            <div class="card-body">
               <div id="openStreetMap"></div>
            </div>
          </div>
          
        <jsp:include page="fragments/footer.html" />
          
        
        <jsp:include page="fragments/js_include.html" />
        <script src="js/leaflet/leaflet.js"></script>
        <script src="js/pages/location.js"></script>

    </body>
</html>
