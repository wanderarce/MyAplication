package br.com.wanderarce.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.wanderarce.myapplication.R;
import br.com.wanderarce.myapplication.entities.City;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    List<City> cities;
    public MyAdapter(List<City> cities) {
        this.cities = cities;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,  parent,false);
        return new MyViewHolder(list);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        City city = cities.get(position);
        holder.textView.setText(city.getName());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewCity);
        }
    }
}