package testdatatable;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class DataTable {
	
	private Integer id;
	private String url;
	private ArrayList<Column> columns = new ArrayList<>();
	private Integer limit =10;
	private Integer offset =0;

	private boolean sorting;
	private boolean searching;
	
	public DataTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataTable(Integer id,ArrayList<Column> columns,String url) {
		super();
		this.columns = columns;
		this.id=id;
		this.url=url;
	}
	
	public DataTable(Integer id,ArrayList<Column> columns,String url,Integer limit) {
		super();
		this.columns = columns;
		this.id=id;
		this.url=url;
		this.limit = limit;
	}

	
	@XmlElement(name = "column")
	public ArrayList<Column> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<Column> columns) {
		this.columns = columns;
	}

	@XmlAttribute(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlAttribute(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	@XmlAttribute(name = "limit")
	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@XmlAttribute(name = "sorting")
	public boolean isSorting() {
		return sorting;
	}


	public void setSorting(boolean sorting) {
		this.sorting = sorting;
	}

	@XmlAttribute(name = "searching")
	public boolean isSearching() {
		return searching;
	}

	public void setSearching(boolean searching) {
		this.searching = searching;
	}

	public Integer getOffset() {
		return offset;
	}

	@XmlAttribute(name = "offset")
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	
}
