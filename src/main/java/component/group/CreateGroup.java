package component.group;

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

import component.http.HttpUtils;

public class CreateGroup {

	public CreateGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getGroupCreationPage() throws IOException {
		  VelocityEngine ve = new VelocityEngine();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        	
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/group/create_group.vm" );
	       
	        /*  create a context and add data */
	   
	        JSONObject json =  new JSONObject();
	        
	        JSONArray jsonArray=new JSONArray();
	        jsonArray.put("DEPARTMENT");
	        jsonArray.put("SECTION");
	        jsonArray.put("JOB ROLE");
	        jsonArray.put("UNIT");
	        jsonArray.put("PRODUCT");
	        
	        System.err.println();
	        VelocityContext context = new VelocityContext();
	        context.put("data",json );
	        context.put("dropdown",  jsonArray);
	       
	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        System.out.println( writer.toString() );
	        return writer.toString();
	}
	
	


}
