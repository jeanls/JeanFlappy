package datasign.jeanflappy.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by jean on 22/01/16.
 */
public class Pontuacao {

    private static final Paint branco = Cores.getCorDaPontuacao();
    private int pontos;
    private Som som;
    public Pontuacao(Som som){
        this.som = som;
        pontos = 0;
    }

    public void aumenta(){
        som.play(Som.PONTOS);
        pontos++;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawText(String.valueOf(pontos), 100, 100, branco);
    }
}
