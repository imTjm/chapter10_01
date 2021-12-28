package ajaxdemo.util;

import java.sql.*;

public class JDBCUtils {

    /**
     * 1.读取配置文件
     */
    static {
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 2.获得数据库连接
     */
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bbs_message?useUnicode=true&amp;characterEncoding=utf-8",
                "root",
                "123456");
    }

    /**
     * 3.释放资源（方法重载）
     */
    public static void close(PreparedStatement pstmt, Connection conn) {
        close(null,pstmt,conn);
    }

    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
