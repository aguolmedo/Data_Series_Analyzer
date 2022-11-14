package models;

import soporte.TPUHashtable;

import java.util.LinkedList;

public class Genero {
    private int cantidadSeries;
    private LinkedList<Serie> seriesPorGenero;
    public TPUHashtable<Integer,Puntuacion> seriesPorPuntuacion;

    public Genero(int cantidadSeries, LinkedList<Serie> series, TPUHashtable<Integer, Puntuacion> seriesPorPuntuacion) {
        this.cantidadSeries = cantidadSeries;
        this.seriesPorGenero = series;
        this.seriesPorPuntuacion = seriesPorPuntuacion;
    }

    public Genero() {
        this.cantidadSeries = 0;
        this.seriesPorGenero = new LinkedList<Serie>();
        this.seriesPorPuntuacion = new TPUHashtable<Integer,Puntuacion>() {
        };

    }

    public void addSeriePorPuntuacion(Serie serie) {
        int puntuacion = (int) serie.getImdbRating();
        if (!seriesPorPuntuacion.containsKey(puntuacion)) {
            Puntuacion objectPuntuacion = new Puntuacion();
            objectPuntuacion.addSeriePorPuntuacion(serie);
            seriesPorPuntuacion.put(puntuacion, objectPuntuacion);
        } else {
           Puntuacion objectPuntuacion = (Puntuacion) seriesPorPuntuacion.get(puntuacion);
           objectPuntuacion.addSeriePorPuntuacion(serie);

        }
    }

    public int getCantidadSeries() {
        return cantidadSeries;
    }


    public void addSeriePorGenero(Serie serie) {
        seriesPorGenero.add(serie);
        cantidadSeries++;
    }

    public LinkedList<Serie> getSeriesPorGenero() {
        return seriesPorGenero;
    }

    public TPUHashtable getSeriesPorPuntuacion(){
        return seriesPorPuntuacion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Genero {");
        sb.append("cantidadSeries: ").append(cantidadSeries);
        sb.append(", seriesPorGenero = ").append(seriesPorGenero.toString());
        sb.append(", seriesPorPuntuacion =").append(seriesPorPuntuacion.toString());
        sb.append('}');
        return sb.toString();
    }
}
