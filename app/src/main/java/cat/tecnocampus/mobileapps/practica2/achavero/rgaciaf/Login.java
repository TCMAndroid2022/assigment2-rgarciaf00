package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.database.PlayerController;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        PlayerController playerController = new PlayerController(getApplication());
    }
}