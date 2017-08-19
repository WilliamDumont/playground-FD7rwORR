package com.gg.service;
import java.util.ServiceLoader;
public interface AdminService {
	public void printServiceInfo();
	public static AdminService newInstance(){
		ServiceLoader<AdminService> service=ServiceLoader.load(AdminService.class);
		//service.forEach(s-> {return (FInterface)s;});
		for(AdminService inter:service){
			return inter;
		}
		return null;
		
	}
}