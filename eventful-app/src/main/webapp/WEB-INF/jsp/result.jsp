<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
   <head>
      <link rel="stylesheet" type="text/css"
         href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
      <c:url value="/css/main.css" var="jstlCss" />
      <link href="${jstlCss}" rel="stylesheet" />
   </head>
   <body>
      <nav class="navbar navbar-inverse">
         <div class="container">
            <div class="navbar-header">
               <a class="navbar-brand" href="#">Eventful Search</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
               <ul class="nav navbar-nav">
                  <li class="active"><a href="/">Home</a></li>
               </ul>
            </div>
         </div>
      </nav>
      <div class="container">
         <div class="starter-template">
            <h1>Eventful Sample Application</h1>
         </div>
      </div>
      <c:if test="${ not empty message}">
         <div class="alert alert-${css} alert-dismissible" >
            <strong>${message}</strong>
         </div>
      </c:if>
      <c:if test="${ empty message}">
         <table class="table table-striped">
            <thead >
               <tr>
                  <th>ID</th>
                  <th>Title</th>
                  <th>city</th>
                  <th>start time</th>
               </tr>
            </thead>
            <c:forEach var="result" items="${SearchResult}">
               <tr>
                  <td>
                     ${result.id}
                  </td>
                  <td>${result.title}</td>
                  <td>${result.city_name}</td>
                  <td>${result.start_time}</td>
               </tr>
            </c:forEach>
         </table>
      </c:if>
      <script type="text/javascript"
         src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   </body>
</html>