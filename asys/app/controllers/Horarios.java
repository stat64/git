package controllers;

import java.util.List;

import models.Usuario;
import models.UsuarioProfesor;
import play.mvc.Controller;

public class Horarios extends Controller {
	public static void horario() {
		UsuarioProfesor usuario = inicializar();
		render(usuario);
	}

	// FUNCION QUE ENVIA OBJETO A HTML
	private static UsuarioProfesor inicializar() {
		// TODO Auto-generated method stub
		// Store store = new Store();
		// store.save();

		UsuarioProfesor usuario = new UsuarioProfesor();
		usuario.crearHorario(Long.valueOf(1), "Hora", "Lunes", "Martes",
				"Miercoles", "Jueves", "Viernes", "Sabado");		
		return usuario;

	}
	
}
