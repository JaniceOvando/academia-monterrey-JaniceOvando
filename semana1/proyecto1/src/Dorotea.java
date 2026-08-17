// Dorotea IS-A Personaje
public class Dorotea extends Personaje {

    // HAS-A: Dorotea TIENE un inventario de companeros y unos zapatos (no ES un inventario).
    private Inventario<Companero> companeros;
    private ZapatosMagicos zapatos; // empieza en null, hasta que los gane en el nivel 1

    public Dorotea(String nombre) {
        super(nombre, 100);
        this.companeros = new Inventario<>();
    }

    @Override
    public void atacar(Personaje objetivo) {
        int dano = Atacable.obtenerDanoBase();
        mostrarAtaque(nombre, objetivo.getNombre(), dano);
        objetivo.recibirDano(dano);

        // Cada companero que ya se haya unido ayuda tambien en el ataque
        for (Companero c : companeros.getElementos()) {
            c.ayudarEnBatalla(objetivo);
        }
    }

    public Inventario<Companero> getCompaneros() {
        return companeros;
    }
    public void setZapatos(ZapatosMagicos zapatos) {
        this.zapatos = zapatos;
    }
    public ZapatosMagicos getZapatos() {
        return zapatos;
    }
}
