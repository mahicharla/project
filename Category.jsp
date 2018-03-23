<%@ include file="index.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Category page TESTING</h2>
<form action="InsertCategory" method="post">
	<table align="center">
		<tr bgcolor="red">
			<td>Category Name</td>
			<td><input type="text" name="catname" id="catname" /></td>
		</tr>
		<tr bgcolor="red">
			<td>Category Description</td>
			<td><textarea name="catdesc" id="catdesc"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><center>
					<input type="submit" value="SUBMIT" name="sb1" id="sb1" />
				</center></td>
				
		</tr>

	</table>
</form>
<center>
	<table border="5">
		<tr>
			<th>CAT_ID</th>
			<th>CAT_NAME</th>
			<th>CAT_DESC</th>
			<th>OPTION</th>

		</tr>
		
			<c:forEach items="${categoryList}" var="category">
			<tr>
				<td>${category.categoryId}</td>
				<td>${category.categoryName}</td>
				<td>${category.categoryDesc}</td>
				<td>      <a href="<c:url value='/editCategory/${category.categoryId}'/>">EDIT</a>/
				          <a href="<c:url value='/deleteCategory/${category.categoryId}'/>">DELETE</a>
				 </td>         
			</tr>
			</c:forEach>
		
	</table>
	
		</body>
		</html>