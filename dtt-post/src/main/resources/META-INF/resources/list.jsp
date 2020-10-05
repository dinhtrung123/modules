
<%@ include file="./init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<c:if test="${not empty list }">
	<div class="row">
		<div class="col-md-6">
			<table class="table table-bordered table-hover " id="table1">
				<thead>
					<tr>
						<th>Mã</th>
						<th>Họ Tên</th>
						<th>Năm</th>
						<th>Giờ</th>
						<th>Tuổi</th>
						<th>Số Bài Báo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list }">
						<tr>
							<td class="idns">${item.getIdns()}</td>
							<td>${item.getHotenkhaisinh()}</td>
							<td>${item.getYear()}</td>
							<td>${item.getGiogiangday()}</td>
							<td>${item.getTuoi()}</td>
							<td>${item.getSobaibao()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<div class="col-md-6">
			<table id="table2" class="table table-bordered table-hover ">
				<thead>
					<tr>
						<th>Mã</th>
						<th>Họ tên</th>
						<th>Năm</th>
						<th>Tên tạp chí</th>
						<th>Tên bài báo</th>
						<th>Năm bài báo</th>
					</tr>
				</thead>
				<tbody id="body-table-2">

				</tbody>
			</table>
			<!-- <p id="p"></p> -->
		</div>
	</div>
</c:if>
<c:if test="${ empty list }">
	<p>Không có dữ liệu</p>
</c:if>
<portlet:resourceURL var="editUrl">
	<portlet:param name="cmd" value="test" />
</portlet:resourceURL>
<script>
						$(document).ready(function() {
						$('#table1').DataTable();
						

						} );
						$("table tr").click(function() {
						var row = $(this).closest("tr");
						var idns = row.find(".idns").text();
						if ("" != idns) {
						edit(idns);
						}
						})
						
						function edit(idns)
						{

						var data = {"<portlet:namespace/>id":idns};
						$.ajax({
						url:"<%=editUrl%>",
						type: 'POST',
						data,
						success: function(data) {
						if(data=="error")
						{
						$('#table2').DataTable().clear().draw();
						// document.getElementById("p").innerHTML="Không có dữ liệu";
						}
						else
						{
						// document.getElementById("p").innerHTML="";
						
						data = JSON.parse(data);
						var tabledb2 = null;
						if (tabledb2 != null) 
						{
						$("#table2").detach();
						tabledb2 = null;
						}
						$('#body-table-2').empty();
						for (var i = 0; i < data.length; i++) {
						let
						bodytable = "<tr>";
						bodytable = bodytable + "<td>" + data[i].idns
						+ "</td>";
						bodytable = bodytable + "<td>"
						+ data[i].hotenkhaisinh + "</td>";
						bodytable = bodytable + "<td>" + data[i].year
						+ "</td>";
						bodytable = bodytable + "<td>"
						+ data[i].tentapchi + "</td>";
						bodytable = bodytable + "<td>"
						+ data[i].tenbaibao + "</td>";
						bodytable = bodytable + "<td>"
						+ data[i].nambaibao + "</td>";
						bodytable = bodytable + "</tr>";

						tabledb2 = $('#body-table-2').append(bodytable);
						}
						
						
						if($('#table2').DataTable() ==null)
					     {
							
						   $('#table2').DataTable(
						 {
					      	"lengthMenu" : [ [ 2, 5, 10, -1 ],[ 2, 5, 10, "All" ] ]
						   });
						
						 }
						
						
						
						
						}
				} 

						});

}

</script>