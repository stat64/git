package models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import controllers.Actividades;
import play.db.jpa.Model;

@Entity
public class Ubicacion extends Model {
	
	public Long code;
	public String Edificio;
	public String Piso;
	public String Aula;
	

	public Ubicacion(Long codigo,String Edificio, String Piso, String Aula) {
		this.code=codigo;
		this.Edificio = Edificio;
		this.Piso=Piso;
		this.Aula=Aula;
	}
	public String toString() {
		return "Edf: "+Edificio+" Piso: "+Piso+" Aula: "+Aula;
	}
	
}
	
	
