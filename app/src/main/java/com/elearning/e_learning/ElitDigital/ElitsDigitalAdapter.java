package com.elearning.e_learning.ElitDigital;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elearning.e_learning.R;

import java.util.List;

/**
 * Created by Payghost on 8/8/2017.
 */

public class ElitsDigitalAdapter extends RecyclerView.Adapter<ElitsDigitalViewHolder> {

    public List<ElitsDigitalItems> list ;
    private Context context;


    public ElitsDigitalAdapter(Context context,List<ElitsDigitalItems> list) {
        this.list = list;
        this.context = context;

    }
    @Override
    public ElitsDigitalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elits_digital_cardview,null);
        ElitsDigitalViewHolder viewHolder = new ElitsDigitalViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ElitsDigitalViewHolder holder,final int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.author.setText(list.get(position).getAuthor());
        holder.publisher.setText(list.get(position).getPublisher());
        holder.date.setText(list.get(position).getDate());
        holder.place.setText(list.get(position).getPlace());

        holder.imageViewfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(position).getFile()));
                context.startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

}

