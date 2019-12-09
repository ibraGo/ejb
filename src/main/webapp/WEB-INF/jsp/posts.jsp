<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title> Annonces </title>
    <meta charset="utf-8">
</head>

<html>
<body>
    <table>
        <thead>
            <tr>
                <td>ID</td>
                <td>name</td>
                <td>type</td>
                <td>maxPerson</td>
                <td>price</td>
                <td>surface</td>
                <td>description</td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.id}</td>
                <td>${post.name}</td>
                <td>${post.type}</td>
                <td>${post.maxPerson}</td>
                <td>${post.price}</td>
                <td>${post.surface}</td>
                <td>${post.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>