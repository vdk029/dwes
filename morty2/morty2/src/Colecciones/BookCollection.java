package Colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookCollection {
    private List<Book> libros;

    public BookCollection() {
        this.libros = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.libros.add(book);
    }
    public int mas500() {
        int contador = 0;
        for (Book b : libros) {
            if (b.getNumPages() > 500) {
                contador++;
            }
        }
        return contador;
    }

    public int menos300() {
        int contador = 0;
        for (Book b : libros) {
            if (b.getNumPages() < 300) {
                contador++;
            }
        }
        return contador;
    }
    public List<String> listarMas500() {
        List<String> titulos = new ArrayList<>();
        for (Book b : libros) {
            if (b.getNumPages() > 500) {
                titulos.add(b.getBookName());
            }
        }
        return titulos;
    }
    public List<String> top3() {
        List<Book> copiaLibros = new ArrayList<>(libros);
        copiaLibros.sort((libro1, libro2) -> Integer.compare(libro2.getNumPages(), libro1.getNumPages()));

        List<String> top3 = new ArrayList<>();
        int limite = Math.min(3, copiaLibros.size());

        for (int i = 0; i < limite; i++) {
            top3.add(copiaLibros.get(i).getBookName());
        }
        return top3;
    }

    public int paginasTotales() {
        int suma = 0;
        for (Book b : libros) {
            suma += b.getNumPages();
        }
        return suma;
    }
    public List<Book> promedioPaginas() {
        List<Book> librosSobrePromedio = new ArrayList<>();
        if (libros.isEmpty()) return librosSobrePromedio;

        double promedio = (double) paginasTotales() / libros.size();

        for (Book b : libros) {
            if (b.getNumPages() > promedio) {
                librosSobrePromedio.add(b);
            }
        }
        return librosSobrePromedio;
    }

    public Set<String> autoresUnicos() {
        //hashset descartar libros repetidos
        Set<String> autores = new HashSet<>();
        for (Book b : libros) {
            autores.add(b.getBookAuthor());
        }
        return autores;
    }

    public Set<String> autoresMasLibros() {
        Map<String, Integer> conteoAutores = new HashMap<>();
        for (Book b : libros) {
            String autor = b.getBookAuthor();
            conteoAutores.put(autor, conteoAutores.getOrDefault(autor, 0) + 1);
        }

        Set<String> autoresRep = new HashSet<>();
        for (Map.Entry<String, Integer> entry : conteoAutores.entrySet()) {
            if (entry.getValue() > 1) {
                autoresRep.add(entry.getKey());
            }
        }
        return autoresRep;
    }

    public Book libroConMasPaginas() {
        if (libros.isEmpty()) return null;

        Book libroMayor = libros.get(0);
        for (Book b : libros) {
            if (b.getNumPages() > libroMayor.getNumPages()) {
                libroMayor = b;
            }
        }
        return libroMayor;
    }

    public List<String> todosLosTitulos() {
        List<String> titulos = new ArrayList<>();
        for (Book b : libros) {
            titulos.add(b.getBookName());
        }
        return titulos;
    }


    //EJ 2

    public void ordenarLibros() {
        this.libros.sort(null);
    }
    public void mostrarLibros() {
        for (Book b : libros) {
            System.out.println(b.getBookName());
        }
    }
}