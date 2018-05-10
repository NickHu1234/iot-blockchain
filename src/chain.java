import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;


public class chain extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public chain() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    Jedis jedis=Myjedis.getJedis();
        List<String>  l1=jedis.lrange("ul01", 0, -1);
         List<String>  l2=jedis.lrange("ul02", 0, -1);
          List<String>  l3=jedis.lrange("ul03", 0, -1);
           List<String>  l4=jedis.lrange("ul04", 0, -1);
            List<String>  l5=jedis.lrange("ul05", 0, -1);
             List<String>  l6=jedis.lrange("ul06", 0, -1);
             

  MerkleTrees mt1=new MerkleTrees(l1);
	mt1.merkle_tree();
	
   
 
	 
	 MerkleTrees mt2=new MerkleTrees(l2);
	mt1.merkle_tree();
	
	 
	  MerkleTrees mt3=new MerkleTrees(l3);
	mt1.merkle_tree();
	
	 
	  MerkleTrees mt4=new MerkleTrees(l4);
	mt1.merkle_tree();
	
	 
	  MerkleTrees mt5=new MerkleTrees(l5);
	mt1.merkle_tree();
	
	 
	  MerkleTrees mt6=new MerkleTrees(l6);
	mt1.merkle_tree();
	
	out.println(mt1.getRoot()+"<br/>");
	out.println(mt2.getRoot()+"<br/>");
	out.println(mt3.getRoot()+"<br/>");
	out.println(mt4.getRoot()+"<br/>");
	out.println(mt5.getRoot()+"<br/>");
	out.println(mt6.getRoot()+"<br/>");
	
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
