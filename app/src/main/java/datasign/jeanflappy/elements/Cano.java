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
public class Cano {

    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private Tela tela;
    private final Paint verde = Cores.getCorDoCano();
    private int posicao;
    private Bitmap canoInferior;
    private Bitmap canoSuperior;

    public Cano(Tela tela, int posicao, Context context){
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = TAMANHO_DO_CANO + valorAleatorio();
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        this.canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoInferior, false);
        this.canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoSuperior, false);
    }

    public void desenhaNo(Canvas canvas){
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(Canvas canvas){
        //canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), verde);
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas){
        //canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, verde);
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
    }

    public void move() {
        posicao -= 5;
    }

    public int valorAleatorio(){
        return (int)(Math.random() * 150);
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - Passaro.X < Passaro.RAIO;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - Passaro.RAIO < this.alturaDoCanoSuperior || passaro.getAltura() + Passaro.RAIO > this.alturaDoCanoInferior;
    }
}
