package in.undefined.survivor.detect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import in.undefined.survivor.airovips.AriovipsMain;
import in.undefined.survivor.quizz.Splash;

/**
 * Created by Sundeep on 2/6/2017.
 */

public class StartActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button first,second,third;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Survivor: The Clean City");
        first = (Button)findViewById(R.id.first);
        second = (Button)findViewById(R.id.second);
        third = (Button)findViewById(R.id.third);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,FdActivity.class));

            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, AriovipsMain.class));

            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,Splash.class));
            }
        });
    }
}


