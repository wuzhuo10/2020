package cn.edu.zucc.personplan.model;
import java.util.Date;

public class BeanStep {
	public static final String[] tableTitles={"序号","名称","计划开始时间","计划完成时间","实际开始时间","实际完成时间"};
	private int step_id;
	private int plan_id;
	private int step_order;
	private String step_name;
	private Date plan_begin_time;
	private Date plan_end_time;
	private Date real_begin_time;
	private Date real_end_time;
	
	public int getStepid() {
		return step_id;
	}
	public void setStepid(int step_id) {
		this.step_id = step_id;
	}
	
	public int getPlanid() {
		return plan_id;
	}
	public void setPlanid(int plan_id) {
		this.plan_id = plan_id;
	}
	
	public int getSteporder() {
		return step_order;
	}
	public void setSteporder(int step_order) {
		this.step_order = step_order;
	}
	
	public String getStepname() {
		return step_name;
	}
	public void setStepname(String step_name) {
		this.step_name = step_name;
	}
	
	public Date getPlanbegintime() {
		return plan_begin_time;
	}
	public void setPlanbegintime(Date plan_begin_time) {
		this.plan_begin_time = plan_begin_time;
	}
	
	public Date getPlanendtime() {
		return plan_end_time;
	}
	public void setPlanendtime(Date plan_end_time) {
		this.plan_end_time = plan_end_time;
	}
	
	public Date getRealbegintime() {
		return real_begin_time;
	}
	public void setRealbegintime(Date plan_begin_time) {
		this.real_begin_time = real_begin_time;
	}
	
	public Date getRealendtime() {
		return real_end_time;
	}
	public void setRealendtime(Date plan_end_time) {
		this.real_end_time = real_end_time;
	}
	
}
