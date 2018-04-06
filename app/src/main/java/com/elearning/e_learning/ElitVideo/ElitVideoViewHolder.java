package com.elearning.e_learning.ElitVideo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.elearning.e_learning.R;

/**
 * Created by Payghost on 8/7/2017.
 */

public class ElitVideoViewHolder  extends RecyclerView.ViewHolder{
    public TextView subject_title,producer,produced_year;
    public ImageView imageViewfile;

    public ElitVideoViewHolder(View v){
        super(v);
        producer =(TextView)v.findViewById(R.id.elitsvproducer);
        subject_title = (TextView)v.findViewById(R.id.elitvtitle);
        produced_year = (TextView)v.findViewById(R.id.elitsvyear);
        imageViewfile = (ImageView)v.findViewById(R.id.elitsvimageview);
    }
}