javac -d /project/target/mods --module-source-path /project/target/src /project/target/src/com.gg.admin/module-info.java /project/target/src/com.gg.admin/com/gg/service/AdminService.java

javac -d /project/target/mods --module-source-path /project/target/src /project/target/src/com.gg.admin.client/module-info.java /project/target/src/com.gg.admin.client/com/gg/client/Client.java

javac -d /project/target/mods --module-source-path /project/target/src /project/target/src/com.gg.admin.impl/module-info.java /project/target/src/com.gg.admin.impl/com/gg/serviceimple/CarrierAdminServiceImpl.java

java --module-path mods --module com.gg.admin.client/com.gg.client.Client