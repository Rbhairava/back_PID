package com.proyecto.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.proyecto.enums.RoleName;

@Entity
@Table(name= "tb_role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private RoleName roleName;
	
	public Role() {
		super();
	}

	public Role(RoleName roleName) {
		super();
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	
	


}
