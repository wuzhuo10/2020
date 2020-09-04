package cn.edu.zucc.personplan.model;
import java.util.Date;

public class BeanPlan {
	public static final String[] tableTitles={"序号","名称","步骤数","已完成数"};
	private int plan_id;
	private String user_id;
	private int plan_order;
	private String plan_name;
	private Date create_time;
	private int step_count;
	private int start_step_count;
	private int finish_step_count;
	
	public int getPlanid() {
		return plan_id;
	}
	public void setPlanid(int plan_id) {
		this.plan_id = plan_id;
	}
	
	public String getUserid() {
		return user_id;
	}
	public void setUserid(String user_id) {
		this.user_id = user_id;
	}
	
	public int getPlanorder() {
		return plan_order;
	}
	public void setPlanorder(int plan_order) {
		this.plan_order = plan_order;
	}
	
	public String getPlanname() {
		return plan_name;
	}
	public void setPlanname(String plan_name) {
		this.plan_name = plan_name;
	}
	
	public Date getRegistertime() {
		return create_time;
	}
	public void setCteatetime(Date create_time) {
		this.create_time = create_time;
	}
	
	public int getStepcount() {
		return step_count;
	}
	public void setStepcount(int step_count) {
		this.step_count = step_count;
	}
	
	public int getStartstepcount() {
		return start_step_count;
	}
	public void setStartstepcount(int start_step_count) {
		this.start_step_count = start_step_count;
	}
	
	public int getFinishstepcount() {
		return finish_step_count;
	}
	public void setFinishstepcount(int finish_step_count) {
		this.finish_step_count = finish_step_count;
	}
	

}
