
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class GetPointServlet
 */
@WebServlet("/getPoint")
public class GetPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPointServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final String driverName = "com.mysql.jdbc.Driver";
		final String url = "jdbc:mysql://192.168.54.190:3306/jsonkadai06";
		final String id = "jsonkadai06";
		final String pass = "JsonKadai06";
		
		try {
			Class.forName(driverName);
			Connection connection=DriverManager.getConnection(url,id,pass);
			PreparedStatement st = connection.prepareStatement(
							"select point from POINT where USER_ID = ? AND TENPO_ID = ?"
						);
			
			st.setString(1, request.getParameter("USER_ID"));
			st.setString(2, request.getParameter("TENPO_ID"));
			ResultSet result = st.executeQuery();
			
			List<String[]> list=new ArrayList<>();
			
			while( result.next() == true) {
				String[] s=new String[3];
				s[0]=result.getString("point");
				list.add(s);	
			}
			
			if(result.next() == false) {
				PreparedStatement st2 = connection.prepareStatement(
						"insert into point(USER_ID,TENPO_ID,POINT) values(?,?,500)"
					);
				st2.setString(1, request.getParameter("USER_ID"));
				st2.setString(2, request.getParameter("TENPO_ID"));
				int x=st2.executeUpdate();
				if(x == 1) {
					System.out.print("新規追加成功");
				}System.out.print("新規追加失敗");
			}
			
			for(String n[]:list) {
				System.out.println(n[0]);
			}
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/getPoint.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e ) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆ catch 繝悶Ο繝�繧ｯ
			e.printStackTrace();
		} catch (SQLException e ) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆ catch 繝悶Ο繝�繧ｯ
			e.printStackTrace();
		}
	}

}
