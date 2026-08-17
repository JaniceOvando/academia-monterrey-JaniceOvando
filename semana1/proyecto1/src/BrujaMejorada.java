//Herencia (IS-A) + polimorfismo, igual que con los monos.
public final class BrujaMejorada extends Bruja {

    public BrujaMejorada(String nombre) {
        super(nombre);
        this.vida = 100;
        this.vidaMaxima = 100;
        this.dano = this.dano + 10; //mas dano que la bruja del nivel 2
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " invoca el poder de la esmeralda...");
        super.atacar(objetivo);
    }
}
