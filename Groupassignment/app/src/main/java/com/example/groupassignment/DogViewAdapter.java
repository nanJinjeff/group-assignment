package com.example.groupassignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupassignment.Dog;
import com.example.groupassignment.DogDescription;
import com.example.groupassignment.R;

import java.util.List;

public class DogViewAdapter extends RecyclerView.Adapter<DogViewHolder>   {

    public List<Dog> dog_List;

    public DogViewAdapter(List dogList){
        this.dog_List = dogList;
    }

    @Override
    public DogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_dog, parent, false);
        DogViewHolder holder = new DogViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final DogViewHolder holder, final int position) {
        holder.textView2.setText(dog_List.get(position).getName());
        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DogDescription.class);
                intent.putExtra("dogNum", dog_List.get(position).getId());
                intent.putExtra("dogName", dog_List.get(position).getName());
                int urlDogImageID = dog_List.get(position).getId();
                intent.putExtra("urlID",urlDogImageID);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dog_List.size();
    }
}
