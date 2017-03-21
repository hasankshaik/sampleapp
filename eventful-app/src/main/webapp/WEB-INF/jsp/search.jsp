<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
         <div align="center">
            <form:form method="post" commandName="searchForm">
               <table border="0">
                  <tr>
                     <td class="col-sm-2 control-label" >Location:</td>
                     <td>
                        <form:input path="location" />
                     </td>
                  </tr>
                  <tr>
                     <td class="col-sm-2 control-label" >Keyword:</td>
                     <td>
                        <form:input path="keywords" />
                     </td>
                  </tr>
                  <tr>
                     <td  colspan="2" align="center"><input class="btn-lg btn-primary" type="submit" value="Search" /></td>
                  </tr>
               </table>
            </form:form>
         </div>
      </div>
      <script type="text/javascript"
         src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   </body>
</html>