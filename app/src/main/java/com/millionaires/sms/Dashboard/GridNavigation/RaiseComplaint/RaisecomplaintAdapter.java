package com.millionaires.sms.Dashboard.GridNavigation.RaiseComplaint;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.millionaires.sms.Dialogs.ComplaintsDialog;
import com.millionaires.sms.R;


import java.util.ArrayList;

public class RaisecomplaintAdapter extends RecyclerView.Adapter<RaisecomplaintAdapter.RaisecomplaintAdapterViewHolder> {

    Context context;
    ArrayList<RaisecomplaintModel> mAnnouncelist;
    int selectedPosition=-1;

    public RaisecomplaintAdapter(Context mContext, ArrayList<RaisecomplaintModel> arr_complaints) {
        this.context=mContext;
        this.mAnnouncelist=arr_complaints;
    }

    @Override
    public RaisecomplaintAdapterViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_complaints_item, parent, false);
        RaisecomplaintAdapterViewHolder myViewHolder = new RaisecomplaintAdapterViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RaisecomplaintAdapterViewHolder holder, int i) {
        holder.title.setText(mAnnouncelist.get(i).getTitle());
        holder.tv_flatno.setText(mAnnouncelist.get(i).getFlatno());
        holder.datetime.setText(mAnnouncelist.get(i).getDatetime());
        if(selectedPosition==i)
            holder.itemView.setBackgroundColor(Color.parseColor("#000000"));
        else
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));

    }

    @Override
    public int getItemCount() {
        return mAnnouncelist.size();
    }

    public class RaisecomplaintAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        TextView tv_flatno,title,description,status,datetime;
        public RaisecomplaintAdapterViewHolder(View itemView) {
            super(itemView);
            tv_flatno=(TextView) itemView.findViewById(R.id.tv_flatno);
            title=(TextView) itemView.findViewById(R.id.tv_title);
            datetime=(TextView) itemView.findViewById(R.id.tv_datetime);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ComplaintsDialog confirmDialog = new ComplaintsDialog(context, mAnnouncelist.get(position).getTitle(), false,mAnnouncelist.get(position).getDatetime(),mAnnouncelist.get(position).getDescription(),mAnnouncelist.get(position).getStatus());
           // AnnouncementDialog confirmDialog = new AnnouncementDialog(context, mAnnouncelist.get(position).getTitle(), false,mAnnouncelist.get(position).getDatetime(),mAnnouncelist.get(position).getDescription());
            confirmDialog.show();
            Window window = confirmDialog.getWindow();
            window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        }
    }
}
