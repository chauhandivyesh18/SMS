package com.millionaires.sms.Search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.millionaires.sms.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    ArrayList<String> mList;
    Context mContext;
    boolean mIsAllFragment;

    public SearchAdapter(ArrayList<String> mList, Context mContext, boolean mIsAllFragment) {
        this.mList = mList;
        this.mContext = mContext;
        this.mIsAllFragment = mIsAllFragment;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_search, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        //Logit.d("Exch", mExchInfoModel.getExch());
    }

    @Override
    public int getItemCount() {
        if (mIsAllFragment) {
            if(mList.size() < 4)
                return mList.size();
            else
                return 4;
        } else
            return mList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mCompanyNameTextView;
        TextView mExchangeTypeTextView;
        TextView mScripCodeTextView;
        ImageView mAddIconImageView;

        FrameLayout mAddIconLayout;

        public SearchViewHolder(View itemView) {
            super(itemView);

            mCompanyNameTextView = (TextView) itemView.findViewById(R.id.cname_textview);
            mExchangeTypeTextView = (TextView) itemView.findViewById(R.id.exchange_type_textview);
            mScripCodeTextView = (TextView) itemView.findViewById(R.id.scrip_code_textview);
            mAddIconImageView = (ImageView) itemView.findViewById(R.id.add_icon_imageview);
            mAddIconLayout = (FrameLayout) itemView.findViewById(R.id.add_icon_layout);
            itemView.setOnClickListener(this);
            mAddIconLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
