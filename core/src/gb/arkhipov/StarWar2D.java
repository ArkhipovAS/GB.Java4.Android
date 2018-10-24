package gb.arkhipov;

import com.badlogic.gdx.Game;

import gb.arkhipov.screen.MenuScreen;

public class StarWar2D extends Game {
    @Override
    public void create(){
        setScreen(new MenuScreen());
    }
}
