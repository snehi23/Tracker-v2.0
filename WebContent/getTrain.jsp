<%@page import="java.math.BigInteger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tracker.service.*"%>
    <%@page import="com.tracker.model.*"%>
    <%@page import="java.util.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%
String trainName = request.getParameter("q");
List<TrainDetails> trainDetails = new TrainDao().getTrain(trainName);

			Iterator<TrainDetails> iterator = trainDetails.iterator();
			
            while(iterator.hasNext()) {
            	TrainDetails t = iterator.next();
            	String train_Name = t.getTrain_Name();
            	BigInteger train_Number = t.getTrain_Number();
                        out.println(train_Name+"("+train_Number+")");
                        
                        
            }
       
       
%>
