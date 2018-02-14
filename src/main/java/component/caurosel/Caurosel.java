package component.caurosel;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.json.JSONObject;

import component.http.HttpUtils;

public class Caurosel {

	public Caurosel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getEventCards() throws IOException {
		  VelocityEngine ve = new VelocityEngine();
		  HashSet<String> groupType=new HashSet<>();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/caurosel/event.vm" );
	        /*  create a context and add data */
	        HttpUtils httpUtils = new HttpUtils();
	        String responseData = httpUtils.makeHttpCall("http://192.168.1.13:8080/istar/rest/principal/dashboard/3/todays_training_projects", "GET");
	       JSONObject json =  new JSONObject(responseData);
	        System.err.println();
	        VelocityContext context = new VelocityContext();
	        context.put("data",json );
	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        return writer.toString();
	}
	
	
	
	public String getProductivityCards() throws IOException {
		  VelocityEngine ve = new VelocityEngine();
		  HashSet<String> groupType=new HashSet<>();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/caurosel/productivity.vm" );
	        /*  create a context and add data */
	        HttpUtils httpUtils = new HttpUtils();
	        String responseData = httpUtils.makeHttpCall("http://192.168.1.13:8080/istar/rest/principal/dashboard/3/todays_deals", "GET");
	       JSONObject json =  new JSONObject(responseData);
	        
	        System.err.println();
	        VelocityContext context = new VelocityContext();
	       

	      

	        context.put("data",json );
	       

	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        return writer.toString();
	}
	
	
	public String getElearingCards() throws IOException {
		  VelocityEngine ve = new VelocityEngine();
		  HashSet<String> groupType=new HashSet<>();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        	
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/caurosel/elearning.vm" );
	       
	        /*  create a context and add data */
	        HttpUtils httpUtils = new HttpUtils();
	        String responseData = httpUtils.makeHttpCall("http://192.168.1.13:8080/istar/rest/principal/dashboard/3/todays_group_learning_projects", "GET");
	       JSONObject json =  new JSONObject(responseData);
	        
	        System.err.println();
	        VelocityContext context = new VelocityContext();
	       

	      

	        context.put("data",json );
	       

	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        return writer.toString();
	}
}
