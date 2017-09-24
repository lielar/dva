<html>
<head><title>Book List</title>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src = "/nla2/js/jquery-3.1.1.min.js"></script>
      
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src = "/nla2/js/bootstrap.min.js"></script>
     <meta charset = "utf-8">
      <meta http-equiv = "X-UA-Compatible" content = "IE = edge">
      <meta name = "viewport" content = "width = device-width, initial-scale = 1">
      
      <title>Bootstrap 101 Template</title>
      
      <!-- Bootstrap -->
      <link href="/nla2/css/bootstrap.min.css" rel = "stylesheet">

</head>
<body>
<div class="jumbotron"><h1>Book List</h1></div>

<table class="container">
<#list model["booklist"] as book> 
<tr class="col-xs-3">
<td class="row">${book.title} - ${book.author}</td>
</tr>
</#list>
</div>

 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src = "/nla2/js/jquery-3.1.1.min.js"></script>
      
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src = "/nla2/js/bootstrap.min.js"></script>
   
</body>

</html>