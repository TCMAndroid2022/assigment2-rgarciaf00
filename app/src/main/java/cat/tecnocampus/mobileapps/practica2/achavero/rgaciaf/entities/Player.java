package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"nickname"}, unique = true)})
public class Player {
    @PrimaryKey (autoGenerate = true)
    public int id;
    public String nickname;
    public int score;

    public Player(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getScore() {
        return score;
    }
}
