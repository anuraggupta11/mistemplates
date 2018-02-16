package testdatatable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class GetDataTable
 */
public class GetDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int limit =10;
		int offset =0 ;
		Integer showentries = null;
		String searchterm = null;
		String columnname="";
		if(request.getParameter("limit") !=null) {
			try {
				limit= Integer.parseInt(request.getParameter("limit").toString());
			}catch(Exception e) {
				
			}
		}
		if(request.getParameter("offset") !=null) {
			try {
				offset = Integer.parseInt(request.getParameter("offset").toString());
			}catch(Exception e) {
				
			}
		}
		if(request.getParameter("showentries") !=null) {
			try {
				showentries= Integer.parseInt(request.getParameter("showentries").toString());
				 
			}catch(Exception e) {
				e.printStackTrace();

			}
		}
		if(request.getParameter("searchterm") !=null && !request.getParameter("searchterm").toString().equalsIgnoreCase("") ) {
			try {
				searchterm= request.getParameter("searchterm").toString();
				 
			}catch(Exception e) {
				e.printStackTrace();

			}
		}
		
		Connection c = null;
	      Statement stmt = null;
	         JSONArray jsonArray = new JSONArray();
	         	String result="";
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection(
						"jdbc:postgresql://127.0.0.1:5432/test", "postgres",
						"4a626021-e55a");
	         c.setAutoCommit(false);

	         stmt = c.createStatement();
	         String sql="";
	       /*  String sql="select row_to_json(t) from (   select     (select count(*) from public.test) as total_count,     (select json_agg(row_to_json(tt))        from ("
	         		+ "select * from public.test order by id limit "
	         		+ limit+" offset "+offset
	         		+ ") tt) as data ) t";*/
	         
	         if(searchterm != null && !searchterm.equalsIgnoreCase("")) {
	        	 sql="SELECT 	row_to_json (T)   FROM 	( 		SELECT 			( 				SELECT 					COUNT (*) 				FROM 					PUBLIC .chotitable 			) AS total_count, 			( 				SELECT 					json_agg (row_to_json(tt)) 				FROM 					( 						SELECT 							* 						FROM 							PUBLIC .chotitable where lower(name) like '%"
		        	 		+ searchterm
		        	 		+ "%'  OR lower(email) like '%"
		        	 		+ searchterm + "%' OR lower(gender) like '%"
		        	 		+ searchterm + "%' OR lower(address) like '%"
		        	 		+ searchterm + "%' 						ORDER BY 							ID 						LIMIT "
		        	 		+ limit
		        	 		+ " OFFSET "
		        	 		+ offset
		        	 		+ " 					) tt 			) AS DATA 	) T";
	         }else {
	        	 sql =" SELECT 	row_to_json (T) FROM 	( 		SELECT 			(SELECT	COUNT (*)FROM	PUBLIC .chotitable 			) AS total_count, 			(SELECT	json_agg (row_to_json(tt))FROM	(		SELECT			*		FROM			PUBLIC .chotitable		ORDER BY			ID		"
	 	         		+ "LIMIT "
	 	         		+ limit
	 	         		+ " OFFSET "
	 	         		+ offset
	 	         		+ "	) tt 			) AS DATA 	) T";
	        	
	         }
	         System.out.println("query "  + sql);
	         ResultSet rs = stmt.executeQuery( sql );
	          			
	          while(rs.next()){
	              String myResults = rs.getString(1);
	              result = myResults;
	          }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      
	      response.getWriter().println(result);
	      
	      
	      }

	private void generate_table() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Integer limit =10;
		Integer offset =0 ;
		Integer showentries = null;
		String searchterm = null;
		
		if(request.getParameter("limit") !=null) {
			try {
				limit= Integer.parseInt(request.getParameter("limit").toString());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("limit --> "+limit);
		if(request.getParameter("offset") !=null) {
			try {
				offset= Integer.parseInt(request.getParameter("offset").toString());
				 
			}catch(Exception e) {
				e.printStackTrace();

			}
		}
		
		if(request.getParameter("showentries") !=null) {
			try {
				showentries= Integer.parseInt(request.getParameter("showentries").toString());
				 
			}catch(Exception e) {
				e.printStackTrace();

			}
		}
		if(request.getParameter("searchterm") !=null) {
			try {
				searchterm= request.getParameter("searchterm").toString();
				 
			}catch(Exception e) {
				e.printStackTrace();

			}
		}
		
		NewDatatableService datatableService = new NewDatatableService();

		response.getWriter().println(datatableService.getDataTable(1,limit,offset,showentries,searchterm));
		
		//doGet(request, response);
	}

}
