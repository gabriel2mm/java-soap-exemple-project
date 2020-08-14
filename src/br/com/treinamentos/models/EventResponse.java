package br.com.treinamentos.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="evento")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventResponse {

	@XmlElement(name="tipo")
	private String type;
	
	@XmlElement(name = "status")
	private String status;
	
	@XmlElement(name="data")
	private String date;
	
	@XmlElement(name="hora")
	private String hour;
	
	@XmlElement(name="descricao")
	private String description;
	
	@XmlElement(name = "local")
	private String local;
	
	@XmlElement(name="codigo")
	private String code;

	@XmlElement(name="cidade")
	private String city;
	
	@XmlElement(name="uf")
	private String state;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


}
