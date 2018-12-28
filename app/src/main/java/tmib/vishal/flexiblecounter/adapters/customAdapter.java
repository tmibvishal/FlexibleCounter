package tmib.vishal.flexiblecounter.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import tmib.vishal.flexiblecounter.CountpageActivity;
import tmib.vishal.flexiblecounter.R;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder> {

    String[] title = {"Tile 1", "calories", "total run", "total discount", "Tile 2", "Tile 3", "Tile 4", "Tile 5", "Tile 6", "Tile 1", "Tile 7", "Tile 8", "Tile 1", "Tile 9", "35"};
    String[] date = {"22\nDec\n2018", "21\nDec\n2018", "18\nDec\n2018", "17\nDec\n2018", "14\nDec\n2018", "12\nDec\n2018", "10\nDec\n2018", "8\nDec\n2018", "6\nDec\n2018", "4\nDec\n2018", "23\nNov\n2018", "22\nNov\n2018", "20\nNov\n2018", "18\nNov\n2018", "18\nNov\n2018"};
    String[] count = {"40", "20", "60", "30", "35", "40", "20", "60", "30", "35", "40", "20", "60", "30", "35"};

    //String[] color = {"#B3E5FC", "#C8E6C9","#FFCCBC", "#FFE0B2", "#D7CCC8", "#CFD8DC", "#D7CCC8", "#F0F4C3"};
    //int[] colorCode = {-4987396, -3610935, -13124, -8014, -2634552, -3155748, -2634552, -985917};
    //int[] heights = {40, 80, 60, 30, 50};
    Context mMainActivityContext;

    public customAdapter(Context context){
        mMainActivityContext = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        MyViewHolder holder = new MyViewHolder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        //myViewHolder.mTextView.setTextSize(heights[i%5]);
        myViewHolder.mTextViewTitle.setText(title[i]);
        myViewHolder.mTextViewDate.setText(date[i]);
        myViewHolder.mTextViewCount.setText(count[i]);
         //myViewHolder.mLinearLayout.setBackgroundColor(colorCode[i%8]);
        //Log.d("color code ", String.valueOf(Color.parseColor(color[i%8])));

        myViewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mMainActivityContext, CountpageActivity.class);
                intent.putExtra("title", title[i]);
                intent.putExtra("date", title[i]);
                intent.putExtra("count", title[i]);
                mMainActivityContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTextViewTitle;
        TextView mTextViewDate;
        TextView mTextViewCount;
        LinearLayout mLinearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.textViewTitle);
            mTextViewDate = itemView.findViewById(R.id.textViewDate);
            mTextViewCount = itemView.findViewById(R.id.textViewCount);
            mLinearLayout = itemView.findViewById(R.id.colorLinearLayout);
        }
    }
}
