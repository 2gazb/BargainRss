package a2gazb.hatenarssreader.m_UI;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.squareup.picasso.Picasso;
import a2gazb.hatenarssreader.R;
import a2gazb.hatenarssreader.WebViewActivity;
import a2gazb.hatenarssreader.m_DataObject.Article;
import java.util.ArrayList;
import java.util.List;

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
        } else {
            holder.topTag.setVisibility(View.GONE);
        }

        holder.titleTxt.setText(article.getTitle());
        holder.descTxt.setText(article.getDescription());
        holder.dateTxt.setText(article.getDate());

        try {
            Picasso.with(c).load(article.getImg()).into(holder.thumImg);
        } catch (Exception e) {
            System.out.println("java.lang.IllegalArgumentException: Path must not be empty.");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Article article = articles.get(position);
                Intent intent = new Intent(c, WebViewActivity.class);
                intent.putExtra("ARTICLE_URL",article.getLink());
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}