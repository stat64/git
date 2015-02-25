package models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Hora extends Model {
	public long code;
	public String hora;

	public Hora(Long code, String hora) {
		this.code = code;
		this.hora = hora;

	}

	public Horario findAhorario(int code) {
		return null;
	}

	public String toString() {
		return hora;
	}
	// fin actividades
	
}
