package br.com.treinamentos.beans;

import java.text.MessageFormat;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.treinamentos.consume.utils.ConvertObjectUtils;
import br.com.treinamentos.consume.utils.SendSoapObject;
import br.com.treinamentos.consume.webservices.TrackerRequestSoap;
import br.com.treinamentos.models.TrackerRequest;
import br.com.treinamentos.models.TrackerResponse;

@ManagedBean(name = "trackerBean")
@RequestScoped
public class TrackerBean {

	private String trackerCode;
	private TrackerRequest trackerRequest;
	private TrackerResponse trackerResponse;
	private static final Logger LOGGER = LogManager.getLogger(TrackerBean.class);
	private static final String ENDPOINT = "http://webservice.correios.com.br/service/rastro";

	@PostConstruct
	public void init() {
		trackerRequest = new TrackerRequest();
		trackerRequest.setLingua("101");
		trackerRequest.setResultado("T");
		trackerRequest.setTipo("L");
		trackerRequest.setUsuario("ECT");
		trackerRequest.setSenha("SRO");
	}

	public String createRequest() {
		
		if (this.trackerCode == null || this.trackerCode.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Preencha o código de rastreio"));
			return null;
		} 
		
		try {
			trackerRequest.setObjetos(this.trackerCode);
			
			TrackerRequestSoap soap = new TrackerRequestSoap();
			soap.setTrackerRequest(trackerRequest);
			
			SendSoapObject soapSendSoapObject = SendSoapObject.newInstance();
			soapSendSoapObject.setEndpoint(ENDPOINT);
		
			SOAPMessage soapResponse = soapSendSoapObject.sendSoap(soap);
			
			if(soapResponse.getSOAPBody().hasFault()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro ao verificar resposta com o servidor"));
				return null;
			}
			
			trackerResponse = (TrackerResponse) ConvertObjectUtils.newInstance().createObjectFromXml(soapResponse.getSOAPBody().extractContentAsDocument(), TrackerResponse.class);
			
		} catch (Exception e) {
			LOGGER.error(MessageFormat.format("Não foi possível criar requisição [{0}] - [{1}]", e.getMessage(),
					e.getCause()));
		}

		return "index";
	}

	public String getTrackerCode() {
		return this.trackerCode;
	}

	public void setTrackerCode(String trackerCode) {
		this.trackerCode = trackerCode;
	}

	public TrackerResponse getTrackerResponse() {
		return trackerResponse;
	}

	public void setTrackerResponse(TrackerResponse trackerResponse) {
		this.trackerResponse = trackerResponse;
	}
}
