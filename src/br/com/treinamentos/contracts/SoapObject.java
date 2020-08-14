package br.com.treinamentos.contracts;

import javax.xml.soap.SOAPMessage;

public interface SoapObject<T> {
	public SOAPMessage createSOAPMessage();
}
