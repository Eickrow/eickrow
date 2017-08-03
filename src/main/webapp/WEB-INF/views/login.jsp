<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title>login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/login.css" rel="stylesheet">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <img class="profile-img" src="/imgs/login_user_photo.png" alt="user_photo">
                <form class="form-signin" action="/login_process" method="post">
                    <security:csrfInput/>
                    <input type="text" name="login_user" class="form-control" placeholder="Username" required autofocus>
                    <input type="password" name="login_pwd" class="form-control" placeholder="Password" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">
                        Sign in
                    </button>
                    <label class="checkbox pull-left">
                        <input type="checkbox" value="remember-me">
                        Remember me
                    </label>
                    <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="#" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>
</body>
</html>