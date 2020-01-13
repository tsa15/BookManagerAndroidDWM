package pt.ipca.androidbookdwm.activities;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.LinearLayout;

import pt.ipca.androidbookdwm.BookManagerApp;
import pt.ipca.androidbookdwm.R;
import pt.ipca.androidbookdwm.adapters.BookAdapter;
import pt.ipca.androidbookdwm.interfaces.OnItemResult;
import pt.ipca.androidbookdwm.models.Book;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView recyclerView;

    private BookAdapter adapter;

    private BookManagerApp bookManagerApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();

        bookManagerApp = ((BookManagerApp) getApplication());
        recyclerView = findViewById(R.id.books_recycler_view);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BookAdapter(bookManagerApp.getLstBooks(), new OnItemResult() {
            @Override
            public void onItemDeleted(int position) {
                bookManagerApp.removeBook(position);
                //adapter.notifyDataSetChanged();
                adapter.notifyItemRemoved(position);
            }

            @Override
            public void onItemSelected(int position) {

            }
        });


        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book("new book", "new autor",
                        25, R.drawable.book_open);
                bookManagerApp.addBook(book);
                adapter.notifyDataSetChanged();
            }
        });

    }

    void setUpToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
    }


}
