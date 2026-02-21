package com.example.admin_service.dto;

import java.math.BigDecimal;

import com.example.admin_service.feign.PuestoTrabajo;

public class EmpleadoFormDTO {

		  private Long id;            
		  private String usuario;       
		  private String contrasena;   
		  private Boolean habilitado = true;
		  
		  private String nombre;
		  private String apellido;
		  private String correo;
		  private String dni;
		  private BigDecimal salario;
		  private PuestoTrabajo puesto;
		  
		  public Long getId() { return id; }
		  public void setId(Long id) { this.id = id; }
		  public String getUsuario() { return usuario; }
		  public void setUsuario(String usuario) { this.usuario = usuario; }
		  public String getContrasena() { return contrasena; }
		  public void setContrasena(String contrasena) { this.contrasena = contrasena; }
		  public Boolean getHabilitado() { return habilitado; }
		  public void setHabilitado(Boolean habilitado) { this.habilitado = habilitado; }
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
