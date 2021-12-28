package ajaxdemo.dao.impl;

import ajaxdemo.dao.BaseDao;
import ajaxdemo.entity.BBSMessage;
import ajaxdemo.util.JDBCUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class BBSMessageDaoImpl extends BaseDao{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	/*
	 * 执行查询操作
	 * @param
	 * 	elements：查询条件集合 	
	 */	
	public JSONArray getMessages(String username) {
		/*
		 * 拼写sql
		 */
		String sql = "select * from msg where 1 = 1 ";
		/*
		 * 编写条件语句
		 */
		sql += username != null?" and username='" + username + "' ":"";
		/*
		 * 返回结果
		 */
		JSONArray jsonArray = new JSONArray();
		try {
			//1.获取连接
			conn = JDBCUtils.getConn();
			//2.获取sql执行对象
			pstmt = conn.prepareStatement(sql);
			//3.执行sql
			rs = pstmt.executeQuery();
			while(rs.next()){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("msgid", rs.getString("msgid"));
				jsonObject.put("title", rs.getString("title"));
				jsonObject.put("msgcontent", rs.getString("msgcontent"));
				jsonObject.put("sendto", rs.getString("sendto"));
				jsonObject.put("state", rs.getInt("state"));
				jsonObject.put("msgCreateDate", rs.getDate("msg_create_date"));
				jsonObject.put("username", rs.getString("username"));
				jsonArray.add(jsonObject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(pstmt, conn);
		}
		return jsonArray;
	}

//	public List<BBSMessage> getMessages(String username) {
//		/*
//		 * 拼写sql
//		 */
//		String sql = "select * from msg where 1 = 1 ";
//		/*
//		 * 编写条件语句
//		 */
//		sql += username != null?" and username='" + username + "' ":"";
//		/*
//		 * 返回结果
//		 */
//		JSONArray jsonArray = new JSONArray();
//		List<BBSMessage> list = new ArrayList<>();
//		try {
//			//1.获取连接
//			conn = JDBCUtils.getConn();
//			//2.获取sql执行对象
//			pstmt = conn.prepareStatement(sql);
//			//3.执行sql
//			rs = pstmt.executeQuery();
//			while(rs.next()){
////				JSONObject jsonObject = new JSONObject();
//				BBSMessage bbsMessage = new BBSMessage();
//
//				bbsMessage.setMsgid(rs.getString("msgid"));
//				bbsMessage.setTitle(rs.getString("title"));
//				bbsMessage.setUsername(rs.getString("msgcontent"));
//				bbsMessage.setContent(rs.getString("msgcontent"));
//				bbsMessage.setSendto(rs.getString("sendto"));
//
////				jsonObject.put("msgid", rs.getString("msgid"));
////				jsonObject.put("title", rs.getString("title"));
////				jsonObject.put("msgcontent", rs.getString("msgcontent"));
////				jsonObject.put("sendto", rs.getString("sendto"));
////				jsonObject.put("state", rs.getInt("state"));
////				jsonObject.put("msgCreateDate", rs.getDate("msg_create_date"));
////				jsonObject.put("username", rs.getString("username"));
//				list.add(bbsMessage);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			JDBCUtils.close(pstmt, conn);
//		}
//		return list;
//	}


}
