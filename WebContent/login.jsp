<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<script>
function validateLogin()
{
	var x=document.forms["loginform"]["user"].value;
	var y=document.forms["loginform"]["pass"].value;
	
	if (x==null || x=="")
  	{
  		document.getElementById("error").innerHTML="Please enter Username";
  		return false;
  	}
	
	if(y==null || y=="")
  	{
		document.getElementById("error").innerHTML="Please enter Password";
		return false;
  	}
	
	if (!/[a-zA-Z]/.test(x) || !/[0-9]/.test(x))
	{
		document.getElementById("error").innerHTML="Username requires one of the letters or digits";
  		return false;		
	}	
	
	if (!/[a-zA-Z]/.test(y) || !/[0-9]/.test(y))
	{
		document.getElementById("error").innerHTML="Password requires one of the letters or digits";
  		return false;		
	}
	
	return true;
 
}
</script>
</head>
<body>
    <form name="loginform" action="LoginController" method="post">
<table align="left" border="0" cellspacing="0" cellpadding="3">
    <tr>
    	<td></td>
    	<td><div id="error" style="color:red"></div></td>
    </tr>
    
    <tr>
        <td>Username:</td>
        <td><input type="text" name="user" maxlength="30"></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><input type="password" name="pass" maxlength="30"></td>
    </tr>
    <tr>
        <td colspan="2" align="left"><input type="checkbox" name="remember"><font size="2">Remember Me</font></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" name="submit" value="Login"></td>
    </tr>
</table> 
</form>
</body>
</html>