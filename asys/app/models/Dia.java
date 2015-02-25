package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Dia extends Model {
	public long codi;
	public String dia;

	public Dia(long codi, String dia) {
		this.codi = codi;
		this.dia = dia;

	}

	public String toString() {
		return dia;
	}

}
