<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tracker.service.*"%>
    <%@page import="com.tracker.model.*"%>
    <%@page import="java.util.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
String stationName = request.getParameter("q");
List<StationDetails> stationDetails = new StationDao().getStation(stationName);

			Iterator<StationDetails> iterator = stationDetails.iterator();
			
            while(iterator.hasNext()) {
            	StationDetails t = iterator.next();
            	String Station_Name = t.getStation_Name();
            	String Station_Code = t.getStation_Code();
                        out.println(Station_Name+"("+Station_Code+")");
                        
                        
            }
       
       
%>
