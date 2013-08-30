package pageSpliter;

/*
 * 实现分页
 */

import java.sql.SQLException;
import java.util.ArrayList;

public class PageSpliter 
{
	private int pageSize;    //每页的记录数
	private ArrayList<Object> list;  //全部的记录
	private int itemCount;   //记录总数
	private int pageCount;   //页数
	private int headPage;    //首页编号
	private int tailPage;	 //尾页编号
	private int prevPage;	 //上一页编号
	private int nextPage;    //下一页编号
	private int[] press = new int[5];  //可显示的页码
	
	public PageSpliter(ArrayList<Object> list, int size) throws SQLException{		
		this.pageSize = size;
		this.list = list;
		this.itemCount = this.list.size();
		this.pageCount = itemCount/size + 1;
	}
	
	public ArrayList<Object> getPage(int page){
		if ( page > this.pageCount )
			page = this.pageCount;
		else if ( page <= 0 )
			page = 1;
		newPage(page);   //计算相关分页数据
		int start = (page - 1) * this.pageSize;  //目标项目的起始编号
		int end = (start + this.pageSize) > this.list.size()
		? this.list.size() : (start + pageSize); //目标项目的结束编号
		ArrayList<Object> subList = new ArrayList<Object>();
		for(int i = start; i < end; i++)
			subList.add(this.list.get(i));
		return subList;
		
	}
	
	private void newPage(int page){
		if ( this.itemCount > 0 ){
			this.headPage = 1;
			this.tailPage = this.pageCount;
			this.prevPage = page == 1 ? 0 : (page - 1);
			this.nextPage = page == this.pageCount ? 0 : (page + 1);
			int start = (page-1)/5 * 5 + 1;
			for(int i = 0; i < 5; i++, start++)
				this.press[i] = start > this.pageCount ? 0 : start;
		} else {
			this.headPage = 0;
			this.tailPage = 0;
			this.prevPage = 0;
			this.nextPage = 0;
			for(int i = 0; i < 5; i++)
				this.press[i] = 0;
		}
	}
}

