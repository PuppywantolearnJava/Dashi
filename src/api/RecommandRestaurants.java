package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import db.DBConnection;
import db.MySQLDBConnection;
import db.MongoDBConnection;

/**
 * Servlet implementation class RecommandRestaurants
 */
@WebServlet("/recommendation")
public class RecommandRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommandRestaurants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	//private static DBConnection connection = new MySQLDBConnection();
	private static DBConnection connection = new MongoDBConnection();


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		JSONArray array = null;
		
		if (request.getParameterMap().containsKey("user_id")) {
			String userId = request.getParameter("user_id");
			array = connection.recommendRestaurants(userId);
		}
		RpcParser.writeOutput(response, array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
