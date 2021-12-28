package ajaxdemo.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class BaseDao {

	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//获取连接
	protected void openConnection(){
			try {
				//连接MySql数据库，用户名和密码都是root
				String url = "jdbc:mysql://localhost:3306/bbs_message" ;
				String username = "root" ;
				String password = "root" ;
				con = DriverManager.getConnection(url , username , password ) ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}	
	
	//更新新据库
	public int executeUpdata(String sql, List<Object> list){		
		openConnection();
		try {
			ps = con.prepareStatement(sql);
			if(list == null)
				return ps.executeUpdate();
			int i = 1;
			for(Object obj:list){
				ps.setObject(i, obj);
				i++;
			}
			return ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			closeResource();
		}
		return 0;
	}
	
	//关闭流
	protected void closeResource(){		
	try {
		if(rs != null)
			rs.close();
		if(ps != null)
			ps.close();
		if(con != null)
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
