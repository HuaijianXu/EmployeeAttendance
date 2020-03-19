package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Bumen;
import Bean.Yuangong;
import Dao.Add;
import Dao.Change;
import Dao.Get;
import Dao.Select;
import Dao.UserDao;
import Login.Power;

/**
 * Servlet implementation class DiaodongServlet
 */
@WebServlet("/DiaodongServlet")
public class DiaodongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaodongServlet() {
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
			String department=Power.getBumen();
			System.out.println(department);
			List<Yuangong> bumen=Get.getAll_bumen(table,department);
			java.util.Collections.reverse(bumen);
			req.setAttribute("bumen", bumen);
			req.getRequestDispatcher("yuangong/xiangxi.jsp").forward(req, resp);
		}
		if(function.equals("xiangxi")) {
			String table="user_information";
			String JobID=req.getParameter("JobID");
			Select s=new Select();
			s.select(table, JobID);
			req.getRequestDispatcher("yuangong/gangweidiaodong.jsp").forward(req,resp);
		}
		if(function.equals("diaodong")) {
			String table="user_information";
			String JobID=req.getParameter("JobID");
			String department=req.getParameter("department");
			UserDao dao=new UserDao();
			boolean b=dao.login3(table, department);
			if(b) {
				Change c=new Change();
				c.change(table, "department", "JobID", department, JobID);
				req.setAttribute("message", "调动成功");
				req.getRequestDispatcher("yuangong/xiangxi.jsp").forward(req,resp);
			}else {
				req.setAttribute("message", "该部门不存在");
				req.getRequestDispatcher("yuangong/gangweidiaodong.jsp").forward(req,resp);
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
