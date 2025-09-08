package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;

import java.util.ArrayList;
import java.util.List;

public abstract class ParticipanteRepositorio {
   public List<Participante> listaParticipantes =new ArrayList<>();

   public List<Participante> findAll(){
      listaParticipantes.add(
              new Participante(
                      new SimpleStringProperty("43631917"),
                      new SimpleStringProperty("Eliza"),
                      new SimpleStringProperty("Cande"),
                      new SimpleBooleanProperty(true), Carrera.EDUCACION,
                      TipoParticipante.ASISTENTE
              )
      );
      listaParticipantes.add(
              new Participante(
                      new SimpleStringProperty("43631918"),
                      new SimpleStringProperty("Brayan"),
                      new SimpleStringProperty("Lcf"),
                      new SimpleBooleanProperty(true), Carrera.SISTEMAS,
                      TipoParticipante.ASISTENTE
              )
      );
      return listaParticipantes;
   }

}
