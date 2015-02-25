package controllers;

import java.util.List;

import models.Actividad;
import models.Dia;
import models.Hora;
import models.Horario;
import models.HorarioV;
import models.Usuario;
import models.UsuarioProfesor;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.Controller;

public class Horarios extends Controller {
	public static void horario() {

		// Horario hora =inicializar();
		// render(hora);
	}

	public static void docente(long codigo) {
		Long val = codigo;

		// String search="TOPICOS ESPECIALES";
		List<Usuario> usuarios = null;
		usuarios = Usuario.find("id", codigo).fetch();
		List<HorarioV> horarios = null;
		List<Actividad> actividades = null;
		// horarios=Horario.all().fetch();
		// horarios=Horario.find("upper(Lunes) like ?1","%"+search+"%").fetch();
		horarios = HorarioV.find("usuario_id", codigo).fetch();
		actividades=Actividad.findAll();
		List<Dia> dias = null;
		dias = Dia.findAll();
		List<Hora> horas = null;
		horas = Hora.findAll();
		
		render(val, horarios, usuarios, dias,horas,actividades);
	}

}
