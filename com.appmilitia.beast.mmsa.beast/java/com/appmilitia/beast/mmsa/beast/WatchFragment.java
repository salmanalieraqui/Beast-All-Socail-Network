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

public class WatchFragment extends Fragment implements OnClickListener {
    TransferingData transferingData;

    public interface TransferingData {
        void watchfragment(int i);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watch, container, false);
        ((Button) view.findViewById(R.id.watchfragmentvine)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.watchfragmentnetflix)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.watchfragmenthulu)).setOnClickListener(this);
        return view;
    }

    public void onClick(View v) {
        this.transferingData.watchfragment(R.id.watchfragmentvine);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        MainActivity mainActivity = new MainActivity();
        v.setSelected(true);
        switch (v.getId()) {
            case R.id.watchfragmentvine /*2131427474*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://vine.co");
                return;
            case R.id.watchfragmentnetflix /*2131427475*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://netflix.com");
                return;
            case R.id.watchfragmenthulu /*2131427476*/:
                fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
                fragmentTransaction.commit();
                mainActivity.setwebviewurl("https://hulu.com");
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
