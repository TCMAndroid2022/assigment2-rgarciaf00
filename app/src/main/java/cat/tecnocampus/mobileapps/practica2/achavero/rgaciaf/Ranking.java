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

public class Ranking extends AppCompatActivity {

    private RecyclerView recyclerView;
    PlayerController playerController;

    // Variables
    private List<Player> players = new ArrayList<Player>();
    private RankingAdapter rankingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ranking);
        recyclerView = (RecyclerView) findViewById(R.id.rvPlayers);
        playerController = new PlayerController(getApplication());

        initRecyclerView();
        //insertFakePlayers();
        showPlayers();

        setTitle("RANKING");
    }

    private void initRecyclerView(){
        rankingAdapter = new RankingAdapter((ArrayList<Player>) players);
        recyclerView.setAdapter(rankingAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void insertFakePlayers(){
        for(int i = 0; i < 5; i++){
            String name = "Player #" + i;
            int score = i;
            Player player = new Player(name,score);
            players.add(player);
        }
        rankingAdapter.notifyDataSetChanged();
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
}