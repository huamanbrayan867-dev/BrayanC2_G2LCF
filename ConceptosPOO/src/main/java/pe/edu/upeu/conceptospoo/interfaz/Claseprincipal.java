package pe.edu.upeu.conceptospoo.interfaz;

public class Claseprincipal {

    public static void main(String[] args) {
        Animal animal = new Loro();
        animal.emitirSonido();
        animal.dormir();

        animal=new Gato();
        animal.emitirSonido();
        animal.dormir();
    }
}
