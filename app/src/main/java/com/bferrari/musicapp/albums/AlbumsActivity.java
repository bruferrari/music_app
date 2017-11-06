package com.bferrari.musicapp.albums;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bferrari.musicapp.R;
import com.bferrari.musicapp.model.Album;

import java.util.ArrayList;
import java.util.List;

public class AlbumsActivity extends AppCompatActivity {

    private List<Album> mAlbums = new ArrayList<>();
    private RecyclerView mAlbumsListLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAlbumsListLayout = findViewById(R.id.albums_list);
        mAlbumsListLayout.setLayoutManager(new LinearLayoutManager(this));

        mAlbums.add(new Album("Album 1", "Author 1", ""));
        mAlbums.add(new Album("Album 2", "Author 2", ""));
        mAlbums.add(new Album("Album 3", "Author 3", ""));
        mAlbums.add(new Album("Album 4", "Author 4", ""));
        mAlbums.add(new Album("Album 5", "Author 5", ""));


        AlbumAdapter adapter = new AlbumAdapter();
        adapter.setData(mAlbums);

        mAlbumsListLayout.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
