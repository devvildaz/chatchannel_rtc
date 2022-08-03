package org.devvildaz.chatchannel.models;

import java.util.Set;
import java.util.UUID;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AppAuthority extends AuditableEntity implements GrantedAuthority{
	/* fixed list of authorities */
	@Id
	private UUID id;

	private String name;

	@ManyToMany(mappedBy = "authorities")
	private Set<AppRole> roles;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
