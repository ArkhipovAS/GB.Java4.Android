package gb.arkhipov.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import gb.arkhipov.base.Sprite;
import gb.arkhipov.math.Rect;

public class Close extends Sprite {
    private Rect worldBounds;

    public Close(TextureAtlas atlas) {
        super(atlas.findRegion("close"));
        //setHightProportion(0.2f);

    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float posX = worldBounds.getRight() - 0.1f;
        float posY = worldBounds.getBottom() + 0.1f;
        pos.set(posX, posY);
        setHightProportion(0.2f);
    }

    @Override
    public void update(float delta) {
        setScale(delta);
    }

}
