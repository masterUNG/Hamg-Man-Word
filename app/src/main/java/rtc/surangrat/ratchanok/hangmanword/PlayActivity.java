package rtc.surangrat.ratchanok.hangmanword;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    private EditText editText;
    private TextView timeTextView, scoreTextView, questionTextView, answerTextView;
    private int scoreAnInt = 0, timeAnInt = 30, wordAnInt = 0, index = 0;
    private MyConstant myConstant;
    private String[] questionStrings, answerStrings;
    private String resultString;
    private int maxLengthofEditText;
    private ArrayList<String> answerArrayList, testStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        bindWidget();

        checkTime();

        //Setup
        maxLengthofEditText = getIntent().getIntExtra("Word", 4);
        Log.d("3decV1", "maxLength ==> " + maxLengthofEditText);

        //Question & Answer
        myConstant = new MyConstant();
        switch (maxLengthofEditText) {
            case 4:
                questionStrings = myConstant.getQuestionStrings();
                answerStrings = myConstant.getAnswerStrings();
                break;
            case 6:
                questionStrings = myConstant.getQuestion2Strings();
                answerStrings = myConstant.getAnswer2Strings();
                break;
            case 8:
                questionStrings = myConstant.getQuestion3Strings();
                answerStrings = myConstant.getAnswer3Strings();
                break;
        }   // switch

        changeView(0);

        checkWord(scoreAnInt);


        //About Edittext
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLengthofEditText)});

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                resultString = editText.getText().toString();
                answerTextView.setText(resultString);
                myArrayList(resultString);

            }   // onTextChange

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }   // Main Method

    private void myArrayList(String resultString) {

        ArrayList<String> strings = new ArrayList<String>();
        strings.add(resultString);
        String s = strings.toString();
        Log.d("3decV2", "resultString ==>" + resultString);
        Log.d("3decV2", "s ==> " + s);



    }   // myArrayList


    private void changeView(int index) {

        questionTextView.setText(questionStrings[index]);

    }

    private void checkWord(int indexWord) {

        Log.d("3decV3", "Answer(" + indexWord + ") ==> " + answerStrings[indexWord]);
        String[] strings = answerStrings[indexWord].split("");
        for (int i = 1; i < strings.length; i++) {
            Log.d("3decV3", "strings(" + i + ")= " + strings[i]);
        }



        for (int i=1;i<strings.length;i++) {
            answerArrayList = new ArrayList<String>();
            answerArrayList.add(strings[i]);
            Log.d("3decV3", "answerArrayList ==> " + answerArrayList.toString());
        }





    }   // checkWord

    private void checkTime() {

        if (timeAnInt == 0) {
//            Intent intent = new Intent(PlayActivity.this, ShowScore.class);
//            startActivity(intent);
        }   // if

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timeAnInt -= 1;
                timeTextView.setText(Integer.toString(timeAnInt) + " Sec");
                checkTime();
            }
        }, 1000);

    }   // checkTime

    private void bindWidget() {
        editText = (EditText) findViewById(R.id.editText);
        timeTextView = (TextView) findViewById(R.id.textView4);
        scoreTextView = (TextView) findViewById(R.id.textView5);
        questionTextView = (TextView) findViewById(R.id.txtQuestion);
        answerTextView = (TextView) findViewById(R.id.textView6);

    }

}   // Main Class
