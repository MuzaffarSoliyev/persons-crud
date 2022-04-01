<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.03.2022
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>New person</h2>
    <h3>Personal data</h3>
    <form action="/insert" method="POST">
        <label for="BirthDate">Birth Date</label>
        <input type="date" id="BirthDate" name="BirthDate"><br><br>

        <label for="Name">Name</label>
        <input type="text" id="Name" name="Name"><br><br>

        <label for="Surname">Surname</label>
        <input type="text" id="Surname" name="Surname"><br><br>

        <h3>Permanent Address</h3>

        <label for="CityPer">City</label>
        <input type="text" id="CityPer" name="CityPer"><br><br>

        <label for="CountryPer">Country</label>
        <input type="text" id="CountryPer" name="CountryPer"><br><br>

        <label for="DistrictPer">District</label>
        <input type="text" id="DistrictPer" name="DistrictPer"><br><br>

        <label for="FlatPer">Flat</label>
        <input type="text" id="FlatPer" name="FlatPer"><br><br>

        <label for="HomePer">Home</label>
        <input type="text" id="HomePer" name="HomePer"><br><br>

        <label for="LiveFromPer">LiveFrom</label>
        <input type="date" id="LiveFromPer" name="LiveFromPer"><br><br>

        <label for="RegionPer">Region</label>
        <input type="text" id="RegionPer" name="RegionPer"><br><br>

        <label for="StreetPer">Street</label>
        <input type="text" id="StreetPer" name="StreetPer"><br><br>

        <h3>Passport</h3>

        <label for="Expired">Expired</label>
        <input type="date" id="Expired" name="Expired"><br><br>

        <label for="Issued">Issued</label>
        <input type="date" id="Issued" name="Issued"><br><br>

        <label for="IssuedBy">Issued By</label>
        <input type="text" id="IssuedBy" name="IssuedBy"><br><br>

        <label for="Number">Number</label>
        <input type="text" id="Number" name="Number"><br><br>

        <label for="Series">Series</label>
        <input type="text" id="Series" name="Series"><br><br>

        <h3>Temporary Address</h3>

        <label for="CityTemp">City</label>
        <input type="text" id="CityTemp" name="CityTemp"><br><br>

        <label for="CountryTemp">Country</label>
        <input type="text" id="CountryTemp" name="CountryTemp"><br><br>

        <label for="DistrictTemp">District</label>
        <input type="text" id="DistrictTemp" name="DistrictTemp"><br><br>

        <label for="FlatTemp">Flat</label>
        <input type="text" id="FlatTemp" name="FlatTemp"><br><br>

        <label for="HomeTemp">Home</label>
        <input type="text" id="HomeTemp" name="HomeTemp"><br><br>

        <label for="LiveFromTemp">LiveFrom</label>
        <input type="date" id="LiveFromTemp" name="LiveFromTemp"><br><br>

        <label for="LiveToTemp">LiveTo</label>
        <input type="date" id="LiveToTemp" name="LiveToTemp"><br><br>

        <label for="RegionTemp">Region</label>
        <input type="text" id="RegionTemp" name="RegionTemp"><br><br>

        <label for="StreetTemp">Street</label>
        <input type="text" id="StreetTemp" name="StreetTemp"><br><br>

        <h3>Phone</h3>
        <label for="PhoneNumber">Number</label>
        <input type="text" id="PhoneNumber" name="PhoneNumber"><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
