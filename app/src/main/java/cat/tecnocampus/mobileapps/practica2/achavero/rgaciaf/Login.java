package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.database.PlayerController;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities.Player;

public class Login extends AppCompatActivity {

    PlayerController playerController;
    EditText playerNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        playerController = new PlayerController(getApplication());
        playerNickname = (EditText) findViewById(R.id.etPlayerNickname);
    }

    public void PlayGame(View view) {
        String nickname = playerNickname.getText().toString();

        if (nickname.matches("")) {
            Toast.makeText(this, "You did not enter a nickname", Toast.LENGTH_SHORT).show();
            return;
        }

        Player player = playerController.getPlayer(nickname);

        if (player == null) {
            player = new Player(nickname,0);
            playerController.insertPlayer(player);
        }

        Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.putExtra("nickname", nickname);
        startActivity(myIntent);
    }
}