package com.heverage.zhanyebao.client.add;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.heverage.zhanyebao.R;
  
public class GridAdapter extends BaseAdapter {
	private List<String> list = new LinkedList<String>();
    private Context mContext;
	private LayoutInflater mInflater;

	public GridAdapter(Context context) {
		// TODO Auto-generated constructor
		mContext = context;
		mInflater = LayoutInflater.from(context);	 
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	
	public void addAll(List<String> list){
		this.list.addAll(list);
	}
	/**
	 * Since the data comes from an array, just returning the index is sufficent
	 * to get at the data. If we were using a more complex data structure, we
	 * would return whatever object represents one row in the list.
	 * 
	 * @see android.widget.ListAdapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	/**
	 * Use the array index as a unique id.
	 * 
	 * @see android.widget.ListAdapter#getItemId(int)
	 */
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		TextView textView;

		if (null == convertView) {
			convertView = mInflater.inflate(R.layout.client_new_all_info_grid_item, null);

			textView = (TextView) convertView.findViewById(R.id.textView1);

			convertView.setTag(textView);

		} else {
			textView = (TextView) convertView.getTag();
		}
		// Bind the data efficiently with the holder.
		String text = list.get(position);
		
		textView.setText(text);

		return convertView;		
	}
	
 
}

