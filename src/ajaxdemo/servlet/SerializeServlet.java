package ajaxdemo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SerializeServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        boolean isSuccess = false;
        if("admin".equals(name) && "man".equals(sex)){
            isSuccess = true;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.print(isSuccess);
        pw.flush();
        pw.close();
    }
}
