package com.example.groupassignment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.groupassignment.MainActivity;
import com.example.groupassignment.R;

import java.util.List;

public class TextAdapterView extends RecyclerView.Adapter<TextViewHolder>   {


    public List<Text> text_List;

    public TextAdapterView(List textList){
        this.text_List = textList;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_text, parent, false);
        TextViewHolder holder = new TextViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final TextViewHolder holder, final int position) {
        holder.textView3.setText(text_List.get(position).getText_topic());
        holder.textView5.setText(text_List.get(position).getText_content());
        holder.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    TextDatabase tdb = Room.databaseBuilder(v.getContext(), TextDatabase.class, "text_database")
                            .allowMainThreadQueries().build();
                    tdb.textDao().delete(text_List.get(position));
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    v.getContext().startActivity(intent);
                }

        });
    }

    @Override
    public int getItemCount() {
        return text_List.size();
    }
}
