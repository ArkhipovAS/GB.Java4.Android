package gb.arkhipov.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import gb.arkhipov.base.Base2DScreen;
import gb.arkhipov.math.Rect;
import gb.arkhipov.sprite.Background;
import gb.arkhipov.sprite.Star;
import gb.arkhipov.sprite.Close;

public class GameScreen extends Base2DScreen {
//    private Texture img;
//    TextureRegion region; //rocket
//    TextureRegion region2;//target
//
//    private Vector2 touch;
//    private Vector2 v;
//    private Vector2 v2;
//    private Vector2 buf;
//    private Vector2 pos; //position rocket
//    private Vector2 pos2;//position target
//
//    private Sprite sprite;

    private static final int STAR_COUNT = 32;

    private Texture bgTexture;
    private Background background;
    private Rect worldBounds;

    private TextureAtlas textureAtlas;
    private Star[] stars;
    private Close close;

    public GameScreen (Game game){
        super(game);
    }

    @Override
    public void show() {
        super.show();
        bgTexture = new Texture("bg2.png");
        background = new Background(new TextureRegion(bgTexture));
        textureAtlas = new TextureAtlas("menuAtlas.tpack");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(textureAtlas);
        }
        close = new Close(textureAtlas);


//        img = new Texture("atlas.png");
//
//        region = new TextureRegion(img, 0, 0, 64,128);
//        region2 = new TextureRegion(img, 64, 0, 128,128);
//
//
//        pos = new Vector2(0,0);
//        pos2 = new Vector2(0,0);
//        touch = new Vector2();
//        v = new Vector2();
//        v2 = new Vector2();
//        buf = new Vector2();
//
//        sprite = new Sprite(new TextureRegion(img));
//        sprite.setWidth(0.5f);
//        sprite.setHeight(0.5f);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
//        buf.set(touch);
//        pos2.add(v2);
//        if (buf.sub(pos).len() > v.len()){
//            pos.add(v);
//        }
//        else {
//            pos.set(touch);
//        }
//
//        batch.begin();
////        batch.draw(region, pos.x, pos.y, 0.05f, 0.1f);
////        batch.draw(region2, pos2.x, pos2.y, 0.05f, 0.05f);
//        sprite.draw(batch);
        update(delta);
        draw();
    }

    public void update(float delta){
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(delta);
        }
    }

    public void draw(){
        Gdx.gl.glClearColor(0.2f, 0.5f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < stars.length; i++) {
            stars[i].draw(batch);
        }
        close.draw(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (int i = 0; i < stars.length; i++) {
            stars[i].resize(worldBounds);
        }
//        close.pos.set(worldBounds.getRight(), worldBounds.getBottom());
        close.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bgTexture.dispose();
        textureAtlas.dispose();
        super.dispose();
    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer) {

        if (close.isMe(touch) == true){
            close.update(0.8f);
        }


        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        if (close.isMe(touch) == true){
            close.update(1f);
            Gdx.app.exit();

        }
        return super.touchUp(touch, pointer);
    }

    @Override
    public boolean keyDown(int keycode) {
//        switch (keycode){
//            case 19:{
//                v2.set(0f, 0.05f);
//                break;
//            }
//            case 20:{
//                v2.set(0f,-0.05f);
//                break;
//            }
//            case 21:{
//                v2.set(-0.05f,0f);
//                break;
//            }
//            case 22:{
//                v2.set(0.05f,0f);
//                break;
//            }
//            case 62:{
//                v2.set(0f,0f);
//                touch.set(pos2);
//                v.set(touch.cpy().sub(pos).scl(0.01f));
//                break;
//            }
//            default:{
//            }
//        }
        return super.keyDown(keycode);
    }


}
