public class NivelFinal extends Nivel {

    public NivelFinal(int numero, String nombre) {
        super(numero, nombre);
    }

    @Override
    public void ejecutar(Dorotea dorotea) {
        mostrarEncabezado();
        System.out.println(dorotea.getNombre() + " llega a la Ciudad Esmeralda...");
        System.out.println("El Mago de Oz es descubierto: solo es un hombre detras de una cortina.");

        boolean tieneCompaneros = dorotea.getCompaneros().tieneAlMenos(3);
        boolean tieneZapatos = dorotea.getZapatos() != null;

        if (tieneCompaneros && tieneZapatos) {
            System.out.println("Con la ayuda de sus companeros, Dorotea activa el hechizo...");
            dorotea.getZapatos().activarPoder();
            System.out.println("La Ciudad Esmeralda es restaurada. Dorotea gana el juego.");
        } else {
            System.out.println("Faltan companeros u objetos magicos para completar el hechizo.");
        }
    }
}
