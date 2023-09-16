package com.hacktivate8.aninterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {

    private Context mContext;
    private List<Club> mClubList;
    private ListItemClikcListener mListItemClikcListener;



    public ClubAdapter (Context context, List<Club> clubList) {
        this.mContext = context;
        this.mClubList = clubList;
    }

    public interface ListItemClikcListener {
        public void onListItemClick(View v, int position);
    }

    public void setListener(ListItemClikcListener listItemClikcListener) {
        this.mListItemClikcListener = listItemClikcListener;
    }

    @NonNull
    @Override
    public ClubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubAdapter.ViewHolder holder, int position) {
        Club club = mClubList.get(position);
        holder.nameView.setText(club.getName());

        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.build().load(club.getImg_logo())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.logoView);
    }

    @Override
    public int getItemCount() {

        return mClubList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView logoView;
        private TextView nameView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            logoView = itemView.findViewById(R.id.logo);
            nameView = itemView.findViewById(R.id.nama);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mListItemClikcListener.onListItemClick(v, getAdapterPosition());
                }
            });
        }
    }
}
