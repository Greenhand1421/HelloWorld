package de.ostfalia.bips.ws22.camunda.database.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "professor_hat_stichpunkt")
public class Professor_hat_stichpunkt {
    @EmbeddedId
    private Id id;

    public Professor_hat_stichpunkt() {
    }


    public Professor_hat_stichpunkt(Professor professor, Stichpunkt stichpunkt) {
        this.id = new Id(professor,stichpunkt);
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor_hat_stichpunkt that = (Professor_hat_stichpunkt) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "ProfessorHasStichpunkt{id=" + (id == null ? "<null>" : id) + '}';
    }

    @Embeddable
    public static class Id implements Serializable {
        @ManyToOne(targetEntity = Professor.class, optional = false)
        @JoinColumn(name = "id_professor", referencedColumnName = "id_professor", nullable = false)
        private Professor professor;

        @ManyToOne(targetEntity = Stichpunkt.class, optional = false)
        @JoinColumn(name = "id_stichpunkt", referencedColumnName = "id_stichpunkt", nullable = false)
        private Stichpunkt stichpunkt;

        public Id() {
        }

        public Id(Professor professor, Stichpunkt stichpunkt) {
            this.professor = professor;
            this.stichpunkt = stichpunkt;
        }



        public Professor getProfessor() {
            return professor;
        }

        public void setProfessor(Professor professor) {
            this.professor = professor;
        }

        public Stichpunkt getStichpunkt() {
            return stichpunkt;
        }

        public void setStichpunkt(Stichpunkt stichpunkt) {
            this.stichpunkt = stichpunkt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return Objects.equals(getStichpunkt(), id.getStichpunkt()) && Objects.equals(getProfessor(), id.getProfessor());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getProfessor(), getStichpunkt());
        }

        @Override
        public String toString() {
            return String.format("%s has %s", stichpunkt,  professor);
        }
    }
}
