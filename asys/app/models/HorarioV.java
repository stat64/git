package models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class HorarioV extends Model {
	public Long code;
	@Required
	@ManyToOne
	public Hora hora;
	@Required
	@ManyToOne
	public Dia dia;
	@Required
	@ManyToOne
	public Actividad actividad;
	@Required
	@ManyToOne
	public UsuarioProfesor usuario;

	public HorarioV(Long code, Hora hora, Dia dia, Actividad actividad,
			UsuarioProfesor usuario) {
		this.code = code;
		this.hora = hora;
		this.dia = dia;
		this.actividad = actividad;
		this.usuario = usuario;

	}
	public String toString() {
		return dia+" "+hora+" "+actividad;
	}
	public void CrearDia(Long codi, String dia){
		Dia Ndia= new Dia(codi, dia);
		Ndia.save();
	}
	public void CrearActividad(String type,long code,String actividad,String acronimo,Ubicacion ubicacion){
		if(type=="clases"){
		ActividadClase NactividadClase= new ActividadClase();
		NactividadClase.code=code;
		NactividadClase.actividad=actividad;
		NactividadClase.acronimo=acronimo;
		NactividadClase.ubicacion=ubicacion;
		NactividadClase.save();
		}
		if(type=="docencia"){
			ActividadDocencia NactividadDocencia= new ActividadDocencia();
			NactividadDocencia.code=code;
			NactividadDocencia.actividad=actividad;
			NactividadDocencia.acronimo=acronimo;
			NactividadDocencia.ubicacion=ubicacion;
			NactividadDocencia.save();
			}
		
	}
	public void CrearUsuario(String cedula,String email,String nombre,String password,String Username){
		UsuarioProfesor usuario1 = new UsuarioProfesor();
		usuario1.cedula = cedula;
		usuario1.email = email;
		usuario1.esInactivo = false;
		// Calendar test=
		// usuario1.fecIng=23122014;
		usuario1.nombre = nombre;
		usuario1.password = password;
		usuario1.userName = Username;
		usuario1.save();
	}
	public void CrearHora(Long code,String hora){
		Hora Nhora= new Hora(code, hora);
		Nhora.save();
	}
	
	
}
