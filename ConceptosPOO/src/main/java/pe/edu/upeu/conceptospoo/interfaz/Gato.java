package pe.edu.upeu.conceptospoo.interfaz;

public class Gato implements Animal {
    @Override
    public void emitirSonido() {
        System.out.println("Miauu....mauuu");

    }

    @Override
    public void dormir() {
        System.out.println("Zzz zzz...");
    }
        public String juega() {
            return "le gusta jugar con el raton"
        }

    }
}
