Windows PowerShell
Copyright (C) Microsoft Corporation. All rights reserved.

Install the latest PowerShell for new features and improvements! https://aka.ms/PSWindows

PS C:\Users\abdel\OneDrive\Bureau\examjee> mvn spring-boot:run
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< com.bellagnech:examjee >-----------------------
[INFO] Building examjee 0.0.1-SNAPSHOT
[INFO] from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] >>> spring-boot:3.4.5:run (default-cli) > test-compile @ examjee >>>
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ examjee ---
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] Copying 0 resource from src\main\resources to target\classes
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ examjee ---
[INFO] Nothing to compile - all classes are up to date.
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ examjee ---
[INFO] skip non existing resourceDirectory C:\Users\abdel\OneDrive\Bureau\examjee\src\test\resources
[INFO]
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ examjee ---
[INFO] Nothing to compile - all classes are up to date.
[INFO]
[INFO] <<< spring-boot:3.4.5:run (default-cli) < test-compile @ examjee <<<
[INFO]
[INFO]
[INFO] --- spring-boot:3.4.5:run (default-cli) @ examjee ---
[INFO] Attaching agents: []

. \_**\_ \_ ** \_ \_
/\\ / **_'_ ** \_ _(_)_ \_\_ \_\_ _ \ \ \ \
( ( )\_** | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/ \_**)| |_)| | | | | || (_| | ) ) ) )
' |\_**\_| .**|_| |_|_| |_\__, | / / / /
=========|_|==============|_\_\_/=/_/_/_/

:: Spring Boot :: (v3.4.5)

2025-05-19T10:26:30.013+01:00 INFO 29548 --- [examjee] [ restartedMain] c.bellagnech.examjee.ExamjeeApplication : Starting ExamjeeApplication using Java 23.0.1 with PID 29548 (C:\Users\abdel\OneDrive\Bureau\examjee\target\classes started by abdel in C:\Users\abdel\OneDrive\Bureau\examjee)
2025-05-19T10:26:30.013+01:00 INFO 29548 --- [examjee] [ restartedMain] c.bellagnech.examjee.ExamjeeApplication : The following 1 profile is active: "dev"
2025-05-19T10:26:30.063+01:00 INFO 29548 --- [examjee] [ restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2025-05-19T10:26:30.063+01:00 INFO 29548 --- [examjee] [ restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2025-05-19T10:26:30.571+01:00 INFO 29548 --- [examjee] [ restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2025-05-19T10:26:30.624+01:00 INFO 29548 --- [examjee] [ restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 50 ms. Found 6 JPA repository interfaces.
2025-05-19T10:26:31.007+01:00 INFO 29548 --- [examjee] [ restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer : Tomcat initialized with port 8080 (http)
2025-05-19T10:26:31.007+01:00 INFO 29548 --- [examjee] [ restartedMain] o.apache.catalina.core.StandardService : Starting service [Tomcat]
2025-05-19T10:26:31.007+01:00 INFO 29548 --- [examjee] [ restartedMain] o.apache.catalina.core.StandardEngine : Starting Servlet engine: [Apache Tomcat/10.1.40]
2025-05-19T10:26:31.058+01:00 INFO 29548 --- [examjee] [ restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/] : Initializing Spring embedded WebApplicationContext
2025-05-19T10:26:31.058+01:00 INFO 29548 --- [examjee] [ restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 995 ms
2025-05-19T10:26:31.174+01:00 INFO 29548 --- [examjee] [ restartedMain] o.hibernate.jpa.internal.util.LogHelper : HHH000204: Processing PersistenceUnitInfo [name: default]
2025-05-19T10:26:31.207+01:00 INFO 29548 --- [examjee] [ restartedMain] org.hibernate.Version : HHH000412: Hibernate ORM core version 6.6.13.Final
2025-05-19T10:26:31.228+01:00 INFO 29548 --- [examjee] [ restartedMain] o.h.c.internal.RegionFactoryInitiator : HHH000026: Second-level cache disabled
2025-05-19T10:26:31.390+01:00 INFO 29548 --- [examjee] [ restartedMain] o.s.o.j.p.SpringPersistenceUnitInfo : No LoadTimeWeaver setup: ignoring JPA class transformer
2025-05-19T10:26:31.412+01:00 INFO 29548 --- [examjee] [ restartedMain] com.zaxxer.hikari.HikariDataSource : HikariPool-1 - Starting...
2025-05-19T10:26:32.524+01:00 WARN 29548 --- [examjee] [ restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper : SQL Error: 0, SQLState: 08S01
2025-05-19T10:26:32.524+01:00 ERROR 29548 --- [examjee] [ restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper : Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
2025-05-19T10:26:32.524+01:00 WARN 29548 --- [examjee] [ restartedMain] o.h.e.j.e.i.JdbcEnvironmentInitiator : HHH000342: Could not obtain connection to query metadata

org.hibernate.exception.JDBCConnectionException: unable to obtain isolated JDBC connection [Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.] [n/a]
at org.hibernate.exception.internal.SQLStateConversionDelegate.convert(SQLStateConversionDelegate.java:100) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:94) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.resource.transaction.backend.jdbc.internal.JdbcIsolationDelegate.delegateWork(JdbcIsolationDelegate.java:116) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.getJdbcEnvironmentUsingJdbcMetadata(JdbcEnvironmentInitiator.java:320) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:129) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:81) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:130) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:263) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:238) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:215) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.boot.model.relational.Database.<init>(Database.java:45) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.getDatabase(InFlightMetadataCollectorImpl.java:226) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:194) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:171) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:1442) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1513) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:66) ~[spring-orm-6.2.6.jar:6.2.6]
at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:390) ~[spring-orm-6.2.6.jar:6.2.6]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:419) ~[spring-orm-6.2.6.jar:6.2.6]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:400) ~[spring-orm-6.2.6.jar:6.2.6]
at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:366) ~[spring-orm-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1865) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1814) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:607) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:529) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:339) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:371) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:337) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:207) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:970) ~[spring-context-6.2.6.jar:6.2.6]
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:627) ~[spring-context-6.2.6.jar:6.2.6]
at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.4.5.jar:3.4.5]
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:753) ~[spring-boot-3.4.5.jar:3.4.5]
at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-3.4.5.jar:3.4.5]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:318) ~[spring-boot-3.4.5.jar:3.4.5]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1362) ~[spring-boot-3.4.5.jar:3.4.5]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1351) ~[spring-boot-3.4.5.jar:3.4.5]
at com.bellagnech.examjee.ExamjeeApplication.main(ExamjeeApplication.java:10) ~[classes/:na]
at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50) ~[spring-boot-devtools-3.4.5.jar:3.4.5]
Caused by: com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
at com.mysql.cj.jdbc.exceptions.SQLError.createCommunicationsException(SQLError.java:165) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:55) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:837) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:420) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:238) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:180) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:137) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:360) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:202) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:461) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:550) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:98) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:111) ~[HikariCP-5.1.0.jar:na]
at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:126) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:467) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]  
 at org.hibernate.resource.transaction.backend.jdbc.internal.JdbcIsolationDelegate.delegateWork(JdbcIsolationDelegate.java:61) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
... 38 common frames omitted
Caused by: com.mysql.cj.exceptions.CJCommunicationsException: Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62) ~[na:na]
at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:501) ~[na:na]
at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:485) ~[na:na]
at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:52) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:95) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:140) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.exceptions.ExceptionFactory.createCommunicationsException(ExceptionFactory.java:156) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.protocol.a.NativeSocketConnection.connect(NativeSocketConnection.java:79) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.NativeSession.connect(NativeSession.java:142) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.ConnectionImpl.connectOneTryOnly(ConnectionImpl.java:961) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:825) ~[mysql-connector-j-9.1.0.jar:9.1.0]
... 51 common frames omitted
Caused by: java.net.ConnectException: Connection refused: getsockopt
at java.base/sun.nio.ch.Net.pollConnect(Native Method) ~[na:na]
at java.base/sun.nio.ch.Net.pollConnectNow(Net.java:682) ~[na:na]
at java.base/sun.nio.ch.NioSocketImpl.timedFinishConnect(NioSocketImpl.java:542) ~[na:na]
at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:592) ~[na:na]
at java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:327) ~[na:na]
at java.base/java.net.Socket.connect(Socket.java:760) ~[na:na]
at com.mysql.cj.protocol.StandardSocketFactory.connect(StandardSocketFactory.java:144) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.protocol.a.NativeSocketConnection.connect(NativeSocketConnection.java:53) ~[mysql-connector-j-9.1.0.jar:9.1.0]
... 54 common frames omitted

2025-05-19T10:26:32.542+01:00 WARN 29548 --- [examjee] [ restartedMain] org.hibernate.orm.deprecation : HHH90000025: MySQLDialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2025-05-19T10:26:32.551+01:00 INFO 29548 --- [examjee] [ restartedMain] org.hibernate.orm.connections.pooling : HHH10001005: Database info:
Database JDBC URL [Connecting through datasource 'HikariDataSource (null)']
Database driver: undefined/unknown
Database version: 8.0
Autocommit mode: undefined/unknown
Isolation level: undefined/unknown
Minimum pool size: undefined/unknown
Maximum pool size: undefined/unknown
2025-05-19T10:26:33.219+01:00 INFO 29548 --- [examjee] [ restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2025-05-19T10:26:33.235+01:00 INFO 29548 --- [examjee] [ restartedMain] com.zaxxer.hikari.HikariDataSource : HikariPool-1 - Starting...
2025-05-19T10:26:34.258+01:00 WARN 29548 --- [examjee] [ restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper : SQL Error: 0, SQLState: 08S01
2025-05-19T10:26:34.258+01:00 ERROR 29548 --- [examjee] [ restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper : Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
2025-05-19T10:26:34.258+01:00 ERROR 29548 --- [examjee] [ restartedMain] j.LocalContainerEntityManagerFactoryBean : Failed to initialize JPA EntityManagerFactory: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.exception.JDBCConnectionException: Unable to open JDBC Connection for DDL execution [Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.] [n/a]
2025-05-19T10:26:34.258+01:00 WARN 29548 --- [examjee] [ restartedMain] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.exception.JDBCConnectionException: Unable to open JDBC Connection for DDL execution [Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.] [n/a]
2025-05-19T10:26:34.269+01:00 INFO 29548 --- [examjee] [ restartedMain] o.apache.catalina.core.StandardService : Stopping service [Tomcat]
2025-05-19T10:26:34.277+01:00 INFO 29548 --- [examjee] [ restartedMain] .s.b.a.l.ConditionEvaluationReportLogger :

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2025-05-19T10:26:34.290+01:00 ERROR 29548 --- [examjee] [ restartedMain] o.s.boot.SpringApplication : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.exception.JDBCConnectionException: Unable to open JDBC Connection for DDL execution [Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.] [n/a]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1818) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:607) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:529) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:339) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:371) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:337) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:207) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:970) ~[spring-context-6.2.6.jar:6.2.6]
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:627) ~[spring-context-6.2.6.jar:6.2.6]
at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.4.5.jar:3.4.5]
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:753) ~[spring-boot-3.4.5.jar:3.4.5]
at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-3.4.5.jar:3.4.5]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:318) ~[spring-boot-3.4.5.jar:3.4.5]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1362) ~[spring-boot-3.4.5.jar:3.4.5]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1351) ~[spring-boot-3.4.5.jar:3.4.5]
at com.bellagnech.examjee.ExamjeeApplication.main(ExamjeeApplication.java:10) ~[classes/:na]
at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50) ~[spring-boot-devtools-3.4.5.jar:3.4.5]
Caused by: jakarta.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.exception.JDBCConnectionException: Unable to open JDBC Connection for DDL execution [Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.] [n/a]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:431) ~[spring-orm-6.2.6.jar:6.2.6]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:400) ~[spring-orm-6.2.6.jar:6.2.6]
at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:366) ~[spring-orm-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1865) ~[spring-beans-6.2.6.jar:6.2.6]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1814) ~[spring-beans-6.2.6.jar:6.2.6]
... 18 common frames omitted
Caused by: org.hibernate.exception.JDBCConnectionException: Unable to open JDBC Connection for DDL execution [Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.] [n/a]
at org.hibernate.exception.internal.SQLStateConversionDelegate.convert(SQLStateConversionDelegate.java:100) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:94) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:74) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]  
 at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:39) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]  
 at org.hibernate.tool.schema.internal.exec.ImprovedExtractionContextImpl.getJdbcConnection(ImprovedExtractionContextImpl.java:63) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.tool.schema.internal.exec.ImprovedExtractionContextImpl.getJdbcDatabaseMetaData(ImprovedExtractionContextImpl.java:70) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.tool.schema.extract.internal.InformationExtractorJdbcDatabaseMetaDataImpl.processTableResultSet(InformationExtractorJdbcDatabaseMetaDataImpl.java:65) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.tool.schema.extract.internal.AbstractInformationExtractorImpl.getTables(AbstractInformationExtractorImpl.java:570) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.getTablesInformation(DatabaseInformationImpl.java:122) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.tool.schema.internal.GroupedSchemaMigratorImpl.performTablesMigration(GroupedSchemaMigratorImpl.java:72) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.performMigration(AbstractSchemaMigrator.java:233) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.doMigration(AbstractSchemaMigrator.java:112) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:280) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:144) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at java.base/java.util.HashMap.forEach(HashMap.java:1430) ~[na:na]
at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:141) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:324) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:463) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1517) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:66) ~[spring-orm-6.2.6.jar:6.2.6]
at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:390) ~[spring-orm-6.2.6.jar:6.2.6]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:419) ~[spring-orm-6.2.6.jar:6.2.6]
... 22 common frames omitted
Caused by: com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
at com.mysql.cj.jdbc.exceptions.SQLError.createCommunicationsException(SQLError.java:165) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:55) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:837) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:420) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:238) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:180) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:137) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:360) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:202) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:461) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:550) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:98) ~[HikariCP-5.1.0.jar:na]
at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:111) ~[HikariCP-5.1.0.jar:na]
at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:126) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:467) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]  
 at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:46) ~[hibernate-core-6.6.13.Final.jar:6.6.13.Final]  
 ... 43 common frames omitted
Caused by: com.mysql.cj.exceptions.CJCommunicationsException: Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62) ~[na:na]
at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:501) ~[na:na]
at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:485) ~[na:na]
at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:52) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:95) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:140) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.exceptions.ExceptionFactory.createCommunicationsException(ExceptionFactory.java:156) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.protocol.a.NativeSocketConnection.connect(NativeSocketConnection.java:79) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.NativeSession.connect(NativeSession.java:142) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.ConnectionImpl.connectOneTryOnly(ConnectionImpl.java:961) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:825) ~[mysql-connector-j-9.1.0.jar:9.1.0]
... 56 common frames omitted
Caused by: java.net.ConnectException: Connection refused: getsockopt
at java.base/sun.nio.ch.Net.pollConnect(Native Method) ~[na:na]
at java.base/sun.nio.ch.Net.pollConnectNow(Net.java:682) ~[na:na]
at java.base/sun.nio.ch.NioSocketImpl.timedFinishConnect(NioSocketImpl.java:542) ~[na:na]
at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:592) ~[na:na]
at java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:327) ~[na:na]
at java.base/java.net.Socket.connect(Socket.java:760) ~[na:na]
at com.mysql.cj.protocol.StandardSocketFactory.connect(StandardSocketFactory.java:144) ~[mysql-connector-j-9.1.0.jar:9.1.0]
at com.mysql.cj.protocol.a.NativeSocketConnection.connect(NativeSocketConnection.java:53) ~[mysql-connector-j-9.1.0.jar:9.1.0]
... 59 common frames omitted

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 6.300 s
[INFO] Finished at: 2025-05-19T10:26:34+01:00
[INFO] ------------------------------------------------------------------------
PS C:\Users\abdel\OneDrive\Bureau\examjee>
