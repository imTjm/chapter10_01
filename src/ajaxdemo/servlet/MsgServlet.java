package ajaxdemo.servlet;

import ajaxdemo.dao.impl.BBSMessageDaoImpl;
import ajaxdemo.entity.BBSMessage;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * 首页短信息servlet
 *
 */
public class MsgServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BBSMessageDaoImpl bbsMessageDao = new BBSMessageDaoImpl();
        String name = request.getParameter("name");
        //
        JSONArray jsonArray = bbsMessageDao.getMessages(name);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.print(jsonArray);
        pw.flush();
        pw.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
    }

}
