package com.example.myapplication200122.slideview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author LiuSaiSai
 * @description:实现 View 滑动的 四 种方法；
 * @date :2020/04/15 11:58
 */
public class LayoutSlideView extends View {

    private int lastX;
    private int lastY;

    public LayoutSlideView(Context context) {
        super(context);
    }

    public LayoutSlideView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutSlideView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                /**
                 * 方法一：layout() 实现 View 的滑动；
                 * layout(getLeft() + offsetX,getTop() + offsetY,getRight() + offsetX,getBottom() + offsetY);
                 */
                /**
                 * 方法二：使用 offsetLeftAndRight（）与 offsetTopAndBottom（） 实现 View 的滑动；
                 * offsetLeftAndRight(offsetX);
                 * offsetTopAndBottom(offsetY);
                 */
                /**
                 * 方法三：LayoutParams(改变布局参数)
                 * 注：父布局是：LinearLayout，故使用 LinearLayout.LayoutParams
                 *      如果父布局是 RelativeLayout，就使用 ViewGroup.MarginLayoutParams;
                 *       LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                 *       layoutParams.leftMargin = getLeft() + offsetX;
                 *       layoutParams.topMargin = getTop() + offsetY;
                 *       setLayoutParams(layoutParams);
                 */
                /**
                 * 方法四：scrollTo();和 scrollBy();
                 * 注意这里的 scrollBy 参数设置的是负数；向右下
                 */
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
        }
        return true;

    }
}
