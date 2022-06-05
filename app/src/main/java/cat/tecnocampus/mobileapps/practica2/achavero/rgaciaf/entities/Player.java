package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"nickname"}, unique = true)})
public class Player {
    @PrimaryKey (autoGenerate = true)
    int id;
    String nickname;
    int score;

    public Player(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
    }
}
