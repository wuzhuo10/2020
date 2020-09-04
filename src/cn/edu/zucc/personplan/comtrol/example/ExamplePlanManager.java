package cn.edu.zucc.personplan.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.personplan.util.BusinessException;
import cn.edu.zucc.personplan.util.DBUtil;
import cn.edu.zucc.personplan.util.DbException;
import cn.edu.zucc.personplan.model.BeanUser;
import cn.edu.zucc.personplan.itf.IPlanManager;
import cn.edu.zucc.personplan.model.BeanPlan;
import cn.edu.zucc.personplan.util.BaseException;

public class ExamplePlanManager implements IPlanManager {

	@Override
	public BeanPlan addPlan(String name) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tbl_plan where plan_name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			java.sql.ResultSet rs=pst.executeQuery();
			//if(rs.next()) throw new BusinessException("条码已经被占用");
			rs.close();
			pst.close();
			sql="insert into tbl_plan(plan_id,user_id,plan_order,plan_name," + 
			    "cteate_time,step_count,start_step_count,finished_step_count)" + 
					"values(?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, planid);
			pst.setString(2, BeanUser.currentLoginUser);
			pst.setString(3, null);
			pst.setString(4, name);
			pst.setTimestamp(5,new java.sql.Timestamp(System.currentTimeMillis()));
			pst.setString(6, null);
			pst.setString(7, null);
			pst.setString(8, null);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeanPlan> loadAll() throws BaseException {
		List<BeanPlan> result=new ArrayList<BeanPlan>();
		//BeanPlan p=new BeanPlan();
		//result.add(p);
		//return result;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tbl_plan";
			sql+=" order by planid";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				BeanPlan u=new BeanPlan();
				u.setPlanid(rs.getInt(1));
				u.setUserid(rs.getString(2));
				u.setPlanorder(rs.getInt(3));
				u.setPlanname(rs.getString(4));
				u.setCteatetime(rs.getDate(5));
				u.setStepcount(rs.getInt(6));
				u.setStartstepcount(rs.getInt(7));
				u.setFinishstepcount(rs.getInt(8));
				result.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
		
	}

	@Override
	public void deletePlan(BeanPlan plan) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tbl_plan where plan_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,plan.getPlanid());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("计划不存在");
			if(rs.getDate(1)!=null) throw new BusinessException("该计划已经被删除");
			rs.close();
			pst.close();
			sql="update tbl_plan set removeDate=? where userid=?";
			pst=conn.prepareStatement(sql);
			pst.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
			pst.setString(2, userid);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
