```
~/apache-tomcat-9.0.34/bin$   在tomcat里面的bin目录下输入
./shutdown.sh(关闭运行tomcat)
./startup.sh

cd ..到/apache-tomcat-9.0.34下
cd conf
ls
open web.xml(修改false改成true)
cd ..退回到tomcat下
（cd bin进入到bin目录，关闭之后重启tomcat服务器）
~/apache-tomcat-9.0.34/webapps/ROOT$ 进入到ROOT目录下，新建一个文件夹名叫zyf，
cd zyf
touch 1(在zyf文件夹下建单个文件)
echo "this is a file" > 1

(tomcat静态网页完成)

```

```
建maven项目

在根目录下
mkdir ea
cd ea
mkdir sample
cd sample
mvn archetype:generate
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 7: 10
Define value for property 'groupId': java/club/banyuan
Define value for property 'artifactId': servlet-sample
Define value for property 'version' 1.0-SNAPSHOT: 
Define value for property 'package' club/banyuan: : 
Confirm properties configuration:
groupId: club.banyuan
artifactId: servlet-sample
version: 1.0-SNAPSHOP:
package: club.banyuan
 Y: : y

ls 一下
tree

(图片下)

cd 到~/apache-tomcat-9.0.34/conf$   open tomcat-users.xml 
填下面三行
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<user username="admin" password="password" roles="manager-gui, manager-script"/>

在maven的setting.xml里要添加下面代码
<server>
  <id>TomcatServer</id>
  <username>admin</username>
  <password>password</password>
</server>

再回到~/ea/sample/servlet-sample$  mvn package

成功之后  mvn tomcat7:deploy

```