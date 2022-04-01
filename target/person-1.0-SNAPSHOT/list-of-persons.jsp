<%@ page import="dto.PersonReadDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.03.2022
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Persons</title>
</head>
<body>
<p><a href="<%= request.getContextPath()%>/new">ADD NEW</a></p>
<table border="1" cellpadding="4" cellspacing="0">
    <tr>
        <th rowspan="3">ID</th>
        <th rowspan="3">Birth Date</th>
        <th rowspan="3">Name</th>
        <th rowspan="3">Surname</th>
    </tr>
    <tr>
        <th colspan="8">Permanent Address</th>
        <th colspan="5">Passport</th>
        <th colspan="9">Temporary Address</th>
        <th>Phone</th>
    </tr>
    <tr>
        <th>City</th>
        <th>Country</th>
        <th>District</th>
        <th>Flat</th>
        <th>Home</th>
        <th>LiveFrom</th>
        <th>Region</th>
        <th>Street</th>

        <th>Expired</th>
        <th>Issued</th>
        <th>Issued By</th>
        <th>Number</th>
        <th>Series</th>

        <th>City</th>
        <th>Country</th>
        <th>District</th>
        <th>Flat</th>
        <th>Home</th>
        <th>LiveFrom</th>
        <th>LiveTo</th>
        <th>Region</th>
        <th>Street</th>

        <th>Number</th>
    </tr>
    <% List<PersonReadDTO> personReadDTOS = (List<PersonReadDTO>) request.getAttribute("listPersons");
        for (PersonReadDTO personReadDTO: personReadDTOS) {
            out.println("<tr>");
            out.println("<td>" + personReadDTO.getId() + "</td>");
            out.println("<td>" + personReadDTO.getBirthDate() + "</td>");
            out.println("<td>" + personReadDTO.getName() + "</td>");
            out.println("<td>" + personReadDTO.getSurname() + "</td>");
            out.println("<td>" + personReadDTO.getCityPer() + "</td>");
            out.println("<td>" + personReadDTO.getCountryPer() + "</td>");
            out.println("<td>" + personReadDTO.getDistrictPer() + "</td>");
            out.println("<td>" + personReadDTO.getFlatPer() + "</td>");
            out.println("<td>" + personReadDTO.getHomePer() + "</td>");
            out.println("<td>" + personReadDTO.getLiveFromPer() + "</td>");
            out.println("<td>" + personReadDTO.getRegionPer() + "</td>");
            out.println("<td>" + personReadDTO.getStreetPer() + "</td>");
            out.println("<td>" + personReadDTO.getExpired() + "</td>");
            out.println("<td>" + personReadDTO.getIssued() + "</td>");
            out.println("<td>" + personReadDTO.getIssuedBy() + "</td>");
            out.println("<td>" + personReadDTO.getNumber() + "</td>");
            out.println("<td>" + personReadDTO.getSeries() + "</td>");
            out.println("<td>" + personReadDTO.getCityTemp() + "</td>");
            out.println("<td>" + personReadDTO.getCountryTemp() + "</td>");
            out.println("<td>" + personReadDTO.getDistrictTemp() + "</td>");
            out.println("<td>" + personReadDTO.getFlatTemp() + "</td>");
            out.println("<td>" + personReadDTO.getHomeTemp() + "</td>");
            out.println("<td>" + personReadDTO.getLiveFromTemp() + "</td>");
            out.println("<td>" + personReadDTO.getLiveToTemp() + "</td>");
            out.println("<td>" + personReadDTO.getRegionTemp() + "</td>");
            out.println("<td>" + personReadDTO.getStreetTemp() + "</td>");
            out.println("<td>" + personReadDTO.getPhoneNumber() + "</td>");
            out.println("<td><a href=\"edit?id=" + personReadDTO.getId()  +"\">Edit</a></td>");
            out.println("<td><a href=\"delete?id=" + personReadDTO.getId()  +"\">Delete</a></td>");
            out.println("</tr>");
        }
    %>

</table>
</body>
</html>
