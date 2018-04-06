package com.elearning.e_learning.AssessmentSupports;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.elearning.e_learning.R;
import java.util.List;

/**
 * Created by Payghost on 8/7/2017.
 */

public class AssessmentSupportAdapter  extends RecyclerView.Adapter<AssessmentSupportsViewHolder> {

    public List<AssessmentSupportsItems> list ;
    private Context context;


    public AssessmentSupportAdapter(Context context,List<AssessmentSupportsItems> list) {
        this.list = list;
        this.context = context;

    }
    @Override
    public AssessmentSupportsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.assessment_support_cardview,null);
        AssessmentSupportsViewHolder viewHolder = new AssessmentSupportsViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AssessmentSupportsViewHolder holder,final int position) {
        holder.subject.setText(list.get(position).getSubject());
        holder.grade.setText(list.get(position).getGrade());


         int start = list.get(position).getFile().lastIndexOf("/");
         String Files = list.get(position).getFile().substring(start + 1);
         holder.category.setText(Files);



       /* if(list.get(position).getPhase().equals("GET")){
            holder.phase.setText(list.get(position).getPhase());
        }*/

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
