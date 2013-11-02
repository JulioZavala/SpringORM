
package app.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_rol")
public class UsuarioRol implements Serializable {
 
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "authority")
    private String authority;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public UsuarioRol() {
    }

    public UsuarioRol(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
