package org.devvildaz.chatchannel.models;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AppServer extends AuditableEntity {
	@Id
	private UUID id;
	private String name;

	@OneToMany(mappedBy = "server")
	private Set<AppUserServer> users;

}
