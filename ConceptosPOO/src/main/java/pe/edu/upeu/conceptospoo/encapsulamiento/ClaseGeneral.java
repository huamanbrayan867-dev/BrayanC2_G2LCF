package pe.edu.upeu.conceptospoo.encapsulamiento;

public class ClaseGeneral {
    public static void main(String[] args) {
        Persona persona = new Persona();//persona es un objeto
      //  persona.nombre ="Brayan";
        //persona.edad=18;

        persona.setNombre("Brayan");
        persona.setEdad(17);

        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());
        persona.saludar();
    }
}
