<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="pragma"        content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-store" />


<title>Success</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/traveldataentry.css" rel="stylesheet">
<link href="css/dataentry_form.css" rel="stylesheet">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.min.css">
<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
	<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="js/jquery.autocomplete.js"></script>


<script>
$(function() {
	
    $("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' }).val();
    
  });
  
  $(document).ready(function() {
    $("#autocomplete1").autocomplete("getTrain.jsp");
    $("#autocomplete2").autocomplete("getStation.jsp");
    $("#autocomplete3").autocomplete("getStation.jsp");
});
    
function validateForm() {
	
	
	var only_letters = /^[A-Za-z]{3,20}$/;
	var letters_num = /^[A-Za-z0-9]{3,20}$/;
	var only_caps = /^[A-Z]{1,4}$/;
	
	var x=document.getElementsByName("Train")[0].value;
	var y=document.getElementsByName("From")[0].value;
	var z=document.getElementsByName("To")[0].value;	
	var q=document.getElementsByName("comments")[0].value;
	
	var n = y.localeCompare(z);
	
	/* var radios_c = document.getElementsByName("classes");
	
	var radios_b = document.getElementsByName("berth"); */
	
    var formValid = true;
    /* var classValid = false;
    var berthValid = false; */
    
	var pattern = new RegExp(/[~!#$%\^&*+=\-\[\]\\;,/{}|\\:<>\?]/);
	
	if(n==0) {
		
		document.getElementById("To_error").innerHTML="Dude same source and destination";
		formValid = false;
	} else {
		
		document.getElementById("To_error").innerHTML="";
		
	}
	
	/*
    var i = 0;
    while (!classValid && i < radios_c.length) {
        if (radios_c[i].checked) classValid = true;
        i++;        
    }

    if (!classValid) {
     document.getElementById("Class_error").innerHTML="Must check some option!";
     formValid = false;
    } else {
		
		document.getElementById("Class_error").innerHTML="";
		
	}
    
    var j = 0;
    while (!berthValid && i < radios_b.length) {
        if (radios_b[j].checked) berthValid = true;
        j++;        
    }

    if (!berthValid) {
     document.getElementById("Class_error").innerHTML="Must check some option!";
     formValid = false;
    } else {
		
		document.getElementById("Class_error").innerHTML="";
		
	}
	
	
	 if (!only_letters.test(x)) {
		document.getElementById("Train_error").innerHTML="Train Name requires only letters";
		formValid = false;		
	} else {
		
		document.getElementById("Train_error").innerHTML="";
		
	}	
	
	if (!only_caps.test(y)) {
		document.getElementById("From_error").innerHTML="From Station code should in capital and of length 3-4 characters only";
		formValid = false;		
	} else {
		
		document.getElementById("From_error").innerHTML="";
		
	}
	
	if (!only_caps.test(z)) {
		document.getElementById("To_error").innerHTML="To Station code should in capital and of length 3-4 characters only";
		formValid = false;		
	} else {
		
		document.getElementById("To_error").innerHTML="";
		
	}
	
	if(pattern.test(q)) {
		
		document.getElementById("Comments_error").innerHTML="Please only use standard alphanumerics";
		formValid = false;
	} else {
		
		document.getElementById("Comments_error").innerHTML="";
		
	} */
	
	
	
	if(formValid) {	
		return true;
	} else {return false;}
	
}

function nobacktrack() {
	
	history.forward();
}

  
</script>

</head>
<body onload="nobacktrack();">
    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Hello ${sessionScope['userid']} !</h3>
              <ul class="nav masthead-nav">
                <!-- <li><a href="#">Home</a></li> -->
                <li class="active"><a href="success.jsp">Add a Journey</a></li>
                <li><a href="JourneyDetailsController">Records</a></li>
                <li><a href="DisplayStatisticsController">Statistics</a></li>
                <!-- <li><a href="DisplayLocationController">Locations</a></li> -->
                <li><a href="LogoutController">LogOut</a></li>
                <li><a href="#"><form action='RefreshLocationController' method='post'>
					<input  style="background-image: url(img/refresh.png); background-color: transparent;
						background-repeat: no-repeat;
						background-position: 0px 0px;
						border: none;
						cursor: pointer;
						height: 35px;
						width: 30px;
						padding-left: 16px;
						vertical-align: middle;" title="Force Refresh" type="submit" value="">
					</form></a>
				</li>
              </ul>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Update Your Journey Details</h1>
            <div id="add-another-entry"><h5>${requestScope['Record_Confirmation']}</h5></div>
			<div class="row">
			<form class="form-signin" name="form" action="UserInputUpdateController" METHOD="post" onsubmit="return validateForm()">
				<div id="inner-left" class="col-lg-6">
				<p class="lead">
					<input type="text" name="PNR" SIZE="20" class="form-control" placeholder="Enter Your PNR or Fill out following fields" required autofocus disabled="disabled">
					<div id="pnr_error" style="color:red"></div>
					<input id="autocomplete1" type="text" name="Train" SIZE="20" class="form-control" placeholder="Train Name" required value="${details.train}">
					<div id="Date_error" style="color:red"></div>
					<input id="datepicker" type="text" name="DOJ" SIZE="20" class="form-control" placeholder="Date Of Journey" required value="${details.DOJ}">
					<div id="Date_error" style="color:red"></div>
					<input id="autocomplete2" type="text" name="From" SIZE="20" class="form-control" placeholder="Station From" required value="${details.from_Station}">
					<div id="From_error" style="color:red"></div>
					<input id="autocomplete3" type="text" name="To" SIZE="20" class="form-control" placeholder="Station To" required value="${details.to_Station}">
					<div id="To_error" style="color:red"></div>
					<ul id="class-input-list">
						<li>Class :</li>
						<li><input class="radio-control" TYPE="RADIO" NAME="classes" VALUE="1-AC" ${details.classes == '1-AC' ? 'checked' : ''}>1-AC</li> 
						<li><input class="radio-control" TYPE="RADIO" NAME="classes" VALUE="2-AC" ${details.classes == '2-AC' ? 'checked' : ''}>2-AC</li>
						<li><input class="radio-control" TYPE="RADIO" NAME="classes" VALUE="3-AC" ${details.classes == '3-AC' ? 'checked' : ''}>3-AC</li>
						<li><input class="radio-control" TYPE="RADIO" NAME="classes" VALUE="SL" ${details.classes == 'SL' ? 'checked' : ''}>SL</li>
						<li><input class="radio-control" TYPE="RADIO" NAME="classes" VALUE="Gen" ${details.classes == 'Gen' ? 'checked' : ''}>Gen</li>
					</ul>
					<div id="Class_error" style="color:red"></div>
					<div>
					<ul id="berth-input-list">
						<li>Berth :</li>
						<li><input class="radio-control" TYPE="RADIO" NAME="berth" VALUE="LB" ${details.berth == 'LB' ? 'checked' : ''}>LB</li> 
						<li><input class="radio-control" TYPE="RADIO" NAME="berth" VALUE="MB" ${details.berth == 'MB' ? 'checked' : ''}>MB</li>
						<li><input class="radio-control" TYPE="RADIO" NAME="berth" VALUE="UB" ${details.berth == 'UB' ? 'checked' : ''}>UB</li>
						<li><input class="radio-control" TYPE="RADIO" NAME="berth" VALUE="SL" ${details.berth == 'SL' ? 'checked' : ''}>SL</li>
						<li><input class="radio-control" TYPE="RADIO" NAME="berth" VALUE="SU" ${details.berth == 'SU' ? 'checked' : ''}>SU</li>
					</ul>
					<div id="Berth_error" style="color:red"></div>
					</div>
				</p>
				</div>
				<div id="inner-right" class="col-lg-6">
				<p class="lead">
					<textarea id="memorable-moments" type="text" name="comments" class="form-control" placeholder="Memorable Moments" style="resize:none" required value="">${details.comments}</textarea> 
					<div id="Comments_error" style="color:red"></div>
				</p>
				</div>
				<div id="buttons-control" class="col-lg-14">
				<ul id="submit-buuton-input-list">
					<li><INPUT TYPE="SUBMIT" VALUE="Submit" class="btn btn-lg btn-success"></li>
					
				</ul>
				</div>
			</form>
			</div>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p></p>
            </div>
          </div>

        </div>

      </div>

    </div>
</body>


</html>