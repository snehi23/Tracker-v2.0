<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.min.css">
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui-1.10.4.custom.min.js"></script>

<script>
$(function() {
	
    $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
    
  });
  
$(document).ready(function() {
    $("input#autocomplete1").autocomplete({
        source: function(request, response){
            var options = ["Rajdhani Express","Nagpur Pune Express","Pune Nagpur Express","Sangamitra Express","Sampraka-kranti Express","Garibrath Express"];
            var results = [request.term];
            var regex = new RegExp(request.term, "i");
            for(var i = 0; i< options.length; i++){
                if (options[i].match(regex))
                    results.push(options[i]);
            }
            response(results);
        }       
    });
    
    $("input#autocomplete2").autocomplete({
        source: function(request, response){
            var options = ["SBC","YPR","NGP","PUNE","MAO","HGT","ADI"];
            var results = [request.term];
            var regex = new RegExp(request.term, "i");
            for(var i = 0; i< options.length; i++){
                if (options[i].match(regex))
                    results.push(options[i]);
            }
            response(results);
        }       
    });
    
    $("input#autocomplete3").autocomplete({
        source: function(request, response){
            var options = ["SBC","YPR","NGP","PUNE","MAO","HGT","ADI"];
            var results = [request.term];
            var regex = new RegExp(request.term, "i");
            for(var i = 0; i< options.length; i++){
                if (options[i].match(regex))
                    results.push(options[i]);
            }
            response(results);
        }       
    });
});
  
</script>

</head>
<body>
<marquee><font color="Green">Welcome ${sessionScope['user'].userid}</font></marquee>
 
<H3>User Input</H3>



<form action="UserInputController" METHOD="post">

<table class=".bordered">
<tr>
	<td>Date Of Journey :</td>
	<td><INPUT TYPE="TEXT" id='datepicker' NAME="DOJ" SIZE="20"></td>
</tr>

<tr>
	<td>Train  :</td>
	<td><INPUT TYPE="TEXT" NAME="Train"  id="autocomplete1" SIZE="20"></td>
	
</tr>

<tr>
	<td>From  :</td>
	<td><INPUT TYPE="TEXT" NAME="From" id="autocomplete2" SIZE="20"></td>
	
</tr>

<tr>
	<td>To  :</td>
	<td><INPUT TYPE="TEXT" NAME="To"  id="autocomplete3" SIZE="20"></td>
	
</tr>


<tr> 
<td>Class :</td> 
<tr>

	<td><INPUT TYPE="RADIO" NAME="classes" VALUE="1-AC">1-AC </td>
	<td><INPUT TYPE="RADIO" NAME="classes" VALUE="2-AC">2-AC </td>
	
</tr>

<tr>
	
	<td><INPUT TYPE="RADIO" NAME="classes" VALUE="3-AC">3-AC </td>
	<td><INPUT TYPE="RADIO" NAME="classes" VALUE="SL">SL </td>
	<td><INPUT TYPE="RADIO" NAME="classes" VALUE="Gen">Gen </td>


<tr>

<td>Comments :</td>
<td><textarea NAME="comments" style="resize:none"></textarea> </td>

</tr>
<tr>

<td><INPUT TYPE="SUBMIT" VALUE="Submit"></td>
<td><INPUT TYPE="RESET" VALUE="Reset"></td>

</tr>

</table> 
</form>


<table>
<tr>
<td>
<form action='JourneyDetailsController' method='post'>

<input type="submit" value="Show My data">

</form>
</td>
<td>
<form action='RefreshLocationController' method='post'>

<input type="submit" value="Force Refresh" disabled="disabled">

</form>
</td>
<td>
<form action='DisplayLocationController' method='post'>

<input type="submit" value="Show Location">

</form>
</td>
<td>
<form action='DisplayStatisticsController' method='post'>

<input type="submit" value="Show Stats">

</form>
</td>
</tr>
</table>
</body>


</html>