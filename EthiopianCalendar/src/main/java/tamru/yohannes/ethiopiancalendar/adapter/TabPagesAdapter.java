package tamru.yohannes.ethiopiancalendar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import tamru.yohannes.ethiopiancalendar.activities.fragments.Calendar;
import tamru.yohannes.ethiopiancalendar.activities.fragments.Today;

/**
 * Created by Yohannes Tamru on 12/21/13.
 */
public class TabPagesAdapter extends FragmentStatePagerAdapter {

    public TabPagesAdapter(FragmentManager fm) {
        super(fm);
     }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new Today();
            case 1:
                return new Calendar();
        }
    return null;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
