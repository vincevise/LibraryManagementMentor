<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<h3>Book Directory</h3>
		<hr>
		
		<p class="h4 mb-4">Book</p>
		<form action="/LibraryManagementMentor/books/save" method="Post">
			<input type="hidden" name="id" value="${Book.id }"/>
			<div class="form-inline">
				<input type="text" name="name" value="${Book.name }" class="form-control mb-4 col-4" placeholder="Name"/>	

			</div>
			<div>		
				<input type="text" name="category" value="${Book.category }" class="form-control mb-4 col-4" placeholder="Category"/>			
			</div>
			<div>
				<input type="text" name="author" value="${Book.author }" class="form-control mb-4 col-4" placeholder="Author"/>			
			</div>
				
				<button type="submit" class="btn btn-info col-2">  Save</button>
				
				
			 
			
			<a href="/LibraryManagementMentor/books/List">Back to Books List</a>
		</div>
		</form>
	</div>
	

</body>
</html>