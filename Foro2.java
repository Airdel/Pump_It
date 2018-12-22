package interfaz;


import java.io.Serializable;


public class Foro2 implements  Serializable{
    private String IdTema, tema, usuario, comentario;

    public Foro2() {
    }

    public Foro2(String IdTema, String tema, String usuario, String comentario, int rateing, String file) {
        this.IdTema = IdTema;
        this.tema = tema;
        this.usuario = usuario;
        this.comentario = comentario;
    }



    public String getIdTema() {
        return IdTema;
    }

    public void setIdTema(String IdTema) {
        this.IdTema = IdTema;
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
        return "Game{" + "IdTema=" + IdTema + ", tema=" + tema + ", usuario=" + usuario + ", comentario=" + comentario  + '}';
    }
}
