public class NivelCombate extends Nivel {

    // El enemigo se guarda como tipo "Enemigo", aunque el objeto real sea
    // MonoVolador, MonoVoladorMejorado, Bruja o BrujaMejorada.
    // Esto es UPCASTING: la variable es del tipo padre, pero el objeto es de un tipo hijo.
    private Enemigo enemigo;
    private Premio recompensa;

    public NivelCombate(int numero, String nombre, Enemigo enemigo, Premio recompensa) {
        super(numero, nombre);
        this.enemigo = enemigo;
        this.recompensa = recompensa;
    }

    @Override
    public void ejecutar(Dorotea dorotea) {
        mostrarEncabezado();
        System.out.println("Aparece " + enemigo.getNombre() + "!");

        // Combate por turnos muy simple: se atacan hasta que uno muera
        while (enemigo.estaVivo() && dorotea.estaVivo()) {
            dorotea.atacar(enemigo);

            if (enemigo.estaVivo()) {
                enemigo.atacar(dorotea); // aqui se llama al atacar() de CADA enemigo (polimorfismo)
            }
        }

        if (!dorotea.estaVivo()) {
            System.out.println("Dorotea ha caido. Fin del juego.");
            System.exit(0);
        }

        enemigo.derrotar();
        dorotea.curar(999); // descansa antes de seguir su camino
        entregarRecompensa(dorotea);
    }

    private void entregarRecompensa(Dorotea dorotea) {
        // DOWNCASTING: "recompensa" es un Premio, pero aqui preguntamos que tipo es
        // REALMENTE por dentro, para poder usarlo de forma mas especifica.
        if (recompensa instanceof Companero) {
            Companero companero = (Companero) recompensa; // downcasting: Premio -> Companero
            dorotea.getCompaneros().agregar(companero);
        } else if (recompensa instanceof ZapatosMagicos) {
            ZapatosMagicos zapatos = (ZapatosMagicos) recompensa; // downcasting: Premio -> ZapatosMagicos
            dorotea.setZapatos(zapatos);
            System.out.println("Dorotea obtuvo: " + zapatos.getNombre());
        }
    }
}
