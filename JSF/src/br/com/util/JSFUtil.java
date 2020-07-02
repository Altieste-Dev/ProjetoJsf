package br.com.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class JSFUtil {

	public static void adicionarMensagemSucesso(String mensagem) {		//Titulo, Texto
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem); //Tipo de mensagem "informação"
		FacesContext contexto = FacesContext.getCurrentInstance(); //Coloca a mensagem de acordo com o contexto		
		contexto.addMessage(null, msg);
	}
	
	public static void adicionarMensagemErro(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem); //Tipo de mensagem "Erro"
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
}