package com.elearning.e_learning.ElitDigital;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.elearning.e_learning.R;

/**
 * Created by Payghost on 8/8/2017.
 */

public class ElitsDigitalViewHolder  extends RecyclerView.ViewHolder{
    public TextView title,author,publisher,date,place;
    public ImageView imageViewfile;

    public ElitsDigitalViewHolder(View v){
        super(v);

        title =(TextView)v.findViewById(R.id.elitdtitle);
        author =(TextView)v.findViewById(R.id.elitsdauthor);
        publisher = (TextView)v.findViewById(R.id.elitsdpublisher);
        date = (TextView)v.findViewById(R.id.elitsddate);
        place = (TextView)v.findViewById(R.id.elitsdplace);
        imageViewfile = (ImageView)v.findViewById(R.id.elitsdimage);
    }
}