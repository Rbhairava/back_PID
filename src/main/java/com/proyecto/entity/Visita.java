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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_visita")
public class Visita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_visita;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fecha_reg_visita;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fecha_llegada_visita;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fecha_salida_visita;
	
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_visitante")
	private Visitante visitante;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_propietario")
	private Propietario propietario;

	public int getCod_visita() {
		return cod_visita;
	}

	public void setCod_visita(int cod_visita) {
		this.cod_visita = cod_visita;
	}

	public Date getFecha_reg_visita() {
		return fecha_reg_visita;
	}

	public void setFecha_reg_visita(Date fecha_reg_visita) {
		this.fecha_reg_visita = fecha_reg_visita;
	}

	public Date getFecha_llegada_visita() {
		return fecha_llegada_visita;
	}

	public void setFecha_llegada_visita(Date fecha_llegada_visita) {
		this.fecha_llegada_visita = fecha_llegada_visita;
	}

	public Date getFecha_salida_visita() {
		return fecha_salida_visita;
	}

	public void setFecha_salida_visita(Date fecha_salida_visita) {
		this.fecha_salida_visita = fecha_salida_visita;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	
}
