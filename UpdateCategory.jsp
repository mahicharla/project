
<%@ include file="index.jsp"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<h2>Edit Category</h2>
<form action="<c:url value='/UpdateCategory'/>" method="post">
	<table align="center">
	<tr bgcolor="red">
			<td>Category ID</td>
			<td><input type="text" name="catid" id="catid" readonly value="${categoryInfo.categoryId}" /></td>
		</tr>
		<tr bgcolor="red">
			<td>Category Name</td>
			<td><input type="text" name="catname" id="catname" value="${categoryInfo.categoryName}" /></td>
		</tr>
		<tr bgcolor="red">
			<td>Category Description</td>
			<td><textarea name="catdesc" id="catdesc"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><center>
					<input type="submit" value="UPDATE" name="sb2" id="sb2" />
				</center></td>
				
		</tr>

	</table>
</form>
</body>
</html>