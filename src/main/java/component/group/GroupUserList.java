package component.group;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.json.JSONArray;
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
	        String responseData = httpUtils.makeHttpCall("http://127.0.0.1:8080/istar/rest/group/details/"+id, "GET");
	       JSONObject json =  new JSONObject(responseData);
	        
	        System.err.println();
	        String responseDataCreateUser = httpUtils.makeHttpCall("http://127.0.0.1:8080/istar/rest/user/create/3", "GET");
	        JSONObject jsonDataForCreateUser =  new JSONObject(responseDataCreateUser);

	        VelocityContext context = new VelocityContext();
	        context.put("data",json );
	        context.put("jobRole",getDropDownMultiSelect(ve, context, jsonDataForCreateUser.getJSONObject("data").getJSONArray("job_roles"), "Job Roles", "jobRoles") );
	        context.put("unit",getDropDownMultiSelect(ve, context, jsonDataForCreateUser.getJSONObject("data").getJSONArray("units"), "Units", "units") );
	        context.put("license",getDropDownMultiSelect(ve, context, jsonDataForCreateUser.getJSONObject("data").getJSONArray("licenses"), "License", "licenses") );
	        context.put("groups",getDropDownMultiSelect(ve, context, jsonDataForCreateUser.getJSONObject("data").getJSONArray("groups"), "Group", "groups") );

	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        System.out.println( writer.toString() );
	        return writer.toString();
	}
	
	public String getDropDownMultiSelect(VelocityEngine ve,VelocityContext context,JSONArray jsonArray,String name,String attribute_name ) {
	       JSONArray groupNamesArray=new JSONArray();
	        for (int i = 0;i < jsonArray.length(); i++) {
	        	JSONObject jsonObject=new JSONObject();
	        	jsonObject.put("name", jsonArray.getJSONObject(i).getString("name"));
	        	jsonObject.put("id", jsonArray.getJSONObject(i).getInt("id"));
	        	jsonObject.put("is_mapped", jsonArray.getJSONObject(i).getBoolean("is_mapped"));
	        	groupNamesArray.put(jsonObject);
	        }
		    context.put("attribute_name", attribute_name);
	        System.err.println();
	        context.put("optionsArray", groupNamesArray);
	        context.put("dropdown_name", name);	       
	        Template t1 = ve.getTemplate( "templates/dropdown/dropdown_multiselect.vm" );
	        StringWriter writer = new StringWriter();
	        t1.merge( context, writer);
		
		return writer.toString();
	}
		
}
