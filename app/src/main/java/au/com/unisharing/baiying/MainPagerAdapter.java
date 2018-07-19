package au.com.unisharing.baiying;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0 ){
            return new RecommendFragment();
        }
        else if (position == 1) {
            return new FavoriteFragment();
        }
        else if (position ==2){
            return new MyFragment();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Recommend";
        }else if(position == 1){
            return "Favorites";
        }else
            return "My";

    }
}
