<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/traveldataentry.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="css/simplePagination.css">
<link href="css/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.min.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.pager.js"></script>
<script>

	$(document).ready(function() 
	    { 
	        $("#myTable").tablesorter();  
	    } 
	);
	
	$(document).ready(function() 
		    { 
				$( "#accordion" ).accordion({collapsible:true, heightStyle:"content"}); 
		    } 
	);
	
	$.event.special.hoverintent = {
		    setup: function() {
		      $( this ).bind( "mouseover", jQuery.event.special.hoverintent.handler );
		    },
		    teardown: function() {
		      $( this ).unbind( "mouseover", jQuery.event.special.hoverintent.handler );
		    },
		    handler: function( event ) {
		      var currentX, currentY, timeout,
		        args = arguments,
		        target = $( event.target ),
		        previousX = event.pageX,
		        previousY = event.pageY;
		 
		      function track( event ) {
		        currentX = event.pageX;
		        currentY = event.pageY;
		      };
		 
		      function clear() {
		        target
		          .unbind( "mousemove", track )
		          .unbind( "mouseout", clear );
		        clearTimeout( timeout );
		      }
		 
		      function handler() {
		        var prop,
		          orig = event;
		 
		        if ( ( Math.abs( previousX - currentX ) +
		            Math.abs( previousY - currentY ) ) < 7 ) {
		          clear();
		 
		          event = $.Event( "hoverintent" );
		          for ( prop in orig ) {
		            if ( !( prop in event ) ) {
		              event[ prop ] = orig[ prop ];
		            }
		          }
		          // Prevent accessing the original event since the new event
		          // is fired asynchronously and the old event is no longer
		          // usable (#6028)
		          delete event.originalEvent;
		 
		          target.trigger( event );
		        } else {
		          previousX = currentX;
		          previousY = currentY;
		          timeout = setTimeout( handler, 100 );
		        }
		      }
		 
		      timeout = setTimeout( handler, 100 );
		      target.bind({
		        mousemove: track,
		        mouseout: clear
		      });
		    }
		  };
	

</script>
</head>
<body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Hello ${sessionScope['userid']} !</h3>
              <ul class="nav masthead-nav">
                <li><a href="#">Home</a></li>
                <li><a href="success.jsp">Add a Journey</a></li>
                <li class="active"><a href="JourneyDetailsController">Records</a></li>
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

          <div class="inner cover" id="records">
            <h1 class="cover-heading">Displaying <c:out value="${fn:length(details_list)}"/> results</h1>
				<div id="add-another-entry"><h5>${requestScope['Record_Confirmation']}</h5></div>
			<div id="accordion" > <!-- TODO: 1. Retaining formatting of text in comments 2. Adding link to delete the record -->
				<c:forEach items="${details_list}" var="d1" varStatus="status">
				<ul class="record_heading">
					<li><h3>Journey on <c:out value="${d1.DOJ}"/></h3></li>
					<li><h3><c:out value="${d1.train}"/></h3></li>
					
					
				</ul>
				<div class="comments"><p> <c:out value="${d1.comments}"></c:out> </p>
				
				<a href="DeleteRecordController?recordid=<c:out value="${d1.train_journey_id}"/>" onclick="return confirm('Are you sure you want to delete this journey?');">Delete Journey</a>
				
				<a href="UserInputEditController?recordid=<c:out value="${d1.train_journey_id}"/>">Edit Journey</a>
				
				</div>					 
				</c:forEach>
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
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/simplePagination.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.pager.js"></script>


<title>User Details</title>


<script>

	$(document).ready(function() 
	    { 
	        $("#myTable").tablesorter();  
	    } 
	);

</script>

<style>

.bordered thead {
color: #0E58A0;
font-family: Arial, Helvetica, sans-serif;
font-size: 12px;

}

.bordered tbody
{

border-width: 0px 0px 1px 0px;
font-family: Arial, Helvetica, sans-serif;
color: #2B4EB7;
font-size: 11px;
border-color: #2B4EB7;

}

.bordered {
    border: solid #ccc 1px;
    background-color:#FFF; 
    box-shadow: 0 1px 1px #ccc;
    border-left: 1px solid #ccc;
    border-top: 1px solid #ccc;
    padding: 5px;
    text-align: left;          
}

</style>

</head>
<body>
<font color="Green"> Displaying <c:out value="${fn:length(details_list)}"/> results </font>
<table id="myTable" class="bordered">
<thead>
<tr>
        <th>Train Journey ID</th>        
        <th>Date Of Journey</th>
        <th>Train</th>
		<th>From Station</th>
		<th>To Station</th>
		<th>Class</th>
		<th>Comment</th>		
    </tr>
</thead>
<tbody>
<c:forEach items="${details_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.train_journey_id}"></c:out></td>
    <td><c:out value="${d1.DOJ}"></c:out></td>
     <td><c:out value="${d1.train}"></c:out></td> 
    <td><c:out value="${d1.from_Station}"></c:out></td>
    <td><c:out value="${d1.to_Station}"></c:out></td>
    <td><c:out value="${d1.classes}"></c:out></td>
    <td><c:out value="${d1.comments}"></c:out></td>
     </tr>
</c:forEach>
</tbody>
</table>
</body>
</html> --%>