package tmib.vishal.flexiblecounter;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;


public class CountpageActivity extends AppCompatActivity {
    private static final String TAG = "CountpageActivity";

    String title="";
    String date="";
    String count="";
    TextView mTitleTextView;
    TextView mDateTextView;
    TextView mCountTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countpage);

        NumberPicker mNumberPicker = (NumberPicker) findViewById(R.id.numberpicker_activitycp);
        mNumberPicker.setMinValue(1);
        mNumberPicker.setMaxValue(1000);

        mTitleTextView = (TextView) findViewById(R.id.titleTextView_activitycp);
        mDateTextView = (TextView) findViewById(R.id.dateTextView_activitycp);
        mCountTextView = (TextView) findViewById(R.id.countTextView_activitycp);

        getExtra();
        setExtra();

    }

    private void getExtra() {
        if (getIntent().hasExtra("title") && getIntent().hasExtra("date") && getIntent().hasExtra("count")) {
            title = getIntent().getStringExtra("title");
            date = getIntent().getStringExtra("date");
            date = date.replace('\n', ' ');
            count = getIntent().getStringExtra("count");
        }
    }

    private void setExtra() {
        mTitleTextView.setText(title);
        mDateTextView.setText(date);
        mCountTextView.setText(count);
    }
}
