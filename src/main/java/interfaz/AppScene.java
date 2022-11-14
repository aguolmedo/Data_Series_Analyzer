package interfaz;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Genero;
import models.Puntuacion;
import models.Serie;
import models.SerieModelView;
import soporte.CsvFile;
import soporte.TPUHashtable;

import java.io.File;
import java.net.URL;
import java.util.*;

public class AppScene implements Initializable {

    public Label cantidadSeriesLabel;
    public Label cantidadDeSeriesTEXTO;
    public ComboBox comboBoxPuntuacion;

    public TableView tablaSeries;

    public TableColumn<SerieModelView, String> TableColumnName;
    public TableColumn<SerieModelView, String> TableColumnRuntime;
    public TableColumn<SerieModelView, String> TableColumnCalificacion;
    public TableColumn<SerieModelView, String> TableColumnIMDB;
    public TableColumn<SerieModelView, String> TableColumnNroVotos;
    public TableColumn<SerieModelView, String> TableColumnArgumento;
    @FXML
    private Button btnAbrirCsv;
    @FXML
    private ComboBox comboBoxGeneros;
    @FXML
    private CsvFile csvFile;

    private TPUHashtable ht;

    @FXML
    private String pathText;
    private String genreSelected;
    private String puntuacionSelected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxGeneros.setVisible(false);
        pathText = "No se cargo ningun archivo";
        csvFile = null;
        genreSelected = null;
        tablaSeries.setVisible(false);
        cantidadSeriesLabel.setVisible(false);
        cantidadDeSeriesTEXTO.setVisible(false);
        comboBoxPuntuacion.setVisible(false);
        
    }
    public void btnAbrirCsvClick(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("C:\\Users\\agual\\Documents\\facultad\\TSB\\TPU 2da Parte"));
        chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(new Stage());
        if (file != null) {
            pathText = file.getPath();
            csvFile = new CsvFile(pathText);
        }
        if (csvFile != null) {

            btnAbrirCsv.setVisible(false);
            comboBoxGeneros.setVisible(true);
            cargarComboBoxGeneros();

            Alert dialogo = new Alert(Alert.AlertType.INFORMATION);

            dialogo.setTitle("Carga Exitosa");
            dialogo.setHeaderText("Se cargó un archivo csv Correctamente");
            dialogo.setContentText("path: " + pathText);

            dialogo.showAndWait();
        } else {
            Alert dialogo = new Alert(Alert.AlertType.ERROR);
            dialogo.setTitle("Carga Fallida");
            dialogo.setHeaderText("No se cargo ningun Archivo");
            dialogo.showAndWait();
        }
    }

    private void cargarComboBoxGeneros() {
        ht = csvFile.leerArchivo();
        LinkedList combolist = new LinkedList();

        for (Object o : ht.keySet().toArray()) {
            combolist.add(o.toString());
        }
        comboBoxGeneros.setItems(FXCollections.observableList(combolist));

        // adding a listener
          comboBoxGeneros.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue ov, Number value, Number new_value) {
                comboBoxPuntuacion.getItems().clear();
                puntuacionSelected = null;
                genreSelected = (combolist.toArray()[new_value.intValue()].toString());
                cargarTablaXGenero(genreSelected);
                if(genreSelected != null) comboBoxPuntuacion.setVisible(true);
                cargarComboBoxPuntuacion(genreSelected);
            }
        });


    }

    public void cargarComboBoxPuntuacion(String genero) {
        Genero genre = (Genero) ht.get(genero);
        Object[] htPuntuacion = genre.getSeriesPorPuntuacion().keySet().toArray();
        LinkedList combolist = new LinkedList();
        for (Object o: htPuntuacion) {
            combolist.add(String.valueOf(o));
        }

        comboBoxPuntuacion.setItems(FXCollections.observableList(combolist));

        // adding a listener
        comboBoxPuntuacion.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue ov, Number value, Number new_value) {
                puntuacionSelected = (combolist.toArray()[new_value.intValue()].toString());
                cargarTablaXPuntuacion(genero,puntuacionSelected);
            }
        });


    }

    private void cargarTablaXPuntuacion(String genero,String puntuacionSelected) {
        tablaSeries.getItems().clear();
        Genero genre = (Genero) ht.get(genero);
        Puntuacion puntuacion = genre.seriesPorPuntuacion.get(Integer.parseInt(puntuacionSelected));
        String cantidadSeries = String.valueOf(puntuacion.getCantidad()) ;
        LinkedList<Serie> listaSeriesXgenero = puntuacion.getListaSeries();

        for (Serie serie: listaSeriesXgenero) {
            String calificacion = "N/A";
            if (!serie.getCertificate().toString().equals("")) {calificacion = serie.getCertificate().toString();}
            tablaSeries.getItems().add(
                    new SerieModelView(serie.getSeriesTitle().toString(),
                            serie.getRuntimeOfSeries(),
                            calificacion,
                            String.valueOf(serie.getImdbRating()),
                            String.valueOf(serie.getNumberOfVotes()),
                            serie.getOverview())
            );
        }
        cantidadSeriesLabel.setText(cantidadSeries);

    }

    public void cargarTablaXGenero(String genero) {
        tablaSeries.getItems().clear();
        Genero genre = (Genero) ht.get(genero);
        if (genre == null){throw new RuntimeException("El genero elegido: "+ genero +" no tiene ninguna pelicula");}
        String cantidadSeries = String.valueOf(genre.getCantidadSeries()) ;
        LinkedList<Serie> listaSeriesXgenero = genre.getSeriesPorGenero();

        tablaSeries.setVisible(true);
        cantidadDeSeriesTEXTO.setVisible(true);
        cantidadSeriesLabel.setVisible(true);

         TableColumnName.setCellValueFactory(
                 new PropertyValueFactory<SerieModelView,String>("titulo"));
         TableColumnRuntime.setCellValueFactory(
                 new PropertyValueFactory<SerieModelView,String>("runtime"));
         TableColumnCalificacion.setCellValueFactory(
                 new PropertyValueFactory<SerieModelView,String>("calificacion"));
         TableColumnIMDB.setCellValueFactory(
                 new PropertyValueFactory<SerieModelView,String>("imbd"));
         TableColumnNroVotos.setCellValueFactory(
                 new PropertyValueFactory<SerieModelView,String>("nroVotos"));
         TableColumnArgumento.setCellValueFactory(
                 new PropertyValueFactory<SerieModelView,String>("argumento"));

        for (Serie serie: listaSeriesXgenero) {
            String calificacion = "N/A";
            if (!serie.getCertificate().toString().equals("")) {calificacion = serie.getCertificate().toString();}
                 tablaSeries.getItems().add(
                         new SerieModelView(serie.getSeriesTitle().toString(),
                                 serie.getRuntimeOfSeries(),
                                 calificacion,
                                 String.valueOf(serie.getImdbRating()),
                                 String.valueOf(serie.getNumberOfVotes()),
                                 serie.getOverview())
                 );
        }
        cantidadSeriesLabel.setText(cantidadSeries);
     }
}



