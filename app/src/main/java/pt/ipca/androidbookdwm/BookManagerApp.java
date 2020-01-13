package pt.ipca.androidbookdwm;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import pt.ipca.androidbookdwm.models.Book;

public class BookManagerApp extends Application {

    private List<Book> lstBooks = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        Book book1 = new Book("Book 1", "Author 1",
                100, R.drawable.book_open_page_variant);

        Book book2 = new Book("Book 2", "Author 2",
                25, R.drawable.book_open);

        Book book3 = new Book("Book 3", "Author 3",
                300, R.drawable.book_outline);

        addBook(book1);
        addBook(book2);
        addBook(book3);
    }

    public void addBook(Book book){
        lstBooks.add(book);
    }

    public void removeBook(int position){
        lstBooks.remove(position);
    }

    public List<Book> getLstBooks() {
        return lstBooks;
    }
}
