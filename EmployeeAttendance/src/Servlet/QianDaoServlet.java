package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Bumen;
import Bean.Kaoqin;
import Bean.Yuangong;
import Bean.Yuangong_static;
import Dao.Add;
import Dao.Delete;
import Dao.Get;
import Dao.Select;
import Login.Power;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/QianDaoServlet")
public class QianDaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QianDaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String function=req.getParameter("method");
		if(function.equals("submit")) {
			Date currentTime=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String time = formatter.format(currentTime);
			req.setAttribute("time", time);
			req.getRequestDispatcher("yuangong/daka.jsp").forward(req,resp);
		}
		if(function.equals("shangban")) {
			String JobID=Power.getBianhao();
			Select s=new Select();
			s.select("user_information",JobID);
			Kaoqin kq=new Kaoqin();
			Date currentTime=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			SimpleDateFormat formatter_date = new SimpleDateFormat("yyyy-MM-dd");
			String time = formatter.format(currentTime);
			String date=formatter_date.format(currentTime);
			String time_shangban=date+" 08:00";
			boolean b=s.select_kaoqin("kaoqin",JobID,date,"已上班");
			if(b) {
				req.setAttribute("message", "今天上班已经打卡过了，明天再来叭");
				req.getRequestDispatcher("yuangong/daka.jsp").forward(req,resp);
			}else {
				if(time.compareTo(time_shangban)<=0) {//打卡时间早或等于上班时间
					kq.setAttendancetime(time);
					kq.setAttendancetype("已上班");
					kq.setBirthday(Yuangong_static.getBirthday());
					kq.setDepartment(Yuangong_static.getDepartment());
					kq.setJobID(JobID);
					kq.setName(Yuangong_static.getName());
					kq.setSex(Yuangong_static.getSex());
					kq.setDate(date);
					Add a=new Add();
					a.add("kaoqin", kq);
					req.setAttribute("message", "上班打卡成功");
					req.getRequestDispatcher("yuangong/daka.jsp").forward(req,resp);
				}else {
					req.setAttribute("message", "已超过打卡时间，打卡失败，下次早点来");
					req.getRequestDispatcher("yuangong/daka.jsp").forward(req,resp);
				}
			}		
		}
		if(function.equals("xiaban")) {
			String JobID=Power.getBianhao();
			Select s=new Select();
			s.select("user_information",JobID);
			Kaoqin kq=new Kaoqin();
			Date currentTime=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			SimpleDateFormat formatter_date = new SimpleDateFormat("yyyy-MM-dd");
			String time = formatter.format(currentTime);
			String date=formatter_date.format(currentTime);
			String time_xiaban=date+" 17:00";
			boolean b=s.select_kaoqin("kaoqin",JobID,date,"已下班");
			boolean bb=s.select_kaoqin("kaoqin",JobID,date,"已上班");
			if(bb) {
				if(b) {
					req.setAttribute("message", "今天下班已经打卡过了，明天再来叭");
					req.getRequestDispatcher("yuangong/daka.jsp").forward(req,resp);
				}else {
					if(time.compareTo(time_xiaban)>=0) {
						kq.setAttendancetime(time);
						kq.setAttendancetype("已下班");
						kq.setBirthday(Yuangong_static.getBirthday());
						kq.setDepartment(Yuangong_static.getDepartment());
						kq.setJobID(JobID);
						kq.setName(Yuangong_static.getName());
						kq.setSex(Yuangong_static.getSex());
						kq.setDate(date);
						Add a=new Add();
						a.add("kaoqin", kq);
						req.setAttribute("message", "下班打卡成功");
						req.getRequestDispatcher("yuangong/daka.jsp").forward(req,resp);
					}else {
						req.setAttribute("message", "未到下班时间，打卡失败，一会再来吧");
						req.getRequestDispatcher("yuangong/daka.jsp").forward(req,resp);
					}
				}
			}else {
				req.setAttribute("message", "今天还没上班呢....");
				req.getRequestDispatcher("yuangong/daka.jsp").forward(req,resp);
			}
		}
		if(function.equals("liulangeren")) {
			String JobID=Power.getBianhao();
			List<Kaoqin> userall=Get.getAll_kaoqin("kaoqin",JobID);
			java.util.Collections.reverse(userall);
			req.setAttribute("all", userall);
			req.getRequestDispatcher("yuangong/gerenkaoqin.jsp").forward(req,resp);
		}
		if(function.equals("liulanbumen")) {
			String department=Power.getBumen();
			System.out.println(department);
			List<Kaoqin> userall=Get.getAll_kaoqin1("kaoqin",department);
			java.util.Collections.reverse(userall);
			req.setAttribute("all", userall);
			req.getRequestDispatcher("yuangong/bumenkaoqin.jsp").forward(req,resp);
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
