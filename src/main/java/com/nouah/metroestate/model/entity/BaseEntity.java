package com.nouah.metroestate.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.time.Instant;

@Data
@Audited
@MappedSuperclass
public abstract class BaseEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    protected Long id;
@Version
private Long version;
@CreationTimestamp
@Column(name = "date_created")
    protected Instant dateCreated;
    @UpdateTimestamp
    @Column(name = "last_ updated")
    protected Instant lastUpdated;
}
