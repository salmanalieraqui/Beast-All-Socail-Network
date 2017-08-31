package com.appmilitia.beast.mmsa.beast;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebviewFragment extends Fragment {
    public boolean mShouldPause;
    private WebView webview_webview;
    private ProgressBar webview_webview_pb;

    private class MyWebViewClient extends WebChromeClient {
        private MyWebViewClient() {
        }

        public void onProgressChanged(WebView view, int newProgress) {
            WebviewFragment.this.setValue(newProgress);
            super.onProgressChanged(view, newProgress);
        }
    }

    public class myWebClient extends WebViewClient {
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            WebviewFragment.this.webview_webview_pb.setProgress(0);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        public void onLoadResource(WebView webview, String url) {
            super.onLoadResource(webview, url);
            if (url.contains("youtube.com")) {
                WebviewFragment.this.mShouldPause = true;
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container, false);
        this.webview_webview = (WebView) view.findViewById(R.id.webview_webview);
        this.webview_webview_pb = (ProgressBar) view.findViewById(R.id.webview_webview_pb);
        this.webview_webview_pb.setMax(100);
        this.webview_webview.setWebViewClient(new myWebClient());
        WebSettings webSettings = this.webview_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setPluginState(PluginState.ON);
        webSettings.setRenderPriority(RenderPriority.HIGH);
        webSettings.setCacheMode(1);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        this.webview_webview.getSettings().setAllowFileAccess(true);
        webSettings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        this.webview_webview.setWebChromeClient(new MyWebViewClient());
        webSettings.setEnableSmoothTransition(true);
        this.webview_webview.loadUrl(MainActivity.webview_url);
        return view;
    }

    public void setValue(int progress) {
        this.webview_webview_pb.setProgress(progress);
    }

    public void onPause() {
        super.onPause();
        if (this.mShouldPause) {
            this.webview_webview.onPause();
        }
        this.mShouldPause = false;
    }
}
