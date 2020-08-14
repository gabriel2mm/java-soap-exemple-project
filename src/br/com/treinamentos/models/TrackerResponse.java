package br.com.treinamentos.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "buscaEventosResponse", namespace = "http://resource.webservice.correios.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
public class TrackerResponse implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "return")
	private ReturnResponse returnResponse;

	public ReturnResponse getReturnResponse() {
		return returnResponse;
	}

	public void setReturnResponse(ReturnResponse returnResponse) {
		this.returnResponse = returnResponse;
	}
}
