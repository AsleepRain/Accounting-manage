package cn.itcast.am.controller;

import java.util.List;

import cn.itcast.am.domain.Accounting;
import cn.itcast.am.service.AccountingService;

public class AccountingController {
	private AccountingService service=new AccountingService();
	/*
	 * def funtion, Query all accounting data
	 * */
	public List<Accounting> selectAll() {
		return service.selectAll();		
	}
	/*
	 * def function, conditional quary accounting
	 * use from view layer, transfer two string
	 * use service function, transfer two strings
	 * return view
	 * */
	public List<Accounting> select(String startDate, String endDate){
		return service.select(startDate, endDate);
	}
	/*
	 * def function, add record
	 * use service function, transfer accounting object, get result set
	 * */
	public void addRecord(Accounting ac) {
		service.addRecord(ac);
	}
	//def function, edit record
	//use from view layer, transfer
	//use service, transfer 
	public void editRecord(Accounting ac) {
		service.editRecord(ac);
	}
	/*
	 * def function, delete
	 * use from view laryer
	 * use service
	 * */
	public void deleteRecord(int amid) {
		service.deleteRecord(amid);
	}
	

}
