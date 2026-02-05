package com.nouah.metroestate.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;


@Getter
@Setter
@Audited(targetAuditMode = NOT_AUDITED)
@Entity
@Table(name = "estate")
public class Estate extends BaseEntity {

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "name")
    private String name;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "estate_id", unique = true, nullable = false)
    private String estateId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_admin", referencedColumnName = "user_id", nullable = false)
    private UserEntity estateAdminUser;
}
