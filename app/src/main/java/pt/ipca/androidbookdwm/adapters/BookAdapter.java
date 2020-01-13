package pt.ipca.androidbookdwm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.ipca.androidbookdwm.R;
import pt.ipca.androidbookdwm.interfaces.OnItemResult;
import pt.ipca.androidbookdwm.models.Book;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> lstBooks;

    private OnItemResult onItemResult;

    public BookAdapter(List<Book> lstBooks, OnItemResult onItemResult){
        this.lstBooks = lstBooks;
        this.onItemResult = onItemResult;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);

        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, final int position) {
        Book book = lstBooks.get(position);
        holder.getTitle().setText(book.getTitle());
        holder.getAuthor().setText(book.getAuthor());
        holder.getIcon().setImageResource(book.getImage());
        holder.getPages().setText("" + book.getPages());
        holder.getDeleteButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemResult != null){
                    onItemResult.onItemDeleted(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstBooks != null ? lstBooks.size() : 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;

        private TextView title, author, pages;

        private Button deleteButton;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.bookIcon);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            pages = itemView.findViewById(R.id.pages);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }

        public ImageView getIcon() {
            return icon;
        }

        public void setIcon(ImageView icon) {
            this.icon = icon;
        }

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView getAuthor() {
            return author;
        }

        public void setAuthor(TextView author) {
            this.author = author;
        }

        public TextView getPages() {
            return pages;
        }

        public void setPages(TextView pages) {
            this.pages = pages;
        }

        public Button getDeleteButton() {
            return deleteButton;
        }

        public void setDeleteButton(Button deleteButton) {
            this.deleteButton = deleteButton;
        }
    }

}
