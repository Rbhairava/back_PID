package com.proyecto.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "tb_propietario")
public class Propietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_propietario;
	private String nom_propietario;
	private String dni_propietario;
	private int edad_propietario;
	private String correo_propietario;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fecha_incio_contrato;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fecha_fin_contrato;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_usuario")
	private User usuario;

	public int getCod_propietario() {
		return cod_propietario;
	}

	public void setCod_propietario(int cod_propietario) {
		this.cod_propietario = cod_propietario;
	}

	public String getNom_propietario() {
		return nom_propietario;
	}

	public void setNom_propietario(String nom_propietario) {
		this.nom_propietario = nom_propietario;
	}

	public String getDni_propietario() {
		return dni_propietario;
	}

	public void setDni_propietario(String dni_propietario) {
		this.dni_propietario = dni_propietario;
	}

	public int getEdad_propietario() {
		return edad_propietario;
	}

	public void setEdad_propietario(int edad_propietario) {
		this.edad_propietario = edad_propietario;
	}

	public String getCorreo_propietario() {
		return correo_propietario;
	}

	public void setCorreo_propietario(String correo_propietario) {
		this.correo_propietario = correo_propietario;
	}

	public Date getFecha_incio_contrato() {
		return fecha_incio_contrato;
	}

	public void setFecha_incio_contrato(Date fecha_incio_contrato) {
		this.fecha_incio_contrato = fecha_incio_contrato;
	}

	public Date getFecha_fin_contrato() {
		return fecha_fin_contrato;
	}

	public void setFecha_fin_contrato(Date fecha_fin_contrato) {
		this.fecha_fin_contrato = fecha_fin_contrato;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	
}
