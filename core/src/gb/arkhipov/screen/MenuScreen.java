package gb.arkhipov.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import gb.arkhipov.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {
    private SpriteBatch batch;
    private Texture img;
    TextureRegion region; //rocket
    TextureRegion region2;//target

    private Vector2 pos; //position rocket
    private Vector2 pos2;//position target
    private Vector2 trg;
    private Vector2 v;
    private Vector2 v2;
    private Vector2 vstop;
    private Vector2 vnor;
    private Vector2 l1;
    private int angle = 0;
    private float scx = 1f;
    private float scy = 1f;
    private float scx2 = 0.5f;
    private float scy2 = 0.5f;



    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("atlas.png");
        region = new TextureRegion(img, 0, 0, 64,128);
        region2 = new TextureRegion(img, 64, 0, 128,128);
        pos = new Vector2(0,0);
        pos2 = new Vector2(100,100);
        trg = new Vector2(0,0);
        v = new Vector2(1,1);
        v2 = new Vector2(0,0);
        vnor = new Vector2(0,0);
        vstop = new Vector2(0,0);
        l1 = new Vector2(0,0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.2f, 0.5f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(region, pos.x, pos.y, 0,0,64,128, scx, scy, angle);
        batch.draw(region2, pos2.x, pos2.y, 0,0,128,128, scx2, scy2, angle);
        batch.end();
        pos2.add(v2);
        v = trg.cpy().sub(pos);
        vnor = v.cpy().nor();

//        System.out.println("l1:" + l1 +" l1.len"+ l1.len() + " trg:" +trg + " pos:" + pos + "v:" + v + " vnor:" + vnor);

        if (pos.x != trg.x & pos.y != trg.y ){
            l1 = trg.cpy().sub(pos);
            l1.len();
            if (l1.len()<0.5f){
                pos.add(vstop);
//                scx2 = scx2 * 0.95f;
//                scy2 = scy2 * 0.95f;
            }
            else
            pos.add(vnor);
        }
        else {
            pos.add(vstop);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenY = Gdx.graphics.getHeight() - screenY;
        trg.x = screenX-(region.getRegionWidth()/2*scx);
        trg.y = screenY-(region.getRegionHeight()/2*scy);
        pos2.x = screenX-(region2.getRegionWidth()/2*scx2);
        pos2.y = screenY-(region2.getRegionHeight()/2*scy2);
        System.out.println("screenX:" + screenX + " screenY:" + screenY);
        System.out.println("trg.x:" + trg.x + "trg.y:" + trg.y);
        System.out.println("pos2.x:" + pos2.x + "pos2.y:" + pos2.y);
        System.out.println(" " + region.getRegionWidth() + " " +region.getRegionHeight() + " " + region2.getRegionWidth() +" " +region2.getRegionHeight() );
        v2.set(0,0);
//        scx2 = 0.5f;
//        scy2 = 0.5f;

        return super.touchUp(screenX, screenY, pointer, button);

    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case 19:{
                v2.x = 0;
                v2.y = 1;
                break;
            }
            case 20:{
                v2.x = 0;
                v2.y = -1;
                break;
            }
            case 21:{
                v2.x = -1;
                v2.y = 0;
                break;
            }
            case 22:{
                v2.x = 1;
                v2.y = 0;
                break;
            }
            case 62:{
                v2.x = 0;
                v2.y = 0;
                trg.x = pos2.x;
//                trg.y = pos2.y;
//                trg.x = pos2.x-(region2.getRegionWidth()/2*scx2);
                trg.y = pos2.y-(region2.getRegionHeight()/2*scy2);
                break;
            }
            default:{
                //v.x = 0;
                //v.y = 0;
            }
        }
        return super.keyDown(keycode);
    }
}
