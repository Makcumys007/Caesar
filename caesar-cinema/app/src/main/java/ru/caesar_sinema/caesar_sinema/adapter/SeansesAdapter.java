package ru.caesar_sinema.caesar_sinema.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import ru.caesar_sinema.caesar_sinema.R;
import ru.caesar_sinema.caesar_sinema.pojo.Seans;

/**
 * Created by advirtys on 08.08.15.
 */
public class SeansesAdapter extends BaseAdapter {
    private List<Seans> seanses;
    private LayoutInflater layoutInflater;

    public SeansesAdapter(Context context, List<Seans> seanses) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.seanses = seanses;
    }

    @Override
    public int getCount() {
        return seanses.size();
    }

    @Override
    public Object getItem(int position) {
        return seanses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null){
            view = layoutInflater.inflate(R.layout.item_seans, parent, false);
        }
        Seans seans = getSeans(position);
        TextView seansTitle  = (TextView) view.findViewById(R.id.seansTitle);
        TextView seansDate  = (TextView) view.findViewById(R.id.seansDate);

        seansTitle.setText(seans.getFilmTitle());
        seansDate.setText("Дата: "+seans.getDate()+"      "+"    начало в "+seans.getTime());


        return view;
    }

    private Seans getSeans(int position){
        return (Seans) getItem(position);
    }
}
