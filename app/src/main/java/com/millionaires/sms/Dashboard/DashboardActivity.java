package com.millionaires.sms.Dashboard;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension;
import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.Dashboard.ExpandableList.ExpandableListAdapter;
import com.millionaires.sms.Dashboard.ExpandableList.ExpandableListDataPump;
import com.millionaires.sms.Dashboard.ExpandableList.ExpandableListModel;
import com.millionaires.sms.Dashboard.NavigationViewMenu.Announcements.AnnouncementsFragment;
import com.millionaires.sms.Dashboard.NavigationViewMenu.Bazaar.BazaarFragment;
import com.millionaires.sms.Dashboard.NavigationViewMenu.ExpenditureReports.ExpenditureReportsMainFragment;
import com.millionaires.sms.Dashboard.NavigationViewMenu.SecurityAccessFragment;
import com.millionaires.sms.R;
import com.millionaires.sms.Search.SearchFragment;
import com.millionaires.sms.Settings.SettingsActivity;
import com.millionaires.sms.Utils.NetworkUtility;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DashboardActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout mNavigationView;
    ImageButton mFavouritesButton;
    FrameLayout mFragmentContainer;
    boolean toggleFragment;
    FragmentManager mFragmentManager;
    CardView mFavouritesContainer;
    DrawerLayout mDrawer;

    public SearchView mSearchView;

    boolean searchFragmentVisible;  //toggle search fragment
    public boolean switchFragment;         //toggle navigation drawer fragments
    boolean homeToggle;             //toggle for home
    Resources resources;
    public Fragment fragment = null;

    Animation mSlideUp, mSlideDown, mRotateDown, mRotateUp;

    ExpandableListView mExpandableListView;
    ExpandableListAdapter mExpandableListAdapter;
    List<ExpandableListModel> mExpandableListTitle;
    LinkedHashMap<ExpandableListModel, List<ExpandableListModel>> mExpandableListDetail;
    private int lastExpandedPosition = -1;

    DashboardFragment mDashboardFragment;

    TextView mEmptyView;
    public RecyclerView mFavouritesRecyclerView;

    public BottomSheetBehavior behavior;
    int bottomSheetState;
    boolean bottomSheetVisible;

    static DashboardActivity INSTANCE;

    String mNavigationViewIconsTag;

    public ItemTouchHelperExtension mItemTouchHelperExtension;
    SharedPrefHelper mSharedPrefHelper;
    boolean isPaused;
    LinearLayout MidLayout;

    Context mContext;
    SearchFragment searchFragment;

    LinearLayout mHomeBottomNavigation, mBazzarBottomNavigation, mAnnounceBottomNavigation, mProfileBottomNavigation;

    Fragment mBottomNavigationFragments = null;

    //for orderdetails progressdialog;
    public ProgressDialog progressDialog;
    ProgressDialog updateMasterProgressDialog;
    public FloatingActionButton fab;
    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorTransparent));
        }

        INSTANCE = this;
        resources = getResources();
        mContext = DashboardActivity.this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);

        mHomeBottomNavigation = (LinearLayout) findViewById(R.id.market_bottom_navigation);
        mBazzarBottomNavigation = (LinearLayout) findViewById(R.id.order_bottom_navigation);
        mAnnounceBottomNavigation = (LinearLayout) findViewById(R.id.open_bottom_navigation);
        mProfileBottomNavigation = (LinearLayout) findViewById(R.id.filter_bottom_navigation);

        mFavouritesButton = (ImageButton) findViewById(R.id.favourites_button);
        mFragmentManager = getSupportFragmentManager();

        mSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        mSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        mRotateDown = AnimationUtils.loadAnimation(this, R.anim.rotate_down);
        mRotateUp = AnimationUtils.loadAnimation(this, R.anim.rotate_up);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

       /* NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.container);
        final ImageView toggle = (ImageView) findViewById(R.id.logo);
        ImageView closeNavigationView = (ImageView) findViewById(R.id.close_imageview);

        //Set logo on the action bar according to the theme
        mSharedPrefHelper = SharedPrefHelper.getInstance(this);
        String theme = mSharedPrefHelper.getString(Constants.THEME, Constants.WHITE_THEME);
        switch (theme) {
            case Constants.DARKBLUE_THEME:
                toggle.setImageResource(R.drawable.ic_menu_nav);
                break;
            case Constants.BLACK_THEME:
                toggle.setImageResource(R.drawable.ic_menu_nav);
                break;
            case Constants.WHITE_THEME:
                toggle.setImageResource(R.drawable.ic_menu_nav);
                break;
        }

        //Open drawer on click of logo
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleFragment) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                mDrawer.openDrawer(GravityCompat.START);
            }
        });

       /* //Close drawer on close icon click
        closeNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });*/

        //Set dashboard fragment
        mDashboardFragment = new DashboardFragment();
        mFragmentManager.beginTransaction().add(R.id.navigation_view_fragments_container, mDashboardFragment).commit();

        //Set login/welcome fragment on navigation drawer
        getSupportFragmentManager().beginTransaction().add(frameLayout.getId(), new NavigationViewHeaderWelcomeFragment()).commit();
       /* if (mSharedPrefHelper.getBoolean(Constants.IS_LOGGED_IN)) {
            getSupportFragmentManager().beginTransaction().add(frameLayout.getId(), new NavigationViewHeaderWelcomeFragment()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().add(frameLayout.getId(), new NavigationViewHeaderLoginFragment()).commit();
        }*/
        getSupportFragmentManager().beginTransaction().add(frameLayout.getId(), new NavigationViewHeaderWelcomeFragment()).commit();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkUtility.getInstance(mContext).isNetworkAvailable()) {

                } else {

                }
            }
        });

        //ExpandableListView for navigation drawer
        mExpandableListView = (ExpandableListView) findViewById(R.id.expandablelistview);
        mExpandableListDetail = new ExpandableListDataPump().getData(this);
        mExpandableListTitle = new ArrayList<ExpandableListModel>(mExpandableListDetail.keySet());
        mExpandableListAdapter = new ExpandableListAdapter(this, mExpandableListTitle, mExpandableListDetail);
        mExpandableListView.setAdapter(mExpandableListAdapter);

        //=================================Bottom Navigation=================================

        mHomeBottomNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnnouncementsFragment announcementsFragment = new AnnouncementsFragment();
                mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, mDashboardFragment).commit();
            }
        });

        mBazzarBottomNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BazaarFragment bazaarFragment = new BazaarFragment();
                mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, bazaarFragment).commit();
            }
        });

        mAnnounceBottomNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnnouncementsFragment announcementsFragment = new AnnouncementsFragment();
                mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, announcementsFragment).commit();
            }
        });

        mProfileBottomNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //===========================Navigation drawer item clicks===========================

        TextView Home = (TextView) findViewById(R.id.home_textview);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchFragment || searchFragmentVisible) {
                    homeToggle = true;
                    mDrawer.closeDrawer(GravityCompat.START);
                } else {
                    mDrawer.closeDrawer(GravityCompat.START);
                }
            }
        });

        final SecurityAccessFragment securityAccessFragment = new SecurityAccessFragment();
        TextView SecurityAccess = (TextView) findViewById(R.id.security_access_textview);
        SecurityAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = securityAccessFragment;
                switchFragment = true;
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });

        /*final RaiseComplaintsFragment raiseComplaintsFragment = new RaiseComplaintsFragment();
        TextView RaiseComplaints = (TextView) findViewById(R.id.raise_complaints_textview);
        RaiseComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = raiseComplaintsFragment;
                switchFragment = true;
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });*/

        /*final UploadExpenditureFragment uploadExpenditureFragment = new UploadExpenditureFragment();
        TextView UploadExp = (TextView) findViewById(R.id.upload_exp_textview);
        UploadExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = uploadExpenditureFragment;
                switchFragment = true;
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });*/

       /* final SocietyMembersFragment societyMembersFragment = new SocietyMembersFragment();
        TextView SocietyMembers = (TextView) findViewById(R.id.society_members_textview);
        SocietyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = societyMembersFragment;
                switchFragment = true;
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });*/

        final AnnouncementsFragment announcementsFragment = new AnnouncementsFragment();
        TextView Announcements = (TextView) findViewById(R.id.announcements_textview);
        Announcements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = announcementsFragment;
                switchFragment = true;
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });

        /*final ServiceProviderFragment serviceProviderFragment = new ServiceProviderFragment();
        TextView ServiceProvider = (TextView) findViewById(R.id.service_provider_textview);
        ServiceProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = serviceProviderFragment;
                switchFragment = true;
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });*/

        /*final WasteManagementFragment wasteManagementFragment = new WasteManagementFragment();
        TextView WasteManagement = (TextView) findViewById(R.id.waste_management_textview);
        WasteManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = wasteManagementFragment;
                switchFragment = true;
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });*/
/*
        final ClubhouseFragment clubhouseFragment = new ClubhouseFragment();
        TextView ClubHouse = (TextView) findViewById(R.id.clubhouse_textview);
        ClubHouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = clubhouseFragment;
                switchFragment = true;
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });

        final ClubhouseManagementFragment clubhouseManagementFragment = new ClubhouseManagementFragment();
        TextView ClubHouseManagement = (TextView) findViewById(R.id.clubhouse_management_textview);
        ClubHouseManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = clubhouseManagementFragment;
                switchFragment = true;
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });

        final SocietyMaintenanceChargesFragment societyMaintenanceChargesFragment = new SocietyMaintenanceChargesFragment();
        TextView SocietyMaintenanceCharges = (TextView) findViewById(R.id.society_maintenance_charges_textview);
        SocietyMaintenanceCharges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = societyMaintenanceChargesFragment;
                switchFragment = true;
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });*/


        TextView ChangePassword = (TextView) findViewById(R.id.change_password_textview);
        ChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fragment = reportsFragment3;
                //switchFragment = true;
                //mDrawer.closeDrawer(GravityCompat.START);
                //appBarLayout.setElevation(16);
            }
        });


        TextView Logout = (TextView) findViewById(R.id.logout_textview);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fragment = marketFragment3;
                //switchFragment = true;
                //mDrawer.closeDrawer(GravityCompat.START);
                //appBarLayout.setElevation(16);
            }
        });

        setListViewHeight(mExpandableListView, mExpandableListTitle.size());
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                mExpandableListView.smoothScrollToPosition(groupPosition + 1);
                return false;
            }
        });

        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    mExpandableListView.collapseGroup(lastExpandedPosition);
                    setListViewHeight(mExpandableListView, mExpandableListTitle.size());
                }
                lastExpandedPosition = groupPosition;
            }
        });



        //Navigate to navigation drawer fragments
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ExpandableListModel expandableListModel = (ExpandableListModel) mExpandableListAdapter.getChild(groupPosition, childPosition);
                String child = expandableListModel.getText();
                switch (child) {
                    case "Expenditure Reports":
                        fragment = ExpenditureReportsMainFragment.newInstance(0);
                        break;
                    case "Defaulters List":
                        fragment = ExpenditureReportsMainFragment.newInstance(1);
                        break;
                    case "Society Members List":
                        fragment = ExpenditureReportsMainFragment.newInstance(2);
                        break;
                    default:

                        break;
                }
                mDrawer.closeDrawer(GravityCompat.START);
                mExpandableListView.collapseGroup(groupPosition);
                setListViewHeight(mExpandableListView, mExpandableListTitle.size());
                switchFragment = true;
                return false;
            }
        });

        //DrawerListener
        mDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                if (toggleFragment) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                //Navigate to navigation drawer fragments on drawer close for smooth transition
                if (fragment != null && switchFragment == true) {
                    mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, fragment).commit();
                    if (searchFragmentVisible) {
                        searchFragmentVisible = false;
                        if (!mSearchView.isIconified()) {
                            mSearchView.setIconified(true);
                            mSearchView.onActionViewCollapsed();
                            //toolbar.onActionViewCollapsed();
                        }
                        MidLayout.setVisibility(View.VISIBLE);
                    }
                }

                if (homeToggle) {
                    if (searchFragmentVisible) {
                        mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, mDashboardFragment).commit();
                        searchFragmentVisible = false;
                        if (!mSearchView.isIconified()) {
                            mSearchView.setIconified(true);
                            mSearchView.onActionViewCollapsed();
                            //toolbar.onActionViewCollapsed();
                        }
                        MidLayout.setVisibility(View.VISIBLE);
                        homeToggle = false;
                    } else if (switchFragment) {
                        mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, mDashboardFragment).commit();
                        switchFragment = false;
                        homeToggle = false;
                    }
                }

                //Navigate to activities on navigation drawer icons click
                if (mNavigationViewIconsTag != null && !mNavigationViewIconsTag.equals("")) {
                    switch (mNavigationViewIconsTag) {
                        case Constants.SETTINGS:
                            startActivityForResult(new Intent(mContext, SettingsActivity.class), /*REQUEST_EXIT*/100);
                            //startActivity(new Intent(mContext, SettingsActivity.class));
                            break;
                    }
                    mNavigationViewIconsTag = null;
                }

                mExpandableListView.collapseGroup(lastExpandedPosition);
                setListViewHeight(mExpandableListView, mExpandableListTitle.size());
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        mEmptyView = (TextView) findViewById(R.id.empty_view);
        mFavouritesRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mFavouritesRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        ((SimpleItemAnimator) mFavouritesRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        final View bottomSheet = findViewById(R.id.bottom_sheet);
        setHeightOfFavouritesFragment(bottomSheet);
        behavior = BottomSheetBehavior.from(bottomSheet);

        //Toggle WatchList on ImageButton Click
        mFavouritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleFragment) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });

        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                bottomSheetState = newState;
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    mFavouritesButton.setImageResource(R.drawable.ic_down);
                    toggleFragment = true;
                }
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mFavouritesButton.setImageResource(R.drawable.ic_up);
                    toggleFragment = false;
                    mItemTouchHelperExtension.closeOpened();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });

        searchFragment = new SearchFragment();

        MidLayout = (LinearLayout) findViewById(R.id.mid_layout);
        mSearchView = (SearchView) findViewById(R.id.searchview);
        ImageView closeIcon = (ImageView) mSearchView.findViewById(R.id.search_close_btn);
        EditText searchText = (EditText) mSearchView.findViewById(R.id.search_src_text);
        searchText.setTextColor(getColorAttr(R.attr.textColorWhite, this));

        mSearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleFragment) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                MidLayout.setVisibility(View.GONE);
                mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, searchFragment).commit();
                searchFragmentVisible = true;
            }
        });

        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                if (switchFragment) {
                    mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, fragment).commit();
                } else if (searchFragmentVisible) {
                    mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, mDashboardFragment).commit();
                }
                searchFragmentVisible = false;
                MidLayout.setVisibility(View.VISIBLE);
                return false;
            }
        });

        if (mSharedPrefHelper.getBoolean(Constants.IS_LOGGED_IN)) {

        }

    }

    //This is used for setting ExpandableListView height
    private void setListViewHeight(ExpandableListView listView,
                                   int group) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }

    //Set BottomSheet Height on Expanded
    int bottomSheetAtHeight;

    private void setHeightOfFavouritesFragment(View bottomSheet) {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = getResources().getDisplayMetrics().density;
        float dpHeight = outMetrics.heightPixels / density;
        float dpWidth = outMetrics.widthPixels / density;
        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.LOLLIPOP) {
            bottomSheetAtHeight = (int) dpHeight * 3 / 2;
        } else {
            bottomSheetAtHeight = (int) dpHeight / 2;
        }
        bottomSheet.getLayoutParams().height = bottomSheetAtHeight;
        //mFragmentContainer.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) dpHeight/2));
    }

    //State variable used for setting activities on click of navigation drawer icons
    public void setmNavigationView(String tag) {
        mNavigationViewIconsTag = tag;
    }

    public static DashboardActivity getINSTANCE() {
        return INSTANCE;
    }

    public void setFragment(Fragment f) {
        if (mFragmentManager.findFragmentByTag("FundsFragment") != null && fragment == mFragmentManager.findFragmentByTag("FundsFragment")) {
            return;
        }
        fragment = f;
        switchFragment = true;
        mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, fragment, "FundsFragment").commit();
        mDrawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else if (toggleFragment) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (searchFragmentVisible && switchFragment) {
            //if search and navigation fragments both are there, replace search with navigation fragment on back press
            mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, fragment).commit();
            searchFragmentVisible = false;
            if (!mSearchView.isIconified()) {
                mSearchView.setIconified(true);
                mSearchView.onActionViewCollapsed();
                //toolbar.onActionViewCollapsed();
            }
            MidLayout.setVisibility(View.VISIBLE);
        } else if (switchFragment || searchFragmentVisible) { //if any one of theme is present, come on dashboard
            mFragmentManager.beginTransaction().replace(R.id.navigation_view_fragments_container, mDashboardFragment).commit();
            switchFragment = false;
            searchFragmentVisible = false;
            if (!mSearchView.isIconified()) {
                mSearchView.setIconified(true);
                mSearchView.onActionViewCollapsed();
                //toolbar.onActionViewCollapsed();
            }
            MidLayout.setVisibility(View.VISIBLE);
        } else {
            new AlertDialog.Builder(mContext)
                    .setTitle(R.string.app_name)
                    .setMessage("Do you want to exit the app?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        }
    }

    public static void hideKeyboard(Activity activity) {
        try {
            View view = activity.getCurrentFocus();

            if (view != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof AppCompatEditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }

}
