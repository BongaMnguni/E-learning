package com.elearning.e_learning.CurriculumVideo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elearning.e_learning.R;

/**
 * Created by Payghost on 8/7/2017.
 */

public class CurriculumVideosViewHolder extends RecyclerView.ViewHolder{
public TextView grade,subject,phase,category;
public ImageView imageViewfile;


public CurriculumVideosViewHolder(View v){
        super(v);
        subject =(TextView)v.findViewById(R.id.tvsubject_video);
        grade = (TextView)v.findViewById(R.id.tvgrade_video);
        phase = (TextView)v.findViewById(R.id.tvphase_video);
        category = (TextView)v.findViewById(R.id.tvcategory_video);
        imageViewfile = (ImageView)v.findViewById(R.id.ivimage_video);
        }
 }
