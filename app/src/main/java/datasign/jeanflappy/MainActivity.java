package datasign.jeanflappy;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;

import datasign.jeanflappy.engine.Game;

public class MainActivity extends Activity {
    private Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout container = (FrameLayout)findViewById(R.id.container);
        game = new Game(this);
        container.addView(game);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(game).start();
        game.inicia();
    }

    @Override
    protected void onPause() {
        super.onPause();
        game.cancela();
    }
}
