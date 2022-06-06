package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.adapters.DetailAdapter;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.database.PlayerController;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities.Game;

public class PlayerDetail extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Game> games = new ArrayList<Game>();
    private DetailAdapter detailAdapter;
    PlayerController playerController;

    TextView tvPlayerName;
    String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            nickname = extras.getString("nickname");
        }

        playerController = new PlayerController(getApplication());

        tvPlayerName = findViewById(R.id.tvPlayerName);
        tvPlayerName.setText(nickname);

        //initRecyclerView();
        //insertFakeStands();
    }

    private void initRecyclerView(){
        detailAdapter = new DetailAdapter(games);
        recyclerView.setAdapter(detailAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void insertFakeStands(){

    }
}