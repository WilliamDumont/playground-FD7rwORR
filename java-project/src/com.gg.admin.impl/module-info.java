 module com.gg.admin.impl{
	 requires transitive com.gg.service;
	 exports com.gg.serviceimpl;
	provides com.gg.service.AdminService with com.gg.serviceimpl.CarrierAdminServiceImpl;
}