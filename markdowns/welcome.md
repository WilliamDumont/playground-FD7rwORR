# Java 9 - Implementing Services

# What is Service?

A specific functionality provided by the library is known as service. Let us consider an example to describe in detail, we can have different libraries providing a number check service , which can check whether the given number is valid or not , odd or even , etc., Applications and library providing an implementations for a service are called as service providers. Applications using this service are called as service consumers or clients.

In Java, a service is defined by a set of interfaces and classes. The service contains an interface or an abstract class that defines the functionality provided by the service.

There are multiple implementations for a service and they are called as service providers. The client using this service will not have any contact with the implementations. This can be achieved by using the below concept.

The ServiceLoader\<S> class (java.util) in JDK is responsible for discovering and loading all the service providers at a runtime for a service interface of type S. The ServiceLoader class allows decoupling between the providers and consumers. The consumer which is client knows only about the service interface. The service loader will instantiate all the service providers that are implementing the service and makes it available to the consumer to use.

![Service Concept Diagram](Servicesample.PNG)


This architecture follows plugin mechanism in which the service providers can be added or removed without affecting the service interface and the consumers.


# Discovering Service:

The java.util.ServiceLoader class is used to discover and load all the service providers.The module which discover and load all the service providers should contain the uses statement in module descriptor file.

<B> uses \<service-interface> </B>

In our example, we have the service “AdminService” which is the service interface loads and discovers the service providers.

``` java
module com.gg.admin{
	exports com.gg.service;
	 uses com.gg.service.AdminService;
}

```
The service coding is described below ,
``` java
package com.gg.service;

import java.util.ServiceLoader;

public interface AdminService {
	
	public void printServiceInfo();
	
	public static AdminService newInstance(){
		ServiceLoader<AdminService> service=ServiceLoader.load(AdminService.class);
		for(AdminService inter:service){
			return inter;
		}
		return null;
		
	}
}
```

# Service Provider:

The module which provide the implementation for the service interface should contain provides statement in module descriptor file. If the module doesn’t have the provides statement in the module descriptor file, the service loader will not load that module. The provides statement is used to indicate the service loader, that “I’m providing the implementation for the service”.

 <B> provides \<service-interface> with \<service-implementation> </B>

``` java

 module com.gg.admin.impl{
	 requires transitive com.gg.admin;
	 provides com.gg.service.AdminService with com.gg.serviceimpl.CarrierAdminServiceImpl;
}



```

The sample implemenatation class is provided below,

``` java
package com.gg.serviceimpl;

import com.gg.service.AdminService;

public class CarrierAdminServiceImpl implements AdminService{
	
	public CarrierAdminServiceImpl(){
	}
	public void printServiceInfo(){
		System.out.println("CarrierAdminServiceImpl Implementation");
	}
	
}

```
# Rules for Service Providers:

1.	It must be a public concrete class. It cannot be an inner class or an abstract class.
2.	It should have no-argument constructor. The ServiceLoader class uses this constructor to instantiate the service provider using reflection.
3.	An instance of the implementation class must be compatible with the service interface.

In above sample, we have created only one service providers.In real time , we can have n number of providers who are providing the implementations for a service.

# Service Consumer (Client)
The below diagram explains the class diagram design of our example.
![Service Concept Diagram](serviceexample.PNG)

@[Service ]({"stubs": ["src/com.gg.admin.client/com/gg/client/Client.java"], "command": "/bin/bash run.sh"})

The above examples describe the service implemenation in Java 9.


