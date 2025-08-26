package pe.edu.upeu.conceptospoo.enums;

enum GENERO{M,F}
enum NACIONALIDAD{Peruano, Venezolano, Boliviano}


public class Persona {
   static String nombre;
   static GENERO genero=GENERO.M;
    static NACIONALIDAD nacionalidad=NACIONALIDAD.Peruano;


     public static void main(String[] args) {

         nombre="Brayan";

         System.out.println(nombre+ " es "+nacionalidad+ " y es de genero: "+genero);

         for (GENERO g:GENERO.values()){
             System.out.println(g);
         }
         for (NACIONALIDAD x:NACIONALIDAD.values()){
             System.out.println(x);
         }
     }
}
