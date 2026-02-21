package com.example.admin_service.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

public class ProductoDTO {

	    private Long id;

	    private String nombre;

	    private String ruta;

	    private String descripcion;

	    private BigDecimal precio;

	    private String imagen;

	    private String sku;

	    private Integer existencias = 0;

	    private Boolean habilitado = true;
	   
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

		public BigDecimal getPrecio() {
			return precio;
		}

		public void setPrecio(BigDecimal precio) {
			this.precio = precio;
		}

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public String getSku() {
			return sku;
		}

		public void setSku(String sku) {
			this.sku = sku;
		}

		public Integer getExistencias() {
			return existencias;
		}

		public void setExistencias(Integer existencias) {
			this.existencias = existencias;
		}

		public Boolean getHabilitado() {
			return habilitado;
		}

		public void setHabilitado(Boolean habilitado) {
			this.habilitado = habilitado;
		}

		public ProductoDTO(Long id, String nombre, String ruta, String descripcion, BigDecimal precio, String imagen,
				String sku, Integer existencias, Boolean habilitado) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.ruta = ruta;
			this.descripcion = descripcion;
			this.precio = precio;
			this.imagen = imagen;
			this.sku = sku;
			this.existencias = existencias;
			this.habilitado = habilitado;
		}

		public ProductoDTO() {
			
		}
}
