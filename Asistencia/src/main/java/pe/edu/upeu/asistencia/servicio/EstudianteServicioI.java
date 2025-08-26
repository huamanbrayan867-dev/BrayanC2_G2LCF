package pe.edu.upeu.asistencia.servicio;

import pe.edu.upeu.asistencia.modelo.Estudiante;

import java.util.List;

public interface EstudianteServicioI {
     void saveEntidad(Estudiante estudiante);//C

    List<Estudiante> findAllEntidades();//R

    void updateEntidad(Estudiante estudiante, int index);//U


    void deleteEntidad(int index);//Delete

    Estudiante findEntidad(int index);//Buscar





    }

