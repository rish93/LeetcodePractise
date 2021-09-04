
SpringCloud:



The coordination of distributed systems leads to hot plate models and
 the use of Spring Cloud developers can quickly configure
  the services and applications
 that implement these models. They will perform
 well in any distributed environment,
  including the developer's laptop, core data
   centers, and managed platforms like Cloud Foundry.

Characteristics

Distributed / versioned configuration
Registration and discovery of the service.
Routing
Service to call service
Load balancing
Circuit breakers
Global locks
Choice of direction and status of the cluster.
Distributed messaging


Advantage:

Discovery service
JVM and non-JVM services can register with the service registry and easily discover other services available in the ecosystem.
Distributed configuration
Centralized external configuration management is compatible with a git repository. Configuration resources are directly assigned to Spring Environment but can be used by non-Spring applications if they wish.
Client-side load balancing: Load balancing improves the distribution of workloads across multiple departments. Spring Cloud provides Ribbon, a client-side load balancer that communicates with the service registry and facilitates load balancing.
Circuit breaker: The circuit breaker provides a graceful degradation of functionality when a method call to a service fails. Using the circuit breaker model can allow a microservice to continue operating in the event of an associated service outage, preventing the outage from cascading and allowing time for the outage to recover. Spring Cloud provides Hystrix, which is an implementation of the circuit breaker model.
Routing: Spring Cloud Gateway is a programmable router based on Project Reactor.
Tracking log: Spring Cloud provides Zepkin and Sleuth, which can be used for record mapping and tracking. This is very useful in a real production environment for in-depth problem-solving.
Security: Spring Cloud supports OAuth2 server and resource service using certain annotations. Authorization and authentication can be easily implemented with these libraries.


Consul for Lookup/ Discovery
Apache as a reverse proxy to route calls to the appropriate SCS.
Ribbon for client-side Load Balancing.


<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-consul-discovery</artifactId>
		</dependency>
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-consul-all</artifactId>
		</dependency>

properties
management.endpoints.web.exposure.include=*
spring.sleuth.sampler.percentage=1.0
spring.application.name=catalog
spring.cloud.consul.host=consul
spring.cloud.consul.port=8500
spring.cloud.consul.discovery.preferIpAddress=true
spring.cloud.consul.discovery.instanceId=${spring.application.name}:${spring.application.instance_id:${random.value}}
server.port=8080
logging.level.org.springframework.boot.actuate.trace.WebRequestTraceFilter: TRACE
spring.zipkin.enabled=false
spring.cloud.refresh.refreshable=none


