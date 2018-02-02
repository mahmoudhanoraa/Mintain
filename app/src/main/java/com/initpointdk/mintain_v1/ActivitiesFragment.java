package com.initpointdk.mintain_v1;

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


public class ActivitiesFragment extends Fragment {
    private AppCompatActivity activity;
    public static Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;

    private RecyclerView activitiesRecyclerView;
    private ActivitiesRecyclerViewAdabter activitiesRecyclerViewAdabter;
    private List<Mint> activities = new ArrayList<Mint>();


    public ActivitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.activities_fragment_menu, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(activity, "soso", Toast.LENGTH_LONG).show();
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
        View v = inflater.inflate(R.layout.fragment_activities, container, false);

        toolbar = (Toolbar) v.findViewById(R.id.toolbar_activity);
        collapsingToolbar = (CollapsingToolbarLayout) v.findViewById(R.id.collapse_toolbar_activity);
        activitiesRecyclerView = (RecyclerView) v.findViewById(R.id.activities_recycler);
        activitiesRecyclerViewAdabter = new ActivitiesRecyclerViewAdabter(activities);
        activitiesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.LayoutManager activitiesLayoutManager = new LinearLayoutManager(activity);
        activitiesRecyclerView.setLayoutManager(activitiesLayoutManager);
        activitiesRecyclerView.setAdapter(activitiesRecyclerViewAdabter);

        return v;
    }

    public static class ActivitiesRecyclerViewAdabter extends RecyclerView.Adapter<ActivitiesRecyclerViewAdabter.ViewHolder>{
        List<Mint> activities;

        public ActivitiesRecyclerViewAdabter(List<Mint> activities) {
            this.activities = activities;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View activityCardView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_card, parent, false);
            return new ViewHolder(activityCardView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Mint m = activities.get(position);
            holder.mintPublisher.setText(m.getAuthor());
            holder.mintTitle.setText(m.getTitle());
            holder.ago.setText(m.getDate());
        }

        @Override
        public int getItemCount() {
            return activities.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            // ImageView bannerImage;
            TextView mintTitle;
            TextView mintPublisher;
            TextView ago;

            public ViewHolder(View view) {
                super(view);
                mintTitle = (TextView) view.findViewById(R.id.mint_title);
                mintPublisher = (TextView) view.findViewById(R.id.mint_publisher);
                ago = (TextView) view.findViewById(R.id.activity_ago);
            }
        }


    }

    private void dumData(){
        for(int i = 0; i < 20; i++){
            activities.add(new Mint("koko", "hanora", "soso"));
        }
    }

}
