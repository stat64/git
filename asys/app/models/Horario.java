package models;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Horario extends Model {

	int Nro;

	String Hora;
	String Lunes;
	String Martes;
	String Miercoles;
	String Jueves;
	String Viernes;
	String Sabado;

	public Horario(long Nro, String Hora, String Lunes, String Martes,
			String Miercoles, String Jueves, String Viernes, String Sabado) {
		Nro = this.Nro;
		Hora = this.Hora;
		Lunes = this.Lunes;
		Martes = this.Martes;
		Miercoles = this.Miercoles;
		Jueves = this.Jueves;
		Viernes = this.Viernes;
		Sabado = this.Sabado;
	}

}
