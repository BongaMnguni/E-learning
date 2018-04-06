package com.elearning.e_learning.AssessmentSupports;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elearning.e_learning.R;

/**
 * Created by Payghost on 8/7/2017.
 */

public class AssessmentSupportsViewHolder extends RecyclerView.ViewHolder{
    public TextView grade,subject,phase,category;
    public ImageView imageViewfile;


    public AssessmentSupportsViewHolder(View v){
        super(v);
        subject =(TextView)v.findViewById(R.id.tvsubject_assessment);
        grade = (TextView)v.findViewById(R.id.tvgrade_assessment);
        phase = (TextView)v.findViewById(R.id.tvphase_assessment);
        category = (TextView)v.findViewById(R.id.tvcategory_assessment);
        imageViewfile = (ImageView)v.findViewById(R.id.ivimage_assessment);
    }
}
