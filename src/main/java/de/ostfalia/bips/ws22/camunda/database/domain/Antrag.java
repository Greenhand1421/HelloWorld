package de.ostfalia.bips.ws22.camunda.database.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "antrag")
public class Antrag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_antrag", nullable = false)
    private Integer id;

    @Column(name = "titel", nullable = false)
    private String titel;

    @Column(name = "typ", nullable = false)
    private Integer typ;

    @Column(name = "genehmight_prof", nullable = false)
    private boolean genehmight_prof;

    @Column(name = "genehmight_pav", nullable = false)
    private boolean genehmight_pav;

    @Column(name = "genehmight_ssb", nullable = false)
    private boolean genehmight_ssb;

    @Column(name = "begruendung_ablehnung", nullable = false)
    private String begruendung_ablehnung;

    @ManyToOne(targetEntity = Professor.class, optional = false)
    @JoinColumn(name = "id_professor", referencedColumnName = "id_professor", nullable = false)
    private Professor professor;

    @ManyToOne(targetEntity = Studierender.class, optional = false)
    @JoinColumn(name = "id_studierender", referencedColumnName = "id_studierender", nullable = false)
    private Studierender studierender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Integer getTyp() {
        return typ;
    }

    public void setTyp(Integer typ) {
        this.typ = typ;
    }

    public boolean getGenehmigt_prof() {
        return genehmight_prof;
    }

    public void setGenehmigt_prof(boolean genehmigt_prof) {
        this.genehmight_prof = genehmigt_prof;
    }

    public boolean getGenehmigt_pav() {
        return genehmight_pav;
    }

    public void setGenehmigt_pav(boolean genehmigt_pav) {
        this.genehmight_pav = genehmigt_pav;
    }

    public boolean getGenehmigt_ssb() {
        return genehmight_ssb;
    }

    public void setGenehmigt_ssb(boolean genehmigt_ssb) {
        this.genehmight_ssb = genehmigt_ssb;
    }

    public String getBegruendung_ablehnung() {
        return begruendung_ablehnung;
    }

    public void setBegruendung_ablehnung(String begruendung_ablehnung) {
        this.begruendung_ablehnung = begruendung_ablehnung;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword keyword = (Keyword) o;
        return Objects.equals(getId(), keyword.getId());
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
