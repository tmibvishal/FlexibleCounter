package tmib.vishal.flexiblecounter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddnewitemActivity extends AppCompatActivity {
    Button mAdd;
    Button mCancel;
    EditText mEditText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewitem);
        setTitle("Add New Counter");
        mEditText = (EditText) findViewById(R.id.Edittext_activityani);
        mAdd = (Button) findViewById(R.id.btnAdd_activityani);
        mCancel = (Button) findViewById(R.id.btnCancel_activityani);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat curFormat = new SimpleDateFormat("dd\nMMM\nYYYY");
                Date c = Calendar.getInstance().getTime();
                String date = curFormat.format(c);
                String title = mEditText.getText().toString();
                MainActivity.title.add(0, title);
                MainActivity.date.add(0, date);
                MainActivity.count.add(0, "0");
                MainActivity.returnedFromAddNewActivity = true;
                finish();
            }
        });
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
