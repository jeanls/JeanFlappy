package datasign.jeanflappy.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import datasign.jeanflappy.R;

/**
 * Created by jean on 21/01/16.
 */
public class Passaro {
    public static final int X = 100;
    public static final int RAIO = 50;
    private static final Paint vermelho = Cores.getCorDoPassaro();
    private int altura;
    private Tela tela;
    private Bitmap passaro;
    private Som som;

    public Passaro(Tela tela, Context context, Som som){
        this.altura = 100;
        this.tela = tela;
        this.som = som;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO * 2, RAIO * 2, false);
    }

    public void desenhaNo(Canvas canvas){
        //canvas.drawCircle(X, altura, RAIO, vermelho);
        canvas.drawBitmap(passaro, X-RAIO, altura-RAIO, null);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if(!chegouNoChao){
            this.altura += 5;
        }
    }

    public void pula(){
        if(altura > RAIO){
            som.play(Som.PULO);
            altura -= 150;
        }
    }

    public int getAltura() {
        return altura;
    }
}
