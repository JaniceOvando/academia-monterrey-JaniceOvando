public final class Monovoladormejorado extends Monovolador{
    public Monovoladormejorado(String nombre) {
        super(nombre);
        // Mejoramos las estadísticas heredadas del mono normal
        this.vida = 60;
        this.vidaMaxima = 60;
        this.dano = this.dano + 6; // mas daño que el mono del nivel 1
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " ataca en picada desde el aire...");
        super.atacar(objetivo); // reutiliza el ataque normal del mono, ya con las stats mejoradas
    }
}
