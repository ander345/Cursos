package org.acme.quickstart;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "developer_hibernate")
public class Developer {

    /**
     * Nota, si usamos panache, debemos extener, ademas funciona muy similar a loombok, pero sin tener que agregar los @Getter y @Setter
     * ademas podemos quitar el id, el por defecto agrera un id autoincremental y si podemos public en vez de private el lo cambia a private en la compilacion
     */

    @Id
    private Integer id;

    @Column
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Objects.equals(id, developer.id) && Objects.equals(name, developer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}
