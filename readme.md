# iManager

JavaWeb 结课项目

一个简单的人员管理系统

+ ✅使用了 Google Authenticator 动态验证管理员信息更加的安全。
+ ✅对防Sql注入做了特别的处理
+ ✅支持使用Sqlite或MYSQL数据库 方便部署
+ ✅使用纯CSS样式框架Bulma.io

![img](./img/demo1.png)
![img](./img/demo2.png)
![img](./img/demo3.png)
![img](./img/demo4.png)

### 数据库
可以通过简单的配置jdbc.properties切换MYSQL/Sqlite数据库

若配置文件中MYSQL可以连接成功，否则使用MYSQL否则尝试Sqlite方式

使用Sqlite时默认位置"/Users/veve/Documents/iManager.db"

### Google Authenticator
默认密钥：ERDWUPHTAPEZHJY6

### 部署安装
+ 配置MYSQL数据库或者放置Sqlite数据库文件到对于位置
+ 生成 war 文件，然后部署到Tomcat服务器