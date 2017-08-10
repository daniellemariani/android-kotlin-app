package com.dmariani.kotlinapp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.dmariani.kotlinapp.R;
import com.dmariani.kotlinapp.ui.fragment.HomeFragment;

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
                .add(R.id.container, fragment)
                .commit();
    }

    @Override
    public void navigateToShowPicture(String userName) {
        // TODO navigate
    }
}
