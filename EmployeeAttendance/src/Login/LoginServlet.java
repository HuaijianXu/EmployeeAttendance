package Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String function=req.getParameter("method");
		if(function.equals("login"))
		{
			String table="user_information";
			String username;
			username=req.getParameter("username");
			String password;
			password=req.getParameter("password");
			UserDao dao=new UserDao();
			boolean b=dao.login(table, username);
			boolean bb=dao.login2(table, username, password);
			Select s=new Select();
			s.select(table, username, password);
			if(b) {
				if(bb) {
					req.setAttribute("message", "登录成功");
					req.getRequestDispatcher("Home.jsp").forward(req,resp);
				}else {
					req.setAttribute("message", "密码错误");
					req.getRequestDispatcher("Login.jsp").forward(req,resp);
				}
			} else {
				req.setAttribute("message", "用户名不存在");
				req.getRequestDispatcher("Login.jsp").forward(req,resp);
			}
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
