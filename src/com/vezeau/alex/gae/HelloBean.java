package com.vezeau.alex.gae;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "helloBean")
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String summary;
	private String url;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormattedName() {
		Dao.INSTANCE.add(name, summary, description, url);

		return "Hello, " + name + "!";
	}

	public Todo[] getNames() {

		List<Todo> todos = Dao.INSTANCE.listTodos();

		return todos.toArray(new Todo[todos.size()]);

	}

}
