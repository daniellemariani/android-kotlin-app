package com.dmariani.kotlinapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dmariani.kotlinapp.R;

/**
 * Home Fragment that requests user name.
 *
 * @author danielle.mariani
 */
public class HomeFragment extends Fragment {

    private HomeNavigation homeNavigation;
    private EditText nameEditText;
    private Button button;

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() instanceof HomeNavigation) {
            homeNavigation = (HomeNavigation) getActivity();
        } else {
            throw new ClassCastException("The activity must implement HomeNavigation interface");
        }

        nameEditText = getView().findViewById(R.id.edit_text_user_name);
        button = getView().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShowPictureButton();
            }
        });
    }

    /**
     * It manages click event on ShowPicture Button
     */
    private void onClickShowPictureButton() {
        final String name = nameEditText.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Snackbar.make(button, R.string.user_error_message, Snackbar.LENGTH_LONG)
                    .setAction(R.string.button_skip, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            homeNavigation.navigateToShowPicture(getString(R.string.default_name));
                        }
                    }).show();
        } else {
            homeNavigation.navigateToShowPicture(name);
        }
    }


    /**
     * Interface to communicate the HomeFragment to its Host Activity.
     * It is required to manage the navigation outside the fragment.
     */
    public interface HomeNavigation {

        void navigateToShowPicture(String userName);

    }
}
