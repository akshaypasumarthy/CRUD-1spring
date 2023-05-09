<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            *{
                margin:0;
            }
            .container{
                display: flex; 
                justify-content: center; 
                align-items: center;
                height: 80vh;
            }
            .userid{
                margin-bottom:20px;
                margin-left:25px;
                padding: 5px;
                border: 1px solid #ccc;
            }
            .password{
                margin-bottom   :10px;
                margin-left:5px;
                padding: 5px;
                border: 1px solid #ccc;
            }
            .submit{
              margin-left:100px;
              margin-top:20px;
              padding: 5px 10px;
              background-color: #333;
              color: white;
              border: none;
              cursor: pointer;
            }
            /* Header styles */
            header {
                background-color: #333;
                color: white;
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px;
            }
            header h1 {
                margin: 0;
            }
            header img {
                height: 50px;
            }
            header .login {
                display: flex;
                align-items: center;
            }
            header .login h1 {
                margin-left: 10px;
            }
            /* Footer styles */
            footer {
                background-color: #333;
                color: white;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 50px;
                position: absolute;
                bottom: 0;
                width: 100%;
            }
            footer p {
                margin: 0;
            }
            .one{
                padding-left:50px;
                padding-right:10px;
                padding-top:10px;
                padding-bottom:10px;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <header>
            <div class="login">
                <img src="https://png.pngtree.com/png-vector/20191110/ourmid/pngtree-avatar-icon-profile-icon-member-login-vector-isolated-png-image_1978396.jpg" alt="logo" style="width:100px,height:50px">
                <h1>Login</h1>
            </div>
            <p>Welcome to Assignment 6</p>
        </header>

        <!-- Main content -->
        <div class="container">
            <form action="Login" method="post" class="needs-validation" novalidate>
                <fieldset><legend>Login</legend>
                    <div class="one">
                <label for="userid">userid:</label>
                <input type="text" name="username" id="username" class="userid">
                <br>
                <label for="password">password:</label>
                <input type="password" id="password" name="password" class="password">
                <br>
                <input type="submit" value="Login" class="submit"> 
                    </div></fieldset>
            </form>
        </div>

        <!-- Footer -->
        <footer>
            <p>Nagarro Training</p>
        </footer>
    </body>
</html>
