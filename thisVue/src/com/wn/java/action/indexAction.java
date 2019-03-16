package com.wn.java.action;

import java.util.List;

import javax.websocket.Session;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.wn.java.model.Oneself;
import com.wn.java.model.family;
import com.wn.java.util.PageHelper;


public class indexAction extends Controller{
	
	public Integer num=1;
	public static family  family1 = new family();
	public static PageHelper<family> pageHelper = new PageHelper<family>();
	/**
	 * 请求最后一部分以方法名来命名
	 */
	public void loginPage() {
	
		List<Oneself<family>> family = family1.findAll();
		
		String para = getPara("username");
		System.out.println(para);
		if(para!=null) {
			setSessionAttr("username", para);
		}
		//分页
		Integer pagenum=1;
		String para2 = getPara("nowPage");
		
		if(getPara("nowPage")==null) {
			
		}else {
			int parseInt = Integer.parseInt(para2);
			pagenum=parseInt;
		}
		String sessionAttr = (String)getSessionAttr("username");
		Page<Oneself<family>> paginate =null;
		if(sessionAttr!=null) {
			paginate = Oneself.dao1.paginate(pagenum, 3, "select *", "from family where familyname like ?","%"+sessionAttr+"%");
		}else {
			paginate = Oneself.dao1.paginate(pagenum, 3, "select *", "from family ");
		}
		
//		PageHelper<family> pageHelper = new PageHelper<family>(paginate.getTotalRow(), 3, pagenum);
		//获取总行数
		pageHelper.setTotal(paginate.getTotalRow());
		pageHelper.setPagenumber(3);
		//当前页码
		pageHelper.setLimit(pagenum);
		pageHelper.init(paginate.getTotalRow(), pagenum, 3);
		System.out.println("sdf"+pageHelper.getTotal()+"sdfds"+pageHelper.getLimit()+"sdfdssd"+pageHelper.getpagenumber());
		String navigateBar = pageHelper.getNavigateBar();
		setAttr("pageAll", paginate);
		setAttr("navigateBar", navigateBar);
		//转发
		render("index.jsp");
	}
	/**
	 * 使用AJAX实现
	 */
	public void ajaxloginPage() {
		System.out.println("来了");
		//转发
		String para = getPara("name");
		System.out.println(para);
		render("page1.jsp");
	}
	public static void main(String[] args) {
		System.out.println("fdsgsdr");
		System.out.println("dsfg");
		System.out.println("啦啦啦德玛西亚新的分支");
	}
}

