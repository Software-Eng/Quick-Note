<%-- 
    Document   : login
    Created on : Nov 21, 2014, 1:10:47 PM
    Author     : Steven
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form method ="post" action ="login">
            <center>
            username<input type ="text" name="username"/>
            <br></br>
            password <input type="password" name ="password"/>
            <br></br>
            <input type="submit" name="Submit"/>
            <br/>
            <div>Any questions?</div>
            </center>
        </form>
    </body>
</html>