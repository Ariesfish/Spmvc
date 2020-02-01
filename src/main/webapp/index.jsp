<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
    <a href="param/testServletAPI">Test Servlet API</a>
    <br>

    <!-- 自定义类型转换器 -->
    <form action="param/testRequestBody" method="post">
        Name: <input type="text" name="name" /><br/>
        Age: <input type="text" name="age" /><br/>
        Birthday: <input type="text" name="birthday" /><br/>
        <input type="submit" value="提交"/><br/>
    </form>

    <br>
    <a href="param/testPathVariable/10">Test Path Variable</a>

    <form action="param/testModeAttribute" method="post">
        Name: <input type="text" name="name" /><br/>
        Age: <input type="text" name="age" /><br/>
        <input type="submit" value="提交"/><br/>
    </form>

    <br>
    <a href="param/setSessionAttribute">Set Session Attribute</a>
    <br>
    <a href="param/getSessionAttribute">Get Session Attribute</a>
    <br>
    <a href="param/delSessionAttribute">Delete Session Attribute</a>
</body>
</html>
