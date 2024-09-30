package org.acme.quickstart;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "developer_panache")
public class DeveloperPanache  extends PanacheEntity {

    @Column(unique = true)
    public String name;

}