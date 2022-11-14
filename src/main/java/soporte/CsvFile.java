package soporte;

import models.Genero;
import models.Serie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class CsvFile {

    private File file;

    public CsvFile(String path) {
        file = new File(path);
    }

    public TPUHashtable leerArchivo() {
        String campos[];
        TPUHashtable ht = new TPUHashtable<>();
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNext()) {
                String linea = sc.nextLine();
                campos = linea.split(",");
                String[] genres = getGenres(campos[4]);
                Serie serie = new Serie(campos[0],campos[1],campos[2],campos[3],genres,Float.parseFloat(campos[5]),campos[6],campos[7],campos[8],campos[9],campos[10],Integer.parseInt(campos[11]));
                for (String element: genres) {
                    if(!ht.containsKey(element)) {
                        Genero genero = new Genero();
                        genero.addSeriePorGenero(serie);
                        genero.addSeriePorPuntuacion(serie);
                        ht.put(element, genero);
                    } else {
                        Genero genero = (Genero) ht.get(element);
                        genero.addSeriePorGenero(serie);
                        genero.addSeriePorPuntuacion(serie);
                    }
                }
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo" + file.getName());
        }

        return ht;


    }

    public String[] getGenres(String generosString) {
        return generosString.split("\\|");
    }

}
