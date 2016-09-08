package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.hmm_library.R;

public class EndLayout {

	private View view;
	private ImageView mImageView;
	private FrameLayout endLayoutHolder;
	private Context context;

	public EndLayout(Context context) {
		this.context = context;
		initView(context);
	}

	private void initView(Context context) {
		view = LayoutInflater.from(context).inflate(
				R.layout.pull_to_refresh_end_layout, null);
		mImageView = (ImageView) view.findViewById(R.id.mImageView);
	}

//	public View getView() {
//		return view;
//	}

	public void show() {
		view.setVisibility(View.VISIBLE);
	}

	public void hide() {
		view.setVisibility(View.GONE);
	}

	public void setImageResource(int resId) {
		mImageView.setImageResource(resId);
	}

	public View getLayoutHolder() {
		if (endLayoutHolder == null) {
			endLayoutHolder = new FrameLayout(context);
			endLayoutHolder.addView(view, 0, new FrameLayout.LayoutParams(
					FrameLayout.LayoutParams.MATCH_PARENT,
					FrameLayout.LayoutParams.WRAP_CONTENT));
		}
		return endLayoutHolder;
	}

	public void hideHolder() {
		endLayoutHolder.setVisibility(View.GONE);
	}

	public void showHolder() {
		endLayoutHolder.setVisibility(View.VISIBLE);
	}

}
