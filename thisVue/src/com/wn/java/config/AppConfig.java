package com.wn.java.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.wn.java.model.family;

public class AppConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants constant) {
		//开启开发者模式
		constant.setDevMode(false);
		//配置视图
		constant.setViewType(ViewType.JSP);
		
	}

	@Override
	public void configEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configInterceptor(Interceptors interceptor) {
		// TODO Auto-generated method stub
		
	}
	
	//配置德鲁伊连接池插件
	@Override
	public void configPlugin(Plugins plugin) {
		//只能在classpath中读取properties文件
			loadPropertyFile( "druid.properties" );
			
			String url = getProperty("url");
			String user = getProperty("user");
			String password = getProperty("password");
			DruidPlugin dp = new DruidPlugin(url, user, password);
					
			plugin.add(dp);
			//ActiveRecordPlugin用于映射用户的model与Dao
			ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
			//mysql模型
			arp.setDialect( new MysqlDialect() );
			
			plugin.add(arp);
			
			//表，模型
			arp.addMapping("family", family.class);
		
	}

	@Override
	public void configRoute(Routes route) {
		//路由配置
		route.add("/index", com.wn.java.action.indexAction.class, "/WEB-INF/page");
	}

}
