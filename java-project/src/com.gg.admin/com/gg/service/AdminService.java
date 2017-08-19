package com.gg.service;
import java.util.ServiceLoader;
public interface AdminService {
	public void printServiceInfo();
	public static FInterface newInstance(){
		ServiceLoader<FInterface> service=ServiceLoader.load(FInterface.class);
		//service.forEach(s-> {return (FInterface)s;});
		for(FInterface inter:service){
			return inter;
		}
		return null;
		
	}
}