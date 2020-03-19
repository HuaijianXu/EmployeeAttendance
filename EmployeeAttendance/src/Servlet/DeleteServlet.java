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
import Dao.Delete;
import Dao.Get;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String function=req.getParameter("method");
		if(function.equals("yuangong")) {
			List<Yuangong> userall=Get.getAll("user_information");
			java.util.Collections.reverse(userall);
			req.setAttribute("all", userall);
			req.getRequestDispatcher("guanli/shanchuyuangong.jsp").forward(req,resp);
		}
		if(function.equals("delete1")) {
			String JobID=req.getParameter("JobID");
			Delete d=new Delete();
			d.delete("user_information","JobID",JobID);
			List<Yuangong> userall=Get.getAll("user_information");
			java.util.Collections.reverse(userall);
			req.setAttribute("all", userall);
			req.setAttribute("message", "删除成功");
			req.getRequestDispatcher("guanli/shanchuyuangong.jsp").forward(req,resp);			
		}
		if(function.equals("bumen")) {
			List<Bumen> userall=Get.getAll1("bumen");
			java.util.Collections.reverse(userall);
			req.setAttribute("all", userall);
			req.getRequestDispatcher("guanli/shanchubumen.jsp").forward(req,resp);
		}
		if(function.equals("delete2")) {
			String department=req.getParameter("department");
			Delete d=new Delete();
			d.delete("bumen","department",department);
			List<Bumen> userall=Get.getAll1("bumen");
			java.util.Collections.reverse(userall);
			req.setAttribute("all", userall);
			req.setAttribute("message", "删除成功");
			req.getRequestDispatcher("guanli/shanchubumen.jsp").forward(req,resp);			
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
