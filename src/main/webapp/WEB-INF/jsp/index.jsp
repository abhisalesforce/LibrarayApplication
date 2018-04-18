<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<head>
  <title>Library Managment System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Library</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Allbooks</a></li>
      <li><a href="#">New Book</a></li>
     
    </ul>
  </div>
</nav>
  



<div class="container">
  
  <c:choose>
  <c:when test="${mode == 'BOOK_VIEW'}">
  
					  <table class="table">
					    <thead>
					      <tr>
					        <th>ID</th>
					        <th>Bookname</th>
					        <th>Author</th>
					        <th>Purchase Date</th>
					        <th>Edit</th>
					      </tr>
					    </thead>
					    <tbody>
					      <c:forEach var ="book" items= "${books}">
					      <tr>
					      <td> ${book.id} </td>
					      <td> ${book.bookname} </td>
					      <td> ${book.author} </td>
					      <td> ${book.purchase_date} </td>
					      <td> <a href="/updaterecord?id=${book.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
					      
					      
					      </tr>
					      
					      
					      </c:forEach>
					      
					      
					    </tbody>
					  </table>
  </c:when>
  
  
  <c:when test="${mode == 'BOOK_EDIT' }">
  
				  <form action = "save" method = "put">
				  <input type="hidden" class="form-control" value="${book.id}" name="id" id="id">
				  <div class="form-group">
				    <label for="bookname">Book Name</label>
				    <input type="text" class="form-control" value="${book.bookname}" name="bookname" id="bookname">
				  </div>
				  <div class="form-group">
				    <label for="author">Author</label>
				    <input type="text" class="form-control" name = "author" value="${book.author}" id="author">
				  </div>
				    <div class="form-group">
				    <label for="purchase_date">Purchase date</label>
				    <input type="date" class="form-control" name = "purchase_date" value = "${book.purchase_date }" id="purchase_date">
				  </div>
				    
				  
				  <button type="submit" class="btn btn-default">Submit</button>
				</form>
  
  </c:when>
      </c:choose>     
  
</div>

</body>
</html>



