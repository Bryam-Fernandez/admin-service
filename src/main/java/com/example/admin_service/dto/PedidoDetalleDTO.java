package com.example.admin_service.dto;

import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PedidoDetalleDTO {

	    private Long id;

		public String getImagenUrl() { return imagenUrl; }
	    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }

		private Integer cantidad;

	    private BigDecimal subtotal;
	    
	    private String imagenUrl;

	
	    private PedidoDTO pedido;

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Integer getCantidad() {
			return cantidad;
		}
		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}
		public BigDecimal getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(BigDecimal subtotal) {
			this.subtotal = subtotal;
		}
		public PedidoDTO getPedido() {
			return pedido;
		}
		public void setPedido(PedidoDTO pedido) {
			this.pedido = pedido;
		}
		public PedidoDetalleDTO(Long id, Integer cantidad, BigDecimal subtotal, String imagenUrl, PedidoDTO pedido) {
			super();
			this.id = id;
			this.cantidad = cantidad;
			this.subtotal = subtotal;
			this.imagenUrl = imagenUrl;
			this.pedido = pedido;
		}
	    
		public PedidoDetalleDTO() {
			
		}

}
