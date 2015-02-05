package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

import models.deadbolt.Role;
import models.deadbolt.RoleHolder;
import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.modules.search.Field;
import play.modules.search.Indexed;
import play.modules.search.Query;
import play.modules.search.Search;

/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Inheritance
@Indexed
public abstract class Usuario extends Model implements RoleHolder,
		Comparable<Usuario> {

	@Column(name = "es_inactivo")
	public Boolean esInactivo;

	@Column(name = "fec_ing")
	public Calendar fecIng = Calendar.getInstance();

	@Field
	@Required
	@Column(unique = true, nullable = false)
	@Basic(optional = false)
	public String nombre;

	@Required
	@Column(nullable = false)
	@Basic(optional = false)
	public String password;

	@Email
	@Required
	@Basic(optional = false)
	@Column(unique = true, nullable = false)
	public String email;

	@Field
	@Column(unique = true, nullable = false)
	@Required
	@Basic(optional = false)
	public String cedula;

	@Field
	@Basic(optional = false)
	@Column(name = "user_name", nullable = false)
	@Required
	public String userName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_myrole",  joinColumns = @JoinColumn(name = "usuarios_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"), uniqueConstraints = @UniqueConstraint(name = "UniqueConstraintUsuarioMyRole", columnNames = {
			"usuarios_id", "roles_id" }))
	public List<MyRole> roles;

	public static Usuario connect(String userName, String password) {

		String trimedUser = userName.toLowerCase().trim();

		if (userName.contains("@")) // Si parece email
			return find("byEmailAndPassword", trimedUser, password).first();

		else {
			return find("byUserNameAndPassword", trimedUser, password).first();
		}
	}
	
	@Override
	public List<? extends Role> getRoles() {
		// return Arrays.asList(new MyRole("foo"), new MyRole("conectado"),
		// new MyRole("admin"), new MyRole("restricted"));

		if (this.roles == null)
			return null;

		return new ArrayList(this.roles);
		// ArrayList<MyRole> arrayList = new ArrayList<MyRole>();
		// arrayList.addAll(roles);
		//
		// return arrayList;
	}

	public static Usuario findOne(String userName) {
		if (userName.contains("@"))
			return find("byEmail", userName.toLowerCase().trim()).first();

		else
			return find("byUserName", userName.toLowerCase().trim()).first();
	}

	public String toString() {
		return this.getNombreCompleto();
	}

	public String getNombreCompleto() {
		return this.nombre;
	}

	public static Usuario systemUser() {

		return Usuario.findById(1L);
	}

	@Override
	public int compareTo(Usuario o) {

		return this.getNombreCompleto().compareToIgnoreCase(
				o.getNombreCompleto());
	}

	public static List<Usuario> buscarUsuario(String query) {

		String[] palabrasArray;
		String delimiter = "\\|";

		if (query == null || query.length() == 0)
			throw new IllegalArgumentException(
					"Debe entregar el nombre a buscar");

		String qstr = null;
		int i = 0;
		palabrasArray = query.split(delimiter);

		for (String palabra : palabrasArray) {
			palabra += "*";

			if (i++ > 1)
				qstr = qstr + " AND nombre:" + palabra;
			else
				qstr = "nombre:" + palabra;
		}

		Query q = Search.search(qstr, UsuarioProfesor.class);

		List<Usuario> result = new ArrayList<Usuario>();

		List<Usuario> fetch = q.fetch();
		for (Usuario usr : fetch) {

			result.add(usr);

		}

		return result;

	}
	

	public boolean esEstudiante() {
		return true;
	}

}