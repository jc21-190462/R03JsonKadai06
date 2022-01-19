
import java.io.IOException;
import java.sql.Connection;
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
@WebServlet("/getTicketList")
public class GetTicketListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTicketListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			/*InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/jsonkadai06");
			Connection con=ds.getConnection();
			
			String sql = "select ticket_id,ticket_name,hpoint from TICKET ";
			// --- プリペアドステートメントへ登録
			PreparedStatement st = con.prepareStatement(sql);
			// --- クエリの結果を取得
			ResultSet rs = st.executeQuery();
			// --- 結果のリストをaryへ追加するための繰返し処理
			List<String[]> ary=new ArrayList<>();
			while (rs.next()) {
				// --- １件分のデータを格納するBeanを作成
				String[] p = {
						rs.getString("ticket_id"),
						rs.getString("ticket_name"),
						rs.getString("hpoint")
				};
				// --- Beanを配列aryに追加
				ary.add(p);
			}
			// --- オブジェクトを閉じる
			st.close();
			con.close();*/

			String[] s= {"1","ohoh","100"};
			request.setAttribute("list", s);
			
			//System.out.println(ary.get(0));
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/getTicketList.jsp");
			rd.forward(request, response);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}

}
