package com.elearning.e_learning.ElitVideo;

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
 * Created by Payghost on 8/7/2017.
 */

public class ElitVideoAdapter  extends RecyclerView.Adapter<ElitVideoViewHolder> {

    public List<ElitVideoItems> list ;
    private Context context;


    public ElitVideoAdapter(Context context,List<ElitVideoItems> list) {
        this.list = list;
        this.context = context;

    }
    @Override
    public ElitVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elits_video_cardview,null);
        ElitVideoViewHolder viewHolder = new ElitVideoViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ElitVideoViewHolder holder,final int position) {
        holder.subject_title.setText(list.get(position).getTitle());
        holder.produced_year.setText(list.get(position).getProduced_year());
        holder.producer.setText(list.get(position).getProducer());



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

