package tmib.vishal.flexiblecounter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class CountpageActivity  extends AppCompatActivity {
    private static final String TAG = "CountpageActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countpage);
    }

    void getExtra (){
        if(getIntent().hasExtra("title") && getIntent().hasExtra("date") && getIntent().hasExtra("count")){
            String title = getIntent().getStringExtra("title");
            String date = getIntent().getStringExtra("date");
            String count = getIntent().getStringExtra("count");
        }
    }
}
