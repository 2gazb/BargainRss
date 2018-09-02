package a2gazb.hatenarssreader.m_UI;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import a2gazb.hatenarssreader.R;
import a2gazb.hatenarssreader.WebViewActivity;
import a2gazb.hatenarssreader.m_DataObject.Article;
import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Article> articles;
    RecyclerView mRecycler;
    AdapterView.OnItemClickListener mListener;



    private final Object lock = new Object();
    private final List<String> versions = new ArrayList<>();


    public MyAdapter(Context c, ArrayList<Article> articles) {
        this.c = c;
        this.articles = articles;
    }

    // タップされたときのインタフェースを定義
    protected void onVersionClicked(@NonNull String version) {
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

        Article article = articles.get(position);

        if(position == 0) {
            holder.topTag.setVisibility(View.VISIBLE);
        }

        holder.titleTxt.setText(article.getTitle());
        holder.descTxt.setText(article.getDescription());
        holder.dateTxt.setText(article.getDate());
        Picasso.with(c).load(article.getImg()).into(holder.thumImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final int position = holder.getAdapterPosition();
//                final String version = versions.get(position);
//                onVersionClicked(version);

                Article article = articles.get(position);


//                WebView myWebView = (WebView) findViewById(R.id.webView);
//                myWebView.setWebViewClient(new WebViewClient());
//                myWebView.loadUrl(article.getLink());

//                Uri uri = Uri.parse(article.getLink());
//                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//                c.startActivity(WebViewActivity);

                Intent intent = new Intent(c, WebViewActivity.class);
//                EditText editText = (EditText) findViewById(R.id.editText);
//                String message = editText.getText().toString();
                intent.putExtra("ARTICLE_URL",article.getLink());
                c.startActivity(intent);

//
//
//                Log.d("debug", "tap" + );



            }
        });

//        @Override
//        public void onClick(View v) {
//            addItem(new SampleData(),viewHolder.getLayoutPosition());
//            viewHolder.text.setText("position " + viewHolder.getLayoutPosition());
//        }
//    });

//        holder.thumImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mListener.onClick(view);
//            }
//        });


//        @Override
//        public void onClick(View v) {
//            if (adapter.mListener != null) {
//                int position = getLayoutPosition();
//                Link data = adapter.mLinks.get(position);
//                adapter.mListener.onItemClick(data);
//            }
//        }

    }

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.mListener = mListener;
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


}
