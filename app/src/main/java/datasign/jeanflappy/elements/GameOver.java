package datasign.jeanflappy.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by jean on 22/01/16.
 */
public class GameOver {
    private Tela tela;
    private static final Paint vermelho = Cores.getCorDoGameOver();
    public GameOver(Tela tela){
        this.tela = tela;
    }
    public void desenhaNo(Canvas canvas){
        String gameOver = "Game Over";
        int centroHorizontal = centralizaTexto(gameOver);
        canvas.drawText(gameOver, centroHorizontal, tela.getAltura() / 2, vermelho);
    }

    private int centralizaTexto(String texto){
        Rect limiteDoTexto = new Rect();
        vermelho.getTextBounds(texto, 0, texto.length(), limiteDoTexto);
        return tela.getLargura() / 2 - (limiteDoTexto.right - limiteDoTexto.left)/2;
    }
}
