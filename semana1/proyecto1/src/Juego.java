import java.util.ArrayList;

// SINGLETON: en todo el programa solo puede existir UN objeto Juego.
public class Juego {

    private static Juego instancia; // aqui se guarda la unica instancia que existirá

    private ArrayList<Nivel> niveles;

    // Constructor PRIVADO: nadie fuera de esta clase puede escribir "new Juego()".
    private Juego() {
        niveles = new ArrayList<>();
    }

    // Este es el único modo de conseguir el objeto Juego.
    public static Juego getInstance() {
        if (instancia == null) {
            instancia = new Juego();
        }
        return instancia;
    }

    public void agregarNivel(Nivel nivel) {
        niveles.add(nivel);
    }

    public void iniciar(Dorotea dorotea) {
        System.out.println("=== EL MAGO DE OZ: LA AVENTURA DE " + dorotea.getNombre() + " ===");

        for (Nivel nivel : niveles) {
            nivel.ejecutar(dorotea);
        }

        System.out.println("");
        System.out.println("Enemigos derrotados en total: " + Enemigo.getTotalDerrotados());
    }
}
