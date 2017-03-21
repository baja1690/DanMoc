package com.app.diy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.app.diy.R;
import com.app.diy.base.BaseActivity;
import com.app.diy.fragments.CrochetChartsFragment;
import com.app.diy.fragments.KnittingChartsFragment;
import com.app.diy.fragments.SavedListFragment;
import com.app.diy.fragments.SettingFragment;
import com.app.diy.fragments.TutorialFragment;
import com.app.diy.repository.local.RealmDb;
import com.app.diy.repository.network.FireBaseDb;
import com.app.diy.utils.ActivityUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.app.diy.R.id.nav_knitting_charts;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private FireBaseDb mFireBaseDb;
    private RealmDb mRealmDb;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mFireBaseDb = FireBaseDb.getInstance();
       // mFireBaseDb.writeNewItem("abc","amigur","https://google.com");
        mFireBaseDb.updateItems();
        //testFireBase();
        mRealmDb = RealmDb.getInstance();

    }

    public void init(){
        TutorialFragment fragment = new TutorialFragment();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment,R.id.flContent);
    }

    public void testFireBase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hi!");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        Class fragmentClass;
        String title="";
        switch (item.getItemId()){
            case R.id.nav_learning:
                fragmentClass = TutorialFragment.class;
                title = getResources().getString(R.string.screen_how_to_do);
                break;
            case nav_knitting_charts:
                fragmentClass = KnittingChartsFragment.class;
                break;
            case R.id.nav_crochet_charts:
                fragmentClass = CrochetChartsFragment.class;
                break;
            case R.id.nav_saved_list:
                fragmentClass = SavedListFragment.class;
                break;
            case R.id.nav_setting:
                fragmentClass = SettingFragment.class;
                break;
            default:
                fragmentClass = TutorialFragment.class;
                break;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mToolbar.setTitle(title);
        //getSupportFragmentManager().findFragmentById(R.id.flContent);
        if(fragment!=null){
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment,R.id.flContent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openWebActivity(){
        Intent intent = WebActivity.createIntent(mContext);
        startActivity(intent);
    }
    public void openWebActivity(String content){
        WebActivity.openWebActivity(mContext,content);
    }
}