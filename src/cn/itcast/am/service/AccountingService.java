package cn.itcast.am.service;
/*
 * service level class
 * receive data from last level
 * by calculate, transfer to dao level, operate database
 * use dao level class, position of class, create dao object
 */
import java.util.List;

import cn.itcast.am.dao.AccountingDao;
import cn.itcast.am.domain.Accounting;

public class AccountingService {
	private AccountingDao dao = new AccountingDao();
	/*
	 * def funtion, Query all accounting data
	 * return accounting object group
	 * */
	public List<Accounting> selectAll() {
		return dao.selectAll();
	}
	/*
	 * def function, conditional quary accounting
	 * use from controller, transfer 2 date string
	 * use dao function, transfer 2 date string
	 * get result list
	 * */
	public List<Accounting> select(String startDate, String endDate){
		return dao.select(startDate, endDate);
	}
	/*
	 * def funciton, add record
	 * use controller, transfer accounting object
	 * use dao function, transfer accounting object
	 */
	public void addRecord(Accounting ac) {
		dao.addRecord(ac);
	}
	public void editRecord(Accounting ac) {
		// TODO Auto-generated method stub
		//def function, edit
		//use
		dao.editRecord(ac);
	}
	/*
	 * def function, delete
	 * use from controller, primary key
	 * use dao
	 * */
	public void deleteRecord(int amid) {
		// TODO Auto-generated method stub
		dao.deleteRecord(amid);
	}
	
}
