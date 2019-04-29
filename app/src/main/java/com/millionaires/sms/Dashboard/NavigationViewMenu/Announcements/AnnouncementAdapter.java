package com.millionaires.sms.Dashboard.NavigationViewMenu.Announcements;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.millionaires.sms.Dialogs.AnnouncementDialog;
import com.millionaires.sms.R;

import java.util.ArrayList;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.AnnouncementAdapterViewHolder> {

    Context context;
    ArrayList<AnnouncementModel> mAnnouncelist;

    public AnnouncementAdapter(Context mContext, ArrayList<AnnouncementModel> arr_news) {
        this.context=mContext;
        this.mAnnouncelist=arr_news;
    }

    @Override
    public AnnouncementAdapterViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_announcement_item, parent, false);
        AnnouncementAdapterViewHolder myViewHolder = new AnnouncementAdapterViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(AnnouncementAdapterViewHolder holder, int i) {
        holder.tv_title.setText(mAnnouncelist.get(i).getTitle());
        String desc=mAnnouncelist.get(i).getDescription();

        if(desc.length()>=50)
        {
            holder.tv_description.setText(mAnnouncelist.get(i).getDescription().substring(0,50)+"...");
        }
        else
        {
            holder.tv_description.setText(mAnnouncelist.get(i).getDescription());
        }
        holder.tv_datetime.setText(mAnnouncelist.get(i).getDatetime());
    }

    @Override
    public int getItemCount() {
        return mAnnouncelist.size();
    }

    public class AnnouncementAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_title,tv_description,tv_datetime;
        ImageView img;
        public AnnouncementAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=(TextView) itemView.findViewById(R.id.tv_title);
            tv_description=(TextView) itemView.findViewById(R.id.tv_message);
            tv_datetime=(TextView) itemView.findViewById(R.id.tv_datetime);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            AnnouncementDialog confirmDialog = new AnnouncementDialog(context, mAnnouncelist.get(position).getTitle(), false,mAnnouncelist.get(position).getDatetime(),mAnnouncelist.get(position).getDescription());
            confirmDialog.show();
            Window window = confirmDialog.getWindow();
            window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        }
    }
}
