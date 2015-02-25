package models;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import play.data.validation.Email;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;
import play.modules.search.Field;

@Entity
public class Actividad extends Model {
	public long code;
	// Campos

	@Required
	public String actividad;

	@Required
	@Unique
	public String acronimo;
	@Required
	@ManyToOne
	public Ubicacion ubicacion;
	// Lista de Actividades
	// fin campos

	public Actividad(long code, String actividad, String acronimo,Ubicacion ubicacion) {
		this.code = code;
		this.actividad = actividad;
		this.acronimo = acronimo;
		this.ubicacion= ubicacion;
	}
	public void CrearUbicacion(Long codigo, String Edificio, String Piso,String Aula){
		Ubicacion ubicacion = new Ubicacion(codigo, Edificio, Piso, Aula);
		ubicacion.save();
	}
	public String toString() {
		return actividad;
	}
	// fin Ubicaciones
}
