<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Available Courses</title>
    <style>
        body { font-family: Arial; margin: 30px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        .reg-btn { background-color: #28a745; color: white; border: none; padding: 5px 10px; cursor: pointer; }
    </style>
</head>
<body>
    <h2>Welcome, ${userEmail}</h2>
    <h3>Available Courses</h3>

    <table>
        <tr>
            <th>ID</th>
            <th>Course Name</th>
            <th>Instructor</th>
            <th>Credits</th>
            <th>Action</th>
        </tr>
        <c:forEach var="course" items="${courseList}">
            <tr>
                <td>${course.course_id}</td>
                <td>${course.name}</td>
                <td>${course.instructor}</td>
                <td>${course.credits}</td>
                <td>
                    <form action="register/${course.course_id}" method="post">
                        <button type="submit" class="reg-btn">Register</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>