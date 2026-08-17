JANICE BELEN OVANDO GARCIA.
ACADEMIA MONTERREY - XIDERAL

# El Mago de Oz: La Aventura de Dorotea

> Realicé un pequeño videojuego de texto en Java que sigue a Dorotea en su viaje por Oz, derrotando enemigos, 
> coleccionando compañeros y restaurando la Ciudad Esmeralda.

## Objetivo del Juego

Dorotea debe superar **5 niveles**:
1. Derrotar al **Mono Volador** → Ganar los **Zapatos Mágicos**.
2. Derrotar a la **Bruja de Plata** → Ganar al **Soldado de Plomo**.
3. Derrotar al **Mono Volador Mejorado** → Ganar al **León Cobarde**.
4. Derrotar a la **Bruja Esmeralda** → Ganar al **Hombre de Paja**.
5. **Liberar la Ciudad Esmeralda**: Descubrir el engaño del Mago y restaurar la ciudad con un hechizo.

¡Solo si tiene todos los compañeros y objetos, Dorotea podra ganar!

---

## Estructura del Proyecto
 
Archivo -- Propósito

`Atacable.java`  Interfaz que define que todo personaje atacable debe tener un método `atacar()`.
`Personaje.java` | Clase abstracta base con `nombre` y `vida`. No se instancía directamente.
`Enemigo.java` | Clase abstracta para enemigos: agrega `daño` y un contador de enemigos derrotados.
`MonoVolador.java` | Enemigo del Nivel 1.
`MonoVoladorMejorado.java` | Enemigo del Nivel 3: más fuerte que el del Nivel 1.
`Bruja.java` | Enemiga del Nivel 2.
`BrujaMejorada.java` | Enemiga del Nivel 4: versión mejorada de la Bruja de Plata.
`Premio.java` | Clase base para recompensas (nombre y descripción).
`Companero.java` | Representa a los compañeros: Soldado, León, Hombre de Paja.
`ZapatosMagicos.java` | Objeto único que se gana en el Nivel 1.
`Inventario.java` | "Mochila" que guarda compañeros y objetos (usa **Generics**).
`Dorotea.java` | Protagonista: tiene vida, inventario de compañeros y zapatos.
`Nivel.java` | Clase abstracta base para niveles.
`NivelCombate.java` | Niveles 1-4: combate contra un enemigo y recompensa al ganar.
`NivelFinal.java` | Nivel 5: verifica que Dorotea tenga todos los compañeros y objetos.
`Juego.java` | Orquesta los 5 niveles. Usa **Singleton** (solo puede existir una instancia).
`Main.java` | Punto de entrada: inicia el juego.

## Temas de POO Aplicados

- **Herencia**: `Personaje` → `Enemigo`, `Dorotea`.
- **Abstracción**: Clases abstractas (`Personaje`, `Enemigo`, `Nivel`).
- **Interfaces**: `Atacable` define comportamiento común.
- **Encapsulamiento**: Atributos privados con getters/setters.
- **Polimorfismo**: Diferentes enemigos y niveles con el mismo método `atacar()` o `jugar()`.
- **Singleton**: Clase `Juego` solo tiene una instancia.
- **Generics**: `Inventario<T>` para guardar compañeros y objetos.
- **Clases concretas y abstractas**: Separación clara entre roles.

## Flujo del Juego

1. **Nivel 1**: Dorotea vs Mono Volador → Gana Zapatos Mágicos + Soldado de Plomo.
2. **Nivel 2**: Dorotea vs Bruja de Plata → Gana León Cobarde.
3. **Nivel 3**: Dorotea + Soldado vs Mono Mejorado → Gana Hombre de Paja.
4. **Nivel 4**: Dorotea + Soldado + León vs Bruja Mejorada → Gana la ayuda de sus compañeros.
5. **Nivel 5**: Verifica que Dorotea tenga:
    - Zapatos Mágicos
    - Soldado, León, Hombre de Paja
    - Si todo está bien → ¡Ciudad Esmeralda restaurada!
    - 
## Cómo Ejecutar

1. Se debe asegúrate de tener **Java 17 o superior** instalado.
2. Abrir la terminal en la carpeta del proyecto.
3. Compilar:
   ```bash
   javac *.java