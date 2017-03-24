
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChooseChat
 */
@WebServlet("/Choosechat")
public class ChooseChat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChooseChat() {
		super();
		// TODO Auto-generated constructor stub
	}
	HttpSession[] session=new HttpSession[5];
	int num=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private Map<HttpSession, String> sessions = new ConcurrentHashMap<HttpSession, String>();
	public static Set<String> onlines = new HashSet<String>();
	private Set<String> users = new HashSet<String>();
	private Map<String, String> use = new ConcurrentHashMap<String, String>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		session[num] = request.getSession();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		// ******
		for (int i = 0; i < 5; i++) {
			users.add(i + "");
			use.put(i + "", i + "");
		}
		// ******
		if (use.containsKey(user)) {
			if (use.get(user).equals(pass)) {

				onlines.add(user);
				session[num].setAttribute("username", user);
				session[num].setAttribute("password", pass);
				sessions.put(session[num], request.getRemoteAddr());

				num++;
			} else {
				System.out.println("Incorrect password");
			}

		} else {
			System.out.println("not EXIST");
		}
		System.out.println("user = "+ session[num-1].getAttribute("username"));
		System.out.println(sessions.size());
		System.out.println(use.size());
		System.out.println(user);
		//***********8

        request.getRequestDispatcher("OnlineList.jsp").forward(request, response);
//		 PrintWriter out = response.getWriter();
//
//		   String docType =
//		   "<!doctype html public \"-//w3c//dtd html 4.0 " +
//		   "transitional//en\">\n";
//		   out.println(docType +
//		             "<html>\n" +
//		             "<head><title>" + "Online users" + "</title></head>\n" +
//		             "<body bgcolor=\"#f0f0f0\">\n" +
//		             "<h1 align=\"center\">" + "Online users" + "</h1>\n" +
//		             
//		             "<table border=\"1\" align=\"center\">\n" +
//		             "<tr bgcolor=\"#949494\">\n" +
//		             "  <th>UserName</th>\n" +
//		             "<tr>\n" +
//		        //  for(String online : onlines){ 
//		             "  <td>" + "HIIII" + "</td></tr>\n" +
//		             "<tr>\n" +
//		       //   }
//		             "</body></html>");
//		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
