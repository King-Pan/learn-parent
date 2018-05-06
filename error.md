```java
javax.servlet.ServletException: Circular view path [success]: would dispatch back to the current handler URL [/success] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
	at org.springframework.web.servlet.view.InternalResourceView.prepareForRendering(InternalResourceView.java:209) ~[spring-webmvc-5.0.5.RELEASE.jar:5.0.5.RELEASE]
	at org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:147) ~[spring-webmvc-5.0.5.RELEASE.jar:5.0.5.RELEASE]
	at org.springframework.web.servlet.view.AbstractView.render(AbstractView.java:314) ~[spring-webmvc-5.0.5.RELEASE.jar:5.0.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1325) ~[spring-webmvc-5.0.5.RELEASE.jar:5.0.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1069) ~[spring-webmvc-5.0.5.RELEASE.jar:5.0.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1008) ~[spring-webmvc-5.0.5.RELEASE.jar:5.0.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:925) ~[spring-webmvc-5.0.5.RELEASE.jar:5.0.5.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:974) ~[spring-webmvc-5.0.5.RELEASE.jar:5.0.5.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:866) ~[spring-webmvc-5.0.5.RELEASE.jar:5.0.5.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:635) ~[tomcat-embed-core-8.5.29.jar:8.5.29]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:851) ~[spring-webmvc-5.0.5.RELEASE.jar:5.0.5.RELEASE]
```