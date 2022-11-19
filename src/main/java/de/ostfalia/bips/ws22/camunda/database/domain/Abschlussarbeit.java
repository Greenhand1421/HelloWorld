package de.ostfalia.bips.ws22.camunda.database.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "abschlussarbeit")
public class Abschlussarbeit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_abschlussarbeit", nullable = false)
    private Integer id;

    @Column(name = "ende_datum", nullable = false)
    private String ende_datum;

    @Column(name = "beginn_datum", nullable = false)
    private String beginn_datum;

    @Column(name = "id_antrag", nullable = false)
    private String id_antrag;

    @ManyToOne(targetEntity = Antrag.class, optional = false)
    @JoinColumn(name = "id_antrag", referencedColumnName = "id_antrag", nullable = false)
    private Antrag antrag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnde_datum() {
        return ende_datum;
    }

    public void setEnde_datum(String text) {
        this.ende_datum = text;
    }

    public String getBeginn_datum() {
        return beginn_datum;
    }

    public void setBeginn(String text) {
        this.beginn_datum = text;
    }

    public Antrag getAntrag() {
        return antrag;
    }

    public void setAntrag(Antrag antrag) {
        this.antrag = antrag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abschlussarbeit abschlussarbeit = (Abschlussarbeit) o;
        return Objects.equals(getId(), abschlussarbeit.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return   " (" + (id == null ? "<null>" : id) + ')';
    }
}
