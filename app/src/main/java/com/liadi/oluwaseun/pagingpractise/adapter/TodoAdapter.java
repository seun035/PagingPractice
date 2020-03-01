package com.liadi.oluwaseun.pagingpractise.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.liadi.oluwaseun.pagingpractise.R;
import com.liadi.oluwaseun.pagingpractise.database.Todo;

import java.util.Objects;

public class TodoAdapter extends PagedListAdapter<Todo, TodoAdapter.TodoViewHolder> {

    public TodoAdapter() {
        super(DIFF_CALLBACK );
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_list_item,parent,false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo =  getItem(position);

        if (todo != null){
            holder.textView.setText(todo.getItem());
        }else{
            holder.clear();
        }
    }

    private static DiffUtil.ItemCallback<Todo> DIFF_CALLBACK = new DiffUtil.ItemCallback<Todo>() {
        @Override
        public boolean areItemsTheSame(@NonNull Todo oldItem, @NonNull Todo newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Todo oldItem, @NonNull Todo newItem) {
            return areItemsTheSame(oldItem, newItem);
        }
    };

    class TodoViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.todo_item);
        }

        public void clear(){
            textView = null;
        }
    }
}
