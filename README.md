# cdi-simpleTest
Repository with Java project where SolrServer class makes problem for CDI

Unit test (CDIArquillianTest) works only when SolrServer class is removed from SomeClass, otherwise bellow error is thrown:

INFO  [org.jboss.weld.Bootstrap] (Weld Thread Pool -- 1) WELD-000119: Not generating any bean definitions from projekt.my.cdi.test.SomeClass because of underlying class loading error: Type org.apache.solr.client.solrj.SolrServer from [Module "deployment.CDIArquillianTest.war:main" from Service Module Loader] not found.
...
Caused by: java.lang.NoClassDefFoundError: Lorg/apache/solr/client/solrj/SolrServer;

java.lang.RuntimeException: Could not inject members
	at org.jboss.arquillian.testenricher.cdi.CDIInjectionEnricher.injectClass(CDIInjectionEnricher.java:135)
	at org.jboss.arquillian.testenricher.cdi.CDIInjectionEnricher.enrich(CDIInjectionEnricher.java:78)
	at org.jboss.arquillian.test.impl.TestInstanceEnricher.enrich(TestInstanceEnricher.java:52)
...
	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:382)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:354)
	at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:112)
	at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:137)
	at java.lang.Thread.run(Thread.java:745)
Caused by: org.jboss.arquillian.test.spi.ArquillianProxyException: org.jboss.weld.exceptions.IllegalArgumentException : WELD-001408: Unsatisfied dependencies for type SomeClass with qualifiers @Default
  at injection point [BackedAnnotatedField] @Inject private projekt.my.cdi.test.CDIArquillianTest.someclass
  at projekt.my.cdi.test.CDIArquillianTest.someclass(CDIArquillianTest.java:0)
 [Proxied because : Original exception caused: class java.lang.ClassNotFoundException: org.jboss.weld.exceptions.IllegalArgumentException]
	at org.jboss.weld.manager.InjectionTargetFactoryImpl.createInjectionTarget(InjectionTargetFactoryImpl.java:81)
	at org.jboss.weld.manager.InjectionTargetFactoryImpl.createInjectionTarget(InjectionTargetFactoryImpl.java:69)
	at org.jboss.weld.manager.BeanManagerImpl.createInjectionTarget(BeanManagerImpl.java:1110)
	at org.jboss.weld.util.ForwardingBeanManager.createInjectionTarget(ForwardingBeanManager.java:201)
	at org.jboss.arquillian.testenricher.cdi.CDIInjectionEnricher.injectNonContextualInstance(CDIInjectionEnricher.java:143)
	at org.jboss.arquillian.testenricher.cdi.CDIInjectionEnricher.injectClass(CDIInjectionEnricher.java:125)
	... 115 more
Caused by: org.jboss.arquillian.test.spi.ArquillianProxyException: org.jboss.weld.exceptions.DeploymentException : WELD-001408: Unsatisfied dependencies for type SomeClass with qualifiers @Default
  at injection point [BackedAnnotatedField] @Inject private projekt.my.cdi.test.CDIArquillianTest.someclass
  at projekt.my.cdi.test.CDIArquillianTest.someclass(CDIArquillianTest.java:0)
 [Proxied because : Original exception caused: class java.lang.ClassNotFoundException: org.jboss.weld.exceptions.DeploymentException]
	at org.jboss.weld.bootstrap.Validator.validateInjectionPointForDeploymentProblems(Validator.java:359)
	at org.jboss.weld.bootstrap.Validator.validateInjectionPoint(Validator.java:281)
	at org.jboss.weld.bootstrap.Validator.validateProducer(Validator.java:417)
	at org.jboss.weld.injection.producer.InjectionTargetService.validateProducer(InjectionTargetService.java:36)
	at org.jboss.weld.manager.InjectionTargetFactoryImpl.validate(InjectionTargetFactoryImpl.java:135)
	at org.jboss.weld.manager.InjectionTargetFactoryImpl.createInjectionTarget(InjectionTargetFactoryImpl.java:79)
	... 120 more

