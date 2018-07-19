package au.com.unisharing.baiying;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class PageTransformerTop implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {

        if (position < 0F) { // force the Fragment to the left (Spotlight in the current architecture) to stay put.
            final int pageWidth = page.getWidth();
            final float darkeningAlpha = 1F + (0.9F * position);
            page.setAlpha(darkeningAlpha);

            final float undoHorizontalTranslation = position * -pageWidth;
            if (undoHorizontalTranslation > -pageWidth) {
                page.setTranslationX(undoHorizontalTranslation);
            } else {
                page.setTranslationX(0);
            }
        } else { // make sure the Favorites fragment is at full opacity
            page.setAlpha(1.0F);
        }
    }

}
