package br.com.treinamentos.consume.utils;

import java.io.StringWriter;
import java.text.MessageFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class ConvertObjectUtils {

	private static final Logger LOGGER = LogManager.getLogger(ConvertObjectUtils.class);
	private static ConvertObjectUtils _instance;

	public static ConvertObjectUtils newInstance() {
		if (_instance == null) {
			_instance = new ConvertObjectUtils();
		}

		return _instance;
	}

	public String createXMLString(Object obj, Class<?> classz) {
		try {
			JAXBContext context = JAXBContext.newInstance(classz);
			Marshaller marshaller = context.createMarshaller();
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(obj, stringWriter);

			return stringWriter.toString();
		} catch (JAXBException e) {
			LOGGER.error(MessageFormat.format("Não foi possível criar xml [{0}]", e.getLocalizedMessage()));
		}

		return null;
	}

	public Object createObjectFromXml(Document document, Class<?> cast) {
		Object obj = null;
		try {
			Unmarshaller unmarshaller = JAXBContext.newInstance(cast).createUnmarshaller();
			obj = (Object) unmarshaller.unmarshal(document);
		} catch (JAXBException e) {
			LOGGER.error(MessageFormat.format("Não foi possível converter xml para objeto [{0}]", e.getLocalizedMessage()));
		}
		
		return obj;
	}
}
