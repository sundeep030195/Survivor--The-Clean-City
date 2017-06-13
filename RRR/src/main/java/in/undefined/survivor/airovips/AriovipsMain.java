package in.undefined.survivor.airovips;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class AriovipsMain extends Activity {

    Surface view;
    WakeLock WL;
   // private ImageView img;
   // int[] setImg = {R.drawable.background, R.drawable.background1, R.drawable.background2, R.drawable.background3};
   // RelativeLayout layout1;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //background image change
	/*	setContentView((R.layout.enterhiscore));

			img = (ImageView) findViewById(R.id.img);
         img.setImageDrawable(getResources().getDrawable( R.drawable.background));

		//now gonnaa post animation
		img.post(new Runnable() {
			@Override
			public void run() {

				((AnimationDrawable)img.getBackground()).start();

			}
		});
        setContentView(R.layout.enterhiscore);

        layout1 = (RelativeLayout) findViewById(R.id.mylayout);
        Thread t;
        t = new Thread();
        t.start();

    }
    public void run() {
        for (int i = 0; i < 2; ++i) {
            layout1.setBackgroundResource(setImg[i]);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        @Override
        public void run () {
            for (int i = 0; i < 2; ++i) {
                layout1.setBackgroundResource(setImg[i]);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

*/
    //full screen
    requestWindowFeature(Window.FEATURE_NO_TITLE);

    getWindow()

    .

    setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


    RelativeLayout layout = new RelativeLayout(this);

    //layout
    view=new

    Surface(this,this);

    LayoutParams params1 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    params1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);


    layout.addView(view);

    setContentView(layout);


    //wake-lock
    PowerManager PM = (PowerManager) getSystemService(Context.POWER_SERVICE);
    WL=PM.newWakeLock(PowerManager.FULL_WAKE_LOCK,"Graphics");
    WL.acquire();

    this.

    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
    int rotation = display.getRotation();
    if(rotation==0)
    view.default_lanscape=true;
    if(rotation==180)
    view.default_lanscape=true;
    if(rotation==90)
    view.default_lanscape=false;
    if(rotation==270)
    view.default_lanscape=false;
}

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            view.back();
            return false;
        }

        return false;
    }

    protected void onPause() {
        super.onPause();
        view.pause();
        WL.release();

    }

    protected void onResume() {
        super.onResume();
        view.resume();
        WL.acquire();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        WL.release();

    }
}
