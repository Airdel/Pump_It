/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import java.io.Serializable;
/**
 *
 * @author admin
 */
public class Foro1 implements Serializable {
    private String idTema, tema, usuario, comentario;

        public Foro1() {
    }
    
    public Foro1(String idTema, String tema, String usuario, String comentario) {
        this.idTema = idTema;
        this.tema = tema;
        this.usuario = usuario;
        this.comentario = comentario;
    }



    public String getIdTema() {
        return idTema;
    }

    public void setIdTema(String idTema) {
        this.idTema = idTema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    @Override
    public String toString() {
        return "Foro1{" + "idForo=" + idTema + ", Tema=" + tema + ", usuario=" + usuario + ", Comentario=" + comentario +  '}';
    }
    
}
