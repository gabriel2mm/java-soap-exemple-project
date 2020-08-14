package br.com.treinamentos.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "return")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReturnResponse {

	@XmlElement(name="versao")
	private String version;
	
	@XmlElement(name="qtd")
	private  String quantity;
	
	@XmlElement(name="objeto")
	private ObjectResponse object;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public ObjectResponse getObject() {
		return object;
	}

	public void setObject(ObjectResponse object) {
		this.object = object;
	}
	
}
