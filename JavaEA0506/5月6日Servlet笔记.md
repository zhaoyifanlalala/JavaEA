### public InputStream getResourceAsStream(String path);

path必须以/开始，相对于Context root路径，即从webapp开始

### sendRedirect(Stirng location)

location

相对路径，不一/开头，和当前servlet同级

绝对路径，以/开头，和相对于servletContext的root目录开始

network-path，以//开头，作为URL跳转

### public RequestDispathcher getRequestDispatcher(String path);

path，相对路径不以/ 开头，Context路径，以/开头。尽量用Context路径。以后Spring用的就是这种。

`ServletContext`在Spring中被修正为`ApplicationContext`。作用是连接Servlet和Container以及web app的其他部分。

### web app初始化：

* Container读取DD（web.xml）内容
* Container创建ServletContext的实例
* Container讲context初始化参数传递给ServletContext
* Servlet和JSP作为web app的一部分，可以访问ServletContext

### Linstener监听器

ServletContextListener,监听上下文

ServletContextAttributeListener,监听属性

Attribute放的就是名字内容，name-value，通过name可以获得value值。

Servlet不是线程安全的，Context Attribute是线程安全的么？

不是线程安全的。

### Filter 拦截器

Filter放在servlet的前面，类似于过滤条件，拦截器可以有多个，按照顺序调用，按照顺序返回，指定顺序要在web.xml里配置，web.xml的顺序就是拦截器的顺序

@WebFilter(urlPatterns={"/operator"})意思是要为operator拦截信息。拦截器最后一行`chain.doFilter(request,respones)`传送到下一个拦截器，如果是最后一个拦截器，进入对应Servlet。

一般一个Filter只处理一个方向不会来回两个方向都过滤。

FilterChain本质上就是List，链表

### Spring初识

在start.spring.io的网站可以生成一个项目，添加spring web依赖，做最简项目。用odea直接打开即可。

控制器只需要在前面加注解`@Controller`，`@RequetMapping("/hello")`，类似于Servlet的名字，通过名字找到Controller，`@GetMapping`，以get方式接收。`@ResponseBody` ，类似于HTTPResponse~。最后方法里return信息即可。