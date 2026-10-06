package Colecciones;

public class Book implements Comparable<Book> {
    // Atributos
    private String bookName;
    private int numPages;
    private String bookAuthor;

    // Constructores
    public Book(String bookName, int numPages, String bookAuthor){
        this.bookName = bookName;
        this.numPages = numPages;
        this.bookAuthor = bookAuthor;
    }

    public Book(){
        this.bookName = "DEFAULTNAME";
        this.numPages = 300;
        this.bookAuthor = "DEFAULTAUTHOR";
    }

    //Ejercicio 2
    @Override
    public int compareTo(Book otroLibro) {
        return this.bookName.compareTo(otroLibro.getBookName());
    }

    // Getters y Setters
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", numPages=" + numPages +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }
}