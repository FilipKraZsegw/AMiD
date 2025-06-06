package com.example.szachownica;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Panel P;
    Paint tlo_pola = new Paint();
    Paint tlo_pola2 = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(P=new Panel(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu); // Załaduj menu tylko raz
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.tw) {
            Context context = getApplicationContext();
            CharSequence text = "Twórca: Filip Krasinski";
            int czas = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, czas);
            toast.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 0);
            toast.show();
            return true;
        } else if (id == R.id.wyjscie) {
            finish();
            return true;
        } else if (id == R.id.kolor1) {
            tlo_pola.setColor(Color.BLACK);
            tlo_pola2.setColor(Color.WHITE);
            P.postInvalidate();
            return true;
        } else if(id == R.id.kolor2) {
            tlo_pola.setColor(Color.RED);
            tlo_pola2.setColor(Color.YELLOW);
            P.postInvalidate();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    class Panel extends View {
        public Panel (Context context) {
            super (context);
            tlo_pola.setColor(Color.WHITE);
            tlo_pola2.setColor(Color.BLACK);
        }
        @Override
        public void onDraw (Canvas canvas) {
            canvas.drawColor(Color.GRAY);
            float width = P.getWidth();
            float height = P.getHeight();

            float m = Math.min(width,height);
            for (int i=0;i<8;i++) {
                for (int j=0;j<8;j++) {
                    if((i+j)%2==0) {
                    canvas.drawRect(i*m/8,  j*m/8, (i+1)*m/8, (j+1)*m/8, tlo_pola);
                } else {
                        canvas.drawRect( i*m/8,  j*m/8,  (i+1)*m/8, (j+1) *m/8, tlo_pola2);
                    }

                }
            }
        }
    }
}