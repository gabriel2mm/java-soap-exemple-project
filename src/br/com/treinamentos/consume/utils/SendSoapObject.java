package br.com.treinamentos.consume.utils;

import java.text.MessageFormat;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.treinamentos.contracts.SoapObject;

public class SendSoapObject {

	private String endpoint;
	private static SendSoapObject _instance;
	private static final Logger LOGGER = LogManager.getLogger(SendSoapObject.class);

	public static SendSoapObject newInstance() {
		if (_instance == null) {
			_instance = new SendSoapObject();
		}
		return _instance;
	}

	public SOAPMessage sendSoap(SoapObject<?> obj) throws Exception {
		SOAPMessage soapMessage = obj.createSOAPMessage();
		
		if(soapMessage == null) {
			throw new Exception("Não foi possível criar requisição soap");
		}
		
		SOAPConnectionFactory soapConnectionFactory = null;
		try {
			soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			SOAPMessage soapResponse = soapConnection.call(soapMessage, this.endpoint);

			return soapResponse;			
		} catch (UnsupportedOperationException | SOAPException e) {
			LOGGER.error(MessageFormat.format("Não foi possível criar requisição SOAP [{0}]", e.getMessage()));
		}
		
		return null;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}
