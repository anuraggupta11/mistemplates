package testdatatable;

import javax.xml.bind.annotation.XmlAttribute;

public class Column {
	private String name;
	private Boolean dropDownFilter = false;
	private String searchTerm ="";
	public Column() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Column(String name) {
		super();
		this.name = name;
	}

	@XmlAttribute(name = "name")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	@XmlAttribute(name = "dropDownFilter")
	public Boolean getDropDownFilter() {
		return dropDownFilter;
	}

	public void setDropDownFilter(Boolean dropDownFilter) {
		this.dropDownFilter = dropDownFilter;
	}

	
	@XmlAttribute(name = "searchTerm")
	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	
}
