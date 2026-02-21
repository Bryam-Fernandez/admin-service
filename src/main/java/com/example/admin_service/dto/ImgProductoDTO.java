package com.example.admin_service.dto;


import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ImgProductoDTO {

    private Long id;
    private String url;
    private Integer orden = 0;
    private Boolean principal = false;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public Boolean getPrincipal() {
		return principal;
	}
	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}
	public ImgProductoDTO(Long id, String url, Integer orden, Boolean principal, ProductoDTO producto) {
		super();
		this.id = id;
		this.url = url;
		this.orden = orden;
		this.principal = principal;
	}
    
	public ImgProductoDTO() {
		
	}
	@Override
	public String toString() {
		return "ImgProductoDTO [id=" + id + ", url=" + url + ", orden=" + orden + ", principal=" + principal
				+ ", getId()=" + getId() + ", getUrl()=" + getUrl() + ", getOrden()="
				+ getOrden() + ", getPrincipal()=" + getPrincipal() + ", getProducto()="
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
