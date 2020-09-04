package cn.edu.zucc.personplan.model;
import java.util.Date;

public class BeanUser {
	private String user_id;
	private String user_pwd;
	private Date register_time;
	public static BeanUser currentLoginUser=null;
	
	public String getUserid() {
		return user_id;
	}
	public void setUserid(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUserpwd() {
		return user_pwd;
	}
	public void setUserpwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	
	public Date getRegistertime() {
		return register_time;
	}
	public void setRegistertime(Date register_time) {
		this.register_time = register_time;
	}

}
