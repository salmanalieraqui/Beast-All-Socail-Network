package com.appmilitia.beast.mmsa.beast;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class InviteFragment extends Fragment implements OnClickListener {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invite, container, false);
        ((Button) view.findViewById(R.id.rewardsfragmentrateus)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.rewardsfragmentinvite)).setOnClickListener(this);
        return view;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rewardsfragmentrateus /*2131427459*/:
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.appmilitia.beast.mmsa.beast")));
                    return;
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.appmilitia.beast.mmsa.beast")));
                    return;
                }
            case R.id.rewardsfragmentinvite /*2131427460*/:
                PackageManager pm = getActivity().getPackageManager();
                try {
                    Intent waIntent = new Intent("android.intent.action.SEND");
                    waIntent.setType("text/plain");
                    PackageInfo info = pm.getPackageInfo("com.whatsapp", 128);
                    waIntent.setPackage("com.whatsapp");
                    waIntent.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=com.appmilitia.beast.mmsa.beast  Getting Bore? Join our community now! Here's All You Need.Get exciting prizes,merchandises and a chance to win iPhone 7 while enjoying the app..go now!");
                    startActivity(Intent.createChooser(waIntent, "Share with"));
                    return;
                } catch (NameNotFoundException e2) {
                    Toast.makeText(getContext(), "WhatsApp not Installed", 0).show();
                    return;
                }
            default:
                return;
        }
    }
}
