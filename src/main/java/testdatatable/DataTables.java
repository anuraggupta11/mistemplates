package testdatatable;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class DataTables {
	ArrayList<DataTable> datatables = new ArrayList<>();

	public DataTables() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataTables(ArrayList<DataTable> datatables) {
		super();
		this.datatables = datatables;
	}

	@XmlElement(name="DataTable")
	public ArrayList<DataTable> getDataTable() {
		return datatables;
	}

	public void setDataTable(ArrayList<DataTable> datatables) {
		this.datatables = datatables;
	}
	
}
