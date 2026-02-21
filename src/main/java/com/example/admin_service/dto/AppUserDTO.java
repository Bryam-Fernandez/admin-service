package com.example.admin_service.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

public class AppUserDTO {
	
	    private Long id;
	    private String username;
	    private String password;
	    private boolean enabled = true;
	    private Set<RoleDTO> roles = new HashSet<>();
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public Set<RoleDTO> getRoles() {
			return roles;
		}
		public void setRoles(Set<RoleDTO> roles) {
			this.roles = roles;
		}
		public AppUserDTO(Long id, String username, String password, boolean enabled, Set<RoleDTO> roles,
				List<PedidoDTO> pedidos) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.enabled = enabled;
			this.roles = roles;
		}
		public AppUserDTO() {
			
		}
	    
}
