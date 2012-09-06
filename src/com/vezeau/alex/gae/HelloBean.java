package com.vezeau.alex.gae;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormattedName() {
		Dao.INSTANCE.add(name, "summary", "description",
				String.valueOf(System.currentTimeMillis()));

		return "Hello, " + name + "!";
	}

	public Todo[] getAllEntries() {
		List<Todo> todos = Dao.INSTANCE.getTodos(name);
		
		return todos.toArray(new Todo[todos.size()]);
	}
	
	public void setAllEntries(Todo[] todos) {
		
	}	

}
