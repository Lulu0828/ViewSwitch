package com.lulu.viewswitch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 使用同一个adapter填充list或者grid
 * Created by Lu on 2016/1/27.
 */
public class ServiceZoneAdapter extends BaseAdapter{

    /**
     * Get view from xml layout.
     */
    private LayoutInflater mInflater     = null;
    /**
     * A list to encapsulate servcie information.
     */
    private List<ServiceBean> mServiceBeans = null;

    public ServiceZoneAdapter(Context c, List<ServiceBean> serviceBeans) {
        mServiceBeans = serviceBeans;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mServiceBeans == null ? 0 : mServiceBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return mServiceBeans == null ? null : mServiceBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            if (MainActivity.isGridView) {
                convertView = mInflater.inflate(R.layout.each_app_grid_layout, parent, false);
            } else {
                convertView = mInflater.inflate(R.layout.each_app_list_layout, parent, false);
            }
        }

        ServiceBean service = (ServiceBean)getItem(position);
        if (service != null) {
            ImageView imageView = (ImageView)convertView.findViewById(R.id.app_icon);
            TextView text = (TextView)convertView.findViewById(R.id.app_name);
            imageView.setImageResource(service.getIconId());
            text.setText(service.getName());
        }

        return convertView;
    }
}
