package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.adapters;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.R;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities.Player;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {

    private ArrayList<Player> players = new ArrayList<Player>();

    public RankingAdapter(ArrayList<Player> players) {
        this.players = players;
    }

    // Primary methods of the adapter
    @NonNull
    @Override
    public RankingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingAdapter.ViewHolder holder, int position) {
        try {
            Player player = players.get(position);

            TextView tvNickname = holder.tvNickname;
            tvNickname.setText(player.getNickname());

            TextView tvScore = holder.tvScore;
            int score = player.getScore();
            tvScore.setText(""+score);

        } catch (NullPointerException e) {
            Log.e("Adapter", "onBindViewHolder: Null Pointer: " + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    // The ViewHolder describes and provides access to all the views within each item row

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvNickname, tvScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNickname = (TextView) itemView.findViewById(R.id.player_nickname);
            tvScore = (TextView) itemView.findViewById(R.id.player_score);
        }
    }

}
