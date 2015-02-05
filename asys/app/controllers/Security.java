package controllers;

import models.Usuario;

public class Security extends Secure.Security {

	static boolean authentify(String userName, String password) {
		Usuario usuario = Usuario.connect(userName, password);
		if (usuario != null && usuario.esInactivo)
			return false;

		return usuario != null;
	}

}