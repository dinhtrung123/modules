<%@ include file="./init.jsp"%>
<c:if test="${not empty list}">
<table border="1" id="tableId">
		<tr>
			<th>IDNS</th>
			<th>HOTENKHAISINH</th>
			<th>YEAR</th>
			<th>GIOGIANHDAY</th>
			<th>TUOI</th>
			<th>SOBAIBAO</th>
		</tr>
		<c:forEach items = "${list }"  var = "item">
		<tr>
		
		<td> ${ item.getIdns()}</td>
		<td> ${item.getHotenkhaisinh()}</td>
		<td> ${item.getYear()}</td>
		<td> ${item.getGiogiangday()}</td>
		<td> ${item.getTuoi()}</td>
		<td> ${item.getSobaibao()}</td>
	
		</tr>
	    </c:forEach>
</c:if>
<c:if test="${not empty donvi}">
<table border="1" id="tableId">
		<tr>
			<th>IDNS</th>
			<th>HOTENKHAISINH</th>
			<th>YEAR</th>
			<th>GIOGIANHDAY</th>
			<th>TUOI</th>
			<th>SOBAIBAO</th>
		</tr>
		<tr>
		
		<td> ${donvi.getIdns()}</td>
		<td> ${donvi.getHotenkhaisinh()}</td>
		<td> ${donvi.getYear()}</td>
		<td> ${donvi.getGiogiangday()}</td>
		<td> ${donvi.getTuoi()}</td>
		<td> ${donvi.getSobaibao()}</td>
	
		</tr>
</c:if>
<portlet:resourceURL var="baseResourceUrl" >
<portlet:param name="cmd" value="getDetail"/>
</portlet:resourceURL>


<script>
/* var id;
function addRowHandlers() {
	
    var table = document.getElementById("tableId");
    var rows = table.getElementsByTagName("tr");
    for (i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var createClickHandler = 
            function(row) 
            {
        	 var cell = row.getElementsByTagName("td")[0];
             id = cell.innerHTML;
                 return function() 
                 {  
                   alert("id:"+id);                   
                  }; 
            };

        currentRow.onclick = createClickHandler(currentRow);
    }
}
 window.onload = addRowHandlers(); */
 $(document).ready(function() {
	    $("div.custList > table > tr").live('click', function() {
	        alert("You clicked my <tr>!");
	        //get <td> element values here!!??
	    });
	});
</script>