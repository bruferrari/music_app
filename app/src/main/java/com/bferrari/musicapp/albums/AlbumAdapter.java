package com.bferrari.musicapp.albums;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bferrari.musicapp.R;
import com.bferrari.musicapp.model.Album;
import com.bferrari.musicapp.tracks.TracksActivity;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by bferrari on 03/11/17.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Album> mAlbums;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private TextView author;
        private ImageView cover;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.album_title);
            author = itemView.findViewById(R.id.album_author);
            cover = itemView.findViewById(R.id.album_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, TracksActivity.class);
            intent.putExtra("album", mAlbums.get(getAdapterPosition()));
            mContext.startActivity(intent);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Album album = mAlbums.get(position);
        holder.title.setText(album.getTitle());
        holder.author.setText(album.getAuthor());

        Glide.with(mContext)
                .load(album.getCoverUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.cover);
    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }

    public void setData(List<Album> albumList) {
        mAlbums = albumList;
        notifyDataSetChanged();
    }
}
