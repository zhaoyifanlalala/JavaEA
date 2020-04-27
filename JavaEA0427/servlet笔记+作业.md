## 作业1：笔记
LBS负载均衡

MQ 消息队列：webserver处理不了通过MQ发送给worker处理

静态页面的内容都是固定的

动态页面内容会变

URL冒号前面是Https或Http是协议，后面第一个斜线前面是IP，也可以是域；第二个斜线前面是PATH资源文件；在？后是参数，key和value是用&作为分隔符

Get和Post是请求方式，Get可以在浏览器地址栏中写，POST不可以
post是改变服务器状态的请求

Servlet 静态到动态之间的转变

URI用来标识资源

mvn archetype:generate 创建maven项目
mvn package  打包项目生成war文件
mvn tomcat7:deploy  部署项目

POM加入 servlet 依赖
```
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>4.0.1</version>
  <scope>provided</scope>
</dependency>
```
POM指定 JRE 版本
```
<plugin>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
	<source>11</source>
	<target>11</target>
    </configuration>
</plugin>
```
生成 war 文件

mvn package

在 target 目录下可以看到新生成的war文件

在Tomcat上部署配置 Tomcat 管理用户名和密码:conf/tomcat_users.xml
```
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<user username="admin" password="password" roles="manager-gui, manager-script"/>
```
启动或重启Tomcat
```
bin/shutdown.sh
bin/startup.sh
```
在Maven中配置Tomcat的用户名和密码
~/maven/.../settings.xml
```
<server>
  <id>TomcatServer</id>
  <username>admin</username>
  <password>password</password>
</server>
注意: username 和 password 需要和Tomcat的conf文件中配置保持一致
```

在项目的POM文件中配置Tomcat的插件
pom.xml
```
<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
	<url>http://localhost:8080/manager/text</url>
	<server>TomcatServer</server>
	<path>/myapp</path>
    </configuration>
</plugin>
```
```
<url> 配置Tomcat的管理地址,你只需要注意IP和端口号是否需要改变,其余不动
<server> 和Maven settings.xml 中配置的 <server> <id> 保持一致
<path> app 运行在Tomcat上的路径
```
在DD文件中(web.xml)配置servlet映射关系
```
<servlet>
    <servlet-name>my-1st-servlet</servlet-name>
    <servlet-class>club.banyuan.ServletDemo</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>my-1st-servlet</servlet-name>
    <url-pattern>/aaa</url-pattern>
</servlet-mapping>
```
部署或卸载应用
```
mvn tomcat7:deploy
mvn tomcat7:redeploy
mvn tomcat7:undeploy
```

## 作业2：访问一个网页时发生了什么？

浏览器首先去查询DNS(Domain Naming Service)服务器，DNS会将网址转化为IP地址，运行在TCP/IP协议上，所以要知道Web的IP地址。有IP地址就基于HTTP协议向远程的Web服务器发送请求了。浏览器会调用后端的一系列功能，并且组装出HTML页面，通过HTTP协议返回给浏览器，浏览器在渲染成页面，整个过程都是在TCP/IP协议上完成的。

## 作业3: 实现静态页面（见文件夹图片）
    
    
