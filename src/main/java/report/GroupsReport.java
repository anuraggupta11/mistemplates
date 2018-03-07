package report;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;

import component.http.HttpUtils;

public class GroupsReport {

	public GroupsReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getGroupReportData() throws IOException {
		  VelocityEngine ve = new VelocityEngine();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        	
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/report/groups_report.vm" );
	       
	        /*  create a context and add data */
	        HttpUtils httpUtils = new HttpUtils();
	        String responseData = httpUtils.makeHttpCall("http://127.0.0.1:8080/istar/rest/principal/dashboard/3/get_all_groups_reports", "GET");
	       JSONObject json =  new JSONObject(responseData);

	       VelocityContext context = new VelocityContext();
	       context.put("data",json );
	       
	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        System.out.println( writer.toString() );
	        return writer.toString();
	}
	
	public String getGroupReportDetail(Integer groupId) throws IOException {
		  VelocityEngine ve = new VelocityEngine();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        	
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/report/individual_groups_report.vm" );
	       
	        /*  create a context and add data */
	        HttpUtils httpUtils = new HttpUtils();
	        String responseData = httpUtils.makeHttpCall("http://127.0.0.1:8080/istar/rest/group/3/get_groups_stats_performance/"+groupId, "GET");
	        
	        JSONObject json =  new JSONObject(responseData);
	        
	       VelocityContext context = new VelocityContext();
	       context.put("data",json );
	     
	       
	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        System.out.println( writer.toString() );
	        return writer.toString();
	}
	

}
