package testdatatable;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.github.javafaker.Faker;

public class TestDataTable {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		Faker faker =new Faker();
		ArrayList<Column> columns = new ArrayList<>();
		columns.add(new Column("address"));
		columns.add(new Column("gender"));
		columns.add(new Column("phone"));
		columns.add(new Column("name"));
		columns.add(new Column("id"));
		columns.add(new Column("email"));

		
		DataTable dataTable = new DataTable(1,columns,"http://localhost:8080/mistemplates/GetDataTable");
		DataTable dataTable1 = new DataTable(2,columns,"http://localhost:8080/mistemplates/GetDataTable");

		
		ArrayList<DataTable> datatables = new ArrayList<>();
		dataTable.setSearching(true);
		
		datatables.add(dataTable);
		dataTable1.setSorting(true);
		datatables.add(dataTable1);
		DataTables dataTables2 = new DataTables(datatables);
		
		 JAXBContext context = JAXBContext.newInstance(DataTables.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        m.marshal(dataTables2, System.out);

	}

}
