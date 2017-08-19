package com.gg.client;
import com.gg.service.AdminService;
/**
by Gowtham Girithar Srirangasamy
This class is client which is consuming the implemenation of a Admin Service.
**/
public class Client {
	public static void main(String[] args){
		
		AdminService adminservice=AdminService.newInstance();
		adminservice.printServiceInfo();
	}
	
	
}
