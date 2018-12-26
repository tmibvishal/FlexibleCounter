package tmib.vishal.flexiblecounter.adapters;

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

import tmib.vishal.flexiblecounter.R;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder> {

    String[] dataset = {"40", "20", "60", "30", "35", "40", "20", "60", "30", "35", "40", "20", "60", "30", "35"};
    Random rand = new Random();
    //String[] color = {"#B3E5FC", "#C8E6C9","#B2EBF2", "#FFE0B2", "#D7CCC8"};
    int[] colorCode = {-4987396, -3610935, -5051406, -8014, -2634552};
    int[] heights = {40, 80, 60, 30, 50};


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.mTextView.setTextSize(heights[i%5]);
        myViewHolder.mTextView.setText(dataset[i]);
        myViewHolder.mLinearLayout.setBackgroundColor(colorCode[i%5]);
        //Log.d("color code ", String.valueOf(Color.parseColor(color[i])));

    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        LinearLayout mLinearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
            mLinearLayout = itemView.findViewById(R.id.colorLinearLayout);
        }
    }
}
