package in.undefined.survivor.quizz;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import in.undefined.survivor.detect.R;

public class QuizzActivity extends Activity
{
    TextView tv;
    Button btnNext;
    RadioButton rb1, rb2, rb3, rb4;
    RadioGroup rg;

    private String mQuestion[] = {
            "Q1 How many acres of forest could be saved by recycling half the world's paper? ",
            "Q2 For each $1,000.00 of fast food served, the solid waste created equals? ",
            "Q3 To manufacture 85 million tons of paper, how many trees must be cut down and processed? ",
            "Q4 Using recycled glass to produce new glass products reduces air pollution by .....%? ",
            "Q5 Every ton of new glass produced generates ...... lbs. of air pollution? ",
            "Q6 The Department of Agriculture found a way to make disposable diapers out of.......? ",
            "Q7 By what year is San Francisco planning to recycle and compost 100% of its trash?",
            "Q8 Which ONE of the following items DOES belong in the blue recycling container?",
            "Q9 Which of the following can NOT be placed in a school composting container or in your yard waste cart at home? ",
            "Q10 Which of the following is recyclable material?",
            "Q11 Reuse of stuff would",
            "Q12 Consumers are encouraged to reduce their waste by...",
            "Q13 The percentage of waste in a house that is recyclable is...",
            "Q14 Which type of plastic is more friendly to the environment?",
            "Q15 How much energy could 1 recycled tin can save?",
            "Q16 Glass can be recycled without alteration",
            "Q17 How many trees will be saved by recycling 1 ton of paper?",
            "Q18 Composting is achieved through recycling...",
             "Q19 Making new containers from crushed glass helps to",
            "Q20 Metal is a/an..",

    };

    private String[][] mChoices = {
            {"10 million ","50 million ","20 million ","25 million "},
            {"10 lbs.","25 lbs. ","200 lbs. ","500 lbs."},
            {"1.4 billion trees ","3 billion trees ","5.2 billion trees ","6 billion trees "},
            {"1-13% ","14-20% ","21-28% ","29-35% "},
            {"27.8 lbs. ","33.1 lbs ","42.7 lbs","47.3 lbs. "},
            {"leaves ","newspaper","magzines","chicken feather"},
            {"2045","2035","2030","2020"},
            {"Food scraps such as a banana peel","A plastic bottle","A straw", "A bottle cap"},
            {"Apple core","Milk carton","Pizza delivery box","Paper napkins"},
            {"Aluminum","Glass","Cardboard","All of the above"},
            {"Minimize the strain on the environment ","Help municipal waste management ","Both above","difficult and time consuming "},
            {"Purchasing in bulk", "Switching to re-useable", "Buying items with less packaging ", "All of the above "},
            {"5-10%", "40-60%", "80-90%", "100%"},
            {"PVC", "PET", "HDPE", "PS"},
            {"Enough to power a cell phone for 18 hours", "Enough to power a TV for 3 hours", "Enough to power lamp for 6 hours", "Enough to power a TV for 6 hours. "},
            {"once", "Twice", "5-10 times", "continously"},
            {"1 tree", "5 trees", "17 trees", "over 100 trees  "},
            {"Batteries", "Plastic", "Organic waste", "Glass"}
            ,{"save materials","Save fuel","Both above ","None of these"},
            {"Element","Artificial resource","non-renewable resource","renewable resource"}
    };


    private String mCorrectAnswer[] = {"20 million ","200 lbs. ","1.4 billion trees ","14-20% ","27.8 lbs. ","chicken feather","2020","A plastic bottle","Milk carton","All of the above","Both above","All of the above ","40-60%", "PVC", "Enough to power a TV for 3 hours", "continously", "17 trees", "Organic waste","Both above ","non-renewable resource"};

    int flag = 0;
    public static int marks, correct, wrong;

    private boolean isUserClickBackButton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        tv = (TextView) findViewById(R.id.textView);
        rb1 = (RadioButton) findViewById(R.id.radioButton2);
        rb2 = (RadioButton) findViewById(R.id.radioButton);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        rg = (RadioGroup) findViewById(R.id.rg);
        /*int color = Color.parseColor("#5AB300");
        rb1.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF,color));
        rb2.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF,color));
        rb3.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF,color));
        rb4.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF,color));*/

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.button_9);


        btnNext = (Button) findViewById(R.id.button3);
        tv.setText(mQuestion[flag]);
        rb1.setText(mChoices[0][0]);
        rb2.setText(mChoices[0][1]);
        rb3.setText(mChoices[0][2]);
        rb4.setText(mChoices[0][3]);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                RadioButton ans = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                String ansText = ans.getText().toString();

                if (ansText.equalsIgnoreCase(mCorrectAnswer[flag])) {
                    correct++;
                    Toast.makeText(QuizzActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizzActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    wrong++;

                }
                flag++;
                if (flag < mQuestion.length) {
                    tv.setText(mQuestion[flag]);
                    rb1.setText(mChoices[flag][0]);
                    rb2.setText(mChoices[flag][1]);
                    rb3.setText(mChoices[flag][2]);
                    rb4.setText(mChoices[flag][3]);
                } else {
                    marks = correct;


                    Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(in);
                }

            }

        });
    }
    public void onBackPressed()
    {
        if(!isUserClickBackButton){
            Toast.makeText(this,"Press Button Again to Exit",Toast.LENGTH_LONG).show();
            isUserClickBackButton = true;
        }
        else{
            super.onBackPressed();
        }
        new CountDownTimer(3000,1000){
                public void onTick(long millisUntilFinished){

                }
                public void onFinish(){
                    isUserClickBackButton = false;
                }
        }.start();
    }
}


