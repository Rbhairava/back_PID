package com.proyecto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_mascota;
	private String nom_mascota;
	private String sexo_mascota;
	private String raza_mascota;
	public int getCod_mascota() {
		return cod_mascota;
	}
	public void setCod_mascota(int cod_mascota) {
		this.cod_mascota = cod_mascota;
	}
	public String getNom_mascota() {
		return nom_mascota;
	}
	public void setNom_mascota(String nom_mascota) {
		this.nom_mascota = nom_mascota;
	}
	public String getSexo_mascota() {
		return sexo_mascota;
	}
	public void setSexo_mascota(String sexo_mascota) {
		this.sexo_mascota = sexo_mascota;
	}
	public String getRaza_mascota() {
		return raza_mascota;
	}
	public void setRaza_mascota(String raza_mascota) {
		this.raza_mascota = raza_mascota;
	}
	
	
	
	
}
