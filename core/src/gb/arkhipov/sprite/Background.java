package gb.arkhipov.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import gb.arkhipov.base.Sprite;
import gb.arkhipov.math.Rect;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}
