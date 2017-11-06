package com.bferrari.musicapp.tracks;

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
import com.bferrari.musicapp.model.Track;
import com.bferrari.musicapp.player.PlayerActivity;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by bferrari on 03/11/17.
 */

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private List<Track> mTracks;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name;
        private ImageView cover;
        private TextView album;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.track_name);
            cover = itemView.findViewById(R.id.track_cover_image);
            album = itemView.findViewById(R.id.track_album);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, PlayerActivity.class);
            intent.putExtra("track", mTracks.get(getAdapterPosition()));

            mContext.startActivity(intent);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Track track = mTracks.get(position);
        Album album = track.getAlbum();

        holder.name.setText(track.getName());
        holder.album.setText(album.getTitle());

        Glide.with(mContext)
                .load(album.getCoverUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.cover);
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public void setData(List<Track> albumList) {
        mTracks = albumList;
        notifyDataSetChanged();
    }
}
