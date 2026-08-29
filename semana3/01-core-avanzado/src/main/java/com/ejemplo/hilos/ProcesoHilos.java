package main.java.com.ejemplo.hilos;

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class ResultadoProceso implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombreArchivo;
    private int lineasProcesadas;
    private transient String datosSensibles;

    public ResultadoProceso(String nombreArchivo, int lineasProcesadas) {
        this.nombreArchivo = nombreArchivo;
        this.lineasProcesadas = lineasProcesadas;
        this.datosSensibles = "contraseña_secreta_123";
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "nombre='" + nombreArchivo + '\'' +
                ", lineas=" + lineasProcesadas +
                ", datosSensibles='" + datosSensibles + '\'' +
                '}';
    }
}

public class ProcesoHilos {
    private static final AtomicInteger totalLineas = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("Iniciando proceso con hilos...");

        // Crear archivos de prueba
        try {
            Files.writeString(Path.of("archivo1.txt"), "Línea 1\nLínea 2\nLínea 3");
            Files.writeString(Path.of("archivo2.txt"), "Línea A\nLínea B");
            Files.writeString(Path.of("archivo3.txt"), "Línea X");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Usar ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] archivos = {"archivo1.txt", "archivo2.txt", "archivo3.txt"};

        for (String archivo : archivos) {
            executor.submit(() -> procesarArchivo(archivo));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total de líneas procesadas (concurrente): " + totalLineas.get());

        // Serialización
        ResultadoProceso resultado = new ResultadoProceso("archivo1.txt", 100);
        guardarObjeto(resultado, "resultado.dat");
        System.out.println("Objeto guardado en disco.");

        // Deserialización
        ResultadoProceso cargado = leerObjeto("resultado.dat");
        System.out.println("Objeto cargado: " + cargado);
        System.out.println("Nota: 'datosSensibles' debería ser null (por transient).");
    }

    private static void procesarArchivo(String nombre) {
        try {
            Thread.sleep(500); // Simular trabajo lento
            long lineas = Files.lines(Path.of(nombre)).count();
            totalLineas.addAndGet((int) lineas);
            System.out.println("Procesado: " + nombre + " -> " + lineas + " líneas (Hilo: " + Thread.currentThread().getName() + ")");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void guardarObjeto(ResultadoProceso obj, String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ResultadoProceso leerObjeto(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (ResultadoProceso) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}