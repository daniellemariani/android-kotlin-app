package com.dmariani.kotlinapp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dmariani.kotlinapp.R;
import com.dmariani.kotlinapp.ui.fragment.HomeFragment;
import com.dmariani.kotlinapp.ui.fragment.PictureFragment;

/**
 * Application's Main Activity
 */
public class MainActivity extends AppCompatActivity implements HomeFragment.HomeNavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigatesTo(HomeFragment.newInstance());
    }

    /**
     * This method shows a fragment into the activity
     */
    private void navigatesTo(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed(){
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void navigateToShowPicture(String userName) {
        navigatesTo(PictureFragment.newInstance(userName));
    }
}
