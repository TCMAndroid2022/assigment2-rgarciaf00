package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.adapters.RankingAdapter;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.database.PlayerController;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities.Player;

public class MainActivity extends AppCompatActivity {

    private List<String> wordLetters = new ArrayList<>();

    // Layout variables
    TextView tvWord;

    // Game variables
    private String nickname;
    private String gameWord;
    private String solution;
    private int intents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("GAME");

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            nickname = extras.getString("nickname");
        }

        PlayerController playerController = new PlayerController(getApplication());
        Player player = playerController.getPlayer(nickname);
        tvWord = findViewById(R.id.test);

        getWord();
        //wordToArrayList();
    }

    private void getWord() {
        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://palabras-aleatorias-public-api.herokuapp.com/random";

        // Request a string response from the provided URL
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    // Get the game word
                    try {
                        JSONObject body = response.getJSONObject("body");
                        gameWord = body.getString("Word").toUpperCase(Locale.ROOT);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    tvWord.setText(gameWord);
                }, error -> tvWord.setText("That didn't work!"));

        // Add the request to the RequestQueue
        queue.add(jsonObjectRequest);
        tvWord.setText("TEST");
        Log.v("WORD_TEST", "END WORD");
    }

    private void wordToArrayList() {
        int length = gameWord.length();
        for (int i = 0; i < length; i++) {
            wordLetters.add(gameWord.substring(i, Math.min(length, i+1)));
        }
    }

    public void ShowRanking(View view) {
        Intent myIntent = new Intent(this, Ranking.class);
        startActivity(myIntent);
    }
}