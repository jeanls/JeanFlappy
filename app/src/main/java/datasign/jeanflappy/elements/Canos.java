package datasign.jeanflappy.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by jean on 22/01/16.
 */
public class Canos {
    private List<Cano> canos = new ArrayList<>();
    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;
    private Tela tela;
    private Pontuacao pontuacao;
    private Context context;

    public Canos(Tela tela, Pontuacao pontuacao, Context context){
        this.context = context;
        this.pontuacao = pontuacao;
        int posicaoInicial = 200;
        this.tela = tela;
        for(int i = 0; i < QUANTIDADE_DE_CANOS; i++){
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial, context));
        }
    }

    public void desenhaNo(Canvas canvas){
        for(Cano cano : canos){
            cano.desenhaNo(canvas);
        }
    }

    public void move(){
        ListIterator<Cano> iterator = canos.listIterator();
        while (iterator.hasNext()){
            Cano cano = iterator.next();
            cano.move();
            if(cano.saiuDaTela()){
                pontuacao.aumenta();
                iterator.remove();
                Cano outroCano = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context);
                iterator.add(outroCano);
            }
        }
    }

    public int getMaximo(){
        int maximo = 0;
        for(Cano cano : canos){
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public boolean temColisaoCom(Passaro passaro) {
        for(Cano cano : canos){
            if(cano.temColisaoHorizontalCom(passaro) && cano.temColisaoVerticalCom(passaro)){
                return true;
            }
        }
        return false;
    }
}
