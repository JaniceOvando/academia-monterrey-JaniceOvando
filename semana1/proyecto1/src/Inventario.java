import java.util.ArrayList;

// GENERICS: "T extends Premio" significa que esta clase sirve para guardar
// cualquier tipo de Premio (o algo que herede de Premio), sin repetir código.
public class Inventario<T extends Premio> {

    private ArrayList<T> elementos = new ArrayList<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
        System.out.println("Dorotea obtuvo: " + elemento.getNombre() + " (" + elemento.getDescripcion() + ")");
    }

    public boolean tieneAlMenos(int cantidad) {
        return elementos.size() >= cantidad;
    }

    public ArrayList<T> getElementos() {
        return elementos;
    }
}
