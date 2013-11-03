package app.model;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name = "socio")
public class Socio implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;
 
    @OneToMany(mappedBy = "socio", fetch = FetchType.LAZY)
    private List<SolicitudAlquiler> solicitudAlquiler;

    public Socio() {}

    public Socio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<SolicitudAlquiler> getSolicitudAlquiler() {
        return solicitudAlquiler;
    }

    public void setSolicitudAlquiler(List<SolicitudAlquiler> solicitudAlquiler) {
        this.solicitudAlquiler = solicitudAlquiler;
    }


}