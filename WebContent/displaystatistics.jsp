<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<title>USER LOCATION STATISTICS</title>
<style>
table, td, th
{
border:1px solid green;
}
th
{
background-color:green;
color:white;
}
</style>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script>
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart1);
      google.setOnLoadCallback(drawChart2);
      google.setOnLoadCallback(drawChart3);
      google.setOnLoadCallback(drawChart4);
      google.setOnLoadCallback(drawChart5);
      google.setOnLoadCallback(drawChart6);
      google.setOnLoadCallback(drawChart7);
      
      function drawChart1() {
        
    	var data = new google.visualization.DataTable();
        data.addColumn('string','Train');
        data.addColumn('number','Count');
        <c:forEach items="${group_by_train_list}" var="d1" > 
        
          data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
          
      	</c:forEach>
        
        
        var options = {
          title: 'My Train Preferences'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart1'));
        chart.draw(data, options);
      }
      
      function drawChart2() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','From');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_from_station_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My From Station Preferences'
          };

          var chart = new google.visualization.PieChart(document.getElementById('piechart2'));
          chart.draw(data, options);
        }
      
      function drawChart3() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','To');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_to_station_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My To Station Preferences'
          };

          var chart = new google.visualization.PieChart(document.getElementById('piechart3'));
          chart.draw(data, options);
        }
      
      function drawChart4() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','Class');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_class_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My Class Preferences'
          };

          var chart = new google.visualization.PieChart(document.getElementById('piechart4'));
          chart.draw(data, options);
        }
      
      function drawChart5() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','Year');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_year_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My Yearly Stats'
          };

          var chart = new google.visualization.BarChart(document.getElementById('bargraph1'));
          chart.draw(data, options);
        }
      
      function drawChart6() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','Month');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_month_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My Monthly Stats'
          };

          var chart = new google.visualization.BarChart(document.getElementById('bargraph2'));
          chart.draw(data, options);
        }
      
      function drawChart7() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','Day');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_day_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My Daily Stats'
          };

          var chart = new google.visualization.BarChart(document.getElementById('bargraph3'));
          chart.draw(data, options);
        }
      
      $(document).ready(function() 
    		    { 
    		        $("#myTable1").tablesorter();
    		        $("#myTable2").tablesorter();
    		        $("#myTable3").tablesorter();
    		        $("#myTable4").tablesorter();
    		        $("#myTable5").tablesorter();
    		        $("#myTable6").tablesorter();
    		        $("#myTable7").tablesorter();
    		        
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

<table>
<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_train_list)}"/> results </font>
<table id="myTable1" class="bordered">
<thead id="Thead">
	<tr>
        <th>Train</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody id="Tbody">
<c:forEach items="${group_by_train_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div> </td>
<td>
<div id="piechart1" style="width: 900px; height: 500px;"></div>
</td>
</tr>
<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_from_station_list)}"/> results </font>
<table id="myTable2" class="bordered">
<thead>
	<tr>
        <th>From Station</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_from_station_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="piechart2" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>
<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_to_station_list)}"/> results </font>
<table id="myTable3" class="bordered">
<thead>
	<tr>
        <th>To Station</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_to_station_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="piechart3" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>

<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_class_list)}"/> results </font>
<table id="myTable4" class="bordered">
<thead>
	<tr>
        <th>Class</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_class_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="piechart4" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>

<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_year_list)}"/> results </font>
<table id="myTable5" class="bordered">
<thead>
	<tr>
        <th>Year</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_year_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="bargraph1" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>

<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_month_list)}"/> results </font>
<table id="myTable6" class="bordered">
<thead>
	<tr>
        <th>Month</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_month_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="bargraph2" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>

<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_day_list)}"/> results </font>
<table id="myTable7" class="bordered">
<thead>
	<tr>
        <th>Day Of Week</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_day_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="bargraph3" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>
</table>
</body>
</html>