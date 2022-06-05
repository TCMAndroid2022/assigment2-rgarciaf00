package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.contracts;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities.Game;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities.Player;

@Dao
public interface PlayerDAO {
    @Query("SELECT * FROM Player")
    List<Player> getPlayers();

    @Query("SELECT * FROM Player WHERE nickname LIKE :nickname")
    List<Player> getPlayer(String nickname);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insertPlayer(Player player);

    @Delete
    void deletePlayer(Player player);
}
