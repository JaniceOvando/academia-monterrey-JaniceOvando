package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="libro")
public class Libro {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="autor")
    private String autor;

    @Column(name="isbn")
    private String isbn;

    @Column (name="precio")
    private double precio;


    // define constructors
    public Libro() {

    }

    public Libro(String titulo, String autor, String isbn, double precio) {
        this.titulo= titulo;
        this.autor= autor;
        this.isbn= isbn;
        this.precio= precio;
    }

    // define getter/setter

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() { return isbn;
    }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public double setPrecio() { return precio; }
    public void  setPrecio(double precio) { this.precio = precio; }

    // define toString
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo ='" + titulo + '\'' +
                ", autor ='" + autor + '\'' +
                ", isbn ='" + isbn + '\'' +
                ", precio ='" + precio + '\'' +
                '}';
    }
}








