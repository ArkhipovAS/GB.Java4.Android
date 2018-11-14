package gb.arkhipov.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import gb.arkhipov.base.Sprite;
import gb.arkhipov.math.Rect;

public class Start extends Sprite {
    private Rect worldBounds;

    public Start(TextureAtlas atlas) {
        super(atlas.findRegion("start"));
        //setHightProportion(0.2f);

    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float posX = worldBounds.getLeft()+ getHalfWidth();
        float posY =worldBounds.getBottom()+getHalfHeight();
        pos.set(posX, posY);
        setHightProportion(0.2f);
    }

    @Override
    public void update(float delta) {
            setScale(delta);
    }


}