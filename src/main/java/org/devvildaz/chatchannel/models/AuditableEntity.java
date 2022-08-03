package org.devvildaz.chatchannel.models;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class AuditableEntity {
	java.sql.Timestamp createdDate;
	java.sql.Timestamp lastModifiedDate;
	
	
	@PrePersist
	public void prePersit() {
		this.createdDate = java.sql.Timestamp.valueOf(LocalDateTime.now());
	}
	
	@PreUpdate
	public void preUpdate() {
		this.lastModifiedDate = java.sql.Timestamp.valueOf(LocalDateTime.now());
	}
	
}
