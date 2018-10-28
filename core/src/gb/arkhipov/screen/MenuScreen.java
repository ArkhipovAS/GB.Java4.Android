package gb.arkhipov.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import gb.arkhipov.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {
    private Texture img;
    TextureRegion region; //rocket
    TextureRegion region2;//target

    private Vector2 touch;
    private Vector2 v;
    private Vector2 v2;
    private Vector2 buf;
    private Vector2 pos; //position rocket
    private Vector2 pos2;//position target




    @Override
    public void show() {
        super.show();
        img = new Texture("atlas.png");

        region = new TextureRegion(img, 0, 0, 64,128);
        region2 = new TextureRegion(img, 64, 0, 128,128);


        pos = new Vector2(0,0);
        pos2 = new Vector2(0,0);
        touch = new Vector2();
        v = new Vector2();
        v2 = new Vector2();
        buf = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.2f, 0.5f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buf.set(touch);
        pos2.add(v2);
        if (buf.sub(pos).len() > v.len()){
            pos.add(v);
        }
        else {
            pos.set(touch);
        }

        batch.begin();
        batch.draw(region, pos.x, pos.y, 2f, 4f);
        batch.draw(region2, pos2.x, pos2.y, 2f, 2f);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        this.touch = touch;
        v.set(touch.cpy().sub(pos).scl(0.01f));
        pos2.set(touch);
        return false;
    }


    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case 19:{
                v2.set(0f, 1f);
                break;
            }
            case 20:{
                v2.set(0f,-1f);
                break;
            }
            case 21:{
                v2.set(-1f,0f);
                break;
            }
            case 22:{
                v2.set(1f,0f);
                break;
            }
            case 62:{
                v2.set(0f,0f);
                touch.set(pos2);
                v.set(touch.cpy().sub(pos).scl(0.01f));
                break;
            }
            default:{
            }
        }
        return super.keyDown(keycode);
    }
}
