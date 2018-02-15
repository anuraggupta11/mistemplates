package testdatatable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TestDatatableService {
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		ClassLoader classLoader =TestDatatableService.class.getClassLoader();
		 File file = new File(classLoader.getResource("datatable/table.xml").getFile());
	        JAXBContext jaxbContext = JAXBContext.newInstance(DataTables.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        DataTables dataTables= (DataTables) jaxbUnmarshaller.unmarshal(file);  
	        System.out.println(dataTables.getDataTable().size());
		
	}
}
