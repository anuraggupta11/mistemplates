package testdatatable;

import javax.xml.bind.annotation.XmlAttribute;

public class Column {
	private String name;

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
	
	
}
