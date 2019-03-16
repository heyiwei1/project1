package com.wn.java.util;

import java.util.List;

public class PageHelper<T> {
	private List<T> list;//对象记录结果集，没有使用
	private Integer total = 0;//保存总记录行数
	private Integer startrownumber = 1;//取记录的开始行
	private Integer limit = 4;//每页显示记录数 数据库行数
	private Integer pages = 1;//保存总页数
	private Integer pagenumber = 1;//当前页码
	
	private boolean isFirstPage = false; //是否为第一页
	private boolean isLastPage = false;//是否为最后一夜
	private boolean hasPreviousPage = false;//是否有前一页
	private boolean hasNextPage = false; //是否有下一页
	
	private Integer navigatePages = 5;//页码导航条显示的页码数
	private Integer[] navigatepagenumbers;//保存页码编号的数组
	public PageHelper() {
		
	}
	public PageHelper(Integer total, Integer pagenumber) {
		init(total, pagenumber, limit);
	}
	 //当  new 对象的时候会调用init 进行必要的计算 
	public PageHelper(Integer total, Integer limit, Integer pagenumber) {
		init(total, pagenumber, limit);
	}
	//计算了启始记录位置，总页数 ，生成了导航条页面的数组，生成了导航条页面有没有前一页后一页等标志   total总条数 pagenumber当前页数
	public void init(Integer total, Integer pagenumber, Integer limit) {
		this.total=total;
        this.limit=limit;
        this.pagenumber = pagenumber;
      //计算了启始记录位置，总页数
        this.startrownumber = (this.pagenumber - 1)* limit;
        this.pages = (this.total - 1)/ this.limit + 1 ;
      //设置当前页，如果当前页小于1就设为1，大于最大页面就设为最大页码，否则就不变
        if(pagenumber < 1) {
        	this.pagenumber = 1;
        }else if(pagenumber > this.pages) {
        	this.pagenumber = this.pages;
        }else {
        	this.pagenumber = pagenumber;
        }
        //计算导航条页码的数组
        calcNavigatepagenumbers();
         
        //前一页下一页标志的设定
        judgePageBoudary();
	}
	//计算导航条码页的数组
	private void calcNavigatepagenumbers(){
		//当总页数小于navigatePages时候就建一个总页数大小的数组，并初始化数组为1到总页数
		if(pages <= navigatePages) {
			navigatepagenumbers = new Integer[pages];
			for(int i = 0 ; i < pages; i ++) {
				navigatepagenumbers[i] = i + 1;
			}
			//否则建一个navigatePages大小的数组，假设当前页pagenumber 是5
	        // 将    startNum 设置为 pagenumber-navigatePages/2 等于 1
	        // 将    endNum  设置为    pagenumber+navigatePages/2 等于9
	        // 
		}else {
			navigatepagenumbers=new Integer[navigatePages];
			int startNum=pagenumber-navigatePages/2;
            int endNum=pagenumber+navigatePages/2;
          //如果startNum 小于1 就赋值为1 然后就生成1到navigatePages的数组
            if(startNum < 1) {
            	startNum = 1;
            	for(int i = 0 ; i < navigatePages ; i ++) {
            		navigatepagenumbers[i] = startNum++;
            	}
            	 //如果   endNum 大于总页数 endNum设置为总页数
                //将数组设置为从endnum开始递减7次后的8个元素的数组
            }else if (endNum > pages) {
            	endNum = pages;
            	for(int i = navigatePages - 1; i >= 0; i--) {
            		 navigatepagenumbers[i]=endNum--;
            	}
            	//否则将数组设置为startNum 开始递增7次的8个元素的数组
            }else {
            	for(int i=0;i<navigatePages;i++){
                    navigatepagenumbers[i]=startNum++;
                }
            }
		}
	}
	 public String getNavigateBar(){
	    	
	    	String result = "<ul class='pagination' >";
	    	//如果不是第一页就加一个到第一页的链接 符号用<<
	    	if (!isFirstPage)
	    	{	
	    		result += " <li><a href='loginPage?nowPage=1'>&laquo</a></li> ";
	    	}
	        //如果有前一页就加一个到前一页的链接 符号用 <  链接的参数就是当前页减一
	    	if (hasPreviousPage)
	    	{	
	    		result += "<li><a href='loginPage?nowPage=" + ( pagenumber - 1)+"'>上一页</a></li>" ;
	    	}
	    	
	        for(int i=0;i<navigatepagenumbers.length;i++){
	        	if (pagenumber == navigatepagenumbers[i])
	        	{
	                result +=  "<li class='active'><a  href='loginPage?nowPage=" + (navigatepagenumbers[i]) +"'>"   + navigatepagenumbers[i]  + "</a></li>";
	                
	        	}
	        	else
	        	{
	                result +=  "<li><a  href ='loginPage?nowPage=" + (navigatepagenumbers[i] ) +"' >" + navigatepagenumbers[i] + "</a></li>" ;
	        	}
	        }
	        
	    	if (hasNextPage)
	    	{	
	    		result +=  "<li><a  href ='loginPage?nowPage=" + ( pagenumber + 1) +"' >下一页</a></li>" ;
	    	}
	    	
	    	if (!isLastPage)
	    	{	
	    		result += "<li><a href='loginPage?nowPage=" +pages+"'>&raquo</a></li>" ;
	    	}        
	        
	        result += "</ul>";
	        return result;
	    }    
	    
	    /**
	     * 判定页面边界
	     */
	    private void judgePageBoudary(){
	        isFirstPage = pagenumber == 1;
	        isLastPage = pagenumber == pages && pagenumber!=1;
	        hasPreviousPage = pagenumber!=1;
	        hasNextPage = pagenumber!=pages;
	    }
	     
	     
	    public void setList(List<T> list) {
	        this.list = list;
	    }
	 
	    /**
	     * 得到当前页的内容
	     * @return {List}
	     */
	    public List<T> getList() {
	        return list;
	    }
	 
	    /**
	     * 得到记录总数
	     * @return {int}
	     */
	    public int getTotal() {
	        return total;
	    }
	 
	    /**
	     * 得到每页显示多少条记录
	     * @return {int}
	     */
	    public int getLimit() {
	        return limit;
	    }
	 
	    /**
	     * 得到页面总数
	     * @return {int}
	     */
	    public int getPages() {
	        return pages;
	    }
	 
	    /**
	     * 得到当前页号
	     * @return {int}
	     */
	    public int getpagenumber() {
	        return pagenumber;
	    }
	 
	 
	    /**
	     * 得到所有导航页号 
	     * @return {int[]}
	     */
	    public Integer[] getNavigatepagenumbers() {
	        return navigatepagenumbers;
	    }
	 
	    public boolean isFirstPage() {
	        return isFirstPage;
	    }
	 
	    public boolean isLastPage() {
	        return isLastPage;
	    }
	 
	    public boolean hasPreviousPage() {
	        return hasPreviousPage;
	    }
	 
	    public boolean hasNextPage() {
	        return hasNextPage;
	    }
	    
	    
	    
	 
	    public int getStartrownumber() {
			return startrownumber;
		}

		public void setStartrownumber(int startrownumber) {
			this.startrownumber = startrownumber;
		}

		public String toString(){
	        String str=new String();
	        str= "[" +
	            "total="+total+
	            ",pages="+pages+
	            ",pagenumber="+pagenumber+
	            ",limit="+limit+
	            //",navigatePages="+navigatePages+
	            ",isFirstPage="+isFirstPage+
	            ",isLastPage="+isLastPage+
	            ",hasPreviousPage="+hasPreviousPage+
	            ",hasNextPage="+hasNextPage+
	            ",navigatepagenumbers=";
	        int len=navigatepagenumbers.length;
	        if(len>0)str+=(navigatepagenumbers[0]);
	        for(int i=1;i<len;i++){
	            str+=(" "+navigatepagenumbers[i]);
	        }
	        //sb+=",list="+list;
	        str+="]";
	        return str;
	    }
		public Integer getPagenumber() {
			return pagenumber;
		}
		public void setPagenumber(Integer pagenumber) {
			this.pagenumber = pagenumber;
		}
		public boolean isHasPreviousPage() {
			return hasPreviousPage;
		}
		public void setHasPreviousPage(boolean hasPreviousPage) {
			this.hasPreviousPage = hasPreviousPage;
		}
		public boolean isHasNextPage() {
			return hasNextPage;
		}
		public void setHasNextPage(boolean hasNextPage) {
			this.hasNextPage = hasNextPage;
		}
		public Integer getNavigatePages() {
			return navigatePages;
		}
		public void setNavigatePages(Integer navigatePages) {
			this.navigatePages = navigatePages;
		}
		public void setTotal(Integer total) {
			this.total = total;
		}
		public void setStartrownumber(Integer startrownumber) {
			this.startrownumber = startrownumber;
		}
		public void setLimit(Integer limit) {
			this.limit = limit;
		}
		public void setPages(Integer pages) {
			this.pages = pages;
		}
		public void setFirstPage(boolean isFirstPage) {
			this.isFirstPage = isFirstPage;
		}
		public void setLastPage(boolean isLastPage) {
			this.isLastPage = isLastPage;
		}
		public void setNavigatepagenumbers(Integer[] navigatepagenumbers) {
			this.navigatepagenumbers = navigatepagenumbers;
		}
		
	    
}
