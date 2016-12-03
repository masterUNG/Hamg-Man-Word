package rtc.surangrat.ratchanok.hangmanword;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainHold extends AppCompatActivity implements View.OnClickListener {

    private ImageView easyImageView, medienImageView, diffImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hold);

        //Bind Widget
        easyImageView = (ImageView) findViewById(R.id.imageView3);
        medienImageView = (ImageView) findViewById(R.id.imageView4);
        diffImageView = (ImageView) findViewById(R.id.imageView5);

        easyImageView.setOnClickListener(this);
        medienImageView.setOnClickListener(this);
        diffImageView.setOnClickListener(this);
    }   // Main Class

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageView3:
                startActivity(new Intent(MainHold.this, EasyPlay.class));
                break;
            case R.id.imageView4:
                startActivity(new Intent(MainHold.this, MedienPlay.class));
                break;
            case R.id.imageView5:
                startActivity(new Intent(MainHold.this, PlayActivity.class));
                break;
        }


    }   // onClick
}   // Main Class
