package models;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import models.deadbolt.Role;
import play.db.jpa.Model;

@Entity
public class MyRole extends Model implements Role {

	private String name;

	@ManyToMany(mappedBy = "roles")
	public Set<Usuario> usuarios;

	@Override
	public String toString() {
		return name;
	}



	public String getRoleName() {
		return name;
	}

	public static MyRole ADMINISTRADOR() {

		return MyRole.findById(1L);
	}

	public static MyRole ALUMNO() {

		return MyRole.findById(3L);
	}
	
	public static MyRole PROFESOR() {

		return MyRole.findById(5L);
	}


	public static MyRole ROOT() {

		return MyRole.findById(100L);
	}



}