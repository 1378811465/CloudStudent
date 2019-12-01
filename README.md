# CloudStudent
SpringCloud云服务学习<br/>
所用技术栈：<br/>
SpringCloud<br/>
服务注册中心：Eureka<br/>
负载均衡：Feign<br/>
集群<br/>
熔断：Hystrix<br/>
网关：Zuul<br/>
配置中心:Spring Config
<br/>
SpringBoot<br/>热部署<br/>1、pom.xml配置<br/><!—引入热部署依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency><br/><dependency>
    <groupId>org.springframework</groupId>
    <artifactId>springloaded</artifactId>
    <version>1.2.6.RELEASE</version>
</dependency><br/><br/>2、yml配置<br/>spring:<br/>  #热部署
devtools:
  restart:
    enabled: true
    additional-paths: src/main/java<br/><br/>3、IDEA配置<br/>3.1.Build project automatically<br/> <br/><br/>3.2.Shift+Ctrl+Alt+/->Registry->compiler.automake.allow.when.app.running<br/> <br/><br/>4、重启服务<br/>微服务<br/>概述<br/>微服务概念提出者：Martin Fowler（马丁·福勒）微服务的定义：微服务架构是一种架构模式或者说是一种架构风格，它提倡将单一应用程序分成一组小的服务,服务之间互相协调、互相配合，为用户提供最终价值。服务之间采用轻量级的通信机制互相沟通（通常是基于HTTP协议的RESTful API，也可以采用消息队列来通信，如RoocketMQ,Kafaka等）.每个服务都围绕着具体业务进行构建，并且能够被独立地部署到生产环境、类生产环境等。另外，应尽量避免统一的、集中式的服务管理机制，对具体的一个服务而言，应根据业务上下文，选择合适的语言、工具对其进行构建，可以有一个非常轻量级的集中式管理来协调这些服务，可以使用不同的语言来编写服务，也可以使用不同的数据存储。<br/><br/>前提知识+相关的说明<br/>1、SpringMVC+Spring/SpringBoot+Mybatisz+Maven+Git<br/>     尚硅谷视频教程<br/><br/>2、SpringCloud 是微服务分布式技术之合，约21种技术之多<br/>    只学最常用的，俗称Cloud技术的五大神兽<br/>服务注册中心（eureka、nacos、zookeeper）、Ribbon、feign、Hystrix断路器（熔断器）、zuul路由网关、分布式配置中心<br/><br/>开发模式的改变：<br/>单体架构：<br/>	最初是单体结构，所有东西一体化，一个工程，小工程比较适合（开发速度快，成本低），但大工程随着代码越来越多可读性、维护性越来越低，单体架构的应用并发能力十分有限，优化单体架构方式：<br/>单体应用进行集群部署，并增加负载均衡服务器，再来个缓存服务器和文件服务器，数据库再搞个读写分离。大量的业务必然会有大量的代码，代码可读性和可维护性依然很差。如果面对海量的用户，它的并发能力依然不够。基于以上单体架构系统的不足，提出了微服务架构。<br/>分布式架构：<br/>	专业的事情交给专业的人做<br/><br/>微服务技术栈：<br/>	服务开发		spring/springboot/springCloud<br/>	服务配置与管理	Netifix公司的Archaius、阿里的Diamond等<br/>	服务注册与发现	Eureka、Consul、Zookeeper等<br/>	服务调用		Rest、RPC、gRPC<br/>	服务熔断器		Hystrix、Envoy等<br/>	负载均衡		Ribbon、Nginx等<br/>	服务接口调用（客户端调用服务的简化工具）	Feign等<br/>	消息队列		Kafka、RabbitMQ、ActiveMQ<br/>	服务配置中心管理	SpringCloudConfig、Chef等<br/>	服务路由（API网关）	Zuul等<br/>	服务监控		Zabbix、Nagios、Mtrics、Spectator等<br/>	全链路追踪		Zipkin、Brave、Dapper等<br/>	服务部署		Docker、OpenStack、Kubernetes等<br/>	数据流操作开发包	SpringCloud Stream（封装与Redis、Rabit、Kafaka等发送接收消息）<br/>	事件消息总栈	SpringCloud Bus<br/>SpringCloud学习<br/>是什么<br/>SpringCloud,基于SpringBoot提供了一套微服务解决方案，包括服务注册与发现，配置中心，全链路监控，服务网关，负载均衡，熔断器等组件，除了基于NetFlix的开源组件做高度抽象封装之外，还有一些选型中立的开源组件。<br/><br/>SpirngCloud利用Spring Boot的开发便利性巧妙地简化了系统基础设施的开发，SpringCloud为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发信啊、断路器、路由、事件总线、全局锁、决策竞选、分布式会话等等，它们都可以用SpringBoot的开发风格做到一键启动和部署<br/><br/>SpringCloud并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考研的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留下了一套简单易懂、易部署和易维护的分布式系统开发工具包。<br/><br/>Spring Cloud是一个微服务框架的规范，注意，只是规范，他不是任何具体的框架。<br/><br/>简单来说，SpringCloud是分布式微服务架构下的一站式解决方案，是多种微服务架构技术的集合体，俗称微服务全家桶。<br/><br/><br/>常见面试问题：<br/><br/>Springboot 与 Spring Cloud是什么关系？<br/>1、SpringBoot专注于快速方便的开发单个个体微服务<br/>2、SpringCloud是关注全局的微服务协调整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，为各个微服务之间提供，配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等集成服务<br/>3、SpringBoot可以离开SpringCloud独立使用开发项目，但SpringCloud离不开SpringBoot，属于依赖关系（此还有另一种说法，SpringCloud是依赖于SpringBoot自动配置，如果可以将SpringBoot那些配置都拉出来单配置，SpringCloud是可以不用依赖于SpringBoot，需要实测）<br/>4、SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的微服务治理框架。<br/><br/>Durbbo与SpringCloud，为什么选后者？<br/>1、社区活跃度，SpringCloud远高于Dubbo<br/>2、包含技术组件不如SpringCloud完善，<br/>	     Dubbo                SpringCloud<br/>服务注册中心  Zookeeper          Netflix Eureka<br/>服务调用方式  RPC                REST API<br/>服务监控      Dubbo-monitor  	  Spring boot admin<br/>断路器        不完善              Netflix Hystrix<br/>服务网关      无                  Netflix Zuul<br/>分布式配置    无                  SpringCloud Config<br/>服务跟踪      无                  SpringCloud Sleuth<br/>消息总线      无                  SpringCloud Bus<br/>数据流        无                  SpringCloud Stream<br/>批量任务      无                  SpringCloud Task<br/>最大区别，SpringCloud抛弃了Dubbo的RPC,改用了HTTP的REST方式<br/><br/>能干什么<br/>24种技术组件都可以做<br/>从哪下<br/>官网：<br/>https://spring.io/projects/spring-cloud<br/><br/>参考书：<br/>中文文档：<br/>https://www.springcloud.cc/spring-cloud-dalston.html<br/>中国社区：<br/>http://springcloud.cn/<br/>中文网：<br/>https://www.springcloud.cc/<br/>怎么使用<br/>学习SpringCloud集合的多种技术使用<br/>Rest微服务构建<br/>利用技术：springMvc+mybatis+mysql<br/>以部门模块做一个微服务通用案例，<br/>开发步骤<br/>1、通过maven建一个父项目<br/>2、在父项目下建子项目 Consumer(消费者)与Provider提供者(Server)（消费者通过Rest调用提供者提供的服务）<br/>3、创建公共的API子项目（用于存放公共的API/接口/公共配置）<br/>4、编码，在消费者提供的Controlle层 通过RestTemplate调用提供者的接口<br/>（消费者创建RestTemplate时，是通过@Configuration注解 类似Spring里面的applicationContext.xml写入的注入Bean）<br/> <br/>Maven<br/>工程项目提供者：<br/>约定>配置>编码  业务项目代码<br/><br/>工程项目消费者：<br/>约定>配置>编码<br/>1、pom<br/>2、建@Configuration注解的bean （spring 注解配置版的applicationContext.xml）<br/>	@Bean RestTemplate<br/>3、写Controller  访问提供者的接口<br/>4、通过url访问消费者的Controller接口，测试消费者与提供者的连接<br/>Eureka<br/>是什么<br/>Eureka是netflix的一个子模块，也是核心模块之一，Eureka是一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移。服务注册与发现对于微服务架构来说是非常重要的，有了服务发现和注册，只需要使用服务的标识符，就可以访问到服务，而不需要修改服务，而不需要修改服务调用的配置文件了，功能类似于dubbo的注册中心，比如zookeeper。<br/><br/>(Netflix在设计Eureka时遵守AP原则)<br/>原理：<br/>Eureka的基本架构：<br/>Eureka采用了C-S的设计架构，Eureka Server作为服务注册功能的服务器，它是服务注册中心。<br/>而系统中的其它微服务，使用Eureka的客户端链接到Eureka Server并维持心跳连接。这样系统的维护人员就可以通过Eureka Server来监控系统中各个微服务是否正常运行。SpringCloud的一些其他模块（比如Zuul）就可以通过Eureka Server来发现系统中的其他微服务，并执行相关的逻辑。<br/>Eureka与Dubbo架构对比<br/><br/>Eureka架构图<br/> <br/><br/>Dubbo架构图：<br/> <br/><br/>Eureka包含两大组件：Eureka Server和Eureka Client<br/>Eureka Server 提供服务注册服务<br/>各个节点启动后，会在EurekaServer中进行注册，这样EurekaServer中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观的看到<br/><br/>Eureka Client 是一个JAVA客户端，用于简化Eureka Server的交互，客户端同时也具备一个内置的、使用轮询（round-robin）负载算法的负载均衡器，在应用启动后，将会向Eureka Server发送心跳（默认周期为30秒），如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，EurekaServer 将会从服务注册表中把这个服务节点移除（默认90秒）<br/><br/>Eureka的三大角色：<br/>Eureka server提供服务注册和发现<br/>Service Provider服务提供方将自身服务注册到Eureka，从而使服务消费方能够找到。<br/>Service Consumer服务消费方从Eureka获取注册服务列表，从而能够消费服务。<br/><br/>Eureka构建步骤<br/>EurekaServer构建<br/>1、新建子项目（kng-eureka-server-7001）来配置EurekaServer<br/>如果需要引入cloud的一个新技术组件<br/>基本上有三步：<br/>1.1、新增一个相关maven坐标（pom.xml）<br/>1.2、yml或者properties配置文件配置<br/>1.3、在主启动类上面、标注的启动该新组件奇数的相关注解标签<br/>例：@EnableEurekaServer<br/><br/>2、配置pom.xml<br/>引入Eureka服务端的依赖<br/><!-- Eureka服务端 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency><br/><br/>3、配置yml或这properties(这里是yml)<br/>eureka:
  instance:
    hostname: localhost
  client:
    fetch-registry: false #是否拉取其它服务的信息，默认是TRUE
    register-with-eureka: false #是否注册自己的信息到EurekaServer，默认是true
    service-url:  # EurekaServer的地址，现在是自己的地址，如果是集群，需要加上其它Server的地址
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka<br/><br/>4、在主启动类标注启动该组件技术的相关注解<br/>@EnableEurekaServer（启动EurekaServer的注解）<br/> <br/><br/>5、测试<br/>启动应用，访问运行的ip加上server.port的端口号，进行访问<br/>如果可以看到下面的页面，则配置成功<br/>访问http://localhost:7001<br/> <br/>EurekaClient构建<br/>1、新建微服务项目<br/>新建子项目king-providerProject-8081（提供者）<br/>新建子项目king-consumerProject-80（消费者）<br/><br/>2、构建Pom.xml<br/><!-- Eureka客户端(用于将此微服务注册进Eureka) -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency><br/><!--标配-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency><br/><br/><br/>3、配置yml或者propertities（这里是yml）<br/>eureka:
  instance:
    prefer-ip-address: true #当调用getHostname获取实例的hostname时，返回ip而不是host名称
    ip-address: localhost #指定自己的IP信息，不指定的话会自己寻找
    instance-id: providerProject8081
  client:
    service-url: #EurekaServer地址
      defaultZone: http://localhost:7001/eureka<br/><br/>4、配置启动类<br/>添加注解@EnableEurekaClient 标注本微服务是Eureka客户端，启动之后通过配置自动注册进EurekaServer服务<br/> <br/>5、测试<br/>启动EurekaServer，再启动提供者微服务，然后访问<br/>http://localhot:7001 <br/>如果可以看到以下页面，则注册成功<br/> <br/><br/>注册的Application 下面的名字 是Eureka客户端的spring.application.name下的名字<br/><br/>Actuator与注册服务信息完善<br/>主机名称与服务名称的修改<br/>Yml配置<br/>eureka:
  instance: 
    instance-id: providerProject8081 #指定自己入住eureka服务的实例别名<br/><br/>效果：<br/> <br/><br/>访问信息有IP信息提示<br/>不修改所展示的内容<br/> <br/><br/>修改EurekaClient微服务yml<br/><br/><br/>eureka:
  instance:
    prefer-ip-address: true #当调用getHostname获取实例的hostname时，返回ip而不是host名称,并且在EurekaServer页面上放在链接处访问路经可以显示IP地址
    instance-id: providerProject8081 #指定自己入住eureka服务的实例别名<br/><br/>修改后所展示的内容<br/> <br/><br/>微服务Info内容的详细信息配置<br/>未配置前，超链点击进去是如下效果：<br/> <br/><br/>开始配置：<br/>1、Eureka Client微服务引入以下依赖 Pom配置<br/><!-- actuator监控信息完善(Eureka info 必须添加的)(主管监控与信息配置) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency><br/><br/>2、父项目pom配置<br/><build>
    <finalName>cloudStudent</finalName>
    <!--定义识别配置的路径-->
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <!--访问过滤开启-->
            <filtering>true</filtering>
        </resource>
    </resources>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-resources-plugin</artifactId>
            <configuration>
                <!-- 找到resource下和$相对应的 灵活配置 进一步解读，比较像依赖注入 -->
                <delimiters>
                    <delimit>$</delimit>
                </delimiters>
            </configuration>
        </plugin>
    </plugins>
</build><br/><br/>3、修改Eureka Client微服务的yml文件<br/>info:
  app.name: providerProject
  company.name: king-wenge
  build.artifactId: $project.artifactId$
  build.version: $project.version$<br/><br/>Eureka自我保护机制<br/>保护机制问题图：<br/> <br/><br/>什么是自我保护机制：<br/>默认情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例（默认90秒）。但是当网络分区故障发生时，微服务与EurekaServer之间无法正常通信，以上行为可能变得非常危险了——因为微服务本身其实是说健康的，此时本不应该注销这个微服务。Eureka通过“自我保护模式” 来借鉴这个问题——当EurekaServer节点在短时间内丢失过多客户端时（可能发生了网络分区故障），那么这个节点就会进入自我保护模式。一旦进入该模式，EurekaServer就会保护服务注册表中的信息，不再删除服务注册表中的数据（也就是不会注销任何微服务）。当网络故障恢复后，该Eureka Server 节点会自动退出自我保护模式。<br/><br/>在自我保护模式中，EurekaServer会保护服务注册表中的信息，不再注销任何服务实例。当它收到的心跳数重新恢复到阈值以上时，该Eureka Server节点就会自动退出自我保护模式。它的设计哲学就是宁可保留错误的服务注册西你想，也不盲目注销任何可能健康的服务实例。一句话讲解：好死不如赖活着<br/><br/>简单点说就是：某时刻某一个微服务不可用了，eureka不会立刻清理，依旧会对该微服务的信息进行保存<br/><br/>综上，自我保护模式是一种应对网络异常的安全保护措施。它的架构哲学是宁可同时保留所有微服务(健康与不健康的微服务都会保留),也不盲目注销任何健康的微服务。使用自我保护模式，可以让Eureka集群更加的健壮、稳定。<br/><br/>在SpringCloud中，可以使用eureka.server.enable-self-preservation = false 禁用自我保护模式<br/><br/>服务发现<br/>对于注册进微服务Eureka里面的服务，可以通过服务发现来获得该服务的信息<br/><br/>使用方法：<br/>在提供者的Controller<br/>调用Discovery的接口<br/>@Autowired<br/>private DiscoveryClient client<br/> <br/>写以下这个方法接口，获取Eureka所有的实例，并打印出来<br/>@RequestMapping(value = "/provider/discovery", method = RequestMethod.GET)
public Object discovery(){
    List<String> list = client.getServices();
    System.out.println("*****" + list);
    List<ServiceInstance> serverList = client.getInstances("providerProject");
    for(ServiceInstance instance : serverList){
        System.out.println(
                instance.getServiceId() + "\t" +
                instance.getHost() + "\t" +
                instance.getPort() + "\t" +
                instance.getUri());
    }
    return client;
}<br/><br/><br/>2、主启动类添加服务发现的注解<br/>@EnableDiscoveryClient<br/> <br/><br/>3、自测<br/>重启之后输入地址<br/>http://localhost:8081/provider/discovery<br/>如果可以在页面看到如下页面<br/> <br/>并可以在控制台看到如下数据<br/> <br/><br/>则服务发现自测成功<br/><br/>4、搭建消费者服务发现<br/>在Controller下写以下方法调用提供者的服务发现<br/>@RequestMapping(value = "/consumers/discovery", method = RequestMethod.GET)
public Object discovery(){
    return restTemplate.getForObject(URL + "/provider/discovery", Object.class);
}<br/><br/>访问http://localhost/consumers/discovery<br/>出现以下页面，则成功<br/> <br/>集群配置<br/>集群是什么<br/>集群（cluster）技术是一种较新的技术，通过集群技术，可以在付出较低成本的情况下获得在性能、可靠性、灵活性方面的相对较高的收益，其任务调度则是集群系统中的核心技术。<br/>集群是一组相互独立的、通过高速网络互联的计算机，它们构成了一个组，并以单一系统的模式加以管理。一个客户与集群相互作用时，集群像是一个独立的服务器。集群配置是用于提高可用性和可缩放性。<br/><br/>简而言之：集群是指在不同服务器里配置相同的服务对外做一个超大运算的整体。例如淘宝入口只有一个，但内部却有很多服务<br/><br/>集群搭建<br/>新建多个EurekaServer微服务<br/> <br/>配置pom.xml<br/>同上文所说的eureka服务配置<br/>修改主启动类<br/> <br/>修改映射配置<br/>4.1、找到C:\Windows\System32\drivers\etc下的hosts文件<br/>4.2、修改映射配置添加进hosts文件<br/> <br/>配置多台eurekaServer的Yml文件（实现集群）<br/> <br/><br/>配置提供者微服务，注册进集群所有的eurekaServer微服务<br/> <br/>测试<br/>出现如下页面，则已搭配成功：<br/>集群第一个eurekaServer测试：<br/> <br/>集群第二个eurekaServer测试：<br/><br/> <br/><br/><br/>Eureka 比 Zookeeper 好在哪<br/>eureka 遵守AP<br/>zookeeper 遵守CP<br/><br/>CAP分别是什么<br/>C:Consistency强一致性、<br/>A:Availability可用性、<br/>P:Partition分区容错性<br/><br/>传统ACID分别是什么<br/>A:Atomicity 原子性<br/>C:Consistency 一致性<br/>I:Isolation 独立性<br/>D:Durability 持久性<br/><br/>负载均衡<br/>LB, 既负载均衡，在微服务或分布式集群中经常用的一种应用。<br/>负载均就简单的说就是将用户的请求平摊的分配到多个服务上，从而达到系统的HA，常见的负载均衡有软件Nginx，LVS,硬件F5等。<br/>相应的在中间件，例如Dubbo和SpringCloud中均提供了负载均衡，SpringCloud的负载均衡算法可以自定义。<br/><br/>负载均衡（Load Balance 简称LB）分为<br/>集中式（LB)  偏硬件 <br/>定义：在服务的消费方和提供方之间使用独立的LB设施可以是硬件，如F5，也可以是软件，如nginx)，由该设施负责把访问请求通过某种策略转发至服务的提供方；<br/>进程内（LB)  偏软件<br/>定义：将LB逻辑集成到消费方，消费方从服务注册中心获知有哪些地址可用，然后自己再从这些地址中选择出一个合适的服务器。<br/><br/>Ribbon<br/>是什么<br/>Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具<br/>它基于Netflix Ribbon实现。通过Spring Cloud的封装，可以让我们轻松地将面向服务的REST模版请求自动转换成客户端负载均衡的服务调用。Spring Cloud Ribbon虽然只是一个工具类框架，它不像服务注册中心、配置中心、API网关那样需要独立部署，但是它几乎存在于每一个Spring Cloud构建的微服务和基础设施中。因为微服务间的调用，API网关的请求转发等内容，实际上都是通过Ribbon来实现的，包括后续我们将要介绍的Feign，它也是基于Ribbon实现的工具。所以，对Spring Cloud Ribbon的理解和使用，对于我们使用Spring Cloud来构建微服务非常重要。<br/><br/><br/>能干嘛<br/>Ribbon就属于进程内LB,它只是一个类库，集成于消费方进程，消费方可以通过它来获取到服务提供方的地址。<br/><br/>配置Ribbon 通过注册中心访问集群微服务提供者<br/>三步走：<br/>引入所需maven依赖<br/>由于Ribbon是客户端的负载均衡工具，肯定配置在eureka的客户端，目前选消费者80的微服务<br/><!-- Ribbon相关 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-ribbon</artifactId>
</dependency><br/><br/>修改yml<br/>eureka:
  instance:
    prefer-ip-address: true # 当其它服务获取地址时提供ip而不是hostname
    ip-address: localhost # 指定自己的ip信息，不指定的话会自己寻找
  client:
    register-with-eureka: false
    service-url: #EurekaServer集群所有地址
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka<br/><br/>RestTemplate配置位置加上自动启动自动负载均衡<br/>加上@LoadBalanced<br/> <br/>配置消费者Controller，通过服务注册中心去访问提供者<br/>//微服务应用名，可以从服务注册中心多个集群服务实现负载均衡区访问最适合的微服务
private static final String URL = "http://providerProject";<br/>参考例子：<br/> <br/>主启动类配置<br/>@EnableEurekaClient<br/><br/>测试<br/>启动多个eureka服务<br/>启动提供者8081服务<br/>启动消费者80服务<br/>访问 http://localhost/consumers/test<br/>出现以下页面则配置成功<br/> <br/>****重要说明****<br/>如果服务注册中心有多个服务提供者Ribbon默认会通过轮询算法进行访问提供者<br/><br/>总结：<br/>Ribbon其实就是一个客户端负载均衡的组件，它可以和其他所需请求的客户端结合，和Eureka结合只是其中一个实例。<br/><br/>Ribbon在工作时分成两步：<br/>第一步：先选择eurekaServer，它优先选择在同一个区域内负载较少的server<br/>第二步：再根据用户指定的策略，在从server取到的服务注册列表中选择一个地址。<br/>其中Ribbon提供了多种策略：比如轮询、随机和根据响应时间加权等。<br/>自定义Ribbon算法<br/>Ribbon核心组件Irule<br/>意义：根据特定算法中从服务列表选取一个最优访问的服务<br/>算法：<br/>RoundRobinRule 轮询<br/>RandomRule	随机<br/>AvailabiltyFilteringRule	会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的链接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问<br/>RetryRule算法：<br/>先按照轮询算法的策略获取服务，如果获取服务失败在指定时间重试，获取可用的服务<br/>等等。。。<br/><br/>配置：<br/>在使用Ribbon的项目中 有@Configuration的配置类中，加入以下内容<br/>@Bean
public IRule myRule() {
    //return new RoundRobinRule();//轮询算法
    return new RandomRule();//随机算法
}<br/>例：<br/> <br/><br/>测试：<br/>重启消费者服务<br/>访问 http://localhost/consumers/test<br/>成功展示：<br/>获取的服务是随机的则就成功<br/><br/>自定义配置算法类<br/>第一步在Ribbon微服务的启动类配置注解<br/>@RibbonClient(name = "PROVIDERPROJECT",configuration = MySelfRule.class)<br/><br/>第二步，创建算法类<br/> <br/>第三步，将Ribbo源码算法数据复制到新建的算法类<br/><br/>第四步，根据新需求改动算法<br/><br/>第五步，MySelfRule调用新建的自定义算法类<br/> <br/>第六步，测试<br/><br/>****注意使用细节****<br/>MySelfRule配置类不能放在配置注解启动类此包及子包下面<br/>因为SpringbootApplication包含@ ComponentScan扫描包的注解，会将MyselfRule配置类给所有Ribbon使用，无法达到特制化的效果<br/>Feign<br/>是什么<br/>Feign是Netflix开发的声明式、模板化的HTTP客户端， Feign可以帮助我们更快捷、优雅地调用HTTP API。<br/><br/>Feign是一个声明式WebService客户端.使用Feign能让编写WebService客户端更加简单,它的使用方法是定义一个接口,然后在上面添加注解,同时也支持JAX-RS标准的注解.Feign也支持可拔插式的编码器和解码器.Spring Cloud对Feign进行了封装,使其支持了Spring MVC标准注解和HttpMessageConverters.Feign可以与Eureka和Ribbon组合使用以支持负载均衡.<br/><br/>能干什么<br/>Feign旨在使编写Java Htpp客户端变得更容易.<br/>使用Ribbon+RestTemplate时,利用RestTemplate对http请求的封装处理,形成了一套模板化的调用方法.但是在实际开发中,由于对服务依赖的调用可能不止一处,往往一个接口会被多处调用,所以通常都会针对每个微服务自行封装一些客户端类来包装这些依赖服务的调用.所以,Feign在此基础上做了进一步封装,由他来帮助我们定义和实现依赖服务接口的定义.在Feign的实现下,我们只需要创建一个接口并使用注解的方式来配置它(以前是Dao接口上标注Mapper注解,现在是一个微服务接口上面标注一个Feign注解即可),即可完成对服务提供方的接口绑定,简化了使用Spring cloud Ribbon时,自动封装服务调用客户端的开发量<br/>Feign集成了Ribbon<br/>利用Ribbon维护了PROVIDERPROJECT,并且通过轮询实现了客户端的负载均衡，而与Ribbon不同的是，通过Feign只需要定义服务绑定接口且以声明式的方法，优雅而简单的实现了服务调用。<br/>怎么使用<br/>新建king-consumersProject-feign<br/>配置和80服务的一样的配置<br/>引入feign所需依赖<br/><!-- Fegin相关 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency><br/><br/>修改启动类配置<br/> <br/>修改public-api配置	<br/>1).引入feign依赖<br/><!-- Fegin相关 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency><br/><br/>2）新建接口StudentClientService<br/>/*Feign根据细粒化，通过服务注册中心，通过服务名选择此服务名多个服务里适当的微服务进行访问*/
@FeignClient(value = "PROVIDERPROJECT")
public interface StudentClientService {
    @GetMapping("/provider/test")
    public String test();

    @RequestMapping(value = "/ provider/discovery", method = RequestMethod.GET)
    public Object discovery();
}<br/> <br/><br/>king-consumersProject-feign服务的Controller调用StudentClientService<br/>@RestController
public class ConsumersController {
    @Resource
    StudentClientService service;

    @GetMapping("/consumers/test")
    public String test(){
        return service.test();
    }

    @RequestMapping(value = "/consumers/discovery", method = RequestMethod.GET)
    public Object discovery(){
        return service.discovery();
    }
}<br/><br/>配置启动类<br/>@EnableFeignClients(basePackages = {"cn.gxw.publicApi"})//参数是公共项目的包
@ComponentScan("cn.gxw.publicApi")<br/><br/> <br/><br/>测试<br/>1）首先启动服务注册中心<br/>2）启动服务提供方法<br/>3）启动Feign消费方法<br/><br/>熔断器 Hystrix<br/>是什么<br/>Hystrix从Netflix API团队于2011年开始的弹性工程工作演变而来。在分布式环境中，许多服务依赖项中的一些不可避免地会失败。Hystrix是一个用于处理分布式系统的延迟和容错的开源库，Hystrix能够保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。<br/><br/><br/>能干什么<br/>“断路器”本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控(类似熔断保险丝)，向调用放返回一个符合预期的、可处理的预选响应（FallBack），而不是长时间的等待或者抛出调用方无法处理的异常，这样就保证了服务调用方得线程不会被长时间，不必要的占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩。<br/><br/>配置Hystrix熔断器<br/>新建king-provider-hystrix-8001项目<br/>配置和8081原班就绪<br/>在项目pom引入hystrix依赖<br/><!--熔断器Hystrix-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency><br/><br/>新建StudentClientServiceFallBack类并实现FallBack<br/> <br/>在公共Public-api项目新建config包，再新建FallBackConfig配置类<br/> <br/> <br/>在StudentClient的Feign注解增加熔断<br/> <br/>在启动类启动Hystrix熔断器<br/>启动项目 测试<br/>开启集群服务注册中心<br/>开启提供者8001<br/>开启fegin消费者项目	<br/>访问<br/>Http://localhost/consumer/test<br/><br/>正常在故意关闭fegin项目再访问，可以正常进入熔断，则配置成功<br/><br/>例：<br/> <br/><br/>服务监控hystrixDashboard<br/>是什么<br/>除了隔离依赖服务的调用以外，Hystrix还提供了准实时的调用监控（Hystrix Dashboard），Hystrix会持续地记录所有通过Hystrix发起的请求的执行信息，并以统计报表和图形的形式展示给用户，包括每秒执行多少请求多少成功，多少失败等。Netflix通过hystrix-metrics-event-stream项目实现了对以上指标的监控，Spring Cloud也提供了Hystrix Dashboard的整合，对监控内容转化成可视化界面。<br/><br/>配置HystrixDashboard<br/>新建king-consumersProject-hystrix-dashboard<br/><br/>配置POM<br/><!--熔断器Hystrix和hystrix dashboard相关-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency><br/><br/>配置YML<br/>server:
  port: 9001<br/><br/>配置主启动类<br/> <br/>所有提供者服务都需要监控依赖配置<br/><!-- actuator监控信息完善(Eureka info 必须添加的)(主管监控与信息配置) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency><br/><br/>启动、测试<br/><br/>第一部分：<br/>启动dashboard监听项目<br/><br/>输入http://localhost:900/hystrix 访问以下界面则成功<br/> <br/><br/>第二部分：<br/><br/>启动eureka集群<br/>启动8001提供者<br/><br/>测试<br/>输入http://localhost:8001/turbine /turbine.stream <br/>或者 <br/>http://localhost:8001/hystrix.stream 出现以下界面则成功<br/><br/><br/>如果访问失败404 这可能由于不能默认访问到/hystrix.stream <br/>解决办法：<br/>1、在项目中增加配置类，再重新访问即可成功<br/>@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}<br/>2、配置yml<br/>#解决http://localhost:8081/actuator/hystrix.stream无法访问的问题<br/>management:<br/>  endpoints:<br/>    web:<br/>      exposure:<br/>        include: "*"<br/><br/><br/>网关<br/>Zuul<br/>是什么<br/>微服务场景下，每一个微服务对外暴露了一组细粒度的服务。客户端的请求可能会涉及到一串的服务调用，如果将这些微服务都暴露给客户端，那么会增加客户端代码的复杂度。<br/><br/>参考GOF设计模式中的Facade模式，将细粒度的服务组合起来提供一个粗粒度的服务，所有请求都导入一个统一的入口，那么整个服务只需要暴露一个api，对外屏蔽了服务端的实现细节，也减少了客户端与服务器的网络调用次数。这就是api gateway。<br/>有了api gateway之后，一些与业务关系并不大的通用处理逻辑可以从api gateway中剥离出来，api gateway仅仅负责服务的编排与结果的组装。<br/><br/>Spring Cloud Netflix的Zuul组件可以做反向代理的功能，通过路由寻址将请求转发到后端的粗粒度服务上，并做一些通用的逻辑处理。<br/><br/>能干什么<br/>Zuul包含了对请求得路由和过滤两个最主要得功能：<br/>其中路由功能负责将外部请求转发到具体得微服务实例上，是实现外部访问统一入口得基础而过滤功能则负责对请求得处理过程进行干预，是实现请求校验、服务聚合等功能得基础Zuul和Eureka进行整合，将Zuul自身注册为Eureka服务治理下的应用，同时从Eureka中获得其他微服务的消息，也即以后的访问微服务都是通过Zuul通过Zuul跳转后获得。<br/><br/>Zuul可以通过加载动态过滤机制，从而实现以下各项功能：<br/><br/>验证与安全保障: 识别面向各类资源的验证要求并拒绝那些与要求不符的请求。<br/><br/>审查与监控: 在边缘位置追踪有意义数据及统计结果，从而为我们带来准确的生产状态结论。<br/><br/>动态路由: 以动态方式根据需要将请求路由至不同后端集群处。<br/><br/>压力测试: 逐渐增加指向集群的负载流量，从而计算性能水平。<br/><br/>负载分配: 为每一种负载类型分配对应容量，并弃用超出限定值的请求。<br/><br/>静态响应处理: 在边缘位置直接建立部分响应，从而避免其流入内部集群。<br/><br/>多区域弹性: 跨越AWS区域进行请求路由，旨在实现ELB使用多样化并保证边缘位置与使用者尽可能接近。<br/><br/>注意：Zuul服务最终还是会注册进Eureka<br/><br/><br/>提供=代理+路由+过滤三大功能<br/><br/>Zuul配置<br/>新建king-zuul-gatway-9527微服务项目<br/><br/>引入Pom依赖<br/><br/><!--Eureka客户端相关-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<!--网关zuul相关-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency><br/><br/>配置YML<br/>server:
  port: 9527

spring:
  application:
    name:  project-zuul-gatway #应用名称
  main:
    allow-bean-definition-overriding: true #当遇到同样名字的时候，是否允许覆盖注册
  #热部署
  devtools:
    restart:
      enabled: true
      additional-paths: src/main/java
      #exclude: static/**,public/**
  #关闭缓存。及时刷新
  thymeleaf:
    cache: false
<br/>#网关Zuul配置
zuul:
  routes:
    PROVIDERPROJECT: #对应注册中心的服务名称 （最好一致）
      serviceId: PROVIDERPROJECT #注册中心的服务名称
      path: /king/**
  ignored-services: PROVIDERPROJECT  #所要忽略服务
  prefix: /api  #访问前缀

eureka:
  instance:
    prefer-ip-address: true #当调用getHostname获取实例的hostname时，返回ip而不是host名称,并且在EurekaServer页面上放在链接处访问路经可以显示IP地址
    ip-address: localhost #指定自己的IP信息，不指定的话会自己寻找
    instance-id: myZuul9527.com #指定自己入住eureka服务的实例别名
  client:
    service-url: #EurekaServer地址
      #单机环境
      #defaultZone: http://localhost:7001/eureka
      #集群环境 注册多个eurekaServer微服务中
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/

info:
  app.name: providerProject
  company.name: king-wenge
  build.artifactId: $project.artifactId$
  build.version: $project.version$<br/><br/><br/>配置Host域名映射<br/><br/>修改C:\Windows\System32\drivers\etc下的hosts文件<br/>添加以下内容<br/> <br/><br/>配置主启动类<br/>@SpringBootApplication
@EnableEurekaClient //开启EurekaClient功能
@EnableZuulProxy    //开启Zuul
public class ZuulProjectApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulProjectApplication9527.class);
    }
}<br/><br/>出现问题解决<br/>问题1 ：运行springcloud，提示bean被覆盖了，错误日志如下：<br/>解决方案：在application.yaml配置如下，但是这不是主要原因。在配置正确后报了第二个错误。<br/>#其中allow-bean-definition-overriding是解决问题的关键。<br/>server:<br/>  port: 9001<br/>spring:<br/>  application: ad-gateway<br/>  main:<br/>allow-bean-definition-overriding: true #当遇到同样名字的时候，是否允许覆盖注册<br/><br/><br/>问题2：spring-boot-autoconfigure/2.1.3.RELEASE找不到servlet方法，错误日志如下：<br/>解决方案：
查看spring cloud官方文档，发现spring boot版本和spring cloud版本不一致导致的上述两个问题。官方文档版本匹配如下：<br/>因此修改父pom文件的版本即可，代码如下：<br/><properties><br/>		<spring-cloud.version>Greenwich.RELEASE</spring-cloud.version><br/>	</properties><br/><br/>启动、测试<br/>启动eureka集群<br/>启动服务提供者8001<br/>启动路由9527<br/><br/>测试：<br/>输入： http://zuul9527.com:9527/king/provider/test 出现以下界面则配置成功<br/> <br/><br/>配置中心<br/>分布式面临的问题：<br/>微服务意味着要将单体应用中的业务拆分成一个个子服务，每个服务的粒度相对较小，因此系统中会出现大量的服务，由于每个服务都需要必要的配置信息(application.yml)才能运行，所以一套集中式的、动态的配置管理设置是必不可少的。SpringCloud提供了ConfigServers来解决问题，我们每一个微服务自己带着一个application.yml，上百个配置文件的管理。<br/>Spring Config<br/>是什么<br/>spring Cloud Config为分布式系统中的外部配置提供服务器和客户端支持。方便部署与运维。
分客户端、服务端。
服务端也称分布式配置中心，是一个独立的微服务应用，用来连接配置服务器并为客户端提供获取配置信息，加密/解密信息等访问接口。
客户端则是通过指定配置中心来管理应用资源，以及与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息。默认采用 git，并且可以通过 git 客户端工具来方便管理和访问配置内容。<br/><br/>

