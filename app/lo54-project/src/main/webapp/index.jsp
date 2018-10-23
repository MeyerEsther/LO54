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
            <li class="breadcrumb-item active">Session</li>
          </ol>


          <!-- Area Chart Example-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-filter"></i>
              Filters</div>
            <div class="card-body">
                 <div class="row">
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label>Looking for a specific <b>date</b> ?</label>
                              <input id="date_filter" type="text" class="form-control" placeholder="Enter the date">
                            </div>
                        <button class="btn btn-primary" onclick="location.href='./index.jsp?date='+ document.getElementById('date_filter').value">Submit</button>
                    </div>
                    <div class="col-sm-3">
                            <div class="form-group">
                                <label>Looking for a <b>location</b> ?</label>
                                <select class="form-control" id="location_filter">
                                      <option value="" selected disabled hidden>Choose the location</option>
                                </select>                            
                            </div>
                            <button type="submit" class="btn btn-primary" onclick="location.href='./index.jsp?location='+ document.getElementById('location_filter').value">Submit</button>
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label >What kind of content are you <b>looking for</b> ?</label>
                            <input type="text" id="keyword_filter" class="form-control" placeholder="Enter keywords">
                        </div>
                        <button type="submit" class="btn btn-primary" onclick="location.href='./index.jsp?search='+ document.getElementById('keyword_filter').value">Submit</button>
                    </div>                         
                    <div class="col-sm-3">
                        <label class="invisible">Just for the style ..</label>
                        <a class="btn btn-info btn-block" href="index.jsp">Reset filters</a>
                    </div>
                  </div> 

            </div>
          </div>

          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-graduation-cap"></i>
              Course sessions</div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Course</th>
                      <th>Begin date</th>
                      <th>End date</th>
                      <th>Location</th>
                      <th>Subscribe</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>Course</th>
                      <th>Begin date</th>
                      <th>End date</th>
                      <th>Location</th>
                      <th>Subscribe</th>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright © Your Website 2018</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->
    
        <jsp:include page="fragments/subscribe_modal.html" />
        <jsp:include page="fragments/success_modal.html" />

        <jsp:include page="fragments/footer.html" />

        <script src="js/pages/index.js"></script>
        
    </body>
</html>
