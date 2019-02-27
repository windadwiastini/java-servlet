<html>
<head>
<title>
Login to system
</title>
<jsp:include page="include.jsp"/>
</head>
<body>
<section class="container">
    <form method="post" action="${baseContext}/login">
        <h2 class="text-center">Login into system</h2>
        <label style="color:red">${error}</label>
        <div class="form-group">
            <label>Username</label>
            <input type="text" class="form-control" placeholder="Masukkan username" name="username"/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" placeholder="Masukkan password" name="password"/>
        </div>

        <div class="form-group">
            <button class="btn btn-primary btn-block">LOGIN</button>
        </div>
    </form>
</section>
</body>
</html>