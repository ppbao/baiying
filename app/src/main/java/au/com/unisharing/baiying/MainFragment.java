package au.com.unisharing.baiying;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainFragment extends Fragment {
    public static final String TAG = MainFragment.class.getSimpleName();

    private Toolbar mToolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);//set whether should have OptionMenu or not
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ViewPager viewPager = (ViewPager) getView().findViewById(R.id.horizontal_viewpager);
        viewPager.setAdapter( new MainPagerAdapter(getFragmentManager()));
        viewPager.setPageTransformer(false,new PageTransformerTop());

        final TabLayout tabLayout =(TabLayout) getView().findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupToolBar();

    }

    private void setupToolBar() {
        if (mToolbar == null){
            mToolbar = (Toolbar) getView().findViewById(R.id.toolbar);
            mToolbar.setNavigationIcon(null);
        }
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        final ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle("");

    }
}
