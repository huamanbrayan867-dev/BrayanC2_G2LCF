package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.modelo.Estudiante;
import pe.edu.upeu.asistencia.servicio.EstudianteServicioI;
import pe.edu.upeu.asistencia.servicio.EstudianteServicioImp;

@Controller

public class Asistenciacontroller {

    //EstudianteServicioI es=new EstudianteServicioImp()

    @Autowired
    private EstudianteServicioI estudianteServicioI;

    @FXML private Label idMsg;

    @FXML TextField txtDato;
    @FXML Button btnenviar;

    @FXML void Enviar() {

        System.out.println("enviando asistencia");
        idMsg.setText(txtDato.getText());


    }

    @FXML
    void regEstudiante() {

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(new SimpleStringProperty(txtDato.getText()));
        estudiante.setEstado(new SimpleBooleanProperty(true));

        estudianteServicioI.saveEntidad(estudiante);
        listarEstudiantes();
    }

void listarEstudiantes(){

for (Estudiante e:estudianteServicioI.findAllEntidades()){
    System.out.println(e.getNombre());
}
}
}