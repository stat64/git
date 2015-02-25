package models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Horario extends Model {

	
	Long code;
	String Hora;
	String Lunes;
	String Martes;
	String Miercoles;
	String Jueves;
	String Viernes;
	String Sabado;

	public Horario(Long code,String Hora, String Lunes, String Martes,
			String Miercoles, String Jueves, String Viernes, String Sabado) {
		this.code=code;
		this.Hora = Hora;
		this.Lunes = Lunes;
		this.Martes = Martes;
		this.Miercoles = Miercoles;
		this.Jueves = Jueves;
		this.Viernes =Viernes;
		this.Sabado = Sabado;
	}
	
	public String toString() {
		return "nombre: (" + code + ")";
	}
	
}
