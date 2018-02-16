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

public class Group {

	
	
	
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGroupCards() throws IOException {
		  VelocityEngine ve = new VelocityEngine();
		  HashSet<String> groupType=new HashSet<>();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        	
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/group/group.vm" );
	       
	        /*  create a context and add data */
	        HttpUtils httpUtils = new HttpUtils();
	        String responseData = httpUtils.makeHttpCall("http://192.168.1.13:8080/istar/rest/group/all/3", "GET");
	       JSONObject json =  new JSONObject(responseData);
	        
	        System.err.println();
	        VelocityContext context = new VelocityContext();
	       

	      

	        context.put("data",json );
	        context.put("dropdown", getDropDown(ve,context,json,"Group Name","group-card-shadow","groupName") );
	        context.put("dropdown1", getDropDown(ve,context,json,"Group Type","group-card-shadow","groupType") );

	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        System.out.println( writer.toString() );
	        return writer.toString();
	}
	
	
	public String getDropDown(VelocityEngine ve,VelocityContext context,JSONObject json,String name,String search_div_name,String attribute_name ) {
		 JSONArray jsonArray = (JSONArray) json.get("data");
	        HashSet<String> groupName = new HashSet<>();
	        for (int i = 0;i < jsonArray.length(); i++) {
	        	System.out.println(jsonArray.getJSONObject(i).get("name"));
	        	if(name.equalsIgnoreCase("Group Name"))
	        	groupName.add(jsonArray.getJSONObject(i).get("name").toString());
	        	else
		        	groupName.add(jsonArray.getJSONObject(i).get("group_type").toString());
	
	        }
	        


		        context.put("attribute_name", attribute_name);

	        context.put("search_div_name", search_div_name);

	        System.err.println();
	        context.put("optionsArray", groupName);
	        context.put("dropdown_name", name);	       
	        Template t1 = ve.getTemplate( "templates/dropdown/dropdown.vm" );
	        StringWriter writer = new StringWriter();
	        t1.merge( context, writer);
		
		return writer.toString();
	}
}
