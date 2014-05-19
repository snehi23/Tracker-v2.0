<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="pragma"        content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-store" />
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/signin.css" rel="stylesheet">
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
	
	
<title>Registration Form</title>

</head>
<body>

<%-- <marquee><font color="Red">${sessionScope['userid uniqeness']}</font></marquee> --%>

	 <form class="form-signin" role="form" name="loginform" action="RegistrationController" method="post" >
		<h2>Create account</h2>
		<div id="error" style="color:red"></div>
		<input id="name" type="text" name="name" maxlength="30" class="form-control" placeholder="Name" required autofocus>
		<input id="username" type="text" name="username" maxlength="30" class="form-control" placeholder="Username" required> <font color="Red">${sessionScope['userid uniqueness']}</font>
		<input id="email" type="text" name="email" maxlength="30" class="form-control" placeholder="Email" required>
		<input id="password" type="password" name="password" maxlength="30" class="form-control" placeholder="Password" required>
		<input id="password2" type="password" name="password2" maxlength="30" class="form-control" placeholder="Repeat password" required>
		Terms of Service<br>
		
		<textarea class="form-control" readonly="readonly"> 
		DESCRIPTION
		journeytracker.in is a service for traveling enthusiasts who want to keep a record of journey they have done.
		Members of journeytracker.in have their own profile where statistics of the members journey are shown, to keep the tracking as simple as possible.
		journeytracker.in is aimed to serve passengers who want to keep track of their journey.

		PRIVACY POLICY
		journeytracker.in will keep your information accurate, secure and private and we will never transfer any information or data to any third party.
		journeytracker.in collects and saves this data at the time of registration for the use of our services:
			- Your name
			- Your e-mail address

					
		RULES AND REGULATIONS
		Once registered to journeytracker.in you will get access to your own personal journeys page. You can manage all of your journeys, delete and add a new journey. What information you add is up to yourself to decide.
		You may add as many journeys you want but you may not abuse the system such as adding unrealistic journeys and you must not add any hypothetical journey, the purpose of journeytracker.in is to track real journeys.

		NOT FOLLOWING THE RULES
		Not following the rules will have consequences. You will be warned, or ultimately banned. In more alarming situations your user account will be deleted and/or your Internet service provider may also be contacted.
		If you are being contacted by one of our staff, it is recommended that you obey their wishes and recommendations. We are here to keep a friendly environment, so please respect our wishes. If you have any comments about the work or decisions of the staff, please contact us via the contact form.
					
		ADVERTISING POLICY
		If you wish to receive more information about future advertisement possibilities at our WebSite, please contact us. For the moment, we are completely ad-free.
					
		TERMINATION OF ACCOUNT
		If a user wishes to delete his or her account, he or she may request this using our contact form. This can be done at any time.
		In the case of termination of an account, all information will be deleted, including all of your journeys.
					
		COPYRIGHT
		When register to journeytracker.in you agree not to copy, distribute, transfer or modify our work.
					
		COSTS AND CONTRIBUTION
		journeytracker.in is completely free of charge.
					
		DISCLAIMER
		journeytracker.in reserves itself for any changes or updates of these terms and conditions. In an event of a major update users will be contacted.
					
		</textarea>
		
		<label class="checkbox">
			<input type="checkbox" value="remember-me"> By clicking "Create account" below, you agree to the Terms of Service.
		</label>
		<button class="btn btn-lg btn-primary btn-block" type="submit" name="submit" value="Create account">Create Account</button>
	</form>
</body>
</html>