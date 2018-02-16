package component.group;

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

public class GroupUserList {

	public GroupUserList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getGroupDetailsData(Integer id) throws IOException {
		  VelocityEngine ve = new VelocityEngine();
		  HashSet<String> groupType=new HashSet<>();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        	
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/group/group_user_list.vm" );
	       
	        /*  create a context and add data */
	        HttpUtils httpUtils = new HttpUtils();
	        String responseData = httpUtils.makeHttpCall("http://192.168.1.13:8080/istar/rest/group/details/"+id, "GET");
	       JSONObject json =  new JSONObject(responseData);
	        
	        System.err.println();
	        VelocityContext context = new VelocityContext();
	        context.put("data",json );
	      /*  context.put("dropdown", getDropDown(ve,context,json,"Group Name","group-card-shadow","groupName") );
	        context.put("dropdown1", getDropDown(ve,context,json,"Group Type","group-card-shadow","groupType") );*/

	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        System.out.println( writer.toString() );
	        return writer.toString();
	}
		
}
