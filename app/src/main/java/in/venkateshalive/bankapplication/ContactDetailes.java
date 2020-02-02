package in.venkateshalive.bankapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetailes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detailes);



        String url ;
        Bundle extras = getIntent().getExtras();
        url = extras.getString("name");

        WebView view= (WebView) this.findViewById(R.id.webView2);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);

        view.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView viewx, String urlx) {
                viewx.loadUrl(urlx);
                return false;
            }
        });
    }
}
