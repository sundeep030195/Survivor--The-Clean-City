package in.undefined.survivor.quizz;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.undefined.survivor.detect.R;
import in.undefined.survivor.detect.StartActivity;

/**
 * Created by Madhubala on 2/4/2017.
 */

public class ResultActivity extends Activity {

    TextView tv;
    Button btnRestart;
    private boolean isUserClickBackButton = false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        tv =(TextView)findViewById(R.id.textView2);
        btnRestart = (Button)findViewById(R.id.button2);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.button_6);

        StringBuffer sb = new StringBuffer();
        sb.append("\nCorrect Ans : " +QuizzActivity.correct);
        sb.append("\nWrong Ans : "+QuizzActivity.wrong);
        sb.append("\nFinal Score : " +QuizzActivity.marks);
        tv.setText(sb);
        QuizzActivity.correct = 0;
        QuizzActivity.wrong = 0;
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent in = new Intent(getApplicationContext(),Splash.class);
                startActivity(in);
            }

        });


    }
    public  void clickExit(View v){
        Intent in = new Intent(getApplicationContext(),StartActivity.class);
        startActivity(in);
    }

    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this);
        builder.setMessage("Do you want to exit???");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
                alert.show();;
    }


}


