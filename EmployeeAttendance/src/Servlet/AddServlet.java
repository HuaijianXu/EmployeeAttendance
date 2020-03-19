package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Bumen;
import Bean.Yuangong;
import Dao.Add;
import Dao.Select;
import Dao.UserDao;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String function=req.getParameter("method");
		if(function.equals("yuangong")) {
			String table="user_information";
			String JobID;
			Select s=new Select();
			int f=s.select(table);
			JobID=""+f;
			String Name = req.getParameter("Name");
			String sex = req.getParameter("sex");
			String birthday = req.getParameter("birthday");
			String department = req.getParameter("department");
			String role = "员工";
			String password = req.getParameter("password");
			Yuangong yg=new Yuangong();
			yg.setJobID(JobID);
			yg.setName(Name);
			yg.setSex(sex);;
			yg.setBirthday(birthday);
			yg.setDepartment(department);
			yg.setRole(role);
			yg.setPassword(password);
			UserDao dao=new UserDao();
			boolean b=dao.login(table, Name);
			if(!b) {
				Add a=new Add();
				a.add(table,yg);
				req.setAttribute("message", "添加成功");
				req.getRequestDispatcher("guanli/tianjiayuangong.jsp").forward(req,resp);
			}else {
				req.setAttribute("message", "该用户名已存在");
				req.getRequestDispatcher("guanli/tianjiayuangong.jsp").forward(req,resp);
			}
		}
		if(function.equals("bumen")) {
			String table="bumen";
			String departmentID=req.getParameter("departmentID");
			String department=req.getParameter("department");
			Bumen bm=new Bumen();
			bm.setDepartmentID(departmentID);
			bm.setDepartment(department);
			UserDao dao=new UserDao();
			boolean b=dao.login3(table, department);
			boolean bb=dao.login4(table, department,departmentID);
			if(!b) {
				if(!bb) {
					Add a=new Add();
					a.add(table,bm);
					req.setAttribute("message", "添加成功");
					req.getRequestDispatcher("guanli/tianjiabumen.jsp").forward(req,resp);
				}else {
					req.setAttribute("message", "部门编号已存在");
					req.getRequestDispatcher("guanli/tianjiabumen.jsp").forward(req,resp);
				}
			}else {
				req.setAttribute("message", "该部门已存在");
				req.getRequestDispatcher("guanli/tianjiabumen.jsp").forward(req,resp);
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
