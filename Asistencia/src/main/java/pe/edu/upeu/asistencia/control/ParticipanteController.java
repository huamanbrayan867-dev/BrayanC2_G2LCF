package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
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
private TableColumn<Participante, Void> opcColum;

    @Autowired
    ParticipanteServicioI ps;
    int indexE=-1;

    @FXML
    public void initialize() {
        cbxCarrera.getItems().setAll(Carrera.values());
        cbxTipoParticipante.getItems().setAll(TipoParticipante.values());
        limpiarformulario();
        definirColumnas();
        listarParticipantes();

    }

    public void limpiarformulario() {



    }

    @FXML
    public void registrarParticipante(){
        Participante p = new Participante();
        p.setDni(new SimpleStringProperty(txtDni.getText()));
        p.setNombre(new SimpleStringProperty(txtNombres.getText()));
        p.setApellidos(new SimpleStringProperty(txtApellidos.getText()));
        p.setCarrera(cbxCarrera.getSelectionModel().getSelectedItem());
        p.setTipoParticipante(cbxTipoParticipante.getSelectionModel().getSelectedItem());
        if(indexE==-1) {


            ps.save(p);
        }else {
            ps.update(p, indexE);
            indexE=-1;
        }
        listarParticipantes();


    }
public  void definirColumnas(){

    dnicolum= new TableColumn("DNI");
    nombrecolum= new TableColumn("Nombre");
    apellidocolum= new TableColumn("Apellidos");
    carreracolum= new TableColumn("Carrera");
    tipoparcolum= new TableColumn("Tipo Participante");
    opcColum= new TableColumn("Opciones");
    opcColum.setPrefWidth(200);
    tableView.getColumns().addAll(dnicolum, nombrecolum, apellidocolum,carreracolum,tipoparcolum, opcColum);



       }

       public  void agregarAccionBotones(){

           Callback<TableColumn<Participante, Void>, TableCell<Participante, Void>> cellFactory=
                   param->new TableCell<>(){

              private final Button editarBtn = new Button("Editar");
private final Button eliminarBtmBtn = new Button("Eliminar");
           {
               editarBtn.setOnAction(event -> {
                   Participante p = getTableView().getItems().get(getIndex());
                   editarDatos(p,getIndex());
               });
               eliminarBtmBtn.setOnAction(event -> {
                   eliminarParticipante(getIndex());
               });
           }




               @Override
                public void updateItem(Void item, boolean empty){
                   super.updateItem(item, empty);
                   if(empty) {

                       setGraphic(null);
                   }else {
                       HBox hbox = new HBox(editarBtn, eliminarBtmBtn);
                       hbox.setSpacing(10);
                       setGraphic(hbox);
                   }
               }


                   };
           opcColum.setCellFactory(cellFactory);
       }

       public void listarParticipantes(){
        dnicolum.setCellValueFactory(cellData->cellData.getValue().getDni());
        nombrecolum.setCellValueFactory(cellData->cellData.getValue().getNombre());
        apellidocolum.setCellValueFactory(cellData->cellData.getValue().getApellidos());

        carreracolum.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
           agregarAccionBotones();
           Listaparticipantes=FXCollections.observableArrayList(ps.findAll());
           tableView.setItems(Listaparticipantes);

       }
       public void eliminarParticipante(int index){
        ps.delete(index);
        listarParticipantes();

       }
       public void editarDatos(Participante p, int index){
        txtDni.setText(p.getDni().getValue());
        txtNombres.setText(p.getNombre().getValue());
        txtApellidos.setText(p.getApellidos().getValue());
        cbxCarrera.setValue(p.getCarrera());
        cbxTipoParticipante.setValue(p.getTipoParticipante());
           indexE=index;

        listarParticipantes();
       }
}
