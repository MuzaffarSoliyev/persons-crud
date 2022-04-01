<%@ page import="dto.PersonReadDTO" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.03.2022
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit person</h2>
<h3>Personal data</h3>
<form action="/update" method="POST">

    <%
        PersonReadDTO personReadDTO = (PersonReadDTO) request.getAttribute("existingPerson");
    %>
    <input type="text" name="id" value="<%=personReadDTO.getId()%>" hidden>
    <label for="BirthDate">Birth Date</label>
    <input type="date" id="BirthDate" name="BirthDate" value="<%=personReadDTO.getBirthDate()%>"><br><br>

    <label for="Name">Name</label>
    <input type="text" id="Name" name="Name" value="<%=personReadDTO.getName()%>" ><br><br>

    <label for="Surname">Surname</label>
    <input type="text" id="Surname" name="Surname" value="<%=personReadDTO.getSurname()%>"><br><br>

    <h3>Permanent Address</h3>

    <label for="CityPer">City</label>
    <input type="text" id="CityPer" name="CityPer" value="<%=personReadDTO.getCityPer()%>"><br><br>

    <label for="CountryPer">Country</label>
    <input type="text" id="CountryPer" name="CountryPer" value="<%=personReadDTO.getCountryPer()%>"><br><br>

    <label for="DistrictPer">District</label>
    <input type="text" id="DistrictPer" name="DistrictPer" value="<%=personReadDTO.getDistrictPer()%>"><br><br>

    <label for="FlatPer">Flat</label>
    <input type="text" id="FlatPer" name="FlatPer" value="<%=personReadDTO.getFlatPer()%>"><br><br>

    <label for="HomePer">Home</label>
    <input type="text" id="HomePer" name="HomePer" value="<%=personReadDTO.getHomePer()%>"><br><br>

    <label for="LiveFromPer">LiveFrom</label>
    <input type="date" id="LiveFromPer" name="LiveFromPer" value="<%=personReadDTO.getLiveFromPer()%>"><br><br>

    <label for="RegionPer">Region</label>
    <input type="text" id="RegionPer" name="RegionPer" value="<%=personReadDTO.getRegionPer()%>"><br><br>

    <label for="StreetPer">Street</label>
    <input type="text" id="StreetPer" name="StreetPer" value="<%=personReadDTO.getStreetPer()%>"><br><br>

    <h3>Passport</h3>

    <label for="Expired">Expired</label>
    <input type="date" id="Expired" name="Expired" value="<%=personReadDTO.getExpired()%>"><br><br>

    <label for="Issued">Issued</label>
    <input type="date" id="Issued" name="Issued" value="<%=personReadDTO.getIssued()%>"><br><br>

    <label for="IssuedBy">Issued By</label>
    <input type="text" id="IssuedBy" name="IssuedBy" value="<%=personReadDTO.getIssuedBy()%>"><br><br>

    <label for="Number">Number</label>
    <input type="text" id="Number" name="Number" value="<%=personReadDTO.getNumber()%>"><br><br>

    <label for="Series">Series</label>
    <input type="text" id="Series" name="Series" value="<%=personReadDTO.getSeries()%>"><br><br>

    <h3>Temporary Address</h3>

    <label for="CityTemp">City</label>
    <input type="text" id="CityTemp" name="CityTemp" value="<%=personReadDTO.getCityTemp()%>"><br><br>

    <label for="CountryTemp">Country</label>
    <input type="text" id="CountryTemp" name="CountryTemp" value="<%=personReadDTO.getCountryTemp()%>"><br><br>

    <label for="DistrictTemp">District</label>
    <input type="text" id="DistrictTemp" name="DistrictTemp" value="<%=personReadDTO.getDistrictTemp()%>"><br><br>

    <label for="FlatTemp">Flat</label>
    <input type="text" id="FlatTemp" name="FlatTemp" value="<%=personReadDTO.getFlatTemp()%>"><br><br>

    <label for="HomeTemp">Home</label>
    <input type="text" id="HomeTemp" name="HomeTemp" value="<%=personReadDTO.getHomeTemp()%>"><br><br>

    <label for="LiveFromTemp">LiveFrom</label>
    <input type="date" id="LiveFromTemp" name="LiveFromTemp" value="<%=personReadDTO.getLiveFromTemp()%>"><br><br>

    <label for="LiveToTemp">LiveTo</label>
    <input type="date" id="LiveToTemp" name="LiveToTemp" value="<%=personReadDTO.getLiveToTemp()%>"><br><br>

    <label for="RegionTemp">Region</label>
    <input type="text" id="RegionTemp" name="RegionTemp" value="<%=personReadDTO.getRegionTemp()%>"><br><br>

    <label for="StreetTemp">Street</label>
    <input type="text" id="StreetTemp" name="StreetTemp" value="<%=personReadDTO.getStreetTemp()%>"><br><br>

    <h3>Phone</h3>
    <label for="PhoneNumber">Number</label>
    <input type="text" id="PhoneNumber" name="PhoneNumber" value="<%=personReadDTO.getPhoneNumber()%>"><br><br>

    <input type="submit" value="EDIT">
</form>
</body>
</html>
