package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.servicio.ParticipanteServicioI;

@Controller
public class ParticipanteController {

    @FXML
    private TextField txtNombres, txtDni, txtApellidos;
    @FXML
    private ComboBox<Carrera> cbxCarrera;
    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;

    @FXML
    private TableView<Participante> tableView;
    ObservableList<Participante> Listaparticipantes;

    @FXML
    private TableColumn<Participante, String> dnicolum, nombrecolum, apellidocolum, carreracolum, tipoparcolum;

    @Autowired
    ParticipanteServicioI ps;

    @FXML
    public void initialize() {
        cbxCarrera.getItems().setAll(Carrera.values());
        cbxTipoParticipante.getItems().setAll(TipoParticipante.values());

        definirColumnas();
        listarParticipantes();

    }

    public void limpiarformulario() {
        txtNombres.setText("");
        txtDni.setText("");
        txtApellidos.setText("");
        cbxCarrera.setValue(null);
        cbxTipoParticipante.setValue(null);


    }

    @FXML
    public void registrarParticipante(){
        Participante p = new Participante();
        p.setDni(new SimpleStringProperty(txtDni.getText()));
        p.setNombre(new SimpleStringProperty(txtNombres.getText()));
        p.setApellidos(new SimpleStringProperty(txtApellidos.getText()));
        p.setCarrera(cbxCarrera.getSelectionModel().getSelectedItem());
        p.setTipoParticipante(cbxTipoParticipante.getSelectionModel().getSelectedItem());
        ps.save(p);
        listarParticipantes();


    }
public  void definirColumnas(){

    dnicolum= new TableColumn("DNI");
    nombrecolum= new TableColumn("Nombre");
    apellidocolum= new TableColumn("Apellidos");
    carreracolum= new TableColumn("Carrera");
    tipoparcolum= new TableColumn("Tipo Participante");
    tableView.getColumns().addAll(dnicolum, nombrecolum, apellidocolum,carreracolum,tipoparcolum);


       }

       public void listarParticipantes(){
        dnicolum.setCellValueFactory(cellData->cellData.getValue().getDni());
        nombrecolum.setCellValueFactory(cellData->cellData.getValue().getNombre());
        apellidocolum.setCellValueFactory(cellData->cellData.getValue().getApellidos());

        carreracolum.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getCarrera().toString()));

           Listaparticipantes=FXCollections.observableArrayList(ps.findAll());
           tableView.setItems(Listaparticipantes);

       }
}
