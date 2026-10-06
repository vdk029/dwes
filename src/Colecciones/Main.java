package Colecciones;

public class Main {
    public static void main(String[] args) {
        BookCollection miColeccion = new BookCollection();

        Book libro1 = new Book("El Señor de los Anillos", 1200, "Tolkien");
        Book libro2 = new Book("El Hobbit", 310, "Tolkien");
        Book libro3 = new Book("1984", 328, "George Orwell");
        Book libro4= new Book("Los Pilares de la Tierra", 1068, "Ken Follett");
        Book libro5 = new Book("El Principito", 96, "Antoine de Saint-Exupéry");
        Book libro6 = new Book("Dune", 800, "Frank Herbert");

        miColeccion.addBook(libro1);
        miColeccion.addBook(libro2);
        miColeccion.addBook(libro3);
        miColeccion.addBook(libro4);
        miColeccion.addBook(libro5);
        miColeccion.addBook(libro6);

        System.out.println("1 +500 paginas " + miColeccion.mas500());

        System.out.println("2 -300 paginas " + miColeccion.menos300());

        System.out.println("3 Mostrar +500 " + miColeccion.listarMas500());

        System.out.println("4 Top3" + miColeccion.top3());

        System.out.println("5 Paginas totales " + miColeccion.paginasTotales());

        System.out.println("6 PRomedio paginas ");
        for (Book b : miColeccion.promedioPaginas()) {
            System.out.println("   - " + b.getBookName() + " (" + b.getNumPages() + " pags)");
        }
        System.out.println("7 Autores unicos: " + miColeccion.autoresUnicos());

        System.out.println("8 Autores que tienen mas de 1 libro: " + miColeccion.autoresMasLibros());

        System.out.println("9 Libro con mas paginsa " + miColeccion.libroConMasPaginas().getBookName());

        System.out.println("10 Todos los libros " + miColeccion.todosLosTitulos());

        //Ej 2
        System.out.println("Antes de ordenar ");
        miColeccion.mostrarLibros();
        miColeccion.ordenarLibros();

        System.out.println("Despues de ordenar de la A a la Z");
        miColeccion.mostrarLibros();
    }

}