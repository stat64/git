package controllers;

import models.Usuario;
import play.Play;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import controllers.Secure.Security;
import controllers.deadbolt.Deadbolt;

/*
 * Controlador comun para todo el sistema
 */

@With({ Secure.class, Deadbolt.class })
public class GlobalController extends Controller {

	public static String userName;

	@Before
	public static void initUser() {


		userName = Security.connected();

		if (userName != null && userName.length() > 0) {
			// Usuario findOne = (Usuario) Usuario.findOne(userName);
			session.put("username", userName);
			renderArgs.put("user", RegistroCentral.getUsuarioConectado());
		} else
			;

		renderArgs.put("context", Play.configuration.getProperty("http.path"));

		renderArgs.put("mostrarMatriz", Boolean.parseBoolean(Play.configuration
				.getProperty("mostrarMatriz")));


		String originalUserName = session.get("usernameOriginal");

		session.remove("usuarioOriginal");
		session.remove("sesionImpersonada");

		if (originalUserName != null) {

			Usuario usuarioOriginal = Usuario.findOne(originalUserName);
			//Usuario usuarioOriginal = null;
			if (usuarioOriginal == null)
				throw new IllegalStateException("Usuario original "
						+ originalUserName + " no encontrado");

			session.put("sesionImpersonada", true);
			renderArgs.put("usuarioOriginal", usuarioOriginal);
		} else
			session.put("sesionImpersonada", false);

	}

	public static Usuario usuarioConectado() {

		return RegistroCentral.getUsuarioConectado();

	}

}
