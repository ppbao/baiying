package au.com.unisharing.baiying;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ParentViewPager extends ViewPager{
    public ParentViewPager(@NonNull Context context) {
        super(context);
    }

    public ParentViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Return true if this is predominantly a horizontal swipe. Return false otherwise.
        // NOTE: There will be ambiguous cases.
        final int historySize = ev.getHistorySize();
        boolean intercepted;
        if (historySize > 2) { // arrived at heuristically; we shouldn't intercept "messy tap" events
            final float xMotion = ev.getHistoricalX(0) - ev.getHistoricalX(historySize - 1);
            final float yMotion = ev.getHistoricalY(0) - ev.getHistoricalY(historySize - 1);
            intercepted = Math.abs(yMotion) < Math.abs(xMotion); // more X movement than Y movement
        } else {
            intercepted = super.onInterceptTouchEvent(ev);
        }
        return intercepted;
       }
}
