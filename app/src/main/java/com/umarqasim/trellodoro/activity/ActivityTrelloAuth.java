package com.umarqasim.trellodoro.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.umarqasim.trellodoro.R;
import com.umarqasim.trellodoroapi.prefrences.TrellodoroApiConstants;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public class ActivityTrelloAuth extends Activity {


    public static final String EXTRA_KEY_TOKEN = "Token";

    @Bind(R.id.webview_auth)
    WebView webviewAuth;
    @Bind(R.id.progress_webview)
    ProgressBar progressWebview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trello_auth);
        ButterKnife.bind(this);

        webviewAuth.getSettings().setJavaScriptEnabled(true);
        webviewAuth.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                if (url.contains(TrellodoroApiConstants.TRELLO_OAUTH_RETURN_TOEKN)) {
                    String token = url.replace(TrellodoroApiConstants.TRELLO_OAUTH_RETURN_TOEKN, "");
                    if (token.trim().length() > 0) {
                        Intent intent = new Intent();
                        intent.putExtra(EXTRA_KEY_TOKEN, token);
                        setResult(RESULT_OK, intent);
                    } else {
                        setResult(RESULT_CANCELED);
                    }
                    finish();
                } else {
                    progressWebview.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressWebview.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressWebview.setVisibility(View.GONE);
            }
        });
        webviewAuth.loadUrl(TrellodoroApiConstants.TRELLO_OAUTH_REQUEST_TOKEN);
    }

}
