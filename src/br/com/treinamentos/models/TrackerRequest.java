package br.com.treinamentos.models;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement(name = "buscaEventos", namespace = "http://resource.webservice.correios.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
public class TrackerRequest implements Serializable{
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "usuario", namespace = "", required = true, nillable = false, defaultValue = "ECT")
	private String usuario;
	@XmlElement(name = "senha", namespace = "", required = true, nillable = false, defaultValue = "SRO")
	private String senha;
	@XmlElement(name = "tipo", defaultValue = "L")
	private String tipo;
	@XmlElement(name = "resultado", defaultValue = "T")
	private String resultado;
	@XmlElement(name = "lingua", defaultValue = "101")
	private String lingua;
	@XmlElement(name = "objetos")
	private String objetos;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getLingua() {
		return lingua;
	}
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	public String getObjetos() {
		return objetos;
	}
	public void setObjetos(String objetos) {
		this.objetos = objetos;
	}
}
