package model.books;


public class BookCreate {
    BooksStore booksStore = new BooksStore();

    public BookCreate(TypeOfBook type, String name, String author, int weightWin, int amount) {
        Book book = new Book(type, name, author, weightWin);
        booksStore.AddBookToStore(book,amount);
    }
}
