
<%@page import="java.util.Map"%>
<%@page import="test.portlet.Age"%>
<%@page import="test.portlet.CountYearAndBirthday"%>

<%@ include file="./init.jsp" %>
<%
DonutChartConfig _donutChartConfig = new DonutChartConfig();

   _donutChartConfig.addColumns(
     new SingleValueColumn("2014", CountYearAndBirthday.Count().get(2014)),
     new SingleValueColumn("2019", CountYearAndBirthday.Count().get(2019))  
  
 );
    Map<Age , Integer> map =  (Map<Age, Integer>)  request.getAttribute("listnew") ;
    BarChartConfig _barChartConfig = new BarChartConfig();
    
      for (Map.Entry<Age, Integer> entry : map.entrySet()) {
    	_barChartConfig.addColumns(
			   	new MultiValueColumn(entry.getKey().toString(), entry.getValue())
			   	
			   );	 
       
    	 }

%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

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
		<tbody>
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
<chart:donut
  config="<%= _donutChartConfig %>"
/>

<chart:bar
  config="<%= _barChartConfig %>"
/>



<portlet:resourceURL var="baseResourceUrl">
</portlet:resourceURL>


<script>
       $(document).ready(function() {
    	   $('#bang1').DataTable(
    				 {
    					 "language": {
    						 "lengthMenu": 'Hiển Thị <select>'+
    					      '<option value="5">5</option>'+
    					      '<option value="20">20</option>'+
    					      '<option value="30">30</option>'+
    					      '<option value="40">40</option>'+
    					      '<option value="50">50</option>'+
    					      '<option value="-1">All</option>'+
    					      '</select> bản ghi',
    				            "zeroRecords": "Loading...- không có dữ liệu",
    				            "loadingRecords": "Vui lòng đợi - Loading....",
    				            "info": " PAGE / _PAGES_",
    				            "infoEmpty": "Không có dữ liệu",
    				            "infoFiltered": "(Lọc từ MAX tổng số bản ghi)",
    				            "search" : "Tìm kiếm",
    				            "paginate": { "first":"đầu tiên", "last":"cuối cùng", "next":"sau", "previous":"trước" }
    				        },
    					 'columnDefs': [{
    	                     'targets': [0,1,2,3,4,5],
    	                     'render': function (data, type, full, meta){
    	                      // var  data1 = '<a style="cursor: pointer; ">' + data + '</a>';
    	        var  data1 = '<a href="javascript:void(0);" onclick="javascript:updateNew(' +"'"+ full['0']  + "'"+');" style="text-decoration: none;">'+ data +  '</a>';

    	                      
    	                       return data1;
    	                       
    	                     }
    	                }],
    	                "drawCallback": function ( settings ) {
    	                    var api = this.api();
    	                    var rows = api.rows( {page:'current'} ).nodes();
    	                    var last=null;
    	          			/ console.log(api.column( 2,{page:'current'} ).data()); /
    	                    api.column(0, {page:'current'} ).data().each( function ( group, i ) {
    	                    	if(i==0){
    	                        	console.log('Row: >>>' +i);
    	                        	console.log('group: >>>' +group);      
    	                        	updateNew(group);
    	                    	}
    	                        } );
    	                }  
    	                
    				 });
	   
	      
	        } );

   
	$("table tr").click(function() {
		var row = $(this).closest("tr");
		var idns = row.find(".idns").text();
		if ("" != idns) {
			updateNew(idns);
		} else {

		}
	});

	function updateNew(idns) {
		$.ajax({
			url : '<%=baseResourceUrl%>',
            type:'GET',
            data :  {<portlet:namespace/>idns:idns},  // CHUYỂN ĐỔI OPJECT JAVASPRIT SANG JSON
            dataType: 'json',  // TỪ SEVER TRẢ VỀ CHO Client
            success:function(result){
            	if($('#bang2').DataTable() !=null)
				{
					 $('#bang2').DataTable().destroy();
				}
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
        		  
					 $('#bang2').DataTable(
							 {
								 "language": {
									 "lengthMenu": 'Hiển Thị <select>'+
								      '<option value="2">2</option>'+
								      '<option value="3">3</option>'+
								      '<option value="30">30</option>'+
								      '<option value="40">40</option>'+
								      '<option value="50">50</option>'+
								      '<option value="-1">All</option>'+
								      '</select> bản ghi',
							            "zeroRecords": "Loading...- không có dữ liệu",
							            "loadingRecords": "Vui lòng đợi - Loading....",
							            "info": " PAGE / _PAGES_",
							            "infoEmpty": "Không có dữ liệu",
							            "infoFiltered": "(Lọc từ MAX tổng số bản ghi)",
							            "search" : "Tìm kiếm",
							            "paginate": { "first":"đầu tiên", "last":"cuối cùng", "next":"sau", "previous":"trước" }
							        }		
							 });	
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