package gb.arkhipov;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import gb.arkhipov.screen.GameScreen;
import gb.arkhipov.screen.MenuScreen;

public class StarWar2D extends Game {

    private Game game;

    public StarWar2D() {
        super();
        game = this;
    }

    @Override
    public void create(){
        setScreen(new MenuScreen(game));
    }
}
