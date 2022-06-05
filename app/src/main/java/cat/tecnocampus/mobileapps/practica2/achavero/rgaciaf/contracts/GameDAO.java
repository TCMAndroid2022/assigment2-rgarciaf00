package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.contracts;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities.Game;

@Dao
public interface GameDAO {
    @Query("SELECT * FROM Game")
    List<Game> getGames();

    @Query("SELECT * FROM Game WHERE nickname LIKE :nickname")
    List<Game> getPlayerGames(String nickname);

    @Insert
    void insertGame(Game game);

    @Delete
    void deleteGame(Game game);
}
