package in.undefined.survivor.quizz;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.undefined.survivor.detect.R;

/**
 * Created by Madhubala on 2/4/2017.
 */

public class Splash extends Activity {

Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashh);

        start = (Button)findViewById(R.id.button);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.button_6);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        mp.start();
                Intent i = new Intent(getBaseContext(), QuizzActivity.class);
                startActivity(i);
            }
        });


//        final ImageView iv = (ImageView) findViewById(R.id.imageView);
//        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
//        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_out);


//        iv.startAnimation(an);
//        an.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                iv.startAnimation(an2);
//                finish();
//
//
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//    }
    }
}