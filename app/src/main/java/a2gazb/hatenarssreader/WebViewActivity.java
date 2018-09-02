//package a2gazb.hatenarssreader;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//
//public class WebViewActivity extends Activity {
//
//    @SuppressLint("SetJavaScriptEnabled")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        //レイアウトで指定したWebViewのIDを指定する。
//        WebView myWebView = (WebView)findViewById(R.id.webView1);
//
//        //リンクをタップしたときに標準ブラウザを起動させない
//        myWebView.setWebViewClient(new WebViewClient());
//
//        //最初にgoogleのページを表示する。
//        myWebView.loadUrl("http://www.google.co.jp");
//
//        //jacascriptを許可する
//        myWebView.getSettings().setJavaScriptEnabled(true);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
