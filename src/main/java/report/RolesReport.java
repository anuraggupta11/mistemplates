package report;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.json.JSONObject;

import component.http.HttpUtils;

public class RolesReport {

	public RolesReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRolesReportData() throws IOException {
		  VelocityEngine ve = new VelocityEngine();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        	
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/report/roles_report.vm" );
	       
	        /*  create a context and add data */
	        HttpUtils httpUtils = new HttpUtils();
	        String responseData = httpUtils.makeHttpCall("http://192.168.1.13:8080/istar/rest/principal/dashboard/3/get_all_courses_reports", "GET");
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
	public String getRoleReportDetail(Integer courseId) throws IOException {
		  VelocityEngine ve = new VelocityEngine();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        	
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/report/individual_roles_report.vm" );
	       
	        /*  create a context and add data */
	        // http://192.168.1.13:8080/istar/rest/course/3/course_stats_performance/1
	        // http://192.168.1.13:8080/istar/rest/course/3/student_enrolled/1
	        // http://192.168.1.13:8080/istar/rest/course/3/group_filter/1
	        // http://192.168.1.13:8080/istar/rest/course/3/skill_mastery_level/1/5407
	        HttpUtils httpUtils = new HttpUtils();
	        String responseData = httpUtils.makeHttpCall("http://192.168.1.13:8080/istar/rest/course/3/course_stats_performance/"+courseId, "GET");
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
