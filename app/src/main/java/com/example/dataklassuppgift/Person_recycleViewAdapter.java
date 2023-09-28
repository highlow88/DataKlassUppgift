package com.example.dataklassuppgift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

 class Person_recycleViewAdapter extends RecyclerView.Adapter<Person_recycleViewAdapter.MyViewHolder> {
    private final RecycleViewInterface recycleViewInterface;

    Context context;
    ArrayList<PersonModel> personModels;

    public Person_recycleViewAdapter(Context context, ArrayList<PersonModel> personModels,
                                     RecycleViewInterface recycleViewInterface) {

        this.context = context;
        this.personModels = personModels;
        this.recycleViewInterface = recycleViewInterface;

    }

    @NonNull
    @Override
    public Person_recycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row, parent, false);

        return new Person_recycleViewAdapter.MyViewHolder(view, recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Person_recycleViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(personModels.get(position).getPersonsName());
        holder.tv2Letter.setText(personModels.get(position).getPersonsAge());
        holder.tv3Letter.setText(personModels.get(position).getPersonsAddress());
        holder.imageView.setImageResource(personModels.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return personModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName, tv2Letter, tv3Letter;

        public MyViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView);
            tv2Letter = itemView.findViewById(R.id.textView2);
            tv3Letter = itemView.findViewById(R.id.textView3);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recycleViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recycleViewInterface.onItemClick(pos);
                        }

                    }
                }
            });

        }
    }
}
