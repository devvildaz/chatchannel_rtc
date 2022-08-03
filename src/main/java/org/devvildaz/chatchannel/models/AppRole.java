package org.devvildaz.chatchannel.models;

import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class AppRole extends AuditableEntity implements GrantedAuthority{
	@Id
	private UUID id;
	
	private String name;

	@ManyToMany
	@JoinTable(
			name="App_RoleAuthority",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name= "authority_id")
	)
	private Set<AppAuthority> authorities;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "user_id"),
			@JoinColumn(name = "server_id")
	})
	private AppUserServer members;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return "ROLE_"+this.name;
	}

}
