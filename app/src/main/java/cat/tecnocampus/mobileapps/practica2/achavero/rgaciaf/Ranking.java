package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.adapters.RankingAdapter;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.database.PlayerController;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities.Player;

public class Ranking extends AppCompatActivity implements RankingAdapter.OnPlayerListener {

    private RecyclerView recyclerView;
    PlayerController playerController;

    // Variables
    private List<Player> players = new ArrayList<Player>();
    private RankingAdapter rankingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        setTitle("RANKING");

        recyclerView = (RecyclerView) findViewById(R.id.rvPlayers);
        playerController = new PlayerController(getApplication());

        initRecyclerView();
        showPlayers();
    }

    private void initRecyclerView(){
        rankingAdapter = new RankingAdapter((ArrayList<Player>) players, this);
        recyclerView.setAdapter(rankingAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void showPlayers(){
        List<Player> currentPlayers = playerController.listPlayers();
        for(Player p: currentPlayers)
            players.add(p);
        rankingAdapter.notifyDataSetChanged();
    }

    public void PlayAgain(View view) {
        Intent myIntent = new Intent(this, Login.class);
        startActivity(myIntent);
    }

    @Override
    public void OnPlayerClick(int position) {
        Player player = players.get(position);
        Intent myIntent = new Intent(this, PlayerDetail.class);
        myIntent.putExtra("nickname", player.getNickname());
        startActivity(myIntent);
    }
}