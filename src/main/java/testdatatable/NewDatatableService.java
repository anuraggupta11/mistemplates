package testdatatable;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.json.JSONObject;

import com.google.gson.JsonObject;

import component.http.HttpUtils;

public class NewDatatableService {

	
	public NewDatatableService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDataTable(Integer id,Integer limit, Integer offset, Integer showentries,String searchterm,String colmun_search_field,String sorted) throws IOException {
		
		ClassLoader classLoader =TestDatatableService.class.getClassLoader();
		 File file = new File(classLoader.getResource("datatable/table.xml").getFile());
	        JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(DataTables.class);
			
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        DataTables dataTables= (DataTables) jaxbUnmarshaller.unmarshal(file);
	        for(DataTable dataTable: dataTables.getDataTable()) {
	        	if(dataTable.getId() == id) {
	        		
	        		
	        		return getDataTableHtml(dataTable,limit,offset,showentries,searchterm,colmun_search_field,sorted);
	        	}
	        }
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;  
		
		
		
		
	}
	
	
	private String getDataTableHtml(DataTable dataTable,Integer limit, Integer offset,Integer showentries,String searchterm,String colmun_search_field,String sorted) {
		  VelocityEngine ve = new VelocityEngine();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        	
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "templates/datatable/datatable.vm" );
	        VelocityContext context = new VelocityContext();
			HttpUtils httpUtils = new HttpUtils();
			String response="";
	        try {
	        if(limit != null) {
    			dataTable.setLimit(limit);
    			if(offset != null) {
        			dataTable.setOffset(offset);
        			if(limit != null && offset != null ) {
        				if(showentries != null ) {
                			dataTable.setShowentries(showentries);
                			if(searchterm != null)
                				dataTable.setSearchterm(searchterm);
            				response = httpUtils.makeHttpCall(dataTable.getUrl()+"?limit="+limit+"&offset="+offset
            						+"&showentries="+showentries+"&searchterm="+searchterm
            						+"&colmun_search_field="+colmun_search_field+"&sorted="+URLEncoder.encode(sorted), "GET");
        				}else {
        				response = httpUtils.makeHttpCall(dataTable.getUrl()+"?limit="+limit+"&offset="+offset, "GET");
        				}
        				
        				
        				if(sorted != null && !sorted.equalsIgnoreCase("")) {
        					JSONObject jsonObject = new JSONObject(sorted);
        					for(Column column: dataTable.getColumns()) {
        						String val = jsonObject.get(column.getName()).toString();
        						column.setSorting(val);
        					}
        				}
        			}

        		}
    		}else {
				response = httpUtils.makeHttpCall(dataTable.getUrl(), "GET");
					
    		}
	        
			
				JSONObject jsonObject = new JSONObject(response);
				
				Integer total_count= jsonObject.getInt("total_count");
		        context.put("datatable",dataTable);
				context.put("count",total_count);
		        context.put("responseSelect",jsonObject);
		        context.put("response",jsonObject);
		        if(colmun_search_field != null && !colmun_search_field.equalsIgnoreCase("") ) {
			        context.put("colmun_search_field",colmun_search_field);

		        }else {
			        context.put("colmun_search_field","");

		        }

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        //System.out.println( writer.toString() );
	        return writer.toString();
	}
}
