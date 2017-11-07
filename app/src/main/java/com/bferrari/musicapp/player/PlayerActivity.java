package com.bferrari.musicapp.player;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bferrari.musicapp.R;
import com.bferrari.musicapp.albums.AlbumsActivity;
import com.bferrari.musicapp.model.Track;
import com.bumptech.glide.Glide;

/**
 * Created by bferrari on 06/11/17.
 */

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTrackTitle;
    private TextView mAlbumTitle;
    private ImageButton mPlayButton;
    private ImageView mAlbumCover;

    private boolean playing = false;

    private Track mTrack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mTrack = (Track) getIntent().getSerializableExtra("track");

        bindUI();
        setupUI();
    }

    private void bindUI() {
        mTrackTitle = findViewById(R.id.player_track);
        mAlbumTitle = findViewById(R.id.player_album);
        mPlayButton = findViewById(R.id.player_play);
        mAlbumCover = findViewById(R.id.player_album_cover);
    }

    private void setupUI() {
        mPlayButton.setOnClickListener(this);
        if (mTrack != null) {
            mTrackTitle.setText(mTrack.getName());
            mAlbumTitle.setText(mTrack.getAlbum().getTitle());

            Glide.with(this)
                    .load(mTrack.getAlbum().getCoverUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(mAlbumCover);
        } else {
            mTrackTitle.setText("no track playing");
            mAlbumTitle.setText("no album playing");

            Glide.with(this)
                    .load("")
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(mAlbumCover);
        }


    }

    @Override
    public void onClick(View view) {
        if (playing) {
            mPlayButton.setImageResource(R.drawable.ic_pause_white);
            playing = false;
        } else {
            mPlayButton.setImageResource(R.drawable.ic_play_arrow_white);
            playing = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.album_action) {
            startActivity(new Intent(this, AlbumsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
