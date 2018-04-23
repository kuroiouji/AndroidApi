package com.kamitoon.api.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kamitoon.api.R;
import com.kamitoon.api.model.StatusDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by computer on 23/4/2561.
 */

public class SpStatusAdapter extends BaseAdapter {

    private List<StatusDao> mData;
    private LayoutInflater mInflater;

    public SpStatusAdapter(Context context, List<StatusDao> mData) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.spinner_list, parent, false);
            holder.name = (TextView) convertView.findViewById(R.id.name);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(mData.get(position).getStName());
        holder.name.setTextColor(Color.parseColor(mData.get(position).getStColor()));

        convertView.setTag(holder);

        return convertView;
    }

    public class ViewHolder {
        TextView name;
    }
}
