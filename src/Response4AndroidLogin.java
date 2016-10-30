import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class Response4AndroidLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Response4AndroidLogin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
		
		System.out.print("--------doGet(...)------------");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("--------doPost(...)------------");
		
		// œﬂ≥ÃÀØŒÂ√Î÷”
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PrintWriter outPrintWriter  = response.getWriter();
		
		String userName = request.getParameter("UserName");
		String password = request.getParameter("PassWord");
		
		System.out.println(userName);
		System.out.println(password);
		
		try {
			
			if (userName.equals("zhangsan") && password.equals("123")) {
				
				JSONArray jsonArray = new JSONArray();
				
				outPrintWriter.print("success");
			} else {
				outPrintWriter.print("falesd");
			}
			 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
