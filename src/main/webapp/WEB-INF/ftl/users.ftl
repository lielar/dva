<html>
<head><title>Book List</title>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src = "js/jquery-3.1.1.min.js"></script>
      
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src = "js/bootstrap.min.js"></script>
     <meta charset = "utf-8">
      <meta http-equiv = "X-UA-Compatible" content = "IE = edge">
      <meta name = "viewport" content = "width = device-width, initial-scale = 1">
      
      <title>Bootstrap 101 Template</title>
      
      <!-- Bootstrap -->
      <link href = "css/bootstrap.min.css" rel = "stylesheet">

<script language="javascript">
function callAjax(userid) {
$.ajax({
   type: "GET",
   url: "/dva/claimsquery/userquery/"+userid,
   dataType: "json",
   success: function(msg){
   	   console.log(msg);
	   console.log(msg.length);
	   var resultHtml = '<table class=\"table table-striped\">'
	   		+'<thead><tr><td>Claims Description</td><td>Amount</td><td>Date</td></tr>';
	   if (msg.length) {
	   	for (var i = 0; i < msg.length; i++) {
	   		//console.log('i '+i+msg[i].title);
			resultHtml += '<tr><td>'+msg[i].description;
			resultHtml += '</td><td>'+msg[i].amount;	   		
			resultHtml += '</td><td>'+msg[i].claimDate;	   		
			resultHtml += '</td></tr>';	   		
	   	}
	   } else {
	   		resultHtml +='<tr><td colspan=\"3\">No books</td></tr>'
	   }
	   		resultHtml += '</table>'
       		$('.answer').html(resultHtml);
   }
});
}
</script>


</head>
<body>
<div class="jumbotron"><h1>Users and claim list</h1></div>

<table class="container">
<#list model["userlists"] as user> 
<tr class="col-xs-3">
<td class="row">${user.user.name} - Phone - ${user.user.phone}, Email - ${user.user.email} - <span class="badge">claims - ${user.claims?size}</span>
<br/><input type="button" class="button btn-default" value="Claim List" onClick="callAjax('${user.user.id}')"/>
</td>
</tr>

</#list>
</table>
<p class="answer"></p>

 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src = "js/jquery-3.1.1.min.js"></script>
      
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src = "js/bootstrap.min.js"></script>
   
</body>

</html>