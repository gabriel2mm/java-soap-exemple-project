package br.com.treinamentos.consume.webservices;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.text.MessageFormat;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import br.com.treinamentos.consume.utils.ConvertObjectUtils;
import br.com.treinamentos.contracts.SoapObject;
import br.com.treinamentos.models.TrackerRequest;

public class TrackerRequestSoap implements SoapObject<TrackerRequest> {

	private TrackerRequest trackerRequest;
	
	@XmlTransient
	private static final Logger LOGGER = LogManager.getLogger(TrackerRequestSoap.class);
	
	@Override
	public SOAPMessage createSOAPMessage() {
		SOAPMessage soapMessage = null;
		try {
			MessageFactory messageFactory = MessageFactory.newInstance();
			soapMessage = messageFactory.createMessage();

			SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
			soapEnvelope.removeNamespaceDeclaration("SOAP-ENV");
			soapEnvelope.addNamespaceDeclaration("res", "http://resource.webservice.correios.com.br/");
			soapEnvelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
			soapEnvelope.setPrefix("soapenv");

			SOAPHeader soapHeader = soapEnvelope.getHeader();
			soapHeader.setPrefix("soapenv");

			SOAPBody soapBody = soapEnvelope.getBody();
			soapBody.setPrefix("soapenv");

			String xml = ConvertObjectUtils.newInstance().createXMLString(trackerRequest, TrackerRequest.class);

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			Document doc = documentBuilderFactory.newDocumentBuilder()
					.parse(new InputSource(new StringReader(xml)));

			soapBody.addDocument(doc);
			soapBody.getFirstChild().setPrefix("res");
			soapMessage.saveChanges();
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			soapMessage.writeTo(out);
			
			
			LOGGER.info(out);
			
		}catch(Exception e) {
			LOGGER.error(MessageFormat.format("Não foi possível criar documento SOAP [{0}]", e.getMessage()));
		}
	
		return soapMessage;
	}

	public TrackerRequest getTrackerRequest() {
		return trackerRequest;
	}

	public void setTrackerRequest(TrackerRequest trackerRequest) {
		this.trackerRequest = trackerRequest;
	}
}
