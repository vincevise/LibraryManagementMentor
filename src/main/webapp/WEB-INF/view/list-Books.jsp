<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Books Directory</title>
</head>

<body>
	
	<div class = "container">
		<h3>Books Directory</h3>
		<hr>
			<form action="/LibraryManagementMentor/books/search" class="form-inline">
			
				<a href="/LibraryManagementMentor/showFormForAdd" class ="btn btn-primary btn-sm mb-3">Add Book</a>
				<input type="search" name="name" placeholder="Name" class="form-control-sm ml-5 mr-2 mb-3">
				<input type="search" name="author" placeholder="Author" class="form-control-sm ml-5 me-2 mb-3" />
				<button type="submit" class="btn btn-success btn-sm mr-2 mb-3">Search</button>
				
				 
			</form>
			<table class="table table-bordered table-striped">
				<thead class="thread-dark">
					<tr>
						<th>Name</th>
						<th>Category</th>
						<th>Author</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Books }" var="myBook">
						<tr>
							 <td><c:out value="${myBook.name }"/></td>
							 <td><c:out value="${myBook.category }"/></td>
							 <td><c:out value="${myBook.author }"/></td>
							 <td>
							 	<a href="/LibraryManagementMentor/books/search/showFormForUpdate?bookId=${myBook.id }" class="btn btn-info btn-sm">Update</a>
								<a href="/LibraryManagementMentor/books/search/delete?bookId=${myBook.id }" class="btn btn-danger btn-sm onClick="if(!(confirm('Are you sure You want to delete This Book Record')))">Delete</a>
							 	
							 </td>
						</tr>
					
					</c:forEach>
				</tbody>
			</table>
	</div>
	 
</body>
</html>