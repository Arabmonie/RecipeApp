package com.droidplate.recipeapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.droidplate.recipeapp.DetailActivity;
import com.droidplate.recipeapp.Pojo.Recipe;
import com.droidplate.recipeapp.R;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyViewHolder>{
    private Context mcontext;
    private List<Recipe> recipeList;
    RecipeOnClickListener listener;

    public  interface RecipeOnClickListener{
        void click(int pos);
    }
    public RecipeAdapter(Context mcontext, List<Recipe> recipeList) {
        this.mcontext = mcontext;
        this.recipeList = recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList){
        this.recipeList = recipeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Log.e("tag", "position " + position);


        holder.recipename.setText(recipeList.get(position).getName());
        holder.fats.setText(recipeList.get(position).getFats());
        holder.proteins.setText(recipeList.get(position).getProteins());
        holder.carbos.setText(recipeList.get(position).getCarbos());
        holder.description.setText(recipeList.get(position).getDescription());
       // holder.deliverable_ingredients.setText(recipeList.get(position).getDeliverableIngredients());

       Glide.with(mcontext)
               .load(recipeList.get(position).getImage())
               .apply(new RequestOptions().placeholder(R.drawable.belly))
               .into(holder.thumb);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mcontext, DetailActivity.class);
                myIntent.putExtra("recipe_name", recipeList.get(position).getName());
                myIntent.putExtra("description", recipeList.get(position).getDescription());
                myIntent.putExtra("fats", recipeList.get(position).getFats());
                myIntent.putExtra("proteins", recipeList.get(position).getProteins());
                myIntent.putExtra("carbos", recipeList.get(position).getCarbos());
                myIntent.putExtra("image", recipeList.get(position).getImage());
//                myIntent.putExtra("pos",get)
                mcontext.startActivity(myIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        if (recipeList != null){

        return  recipeList.size();

        }

        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView thumb;
        public TextView recipename, description, fats,
        proteins, carbos;



        public MyViewHolder(View itemView) {
            super(itemView);

            thumb = itemView.findViewById(R.id.recipe_image);
           recipename = itemView.findViewById(R.id.recipe_name);
            description = (TextView)itemView.findViewById(R.id.description);
            fats = (TextView)itemView.findViewById(R.id.fats);
            proteins = (TextView)itemView.findViewById(R.id.proteins);
           carbos = itemView.findViewById(R.id.carbos);
//           itemView.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//                   Intent intent = new Intent(mcontext,DetailActivity.class);
//                   intent.putExtra("key",getAdapterPosition());
//                   mcontext.startActivity(intent);
//               }
//           });




        }
    }

}
