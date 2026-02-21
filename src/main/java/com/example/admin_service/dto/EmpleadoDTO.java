package com.example.admin_service.dto;

import java.math.BigDecimal;

import com.example.admin_service.feign.PuestoTrabajo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

public class EmpleadoDTO {

	  private Long id;  
	  private AppUserDTO usuario;
	  private String nombre;
	  private String apellido;
	  private String correo;
	  private String dni;
	  private BigDecimal salario;
	  private PuestoTrabajo puesto;


	  public Long getId() { return id; }
	  public void setId(Long id) { this.id = id; }
	  public AppUserDTO getUsuario() { return usuario; }
	  public void setUsuario(AppUserDTO usuario) { this.usuario = usuario; }
	  public String getNombre() { return nombre; }
	  public void setNombre(String nombre) { this.nombre = nombre; }
	  public String getApellido() { return apellido; }
	  public void setApellido(String apellido) { this.apellido = apellido; }
	  public String getCorreo() { return correo; }
	  public void setCorreo(String correo) { this.correo = correo; }
	  public String getDni() { return dni; }
	  public void setDni(String dni) { this.dni = dni; }
	  public BigDecimal getSalario() { return salario; }
	  public void setSalario(BigDecimal salario) { this.salario = salario; }
	  public PuestoTrabajo getPuesto() { return puesto; }
	  public void setPuesto(PuestoTrabajo puesto) { this.puesto = puesto; }
	

}
