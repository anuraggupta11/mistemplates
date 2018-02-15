package testdatatable;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;

import component.http.HttpUtils;

public class DatatableService {

	public String getDataTable(Integer id) {
		ClassLoader classLoader =TestDatatableService.class.getClassLoader();
		 File file = new File(classLoader.getResource("datatable/table.xml").getFile());
	        JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(DataTables.class);
			
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        DataTables dataTables= (DataTables) jaxbUnmarshaller.unmarshal(file);
	        for(DataTable dataTable: dataTables.getDataTable()) {
	        	if(dataTable.getId() == id) {
	        		return createHtmlString(dataTable);
	        	}
	        }
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
		return null;
	}
	
	private String createHtmlString(DataTable dataTable) {
		try {
		StringBuffer sb = new StringBuffer();
		String url = dataTable.getUrl();
		HttpUtils httpUtils = new HttpUtils();
		String response = httpUtils.makeHttpCall(url, "GET");
		JSONObject jsonObject = new JSONObject(response);
		StringBuffer pagination = new StringBuffer();
		
		Integer total_count= jsonObject.getInt("total_count");
		if(dataTable.isSearching()) {
			sb.append("  <div class='d-flex justify-content-end'>   <div class='mr-auto p-2'>   <select class='custom-select datatable_select'>     <option selected value='10'>10</option>   <option value='20'>20</option>   <option value='30'>30</option>     <option value='40'>40</option> 	  <option value='50'>50</option> </select>      </div>   <div class='p-2'><div class='form-group'>     <input type='text' class='form-control' id='exampleFormControlInput1' placeholder='Search ...'>   </div></div> </div>");
		}
		
		sb.append("<table class='table table-bordered' data-url='"+url+"'  data-total_count='"+total_count+"' data-limit='"+dataTable.getLimit()+"'>   <thead> <tr>");
		for(Column column: dataTable.getColumns()) {
			sb.append(" <th>"+column.getName()+"</th>");	
		}
		sb.append("</tr>   </thead>   <tbody>");
		
			JSONArray jsonArray = (JSONArray) jsonObject.get("data");
			
			
			for(int i=0; i<jsonArray.length(); i++) {
				sb.append("<tr>");
				for(Column column: dataTable.getColumns()) {
					sb.append("<td>"+((JSONObject) jsonArray.get(i)).get(column.getName())+"</td>");
				}
				sb.append("</tr>");
			}
			
		
		sb.append("</tbody> </table>");

		pagination.append("<div class=\"page-selection\"></div>");
		sb.append(pagination.toString());

		return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "something went wrong oops.";
		}
	}
	
	
	
	public String getPaginatedDataTable(Integer id, int limit, int page) {
		ClassLoader classLoader =TestDatatableService.class.getClassLoader();
		 File file = new File(classLoader.getResource("datatable/table.xml").getFile());
	        JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(DataTables.class);
			
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        DataTables dataTables= (DataTables) jaxbUnmarshaller.unmarshal(file);
	        for(DataTable dataTable: dataTables.getDataTable()) {
	        	if(dataTable.getId() == id) {
	        		return createPaginatedHtmlString(dataTable,limit,page);
	        	}
	        }
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
		return null;
	}

	private String createPaginatedHtmlString(DataTable dataTable,int limit, int page) {
		try {
			StringBuffer sb = new StringBuffer();
    		dataTable.setUrl(dataTable.getUrl()+"?limit="+limit+"&page="+page);
    		dataTable.setLimit(limit);
			String url = dataTable.getUrl();
			HttpUtils httpUtils = new HttpUtils();
			

			String response = httpUtils.makeHttpCall(url, "GET");
			JSONObject jsonObject = new JSONObject(response);
			
			Integer total_count= jsonObject.getInt("total_count");
			
			
			sb.append("<table class='table table-bordered' data-url='"+url+"'  data-total_count='"+total_count+"' data-limit='"+dataTable.getLimit()+"' data-page='"+page+"'>   <thead> <tr>");
			for(Column column: dataTable.getColumns()) {
				sb.append(" <th>"+column.getName()+"</th>");	
			}
			sb.append("</tr>   </thead>   <tbody>");
			
				JSONArray jsonArray = (JSONArray) jsonObject.get("data");
				
				
				for(int i=0; i<jsonArray.length(); i++) {
					sb.append("<tr>");
					for(Column column: dataTable.getColumns()) {
						sb.append("<td>"+((JSONObject) jsonArray.get(i)).get(column.getName())+"</td>");
					}
					sb.append("</tr>");
				}
				
			
			sb.append("</tbody> </table>");
			
			return sb.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return "something went wrong oops.";
			}
	}
}
