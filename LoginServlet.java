package com.campus.servlet;
import com.campus.dao.DBUtil;
import com.campus.model.User;
import javax.servlet.*; import javax.servlet.http.*;
import java.io.IOException; import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email"); String password=req.getParameter("password");
        Connection conn=null; PreparedStatement ps=null; ResultSet rs=null;
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement("SELECT user_id,name,role FROM users WHERE email=? AND password=?");
            ps.setString(1,email); ps.setString(2,password); rs=ps.executeQuery();
            if(rs.next()){
                User u=new User(rs.getInt("user_id"),rs.getString("name"),email,rs.getString("role"));
                req.getSession().setAttribute("user",u);
                resp.sendRedirect("index.jsp");
            } else { resp.sendRedirect("login.jsp?error=1"); }
        } catch(Exception e){ e.printStackTrace(); } finally { DBUtil.close(rs,ps,conn); }
    }
}
