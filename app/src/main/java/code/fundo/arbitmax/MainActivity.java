package code.fundo.arbitmax;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    TabLayout mTabLayout;
    ViewPager mViewPager;

    String[] tabTitle = {"wallet","send","receive"};
    int[] pageLayout = {R.layout.wallet,R.layout.send,R.layout.receive};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.pager);

        mViewPager.setAdapter(new SamplePagerAdapter());
        //mViewPager.addOnPageChangeListener(EventsActivity.this);

        mTabLayout.setupWithViewPager(mViewPager);

        Log.d("yolo", me.balance + "");

    }

    class SamplePagerAdapter extends PagerAdapter {
        public static final String TAG = "EventListPagerAdapter";

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public CharSequence getPageTitle(int p) {
            return tabTitle[p];
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view=getLayoutInflater().inflate(pageLayout[position],container,false);
            container.addView(view);
            TextView tv = (TextView) findViewById(R.id.balance);
            tv.setText("Balance = " + me.balance + " ( "+(me.balance * me.rate) + " USD)");
            TextView tv2 = (TextView) findViewById(R.id.rate);
            tv2.setText(me.rate + " USD");
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            Log.i(TAG, "destroyItem() [position: " + position + "]");
        }
    }
}
