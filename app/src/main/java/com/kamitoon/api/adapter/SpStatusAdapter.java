package com.kamitoon.api.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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
    private String mId;
    private String mType;

    public SpStatusAdapter(Context context, List<StatusDao> mData, String mId, String mType) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
        this.mId = mId;
        this.mType = mType;
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
            holder.id = (TextView) convertView.findViewById(R.id.ID);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(mData.get(position).getStName());
        holder.name.setTextColor(Color.parseColor(mData.get(position).getStColor()));
        String str = mData.get(position).getStId()+"/"+mId+"/"+mType;
        holder.id.setText(str);
        convertView.setTag(holder);

        return convertView;
    }

    public class ViewHolder {
        TextView name;
        TextView id;
    }
}
