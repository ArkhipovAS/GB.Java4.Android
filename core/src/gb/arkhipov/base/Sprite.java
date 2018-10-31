package gb.arkhipov.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import gb.arkhipov.math.Rect;

public class Sprite extends Rect {

    protected float angle;
    protected float scale = 1f;
    protected TextureRegion[] regions;
    protected int frame;

    public Sprite (TextureRegion region){
        if (region == null){
            throw new NullPointerException("region is null");
        }
        regions = new TextureRegion[1];
        regions[0] = region;
    }

    public void draw (SpriteBatch batch){
        batch.draw(
                regions[frame],//текущий регион
                getLeft(), getBottom(), //точка отрисовки по центру
                halfWidth, halfHeight, // точка вращения
                getWidth(),getHeight(), //ширина и вытсора объекта
                scale, scale, //масштаб по Х и по Y
                angle //угол вращения
        );
    }

    public void setHightProportion (float hight){
        setHeight(hight);
        float aspect = regions [frame].getRegionWidth()/(float)(regions[frame].getRegionHeight());
        setWidth(hight*aspect);
    }

    public void update(float delta){

    }

    public void resize(Rect worldBounds) {

    }

    public boolean touchDown(Vector2 touch, int pointer) {
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer ) {
        return false;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setScale (float scale) {this.scale = scale;}
}
