package br.com.treinamentos.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="objeto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ObjectResponse {
	
	@XmlElement(name="numero")
	private String number;
	
	@XmlElement(name="sigla")
	private String initials;
	
	@XmlElement(name="nome")
	private String name;
	
	@XmlElement(name="categoria")
	private String category;
	
	@XmlElement(name="evento")
	private EventResponse event;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public EventResponse getEvent() {
		return event;
	}

	public void setEvent(EventResponse event) {
		this.event = event;
	}

}
