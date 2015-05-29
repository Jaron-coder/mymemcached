# memcached 与Spring整合 Simple Spring Memcached

#Introduction
Distributed caching can be a big, hairy, intricate, and complex proposition when using it extensively.Simple-Spring-Memcached (SSM) attempts to simplify implementation for several basic use cases.
This project enables caching in Spring-managed beans, by using Java 5 Annotations and Spring/AspectJ AOP on top of the spymemcached, xmemcached or Amazon ElastiCache Cluster Client for Java.Using Simple-Spring-Memcached requires only a little bit of configuration and the addition of some specific annotations on the methods whose output or input is being cached.

#Dependencies
The first thing you'll need, of course, is at least one running Memcached server. (Installation and usage instructions may be found on the memcached project page.)
sIn addition to the Simple-Spring-Memcached JAR files, the following libraries must be accessible (if maven is used you can skip it because all libraries will be included automatically):

1. Spring is an assumed dependency, and this project was built against the 3.0.7.RELEASE version. A Spring library that is 3.0.7.RELEASE compatible must included be on the classpath. For spring-cache module Spring 3.1.3.RELEASE is required.
2. Two AspectJ libraries are also required, and this project was built against the 1.6.8 versions. These libraries may have version dependencies with your Spring version, so you are free to add whatever versions are necessary to the classpath.
3. This project uses Simple Logging Facade for Java (SLF4J), and is built against SLF4J, though you are welcome to provide any other implementation.
