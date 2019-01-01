package tmib.vishal.flexiblecounter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;


public class CountpageActivity extends AppCompatActivity {
    private static final String TAG = "CountpageActivity";

    String title = "";
    String date = "";
    String count = "";
    int position = 0;
    TextView mTitleTextView;
    TextView mDateTextView;
    TextView mCountTextView;

    ImageButton mAddbtn;
    ImageButton mDeleteButton;
    ImageButton mBackButton;
    Button mResetButton;
    NumberPicker mNumberPicker;
    int countInteger = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countpage);

        mNumberPicker = (NumberPicker) findViewById(R.id.numberpicker_activitycp);
        mNumberPicker.setMinValue(1);
        mNumberPicker.setMaxValue(1000);

        mTitleTextView = (TextView) findViewById(R.id.titleTextView_activitycp);
        mDateTextView = (TextView) findViewById(R.id.dateTextView_activitycp);
        mCountTextView = (TextView) findViewById(R.id.countTextView_activitycp);
        mAddbtn = (ImageButton) findViewById(R.id.buttonAdd_activitycp);
        mDeleteButton = (ImageButton) findViewById(R.id.buttonDecrease_activitycp);
        mBackButton = (ImageButton) findViewById(R.id.backButton_activitycp);
        mResetButton = (Button) findViewById(R.id.reset_activitycp);

        mAddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countInteger = countInteger + mNumberPicker.getValue();
                count = String.valueOf(countInteger);
                mCountTextView.setText(count);
            }
        });
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countInteger = countInteger - mNumberPicker.getValue();
                count = String.valueOf(countInteger);
                mCountTextView.setText(count);
            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countInteger = 0;
                count = String.valueOf(countInteger);
                mCountTextView.setText(count);
            }
        });

        getExtra();
        setExtra();

    }


    private void getExtra() {
        if (getIntent().hasExtra("title") && getIntent().hasExtra("date") && getIntent().hasExtra("count")) {
            title = getIntent().getStringExtra("title");
            date = getIntent().getStringExtra("date");
            date = date.replace('\n', ' ');
            count = getIntent().getStringExtra("count");
            position = getIntent().getIntExtra("position", 0);
        }
        try {
            countInteger = Integer.parseInt(count);
        } catch (Exception e) {

        }
    }

    private void setExtra() {
        mTitleTextView.setText(title);
        mDateTextView.setText(date);
        mCountTextView.setText(count);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.count.set(position, count);
    }
}
