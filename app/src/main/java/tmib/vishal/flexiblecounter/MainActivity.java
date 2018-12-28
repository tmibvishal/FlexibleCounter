package tmib.vishal.flexiblecounter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tmib.vishal.flexiblecounter.adapters.customAdapter;

public class MainActivity extends AppCompatActivity {

    public static boolean returnedFromAddNewActivity = false;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    FloatingActionButton floatingActionButton;

    //public static List<String> title = new ArrayList<String>(Arrays.asList("Tile 1", "calories", "total run", "total discount", "Tile 2", "Tile 3", "Tile 4", "Tile 5", "Tile 6", "Tile 1", "Tile 7", "Tile 8", "Tile 1", "Tile 9", "35"));
    //public static List<String> date = new ArrayList<String>(Arrays.asList("22\nDec\n2018", "21\nDec\n2018", "18\nDec\n2018", "17\nDec\n2018", "14\nDec\n2018", "12\nDec\n2018", "10\nDec\n2018", "8\nDec\n2018", "6\nDec\n2018", "4\nDec\n2018", "23\nNov\n2018", "22\nNov\n2018", "20\nNov\n2018", "18\nNov\n2018", "18\nNov\n2018"));
    //public static List<String> count = new ArrayList<String>(Arrays.asList("40", "20", "60", "30", "35", "40", "20", "60", "30", "35", "40", "20", "60", "30", "35"));

    public static List<String> title = new ArrayList<String>();
    public static List<String> date = new ArrayList<String>();
    public static List<String> count = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title.add("2");
        date.add("2");
        count.add("2");
        title.add(0, "1");
        date.add(0, "1");
        count.add(0, "1");



        mRecyclerView = (RecyclerView) findViewById(R.id.recylerView);

        // used to increase performance in case the layout size does not changes
        mRecyclerView.setHasFixedSize(true);

        // (No of columns, Linear Layout Manager)
        //mLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.HORIZONTAL));


        mAdapter = new customAdapter(this, title, date, count);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, CountpageActivity.class);
                intent.putExtra("title", title.get(position));
                intent.putExtra("date", date.get(position));
                intent.putExtra("count", count.get(position));
                intent.putExtra("position", position);
                MainActivity.this.startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Long Press on position :"+position,Toast.LENGTH_SHORT).show();
            }
        }));

        floatingActionButton = (FloatingActionButton) findViewById(R.id.addNewItem);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddnewitemActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        if (returnedFromAddNewActivity){
            mAdapter.notifyItemInserted(0);
            returnedFromAddNewActivity = false;
            return;
        }
        mAdapter.notifyDataSetChanged();
    }

    public static interface ClickListener{
        public void onClick(View view, int position);
        public void onLongClick(View view,int position);
    }

    public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private ClickListener clickListener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener){
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if(child!=null && clickListener!=null){
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                    super.onLongPress(e);
                }
            });
        }


        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (child!=null && clickListener!=null && gestureDetector.onTouchEvent(motionEvent)){
                clickListener.onClick(child, recyclerView.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean b) {

        }
    }

}
