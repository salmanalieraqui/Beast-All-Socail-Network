package com.appmilitia.beast.mmsa.beast;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SocialFragment extends Fragment implements OnClickListener {
    TransferingData transferingData;

    public interface TransferingData {
        void socialfragment(int i);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social, container, false);
        ((Button) view.findViewById(R.id.socialfragmentgoogleplus)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.socialfragmentpinterest)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.socialfragmentinstagram)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.socialfragmentreddit)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.socialfragmentvk)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.socialfragmentflickr)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.socialfragmenttumblr)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.socialfragmentclassmates)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.socialfragmentgmail)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.socialfragmentmeetup)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.socialfragmentwordpress)).setOnClickListener(this);
        return view;
    }

    public void onClick(View v) {
        this.transferingData.socialfragment(R.id.socialfragmentgoogleplus);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        MainActivity mainActivity = new MainActivity();
        v.setSelected(true);
        switch (v.getId()) {
            case R.id.socialfragmentgoogleplus /*2131427463*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://plus.google.com");
                return;
            case R.id.socialfragmentpinterest /*2131427464*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://www.pinterest.com");
                return;
            case R.id.socialfragmentinstagram /*2131427465*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://www.instagram.com");
                return;
            case R.id.socialfragmentreddit /*2131427466*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://www.reddit.com");
                return;
            case R.id.socialfragmentgmail /*2131427467*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://www.google.com/gmail");
                return;
            case R.id.socialfragmentvk /*2131427468*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://www.vk.com");
                return;
            case R.id.socialfragmentflickr /*2131427469*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://www.flickr.com");
                return;
            case R.id.socialfragmenttumblr /*2131427470*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://www.tumblr.com/dashboard");
                return;
            case R.id.socialfragmentmeetup /*2131427471*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://www.meetup.com");
                return;
            case R.id.socialfragmentwordpress /*2131427472*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://www.wordpress.com");
                return;
            case R.id.socialfragmentclassmates /*2131427473*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("http://www.classmates.com");
                return;
            default:
                return;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.transferingData = (TransferingData) activity;
    }
}
