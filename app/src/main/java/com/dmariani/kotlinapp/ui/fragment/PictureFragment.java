package com.dmariani.kotlinapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmariani.kotlinapp.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

/**
 * This fragment will receive the user name and it shows a random picture from a server
 *
 * @author danielle.mariani
 */

public class PictureFragment extends Fragment {

    private static final String ARG_USER_NAME = "USER_NAME";

    private ImageView pictureImageView;
    private TextView messageTextView;

    public static PictureFragment newInstance(String userName) {

        Bundle bundle = new Bundle();
        bundle.putString(ARG_USER_NAME, userName);

        PictureFragment fragment = new PictureFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_picture, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        pictureImageView = getView().findViewById(R.id.picture);
        messageTextView = getView().findViewById(R.id.text_message);

        String name = getString(R.string.default_name);

        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey(ARG_USER_NAME)) {
                name = bundle.getString(ARG_USER_NAME, name);
            }
        }

        messageTextView.setText(getString(R.string.picture_message, name));
        loadImage();
    }

    private void loadImage() {
        Picasso.with(getActivity())
                .load("http://lorempixel.com/150/150/")
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(pictureImageView);
    }
}
