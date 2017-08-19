 module com.gg.admin.impl{
	 requires transitive com.gg.admin;
	// exports com.gg.serviceimpl;
	provides com.gg.service.AdminService with com.gg.serviceimpl.CarrierAdminServiceImpl;
}
