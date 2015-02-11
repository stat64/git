package models;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Horario extends Model {

	long Nro;
	String Hora;
	String Lunes;
	String Martes;
	String Miercoles;
	String Jueves;
	String Viernes;
	String Sabado;

	public Horario(long Nro, String Hora, String Lunes, String Martes,
			String Miercoles, String Jueves, String Viernes, String Sabado) {
		this.Nro= Nro;
		this.Hora = Hora;
		this.Lunes = Lunes;
		this.Martes = Martes;
		this.Miercoles = Miercoles;
		this.Jueves = Jueves;
		this.Viernes =Viernes;
		this.Sabado = Sabado;
	}

}
