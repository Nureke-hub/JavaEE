<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="views/head.jsp"%>
    <style>
        html,body {
            height: 100%;
        }

        .global-container{
            height:100%;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #f5f5f5;
        }

        form{
            padding-top: 10px;
            font-size: 14px;
            margin-top: 30px;
        }

        .card-title{ font-weight:300; }

        .btn{
            font-size: 14px;
            margin-top:20px;
        }


        .login-form{
            width:330px;
            margin:20px;
        }

        .sign-up{
            text-align:center;
            padding:20px 0 0;
        }

        .alert{
            margin-bottom:-30px;
            font-size: 13px;
            margin-top:20px;
        }
    </style>
</head>
<body>
<%String operation = String.valueOf(request.getAttribute("operation"));%>

<div class="global-container">
    <div class="card login-form">
        <%if (operation.equals("unsuccess")){%>
        <div class="alert alert-danger" role="alert">
            Wrong password or Login !
        </div>
        <%}%>
        <div class="card-body">
            <h3 class="card-title text-center">Log in</h3>
            <div class="card-text">
                <form action="/admin" method="post">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control form-control-sm" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <a href="#" style="float:right;font-size:12px;">Forgot password?</a>
                        <input type="password" class="form-control form-control-sm" id="exampleInputPassword1" name="password">
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
