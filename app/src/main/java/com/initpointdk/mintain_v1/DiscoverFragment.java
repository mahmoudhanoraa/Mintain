package com.initpointdk.mintain_v1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DiscoverFragment extends Fragment {
    private AppCompatActivity activity;
    public static Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;

    // curated Lists
    private RecyclerView curatedListsRecyclerView;
    private MintListsRecycleViewAdapter curatedListsRecycleViewAdapter;
    private List<CuratedList> curatedLists = new ArrayList<CuratedList>();

    // should read shouldReadMints
    private RecyclerView shouldReadRecyclerView;
    private MintsRecyclerViewAdapter shouldReadMintsRecyclerViewAdabter;
    private List<Mint> shouldReadMints = new ArrayList<Mint>();

    // trending
    private RecyclerView trendingRecyclerView;
    private MintsRecyclerViewAdapter trendingMintsRecyclerViewAdabter;
    private List<Mint> trendingMints = new ArrayList<Mint>();

    //new
    private RecyclerView newRecyclerView;
    private MintsRecyclerViewAdapter newMintsRecyclerViewAdabter;
    private List<Mint> newMints = new ArrayList<Mint>();


    public DiscoverFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.dicover_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(activity, "item", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = (AppCompatActivity) getActivity();
        setHasOptionsMenu(true);
        dumData();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_discover, container, false);
        toolbar = (Toolbar) v.findViewById(R.id.toolbar_discover);
        collapsingToolbar = (CollapsingToolbarLayout) v.findViewById(R.id.collapse_toolbar_discover);
        activity.setSupportActionBar(toolbar);


        //START curatedListsRecyclerView
        curatedListsRecyclerView = (RecyclerView) v.findViewById(R.id.curated_list_recycler);
        curatedListsRecycleViewAdapter = new MintListsRecycleViewAdapter(curatedLists);
        curatedListsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.LayoutManager curatedListLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL, false);
        curatedListsRecyclerView.setLayoutManager(curatedListLayoutManager);
        curatedListsRecyclerView.setAdapter(curatedListsRecycleViewAdapter);

        //START should read RecyclerView
        shouldReadRecyclerView = (RecyclerView) v.findViewById(R.id.should_read_recycler);
        shouldReadMintsRecyclerViewAdabter = new MintsRecyclerViewAdapter(shouldReadMints);
        shouldReadRecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.LayoutManager shouldReadLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL, false);
        shouldReadRecyclerView.setLayoutManager(shouldReadLayoutManager);
        shouldReadRecyclerView.setAdapter(shouldReadMintsRecyclerViewAdabter);


        //START treadning RecyclerView
        trendingRecyclerView = (RecyclerView) v.findViewById(R.id.trending_recycler);
        trendingMintsRecyclerViewAdabter = new MintsRecyclerViewAdapter(trendingMints);
        trendingRecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.LayoutManager trendingLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL, false);
        trendingRecyclerView.setLayoutManager(trendingLayoutManager);
        trendingRecyclerView.setAdapter(trendingMintsRecyclerViewAdabter);

        // START new RecyclerView
        newRecyclerView = (RecyclerView) v.findViewById(R.id.new_recycler);
        newMintsRecyclerViewAdabter = new MintsRecyclerViewAdapter(newMints);
        newRecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.LayoutManager newLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL, false);
        newRecyclerView.setLayoutManager(newLayoutManager);
        newRecyclerView.setAdapter(newMintsRecyclerViewAdabter);



        return v;
    }

    private static class MintListsRecycleViewAdapter extends RecyclerView.Adapter<MintListsRecycleViewAdapter.ViewHolder>{
        List<CuratedList> mintLists;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View mintListCardView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mint_lists_card, parent, false);
            return new ViewHolder(mintListCardView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            CuratedList m = mintLists.get(position);
            holder.listTitle.setText(m.getTitle());
            holder.shortDisc.setText(m.getShortDisc());
            holder.numTitles.setText(m.getNumTitles() + "");
        }

        @Override
        public int getItemCount() {
            return mintLists.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
           // ImageView bannerImage;
            TextView listTitle;
            TextView shortDisc;
            TextView numTitles;

            public ViewHolder(View view) {
                super(view);
                listTitle = (TextView) view.findViewById(R.id.mint_list_title);
                shortDisc = (TextView) view.findViewById(R.id.mint_list_short_disc);
                numTitles = (TextView) view.findViewById(R.id.mint_list_num_titles);

            }
        }

        public MintListsRecycleViewAdapter(List<CuratedList> mintLists){
            this.mintLists = mintLists;
        }

    }

    public static class MintsRecyclerViewAdapter extends RecyclerView.Adapter<MintsRecyclerViewAdapter.ViewHolder>{
        List<Mint> mints;

        public MintsRecyclerViewAdapter(List<Mint> mints) {
            this.mints = mints;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View mintCardView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mint_card, parent, false);
            return new ViewHolder(mintCardView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Mint m = mints.get(position);
            holder.numLikes.setText(m.getNumLikes() + "");
            holder.listTitle.setText(m.getTitle());
            holder.shortDisc.setText(m.getShortDisc());
        }

        @Override
        public int getItemCount() {
            return mints.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            // ImageView bannerImage;
            TextView listTitle;
            TextView shortDisc;
            TextView numLikes;

            public ViewHolder(View view) {
                super(view);
                listTitle = (TextView) view.findViewById(R.id.mint_title);
                shortDisc = (TextView) view.findViewById(R.id.mint_short_disc);
                numLikes = (TextView) view.findViewById(R.id.mint_num_likes);
            }
        }

    }

    private void dumData(){
        for(int i = 0; i < 20; i++){
            curatedLists.add(new CuratedList("koko", "hanora", "el gamed fash5 ", 5));
            shouldReadMints.add(new Mint("koko", "hanora", 5));
            trendingMints.add(new Mint("koko", "hanora", 5));
            newMints.add(new Mint("koko", "hanora", 5));
        }
    }
}
