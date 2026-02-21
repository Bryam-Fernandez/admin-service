package com.example.admin_service.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CategoriaDTO{

	  private Long id;
	    private String nombre;
	    private String ruta;
	    private String descripcion;
	    private Boolean habilitado;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getRuta() {
			return ruta;
		}
		public void setRuta(String ruta) {
			this.ruta = ruta;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public Boolean getHabilitado() {
			return habilitado;
		}
		public void setHabilitado(Boolean habilitado) {
			this.habilitado = habilitado;
		}
		public CategoriaDTO(Long id, String nombre, String ruta, String descripcion, Boolean habilitado) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.ruta = ruta;
			this.descripcion = descripcion;
			this.habilitado = habilitado;
		}
	    
	    public CategoriaDTO() {
	    	
	    }
	    
}
