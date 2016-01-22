package datasign.jeanflappy.elements;

/**
 * Created by jean on 22/01/16.
 */
public class VerificadorDeColisao {
    private Canos canos;
    private Passaro passaro;

    public VerificadorDeColisao(Canos canos, Passaro passaro){
        this.canos = canos;
        this.passaro = passaro;
    }

    public boolean temColisao(){
        return canos.temColisaoCom(passaro);
    }
}
