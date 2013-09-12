<html>
<body>
    <h3>Welcome <%= System.getProperty("user.name") %></h3>
    <h2>SriLankan Citizen's NIC Interpreter</h2>
    <form action="results.jsp" method="get">
        NIC Number: <input type="text" name="nic">
        <input type="submit" name="submit">
    </form>
</body>
</html>
