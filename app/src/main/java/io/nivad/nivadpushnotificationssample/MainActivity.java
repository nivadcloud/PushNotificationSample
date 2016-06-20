package io.nivad.nivadpushnotificationssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.nivad.push.Facade.Facade;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Facade.initialize(this) ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button register = (Button) findViewById(R.id.activity_main_button_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Facade is the interface provided by Nivad for accessing its features
                        Facade.registerGCM(MainActivity.this);
                    }
                }).start();
            }
        });
    }

}
