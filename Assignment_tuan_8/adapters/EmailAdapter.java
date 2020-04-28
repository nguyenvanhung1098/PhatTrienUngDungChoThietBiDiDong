package com.example.mygmail.adapters;

import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mygmail.R;
import com.example.mygmail.models.EmailModel;

import java.util.List;

public class EmailAdapter extends BaseAdapter {

    List<EmailModel> items;
    String [] color = {"#00FF00","#FFFF00","#00FFFF","#99FF66","#FF99FF",
            "#9999FF","#FF0066","#0000DD","#CC3399","#6666FF","#FF6600","#009966","#009999" };

    public EmailAdapter(List<EmailModel> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_email_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.textName = view.findViewById(R.id.text_name);
            viewHolder.textLetter = view.findViewById(R.id.text_letter);
            viewHolder.textSubject = view.findViewById(R.id.text_subject);
            viewHolder.textContent = view.findViewById(R.id.text_content);
            viewHolder.textTime = view.findViewById(R.id.text_time);
            view.setTag(viewHolder);

        }
        else
            viewHolder =(ViewHolder)view.getTag();

        final ImageView imageFavorite = view.findViewById(R.id.image_favorite);
        final TextView textLetter = view.findViewById(R.id.text_letter);
        final EmailModel item = items.get(i);

        viewHolder.textName.setText(item.getName());
        viewHolder.textSubject.setText(item.getText_subject());
        viewHolder.textContent.setText(item.getText_content());
        viewHolder.textTime.setText(item.getText_time());
        viewHolder.textLetter.setText(item.getLetter());


        imageFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isFavorite = item.is_favorite();
                item.set_favorite(!isFavorite);
                notifyDataSetChanged();
            }
        });
        if(item.is_favorite() == false){
            imageFavorite.setImageResource(R.drawable.ic_star_normal);
        }
        else {
            imageFavorite.setImageResource(R.drawable.ic_star_favorite);
        }
        if(item.getLetter().toString().charAt(0)%6 == 0)
            textLetter.setBackgroundResource(R.drawable.circle_background);
        else if(item.getLetter().toString().charAt(0)%6 == 1)
            textLetter.setBackgroundResource(R.drawable.circle_background1);
        else if(item.getLetter().toString().charAt(0)%6 == 2)
            textLetter.setBackgroundResource(R.drawable.circle_background2);
        else if(item.getLetter().toString().charAt(0)%6 == 3)
            textLetter.setBackgroundResource(R.drawable.circle_background3);
        else if(item.getLetter().toString().charAt(0)%6 == 4)
            textLetter.setBackgroundResource(R.drawable.circle_background4);
        else if(item.getLetter().toString().charAt(0)%6 == 5)
            textLetter.setBackgroundResource(R.drawable.circle_background5);
        return view;
    }

    class ViewHolder {
        TextView textLetter;
        TextView textName;
        TextView textSubject;
        TextView textContent;
        TextView textTime;
    }
}
