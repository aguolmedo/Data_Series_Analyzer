package models;

import java.util.LinkedList;

public class Puntuacion {
    private  int cantidad;
    public final LinkedList<Serie> listaSeries;

    public Puntuacion() {
        cantidad = 0;
        listaSeries = new LinkedList<>();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void addSeriePorPuntuacion(Serie serie) {
        listaSeries.add(serie);
        cantidad++;
    }

    public LinkedList<Serie> getListaSeries() {
        return listaSeries;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(listaSeries.toString());
        return sb.toString();
    }
}
