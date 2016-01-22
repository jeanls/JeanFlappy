package datasign.jeanflappy.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import datasign.jeanflappy.R;
import datasign.jeanflappy.elements.Cano;
import datasign.jeanflappy.elements.Canos;
import datasign.jeanflappy.elements.GameOver;
import datasign.jeanflappy.elements.Passaro;
import datasign.jeanflappy.elements.Pontuacao;
import datasign.jeanflappy.elements.Som;
import datasign.jeanflappy.elements.Tela;
import datasign.jeanflappy.elements.VerificadorDeColisao;

/**
 * Created by jean on 21/01/16.
 */
public class Game extends SurfaceView implements Runnable, View.OnTouchListener{

    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Cano cano;
    private Canos canos;
    private Pontuacao pontuacao;
    private Som som;

    public Game(Context context) {
        super(context);
        inicializaElementos();
        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        this.tela = new Tela(getContext());
        this.som = new Som(getContext());
        this.pontuacao = new Pontuacao(som);
        this.passaro = new Passaro(this.tela, getContext(), som);
        this.background = tela.getBackground();
        this.cano = new Cano(tela, 200, getContext());
        this.canos = new Canos(tela, pontuacao, getContext());
    }

    @Override
    public void run() {
        while (isRunning){
            if(!holder.getSurface().isValid())continue;
            //INICIO
            Canvas canvas = holder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, null);
            passaro.desenhaNo(canvas);
            passaro.cai();

            canos.desenhaNo(canvas);
            canos.move();

            if(new VerificadorDeColisao(canos, passaro).temColisao()){
                som.play(Som.COLISAO);
                new GameOver(tela).desenhaNo(canvas);
                isRunning = false;
            }
            pontuacao.desenhaNo(canvas);
            //FIM
            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia(){
        this.isRunning = true;
    }

    public void cancela(){
        this.isRunning = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        return false;
    }
}
