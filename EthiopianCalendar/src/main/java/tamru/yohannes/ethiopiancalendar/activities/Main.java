package tamru.yohannes.ethiopiancalendar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ViewAnimator;
import tamru.yohannes.ethiopiancalendar.R;
import tamru.yohannes.ethiopiancalendar.adapter.TabPagesAdapter;

public class Main extends FragmentActivity implements android.app.ActionBar.TabListener {

    private android.app.ActionBar actionBar;
    private ViewAnimator viewAnimator;

    private String[] tabs = {"Today", "Calendar"};//, "Gee'ez Numerals"
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(tamru.yohannes.ethiopiancalendar.R.layout.activity_main);
        viewAnimator = (ViewAnimator)findViewById(R.id.viewAnimator);

        actionBar = getActionBar();
        actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
         for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
       getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_about)
            {
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
           }
        else if(id == R.id.action_exit)
            finish();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction ft) {
       viewAnimator.showNext();
    }

    @Override
    public void onTabUnselected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction ft) {
    }
}
