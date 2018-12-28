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
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;

import tmib.vishal.flexiblecounter.CountpageActivity;
import tmib.vishal.flexiblecounter.R;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder> {

    public static List<String> title;
    public static List<String> date;
    public static List<String> count;



    //String[] color = {"#B3E5FC", "#C8E6C9","#FFCCBC", "#FFE0B2", "#D7CCC8", "#CFD8DC", "#D7CCC8", "#F0F4C3"};
    //int[] colorCode = {-4987396, -3610935, -13124, -8014, -2634552, -3155748, -2634552, -985917};
    //int[] heights = {40, 80, 60, 30, 50};
    static Context mMainActivityContext;

    public customAdapter(Context context, List<String> title, List<String> date, List<String> count){
        this.title = title;
        this.date = date;
        this.count = count;
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
        myViewHolder.mTextViewTitle.setText(title.get(i));
        myViewHolder.mTextViewDate.setText(date.get(i));
        myViewHolder.mTextViewCount.setText(count.get(i));

    }

    @Override
    public int getItemCount() {
        return title.size();
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
