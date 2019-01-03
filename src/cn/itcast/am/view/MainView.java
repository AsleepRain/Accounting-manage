package cn.itcast.am.view;
/*
 * view level
 * transfer data to controller level
 * create controller object
 * */


import java.util.List;
import java.util.Scanner;

import cn.itcast.am.controller.AccountingController;
import cn.itcast.am.domain.Accounting;

public class MainView {
	private AccountingController controller = new AccountingController();
    /*
     * realize user view
     * receive input of user
     * by data, use difference function
     */
	public void run() {
		Scanner input=new Scanner(System.in);
		while(true) {
			System.out.println("--------Accounting Management Application--------");
			System.out.println("1.Add Record 2.Edit Record 3.Delete Record 4.Ask Record 5.Exit");
			System.out.println("Enter funtion number [1-5]");	
			//receive selection
			int choose = input.nextInt();
			//swtich function
			switch(choose) {
			case 1: //add
				addRecord();
				break;
			case 2://edit
				editRecord();
				break;
			case 3://delete
				deleteRecord();
				break;
			case 4://ask
				askRecord();
				break;
			case 5://exit
				System.out.println("Bye");
				System.exit(0);
			}
		}		
	}
	//def askRecord()
	//show two ways to ask
	public void askRecord() {
		System.out.println("1.Query All 2.Conditional Query");
		Scanner input = new Scanner(System.in);
		int askchoose=input.nextInt();
		//base user selection, use difference funtion
		switch(askchoose) {
		case 1://select all
			selectall();
			break;
		case 2://conditional quary
			select();
			break;
		}
	}
	/*
	 * def funtion, realize select all
	 * */
	public void selectall() {
		//use function from controller
		List<Accounting> list = controller.selectAll();
		//output table head
		if(list.size()!=0)
			print(list);
		else
			System.out.println("No Result");
	}
	//output accounting data function
	//receive list, traveling set, output set
	private void print(List<Accounting> list) {
		System.out.println("ID\tTYPE\tACCOUNT\tAMOUNT\tDATE\t\tDESCRIPTION");
		//Traverse collection, output console
		for(Accounting am:list) {
			System.out.println(am.getAmid()+"\t"+am.getFlname()+"\t"+am.getAccount()+"\t"+am.getMoney()+"\t"+am.getCreatetime()+"\t"+am.getDescription());
		}
	}
	/*
	 * def funtion, conditional select
	 * enter date, start date and end date
	 * two dates transfer to controller layer
	 * use controller function transfer two dates
	 * get controller result, print it
	 * */
	public void select() {
		System.out.println("Date Format is XXXX-XX-XX");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Start Date: ");
		String startDate=input.nextLine();
		System.out.println("Enter ENd date: ");
		String endDate=input.nextLine();
		//use controller funtion, transfer dates, get results
		List<Accounting> list=controller.select(startDate, endDate);
		if(list.size()!=0)
			print(list);
		else
			System.out.println("No Result");
	}
	/*
	 * def function addRecord()
	 * receive 5 input, use controller
	 * */
	public void addRecord() {
		System.out.println("Add Record Function, Enter the Following: ");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter TYPE: ");
		String flname=input.next();
		System.out.print("Enter Amount: ");
		double money=input.nextDouble();
		System.out.print("Enter Account: ");
		String account=input.next();
		System.out.print("Enter Date: Format XXXX-XX-XX ");
		String createtime=input.next();
		System.out.print("Enter Description: ");
		String description=input.next();
		//receive data, use controller function, transfer 
		//receive all index, combine to a object
		Accounting ac=new Accounting(0,flname,account,money,createtime,description);
		controller.addRecord(ac);
		System.out.println("Add Record Success!");
	}
	/*
	 * def function. edit record
	 * receive information, make object
	 * use controller, transfer
	 * 
	 */
	public void editRecord() {
		//use selectAll(), show all record
		//choice one and edit
		selectall();
		System.out.println("Edit Function, Enter information:");
		System.out.print("Enter ID: ");
		Scanner input=new Scanner(System.in);
		int amid=input.nextInt();
		System.out.print("Enter TYPE: ");
		String flname=input.next();
		System.out.print("Enter Amount: ");
		double money=input.nextDouble();
		System.out.print("Enter Account: ");
		String account=input.next();
		System.out.print("Enter Date: Format XXXX-XX-XX ");
		String createtime=input.next();
		System.out.print("Enter Description: ");
		String description=input.next();
		//make all information to object
		Accounting ac=new Accounting(amid,flname,account,money,createtime,description);
		//use controller function, edit record
		controller.editRecord(ac);
		System.out.println("Edit success");
	}
	/*
	 * def function, delete
	 * enter a primary key
	 * use controller, transfer
	 * */
	public void deleteRecord() {
		selectall();
		System.out.println("Delete function, Enter ID");
		int amid= new Scanner(System.in).nextInt();
		//use controller, tranfer primary key
		controller.deleteRecord(amid);
		System.out.println("Delete success");		
	}
	
}
