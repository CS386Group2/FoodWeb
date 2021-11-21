package com.example.recipeapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recipeapp.Model.createRecipe;
import com.example.recipeapp.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>{

    Context context;
    ArrayList<createRecipe>arraylist;

    public DataAdapter(Context context, ArrayList<createRecipe>arrayList)
        {
         this.context = context;
         this.arraylist = arrayList;

        }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View itemLayout = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new DataViewHolder(itemLayout);
        }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position)
        {
        createRecipe model = arraylist.get(position);

        Glide.with(context).load(model.getUrlOfImage()).into(holder.imageView);

        holder.RecipeName.setText(model.getName());
        holder.RecipeDescription.setText(model.getDescription());
        holder.ingredients.setText(model.getIngredients());
        }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class DataViewHolder extends RecyclerView.ViewHolder
        {
            ImageView imageView;

            TextView RecipeName;
            TextView ingredients;
            TextView RecipeDescription;

            public DataViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.imageView);

                RecipeName = itemView.findViewById(R.id.recipeName);
                ingredients = itemView.findViewById(R.id.ingredients);
                RecipeDescription = itemView.findViewById(R.id.recipeDescription);

            }
        }
}
