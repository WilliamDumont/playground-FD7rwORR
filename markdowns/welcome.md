# Java 9 - Implementing Services

# What is Service?



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


