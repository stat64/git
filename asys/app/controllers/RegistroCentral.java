package controllers;

import models.Usuario;
import play.mvc.Scope;

public class RegistroCentral {

	public static Usuario getUsuarioOriginal() {
		//return Usuario.findOne(Scope.Session.current().get("usernameOriginal"));
		return null;
	}

	public static Usuario getUsuarioConectado() {
		return Usuario.findOne(Scope.Session.current().get("username"));
		//return null;
	}

	public static Boolean getEsSesionImpersonada() {
		String s = Scope.Session.current().get("sesionImpersonada");
		boolean parseBoolean = Boolean.parseBoolean(s);
		return parseBoolean;

	}

}
