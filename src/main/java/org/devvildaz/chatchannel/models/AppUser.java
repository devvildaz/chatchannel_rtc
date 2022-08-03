package org.devvildaz.chatchannel.models;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AppUser extends AuditableEntity implements UserDetails{
	@Id
	private UUID id;
	private String name;
	private String email;
	private String password;
	
	private boolean enabled;

	@OneToMany(mappedBy = "user")
	private Set<AppUserServer> servers;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	
	
}
