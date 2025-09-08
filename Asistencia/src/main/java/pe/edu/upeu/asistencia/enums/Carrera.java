package pe.edu.upeu.asistencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Carrera {
    SISTEMAS(Facultad.FIA,"Sistemas"),
    CIVIL(Facultad.FIA,"Civil"),

    ADMINISTRACION(Facultad.FCE,"Administrador"),

    NUTRICION(Facultad.FCS,"Nutricion"),

    EDUCACION(Facultad.FACIHED,"Educacion"),

    General(Facultad.GENERAL,"General"),;

    private Facultad facultad;
    private String descripcion;



}
