package com.heverage.zhanyebao.client.add;

import java.util.Arrays;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.heverage.zhanyebao.R;

public class ClientInfoActivity extends ActionBarActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dummy);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public class PlaceholderFragment extends Fragment {
		private Context mContext = null;
		
		private GridView mgridView;
		private GridAdapter mGridAdapter;

		private Button backBtn;
		private Button saveBtn;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.client_new_all_info, container, false);
			mContext = this.getActivity();


			backBtn = (Button) rootView.findViewById(R.id.buttonBack);
			backBtn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					finish();
				}
			});
			
			mgridView = (GridView) rootView.findViewById(R.id.gridView1);

			mGridAdapter = new GridAdapter(mContext);
			
			String[] items = { "基本", "工作", "家庭", "收入", "来源", "性格", "服务", "其他", ""};
				
			mGridAdapter.addAll(Arrays.asList(items));
			mgridView.setAdapter(mGridAdapter); 
			
			
			mgridView.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub					
						Toast t = Toast.makeText(mContext, "暂未实现",
								Toast.LENGTH_SHORT);			
						t.show();					
				}
				
			});
			
			Button allBtn = (Button) rootView.findViewById(R.id.client_all_info);
			allBtn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast t = Toast.makeText(mContext, "暂未实现",
							Toast.LENGTH_SHORT);			
					t.show();
				}
			});
					
			
			
			return rootView;
		}


		
	}
	


}
