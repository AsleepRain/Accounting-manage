package cn.itcast.am.domain;

public class Accounting {
private int amid;
private String flname;
private String account;
private double money;
private String createtime;
private String description;
//Generate Constructor using Fields
public Accounting(int amid, String flname, String account, double money, String createtime, String description) {
	super();
	this.amid = amid;
	this.flname = flname;
	this.account = account;
	this.money = money;
	this.createtime = createtime;
	this.description = description;
}
//Generate Constructors from Superclass
public Accounting() {
	super();
	// TODO Auto-generated constructor stub
}

//Generate to String()
@Override
public String toString() {
	return "Accounting [amid=" + amid + ", flname=" + flname + ", account=" + account + ", money=" + money
			+ ", createtime=" + createtime + ", description=" + description + "]";
}
//Generate Getters and Setters
public int getAmid() {
	return amid;
}

public void setAmid(int amid) {
	this.amid = amid;
}

public String getFlname() {
	return flname;
}

public void setFlname(String flname) {
	this.flname = flname;
}

public String getAccount() {
	return account;
}

public void setAccount(String account) {
	this.account = account;
}

public double getMoney() {
	return money;
}

public void setMoney(double money) {
	this.money = money;
}

public String getCreatetime() {
	return createtime;
}

public void setCreatetime(String createtime) {
	this.createtime = createtime;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}
}
