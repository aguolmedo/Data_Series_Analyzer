package models;

public class SerieModelView {

    public String titulo;
    public String runtime;
    public String calificacion;
    public String imbd;
    public String nroVotos;
    public String argumento;

    public SerieModelView(String titulo, String runtime, String calificacion, String imbd, String nroVotos, String argumento) {
        this.titulo = titulo;
        this.runtime = runtime;
        this.calificacion = calificacion;
        this.imbd = imbd;
        this.nroVotos = nroVotos;
        this.argumento = argumento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public String getImbd() {
        return imbd;
    }

    public String getNroVotos() {
        return nroVotos;
    }

    public String getArgumento() {
        return argumento;
    }
}
