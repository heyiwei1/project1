package com.wn.java.model;

import java.util.List;

import org.apache.catalina.LifecycleListener;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;





public class family extends Oneself<family>{
	
	//添加泛型对象
//	public static final family  dao1 = new family();
	
	//查询
	public List<Oneself<family>> findAll(){
		String sql = " select * from family where familyname=?";
		List<Oneself<family>> find = dao1.find(sql,"我家");
		return find;
	}
	//分页
	public List<Oneself<family>> pageAll(Integer start,Integer end,String select,String form){
		String sql = select+form;
		List<Oneself<family>> find = dao1.find(sql);
		return find;
	}
}
