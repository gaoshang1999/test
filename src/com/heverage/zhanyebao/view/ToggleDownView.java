package com.heverage.zhanyebao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.heverage.zhanyebao.R;

public class ToggleDownView extends LinearLayout {
	
	private boolean toggled;
	
	
	public ToggleDownView(Context context) {
		this(context, null);
	}

	public ToggleDownView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ToggleDownView(final Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		
		TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ToggleDownView);

		
		CharSequence text = a.getString(R.styleable.ToggleDownView_text);
		int includeLayout = a.getResourceId(R.styleable.ToggleDownView_includeLayout, R.layout.client_new_basic);
		toggled = a.getBoolean(R.styleable.ToggleDownView_toggled, false);
		
		View rootView = LayoutInflater.from(context).inflate(R.layout.view_toggle_down_view, null);
		
		final LinearLayout client_basic_line = (LinearLayout)rootView.findViewById(R.id.client_basic_line);
		final ImageView client_basic_image = (ImageView)rootView.findViewById(R.id.client_basic_image);
		final TextView textViewBasic = (TextView)rootView.findViewById(R.id.textViewBasic);
		textViewBasic.setText(text);
		
		final ViewStub viewstub = (ViewStub)rootView.findViewById(R.id.viewstub);
		viewstub.setLayoutResource(includeLayout);
		viewstub.setVisibility(View.VISIBLE);
 
		if(!toggled){
			viewstub.setVisibility(View.GONE);
			client_basic_image.setImageDrawable(context.getResources().getDrawable(R.drawable.triangle_right));
		}
				
		
		client_basic_line.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {	
				if(toggled){
					client_basic_image.setImageDrawable(context.getResources().getDrawable(R.drawable.triangle_right));
					viewstub.setVisibility(View.GONE);
					toggled = false;
				}else{
					client_basic_image.setImageDrawable(context.getResources().getDrawable(R.drawable.triangle_down));
					viewstub.setVisibility(View.VISIBLE);
					toggled = true;
				}					
			}        	
        });	
		
		this.addView(rootView);
	}
	
	
	

}
