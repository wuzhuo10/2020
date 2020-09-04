package cn.edu.zucc.personplan.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;

import cn.edu.zucc.personplan.util.DBUtil;
import cn.edu.zucc.personplan.util.DbException;
import cn.edu.zucc.personplan.itf.IUserManager;
import cn.edu.zucc.personplan.model.BeanUser;
import cn.edu.zucc.personplan.util.BaseException;
import cn.edu.zucc.personplan.util.BusinessException;

public class ExampleUserManager implements IUserManager {

	@Override
	public BeanUser reg(String userid, String pwd,String pwd2) throws BaseException {
		if(userid==null || "".equals(userid)) {
			throw new BusinessException("�û�������Ϊ��");
		}
		if(pwd==null || "".equals(pwd) || pwd2==null || "".equals(pwd2)) {
			throw new BusinessException("���벻��Ϊ��");
		}
		if(pwd2==null || "".equals(pwd2)) {
			throw new BusinessException("���ٴ���������");
		}
		if(!pwd.equals(pwd2)) {
			throw new BusinessException("�������벻һ��");
		}
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tbl_user where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("�û����Ѿ�����");
			rs.close();
			pst.close();
			sql="insert into tbl_user(user_id,user_pwd,register_time) values(?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2, pwd);
			pst.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
			BeanUser user=new BeanUser();
			user.setUserid(rs.getString(1));
			user.setUserpwd(rs.getString(2));
			user.setRegistertime(rs.getDate(3));
			pst.execute();
			pst.close();
			return user;
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
		
	}

	
	@Override
	public BeanUser login(String userid, String pwd) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select user_id,user_pwd,register_time from tbl_user where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("�û���������");
			if(!pwd.equals(rs.getString(2))) throw new BusinessException("�������");
			BeanUser u=new BeanUser();
			u.setUserid(rs.getString(1));
			u.setUserpwd(rs.getString(2));
			// if(u.getRegistertime()!=null) throw new BusinessException("���˺��Ѿ���ɾ��");
			rs.close();
			pst.close();
			return u;
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
	}


	@Override
	public void changePwd(BeanUser user, String oldPwd, String newPwd, String newPwd2) throws BaseException {
		if(oldPwd==null) throw new BusinessException("ԭʼ���벻��Ϊ��");
		if(newPwd==null || "".equals(newPwd)) throw new BusinessException("�����벻��Ϊ��");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select user_pwd from tbl_user where user_rid=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,user.getUserid());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("�û���������");
			if(!oldPwd.equals(rs.getString(1))) throw new BusinessException("ԭʼ�������");
			if(!oldPwd.equals(newPwd)) throw new BusinessException("�������벻һ��");
			rs.close();
			pst.close();
			sql="update tbl_user set user_pwd=? where user_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, user.getUserid());
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
		
	}

}
