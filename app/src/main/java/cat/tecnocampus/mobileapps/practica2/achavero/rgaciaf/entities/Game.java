package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {
    @PrimaryKey (autoGenerate = true)
    public int id;
    public String word;
    public String score;
    public String nickname;

    public Game(String word, String score, String nickname) {
        this.word = word;
        this.score = score;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getScore() {
        return score;
    }

    public String getNickname() {
        return nickname;
    }
}
