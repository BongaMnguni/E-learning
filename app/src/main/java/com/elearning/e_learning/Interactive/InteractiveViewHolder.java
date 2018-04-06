package com.elearning.e_learning.Interactive;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.elearning.e_learning.R;

/**
 * Created by Payghost on 8/4/2017.
 */

public class InteractiveViewHolder  extends RecyclerView.ViewHolder{
    public TextView grade,subject,phase,category;
    public ImageView imageViewfile;


    public InteractiveViewHolder(View v){
        super(v);
        subject =(TextView)v.findViewById(R.id.tvsubject);
        grade = (TextView)v.findViewById(R.id.tvgrade);
        phase = (TextView)v.findViewById(R.id.tvphase);
        category = (TextView)v.findViewById(R.id.tvcategory);
        imageViewfile = (ImageView)v.findViewById(R.id.ivimage);
    }

}
