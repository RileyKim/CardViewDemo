package com.taeksukim.android.carddemo;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by TaeksuKim on 2017. 3. 5..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardViewHolder> {

    private String[] titles = {"chapter One", "Chapter Two", "Chapter Three"};
    private String[] details = {"Item One details", "Item Two details", "Item Three details"};
    private int[] images = {R.drawable.android_image_1, R.drawable.android_image_2, R.drawable.android_image_3};

    class CardViewHolder extends RecyclerView.ViewHolder{

        public ImageView itemImage;
        public TextView itemTitle, itemDetail;

        public CardViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            itemDetail = (TextView) itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    Snackbar.make(v, "Click detected on item" + position, Snackbar.LENGTH_INDEFINITE).setAction("Action",null).show();
                }
            });
        }


    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
            CardViewHolder cardHolder = new CardViewHolder(v);
        return cardHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {

        holder.itemTitle.setText(titles[position]);
        holder.itemDetail.setText(details[position]);
        holder.itemImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
