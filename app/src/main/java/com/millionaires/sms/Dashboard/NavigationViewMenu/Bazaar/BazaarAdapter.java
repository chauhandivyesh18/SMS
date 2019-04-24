package com.millionaires.sms.Dashboard.NavigationViewMenu.Bazaar;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.millionaires.sms.Dashboard.NavigationViewMenu.Announcements.AddannouncementActivity;
import com.millionaires.sms.Dashboard.NavigationViewMenu.Announcements.AnnouncementAdapter;
import com.millionaires.sms.Dashboard.NavigationViewMenu.Announcements.AnnouncementModel;
import com.millionaires.sms.Dashboard.SliderAdapter;
import com.millionaires.sms.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;


public class BazaarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<BazaarModel> mAnnouncelist;
    PagerAdapter adapter;
    int[] img;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public BazaarAdapter(Context mContext, ArrayList<BazaarModel> arr_news) {
        this.context = mContext;
        this.mAnnouncelist = arr_news;
        img = new int[]{R.drawable.cosmos, R.drawable.cosmos,
                R.drawable.cosmos};
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bazaar_header, parent, false);
            return new HeaderViewHolder(layoutView);
        } else if (viewType == TYPE_ITEM) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_bazaar, parent, false);
            return new ItemViewHolder(layoutView);
        }
        throw new RuntimeException("No match for " + viewType + ".");

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holding, int i) {
        if (holding instanceof HeaderViewHolder) {

        } else if (holding instanceof ItemViewHolder) {
            ((ItemViewHolder) holding).tv_name.setText(mAnnouncelist.get(i).getName());
            ((ItemViewHolder) holding).tv_time.setText(mAnnouncelist.get(i).getTimestamp());
            ((ItemViewHolder) holding).tv_title.setText(mAnnouncelist.get(i).getTitle());
            ((ItemViewHolder) holding).tv_desc.setText(mAnnouncelist.get(i).getDescription());
            adapter = new SliderAdapter(context, img);
            ((ItemViewHolder) holding).viewpager.setAdapter(adapter);
            ((ItemViewHolder) holding).indicator.setViewPager(((ItemViewHolder) holding).viewpager);
        }


    }

    @Override
    public int getItemCount() {
        return mAnnouncelist.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_time, tv_title, tv_desc;
        ImageView iv_profilepic, iv_images;
        ViewPager viewpager;
        CircleIndicator indicator;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_username);
            tv_time = (TextView) itemView.findViewById(R.id.tv_timestamp);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_description);
            iv_images = (ImageView) itemView.findViewById(R.id.iv_images);
            iv_profilepic = (ImageView) itemView.findViewById(R.id.iv_profile);
            viewpager = (ViewPager) itemView.findViewById(R.id.pager);
            indicator = (CircleIndicator) itemView.findViewById(R.id.indicator);
            viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    currentPage = i;
                }

                @Override
                public void onPageScrollStateChanged(int i) {
                    if (i == ViewPager.SCROLL_STATE_IDLE) {
                        int pageCount = img.length;
                        if (currentPage == 0) {
                            viewpager.setCurrentItem(pageCount - 1, false);
                        } else if (currentPage == pageCount - 1) {
                            viewpager.setCurrentItem(0, false);
                        }
                    }
                }
            });
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout headerTitle;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerTitle = (LinearLayout) itemView.findViewById(R.id.lnr_createpost);
            headerTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context,AddannouncementActivity.class));
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

}
