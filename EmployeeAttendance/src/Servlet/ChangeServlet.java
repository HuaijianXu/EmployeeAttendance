package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Yuangong_static;
import Dao.Change;
import Dao.Select;
import Dao.UserDao;
import Login.Power;

/**
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String function=req.getParameter("method");
		if(function.equals("submit")) {
			String table="user_information";
			String JobID=req.getParameter("JobID");
			Select s=new Select();
			boolean b=s.select(table,JobID);
			if(b) {
				req.getRequestDispatcher("guanli/xiugaiyuangong1.jsp").forward(req,resp);
			}else {
				req.setAttribute("message", "该工号不存在");
				req.getRequestDispatcher("guanli/xiugaiyuangong.jsp").forward(req,resp);
			}
		}
		if(function.equals("yuangong")) {
			String table="user_information";
			String Name = req.getParameter("Name");
			String sex = req.getParameter("sex");
			String birthday = req.getParameter("birthday");
			Change c=new Change();
			c.change(table, "Name", "JobID", Name, Yuangong_static.getJobID());
			c.change(table, "sex", "sex", sex, Yuangong_static.getSex());
			c.change(table, "birthday", "birthday", birthday, Yuangong_static.getBirthday());
			req.setAttribute("message", "修改成功");
			req.getRequestDispatcher("guanli/xiugaiyuangong.jsp").forward(req,resp);
		}
		if(function.equals("bumen")) {
			String table="bumen";
			String department=req.getParameter("department");
			String department_new=req.getParameter("department_new");
			UserDao dao=new UserDao();
			boolean b=dao.login3(table,department);
			if(b) {
				Change c=new Change();
				c.change(table, "department", "department", department_new, department);
				req.setAttribute("message", "修改成功");
				req.getRequestDispatcher("guanli/xiugaibumen.jsp").forward(req,resp);
			}else {
				req.setAttribute("message", "该部门不存在");
				req.getRequestDispatcher("guanli/xiugaibumen.jsp").forward(req,resp);
			}
			

		}
		if(function.equals("juese")) {
			String table="user_information";
			String JobID=req.getParameter("JobID");
			String role=req.getParameter("role");
			UserDao dao=new UserDao();
			boolean b=dao.login(table,JobID);
			if(b) {
				Change c=new Change();
				c.change(table, "role", "JobID", role, JobID);
				req.setAttribute("message", "修改成功");
				req.getRequestDispatcher("guanli/shezhijuese.jsp").forward(req,resp);
			}else {
				req.setAttribute("message", "该工号不存在");
				req.getRequestDispatcher("guanli/shezhijuese.jsp").forward(req,resp);
			}
		}
		if(function.equals("chongzhimima")) {
			String table="user_information";
			String JobID=req.getParameter("JobID");
			UserDao dao=new UserDao();
			boolean b=dao.login(table,JobID);
			if(b) {
				Change c=new Change();
				c.change(table, "password", "JobID", "123456", JobID);
				req.setAttribute("message", "修改成功");
				req.getRequestDispatcher("guanli/shezhijuese.jsp").forward(req,resp);
			}else {
				req.setAttribute("message", "该工号不存在");
				req.getRequestDispatcher("guanli/shezhijuese.jsp").forward(req,resp);
			}
		}
		if(function.equals("xiugaimima")) {
			String table="user_information";
			String JobID=Power.getBianhao();
			String password=req.getParameter("password");
			String password_new=req.getParameter("password_new");
			UserDao dao=new UserDao();
			boolean b=dao.login2(table,JobID,password);
			if(b) {
				Change c=new Change();
				c.change(table, "password", "JobID", password_new, JobID);
				req.setAttribute("message", "修改成功");
				req.getRequestDispatcher("yuangong/xiugaimima.jsp").forward(req,resp);
			}else {
				req.setAttribute("message", "原密码错误");
				req.getRequestDispatcher("yuangong/xiugaimima.jsp").forward(req,resp);
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
