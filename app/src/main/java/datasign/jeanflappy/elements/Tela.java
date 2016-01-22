package datasign.jeanflappy.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import datasign.jeanflappy.R;

/**
 * Created by jean on 21/01/16.
 */
public class Tela {
    private DisplayMetrics metrics;
    private Context context;
    public Tela(Context context){
        this.context = context;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }

    public int getLargura(){
        return metrics.widthPixels;
    }

    public int getAltura(){
        return metrics.heightPixels;
    }

    public Bitmap getBackground(){
        Bitmap back = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
        return Bitmap.createScaledBitmap(back, back.getWidth(), getAltura(), false);
    }
}
