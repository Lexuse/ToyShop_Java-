package model.books;


import java.util.ArrayList;
import java.util.List;

public class BooksStore {

    private List<Book> bookStore = new ArrayList<Book>();

    public void AddBookToStore(Book book, int amount){
        if(amount != 0){
            for (int i = 0; i <= amount ; i++) {
                bookStore.add(book);
            }
        }
    }
}
