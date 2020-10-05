<%@ include file="./init.jsp" %>

	
		<div class="col-md-5">
			<label for="usr">Name</label>
			 <input type="text" class="form-control" id="tuoi" name ="tuoi"
			   placeholder="Input key search" value= "">
		</div>
		<div class="text-left">
       <button type="button" icon="icon-search" id ="search" >seach</button>	
	   </div>
<div class="row">
<div class="col-md-6">	
	<table class="table table-bordered" id ="bang1">	
		<thead>
		<tr>
			<th>IDNS</th>
			<th>HOTENKHAISINH</th>
			<th>YEAR</th>
			<th>GIOGIANHDAY</th>
			<th>TUOI</th>
			<th>SOBAIBAO</th>
		</tr>
			<thead>
		<tbody id ="bang3">
		
		  <c:forEach items="${list}" var="item">
			<tr>
				<td class="idns"> <a>${item.getIdns()}</a>  </td>
				<td>${item.getHotenkhaisinh()}</td>
				<td>${item.getYear()}</td>
				<td>${item.getGiogiangday()} </td>
				<td>${item.getTuoi()}</td>
				<td>${item.getSobaibao()}</td>

			</tr>
		</c:forEach>

		
		</tbody>
		
	</table>

</div>

<div class="col-md-6">
	<table class="table table-bordered" id = "bang2" >
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



<liferay-portlet:resourceURL var="baseResourceUrl" id="baseResourceUrl" copyCurrentRenderParameters="<%=false %>">
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="getCbByTuoi" id="getCbByTuoi" copyCurrentRenderParameters="<%=false %>">
</liferay-portlet:resourceURL>
<script>
   
$('#search').on('click', function() {
	  var tuoi = $('#tuoi').val() ;
	  search(tuoi);
	});
	
function search(tuoi) {
	$.ajax({
		url : '<%=getCbByTuoi%>',
        type:'GET',
        data :  {<portlet:namespace/>tuoi:tuoi},  // CHUYỂN ĐỔI OPJECT JAVASPRIT SANG JSON
        dataType: 'json',  // TỪ SEVER TRẢ VỀ CHO Client
        success:function(result){		
        	$('#bang3').empty();
    		for (var i = 0; i < result.length; i++) {
				let 
				bodytable = "<tr>";
				bodytable = bodytable + "<td >" + result[i].idns+  "</td>";
				bodytable = bodytable + "<td>"+ result[i].hotenkhaisinh + "</td>";
				bodytable = bodytable + "<td>" + result[i].year+ "</td>";
				bodytable = bodytable + "<td>"+ result[i].giogiangday + "</td>";
				bodytable = bodytable + "<td>"+ result[i].tuoi + "</td>";
				bodytable = bodytable + "<td>"+ result[i].sobaibao + "</td>";
				bodytable = bodytable + "</tr>";
				 $('#bang3').append(bodytable);
			}
    		  
			
    		  
		},
		error: function (request) {
		 alert("loi roi");
	    }
        
        
    });
    }
	 
	 
	 
	
   
	$("table tr").click(function() {
		var row = $(this).closest("tr");
		var idns = row.find(".idns").text();
		
		if ("" != idns) {
			updateNew(idns);
		} 
		
	});

	function updateNew(idns) {
		$.ajax({
			url : '<%=baseResourceUrl%>',
            type:'GET',
            data :  {<portlet:namespace/>idns:idns},  // CHUYỂN ĐỔI OPJECT JAVASPRIT SANG JSON
            dataType: 'json',  // TỪ SEVER TRẢ VỀ CHO Client
            success:function(result){		
            	$('#body-table-2').empty();
        		for (var i = 0; i < result.length; i++) {
					let 
					bodytable = "<tr>";
					bodytable = bodytable + "<td>" + result[i].idns+ "</td>";
					bodytable = bodytable + "<td>"+ result[i].hotenkhaisinh + "</td>";
					bodytable = bodytable + "<td>" + result[i].year+ "</td>";
					bodytable = bodytable + "<td>"+ result[i].tentapchi + "</td>";
					bodytable = bodytable + "<td>"+ result[i].tenbaibao + "</td>";
					bodytable = bodytable + "<td>"+ result[i].nambaibao + "</td>";
					bodytable = bodytable + "</tr>";
					 $('#body-table-2').append(bodytable);
				}
        		  
    		},
    		error: function (request) {
    			$('#bang2').DataTable().clear().draw();
    	    }
            
            
        });
        }
	
	 
	
 /*
	function edit(idns) {
		$('#body-table-2').empty();
		$
				.get("http://idm.vnu.edu.vn:8083/getBaiBaoByMaCB?maCanBo="
						+ idns,
						function(data) {
							console.log(data);
							for (var i = 0; i < data.length; i++) {
								let 
								bodytable = "<tr>";
								bodytable = bodytable + "<td>" + data[i].idns+ "</td>";
								bodytable = bodytable + "<td>"+ data[i].hotenkhaisinh + "</td>";
								bodytable = bodytable + "<td>" + data[i].year+ "</td>";
								bodytable = bodytable + "<td>"+ data[i].tentapchi + "</td>";
								bodytable = bodytable + "<td>"+ data[i].tenbaibao + "</td>";
								bodytable = bodytable + "<td>"+ data[i].nambaibao + "</td>";
								bodytable = bodytable + "</tr>";
								$('#body-table-2').append(bodytable);
							}
						});
		//alert(idns);
  
	}
 */
	
</script>


