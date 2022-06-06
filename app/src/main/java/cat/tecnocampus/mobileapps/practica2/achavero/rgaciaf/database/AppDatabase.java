package cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.contracts.GameDAO;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.contracts.PlayerDAO;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities.Game;
import cat.tecnocampus.mobileapps.practica2.achavero.rgaciaf.entities.Player;

@Database(entities = {Game.class, Player.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
        public abstract GameDAO gameDAO();
        public abstract PlayerDAO playerDAO();
}
