package cn.itcast.am.dao;
/*
 *realize add delete edit ask 
 *dbuils tool class, create QueryRuuner object 
 *
 */

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.am.domain.Accounting;
import cn.itcast.am.tools.JDBCUtils;

public class AccountingDao {
	private QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * def funtion, Query all accounting data
	 * */
	public List<Accounting> selectAll() {
		try {
		//query accounting sql statement
			String sql="SELECT * FROM am_Accounting";
			//use query function
			List<Accounting> list = qr.query(sql, new BeanListHandler<>(Accounting.class));
			return list;
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Query all records fail");
		}
	}
	/*
	 * def function, quary database
	 * use from service, quary result save to bean
	 * */
	public List<Accounting> select(String startDate, String endDate){
		try {
			//spell conditional quary sql statement
			String sql="select * from am_accounting where createtime between ? and ?;";
			//def object array, save ?
			Object[] params= {startDate, endDate};
			//use qr object function quary data table get result
			return qr.query(sql, new BeanListHandler<>(Accounting.class),params);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Conditional quary fail");
		}
	}
	/*
	 * def dunction, add Record
	 * use service, transfer object
	 * make accounting object data, add to list
	 * */
	public void addRecord(Accounting ac) {
		try {
			//spell add record
			String sql="INSERT INTO am_accounting(flname,money,account,createtime,description) VALUES (?,?,?,?,?);";
			//create object set, save 5 items
			//source from Accounting
			Object[] params= {ac.getFlname(),ac.getMoney(),ac.getAccount(),ac.getCreatetime(),ac.getDescription()};
			//use qr function, add
			qr.update(sql,params);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Add fail");
		}
	}
			//def function, edit
			//update table
	public void editRecord(Accounting ac) {
		try {
			// TODO Auto-generated method stub
			String sql="update am_accounting SET flname=?, money=?, account=?, createtime=?, description=? where amid=?;";
			//def a set
			Object[] params= {ac.getFlname(),ac.getMoney(),ac.getAccount(),ac.getCreatetime(),ac.getDescription(),ac.getAmid()};
			//use qr object function, edit update
			qr.update(sql,params);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Update fail");			
		}		
	}
	
	//def funcion, delete
	//
	public void deleteRecord(int amid) {
		try {
			// TODO Auto-generated method stub
			//delete sql
			String sql="delete from am_accounting where amid=?;";
			qr.update(sql,amid);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Delete fail");
		}
	}
}

