package rtc.surangrat.ratchanok.hangmanword;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    private EditText editText;
    private TextView timeTextView, scoreTextView, questionTextView, answerTextView;
    private int scoreAnInt = 0, timeAnInt = 30, wordAnInt = 0, index = 0;
    private MyConstant myConstant;
    private String[] questionStrings, answerStrings;
    private String resultString;
    private int maxLengthofEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        bindWidget();

        checkTime();

        maxLengthofEditText = getIntent().getIntExtra("Word", 4);
        Log.d("3decV1", "maxLength ==> " + maxLengthofEditText);

        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLengthofEditText)});

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                resultString = editText.getText().toString();
                answerTextView.setText(resultString);

            }   // onTextChange

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




    }   // Main Method






    private void changeView(int index) {

        questionTextView.setText(questionStrings[index]);

    }

    private void checkWord(int indexWord) {

        String[] strings = answerStrings[index].split("");

        for (int i = 0; i < strings.length; i++) {
            Log.d("1decV1", "strings(" + i + ")= " + strings[i]);
        }



    }   // checkWord

    private void checkTime() {

        if (timeAnInt == 0) {
            Intent intent = new Intent(PlayActivity.this, ShowScore.class);
            startActivity(intent);
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
