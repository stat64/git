package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import models.*;

//para trabajar con login
//public class Application extends GlobalController {
public class Application extends Controller {

	public static void index() {
		
		render();
	}

	public static void list(String search, Integer size, Integer page) {
		List<Usuario> docen = null;
		page = page != null ? page : 1;
		if (search.trim().length() == 0) {
			docen = Usuario.all().fetch(page, size);
		} else {
			search = search.toLowerCase();
			docen = Usuario.find(
					"lower(nombre) like ?1 OR lower(cedula) like ?2 ",
					"%" + search + "%", "%" + search + "%").fetch(page, size);
		}
		render(docen, search, size, page);
		System.out.println("Si se llama a la funcion");
	}

	public void horario(long Nro, String Hora, String Lunes, String Martes,
			String Miercoles, String Jueves, String Viernes, String Sabado) {
		UsuarioProfesor usuarioProfesor = new UsuarioProfesor();
		usuarioProfesor.crearHorario(Nro, Hora, Lunes, Martes, Miercoles,
				Jueves, Viernes, Sabado);
		usuarioProfesor.save();
	}

}