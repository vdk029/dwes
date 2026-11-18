package Colecciones;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FuncionalBookCollection {

    private List<Book> libros;

    public FuncionalBookCollection() {
        this.libros = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.libros.add(book);
    }

    public long mas500() {
        return libros.stream()
                .filter(b -> b.getNumPages() > 500)
                .count();
    }

    public long menos300() {
        return libros.stream()
                .filter(b -> b.getNumPages() < 300)
                .count();
    }

    public List<String> listarMas500() {
        return libros.stream()
                .filter(b -> b.getNumPages() > 500)
                .map(Book::getBookName)
                .collect(Collectors.toList());
    }

    public List<String> top3() {
        return libros.stream()
                .sorted(Comparator.comparingInt(Book::getNumPages).reversed())
                .limit(3)
                .map(Book::getBookName)
                .collect(Collectors.toList());
    }

    public int paginasTotales() {
        return libros.stream()
                .mapToInt(Book::getNumPages)
                .sum();
    }

    public List<Book> promedioPaginas() {
        double promedio = libros.stream()
                .mapToInt(Book::getNumPages)
                .average()
                .orElse(1);

        return libros.stream()
                .filter(b -> b.getNumPages() > promedio)
                .collect(Collectors.toList());
    }

    public Set<String> autoresUnicos() {
        return libros.stream()
                .map(Book::getBookAuthor)
                .collect(Collectors.toSet());
    }

    public Set<String> autoresMasLibros() {
        return libros.stream()
                .collect(Collectors.groupingBy(Book::getBookAuthor, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Book libroConMasPaginas() {
        return libros.stream()
                .max(Comparator.comparingInt(Book::getNumPages))
                .orElse(null);
    }

    public List<String> todosLosTitulos() {
        return libros.stream()
                .map(Book::getBookName)
                .collect(Collectors.toList());
    }
}
