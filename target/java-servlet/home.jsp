<html>
<head>
<title>
Welcome Home
</title>
<jsp:include page="include.jsp"/>
</head>
<body>
<section class="container">
    <h2>Hi ${name}</h2>
    <h3>Welcome home</h3>
    <br>
    <a href="${baseContext}/logout" class="btn btn-primary">Logout</a>
</section>
</body>
</html>