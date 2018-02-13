package dropdown;

import java.io.StringWriter;
import java.util.HashSet;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.json.JSONObject;




public class DropdownHtml {

	
	public DropdownHtml() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDropDownHtml() {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		/* next, get the Template */
		Template t = ve.getTemplate("templates/dropdown/dropdown.vm");
		JSONObject jsonObject = new JSONObject();
		VelocityContext context = new VelocityContext();
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		/* show the World */
		System.out.println(writer.toString());
		return writer.toString();
	}
}
