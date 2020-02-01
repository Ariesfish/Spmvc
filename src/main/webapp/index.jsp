<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
    <a href="user/testParam?username=maurice">请求参数绑定</a>

    <!-- 封装数据，含有集合类 -->
    <form action="param/saveAccount" method="post">
        Name: <input type="text" name="username" /><br/>
        Password: <input type="text" name="password" /><br/>
        Money: <input type="text" name="money" /><br/>

        UserNameList: <input type="text" name="userList[0].name" /><br/>
        UserAgeList: <input type="text" name="userList[0].age" /><br/>

        UserNameMap: <input type="text" name="userMap['one'].name" /><br/>
        UserAgeMap: <input type="text" name="userMap['one'].age" /><br/>
        <input type="submit" value="提交"/><br/>
    </form>
</body>
</html>
