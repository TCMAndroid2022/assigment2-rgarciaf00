package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {
    @PrimaryKey (autoGenerate = true)
    int id;
    String word;
    String score;
    String nickname;

    public Game(String word, String score, String nickname) {
        this.word = word;
        this.score = score;
        this.nickname = nickname;
    }
}
