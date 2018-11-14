package gb.arkhipov.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import gb.arkhipov.StarWar;
import gb.arkhipov.StarWar2D;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		float aspect = 3f/4f;
		config.height = 500;
		config.width = (int)(config.height*aspect);
		config.resizable = false;
		new LwjglApplication(new StarWar2D(), config);
	}
}
