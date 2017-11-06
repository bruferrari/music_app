package com.bferrari.musicapp.tracks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bferrari.musicapp.R;
import com.bferrari.musicapp.model.Album;
import com.bferrari.musicapp.model.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bferrari on 06/11/17.
 */

public class TracksActivity extends AppCompatActivity {

    private List<Track> mTracks = new ArrayList<>();
    private RecyclerView mTracksListLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);

        mTracksListLayout = findViewById(R.id.track_list);
        mTracksListLayout.setLayoutManager(new LinearLayoutManager(this));

        Album album = (Album) getIntent().getSerializableExtra("album");

        mTracks.add(new Track(1, "Track 1", album));
        mTracks.add(new Track(2, "Track 2", album));
        mTracks.add(new Track(3, "Track 3", album));
        mTracks.add(new Track(4, "Track 4", album));
        mTracks.add(new Track(5, "Track 5", album));

        TrackAdapter adapter = new TrackAdapter();
        adapter.setData(mTracks);

        mTracksListLayout.setAdapter(adapter);
    }
}
