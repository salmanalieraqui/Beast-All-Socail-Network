package com.appmilitia.beast.mmsa.beast;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan.Standard;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;
import com.appmilitia.beast.mmsa.beast.SocialFragment.TransferingData;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener, TransferingData, WatchFragment.TransferingData {
    static String webview_url;
    WebView home_webview_webview;
    int salman;
    WebView webview_webview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        setwebviewurl("https://www.9gag.com");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new WebviewFragment());
        fragmentTransaction.commit();
        setid(R.id.webview);
        String text = "You're Awesome, Now Swipe Left To Right To Open Menu.";
        Spannable centeredText = new SpannableString(text);
        centeredText.setSpan(new Standard(Alignment.ALIGN_CENTER), 0, text.length() - 1, 18);
        Toast.makeText(getApplicationContext(), centeredText, 1).show();
    }

    public void onBackPressed() {
        this.webview_webview = (WebView) findViewById(R.id.webview_webview);
        switch (this.salman) {
            case R.id.webview /*2131427477*/:
                if (this.webview_webview.canGoBack()) {
                    this.webview_webview.goBack();
                    return;
                } else {
                    super.onBackPressed();
                    return;
                }
            case R.id.nav_socialmore /*2131427508*/:
                Toast.makeText(getApplication(), "Use navigation to go back", 0).show();
                return;
            case R.id.nav_invites /*2131427515*/:
                Toast.makeText(getApplication(), "Use navigation to go back", 0).show();
                return;
            default:
                return;
        }
    }

    public void setid(int sidra) {
        this.salman = sidra;
    }

    public void setwebviewurl(String sumbul) {
        webview_url = sumbul;
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentTransaction fragmentTransaction;
        if (id == R.id.nav_home) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
            fragmentTransaction.commit();
            setwebviewurl("https://www.9gag.com");
            setid(R.id.webview);
        } else if (id == R.id.nav_facebook) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
            fragmentTransaction.commit();
            setid(R.id.webview);
            setwebviewurl("https://www.facebook.com");
        } else if (id == R.id.nav_twitter) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
            fragmentTransaction.commit();
            setid(R.id.webview);
            setwebviewurl("https://www.twitter.com");
        } else if (id == R.id.nav_linkedin) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
            fragmentTransaction.commit();
            setid(R.id.webview);
            setwebviewurl("https://www.linkedin.com");
        } else if (id == R.id.nav_socialmore) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new SocialFragment());
            fragmentTransaction.commit();
            setid(R.id.nav_socialmore);
        } else if (id == R.id.nav_militiabrowser) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
            fragmentTransaction.commit();
            setid(R.id.webview);
            setwebviewurl("http://www.google.com");
        } else if (id == R.id.nav_youtube) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
            fragmentTransaction.commit();
            setid(R.id.webview);
            setwebviewurl("https://www.youtube.com");
        } else if (id == R.id.nav_vimeo) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
            fragmentTransaction.commit();
            setid(R.id.webview);
            setwebviewurl("https://www.vimeo.com");
        } else if (id == R.id.nav_watchmore) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new WatchFragment());
            fragmentTransaction.commit();
            setid(R.id.nav_watchmore);
        } else if (id == R.id.nav_mixcloud) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
            fragmentTransaction.commit();
            setid(R.id.webview);
            setwebviewurl("https://www.mixcloud.com");
        } else if (id == R.id.nav_digg) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new WebviewFragment());
            fragmentTransaction.commit();
            setid(R.id.webview);
            setwebviewurl("http://www.digg.com");
        } else if (id == R.id.nav_invites) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new InviteFragment());
            fragmentTransaction.commit();
            setid(R.id.nav_invites);
        }
        ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawer(8388611);
        return true;
    }

    public void socialfragment(int bb) {
        setid(R.id.webview);
    }

    public void watchfragment(int bb) {
        setid(R.id.webview);
    }
}
