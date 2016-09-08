package com.github.anzewei.parallaxbacklayout;

import java.util.Stack;

import android.app.Activity;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by zewei on 2015-11-26.
 */
public class ParallaxBackActivityHelper {
    private static final Stack<ParallaxBackActivityHelper> sActivities = new Stack<>();
    private int size  = 0;

    public Activity getActivity() {
        return mActivity;
    }

    private Activity mActivity;

    private ParallaxBackLayout mParallaxBackLayout;

    public ParallaxBackActivityHelper(Activity activity) {
        mActivity = activity;
        mParallaxBackLayout = new ParallaxBackLayout(mActivity);
        sActivities.push(this);
        size = sActivities.size();
    }

    public void onPostCreate() {
        mParallaxBackLayout.attachToActivity(this);
    }

    public void onActivityDestroy() {
        sActivities.remove(this);
    }

    public ParallaxBackActivityHelper getSecondActivity() {
        if (sActivities.size() >= 2)
            return sActivities.elementAt(sActivities.size() - 2);
        return null;
    }
    public ParallaxBackActivityHelper getThirdActivity() {
    	if (sActivities.size() >= 3)
    		return sActivities.elementAt(sActivities.size() - 3);
    	return getSecondActivity();
    }
    

    public void drawThumb(Canvas canvas) {
        View decorChild = getBackLayout().getContentView();
        decorChild.draw(canvas);
    }

    public View findViewById(int id) {
        if (mParallaxBackLayout != null) {
            return mParallaxBackLayout.findViewById(id);
        }
        return null;
    }

    public void scrollToFinishActivity() {
        getBackLayout().scrollToFinishActivity();
    }

    public void setBackEnable(boolean enable) {
        getBackLayout().setEnableGesture(enable);
    }

    public ParallaxBackLayout getBackLayout() {
        return mParallaxBackLayout;
    }

	public void notifySizeChange() {
		this.size--;
	}
}
