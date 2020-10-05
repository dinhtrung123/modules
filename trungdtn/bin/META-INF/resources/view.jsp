<%@ include file="./init.jsp" %>

<div class="row">
<div class="col-md-6">
   <div>
		<div>
			<div class="col-md-5">
				<label>Student Name</label>
			  <input type="text" name="tuoi" id="tuoi" value="" placeholder="Input key search" >
			</div>
		</div>
		<div class="text-right">
		
		
			<button type="button" icon="icon-search"  id="button"  >Seach</button>
	 	</div>
	 	
	<table class="table table-bordered">	
		<tr>
			<th>IDNS</th>
			<th>HOTENKHAISINH</th>
			<th>YEAR</th>
			<th>GIOGIANHDAY</th>
			<th>TUOI</th>
			<th>SOBAIBAO</th>
		</tr>
		<tbody id="body-table-1">
		<c:forEach items="${list}" var="item">
			<tr>
				<td class="idns"><a>${item.getIdns()}</a></td>
				<td>${item.getHotenkhaisinh()}</td>
				<td>${item.getYear()}</td>
				<td>${item.getGiogiangday()} </td>
				<td>${item.getTuoi()}</td>
				<td>${item.getSobaibao()}</td>

			</tr>
		</c:forEach>
		</tbody>
		<tbody id="body-table-3">
		
		</tbody>
		
		
		
	</table>
</div>
</div>

<div class="col-md-6">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>idns</th>
				<th>hotenkhaisinh</th>
				<th>year</th>
				<th>tentapchi</th>
				<th>tenbaibao</th>
				<th>nambaibao</th>
			</tr>
		</thead>
		
		<tbody id="body-table-2">
		
		</tbody>
		
	</table>
</div>
</div>


<portlet:resourceURL var="baseResourceUrl">
</portlet:resourceURL>
>