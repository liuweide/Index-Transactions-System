package wechat_transaction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import dao.ylx_db;


public class BuyDao extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String indexName = request.getParameter("index_name");
		String price = request.getParameter("latest_price");
		String hold = request.getParameter("hold");
		request.setCharacterEncoding("UTF-8");
		System.out.println("FileDao-页面传递过来的数据获取完毕");
		System.out.println("id=" + id + ",index_name=" + indexName + ",latest_price=" + price+ ",hold=" + hold);

		ylx_db insert_db = new ylx_db("xm09");
		
		String sql = "insert into own_index(index_name, latest_price, hold) values('" + indexName + "','" + price
				+ "','"+hold+"')";
		System.out.println("即将执行的SQL语句是：" + sql);
		insert_db.executeUpdate(sql);
		insert_db.close();

		System.out.println("操作数据完毕，关闭了数据库！");
		System.out.println("FileDao页面执行完毕！");
		// 返回结果
		JSONObject json = new JSONObject();
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
}
