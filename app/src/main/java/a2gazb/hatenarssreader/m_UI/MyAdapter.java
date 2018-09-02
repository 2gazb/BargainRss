package a2gazb.hatenarssreader.m_UI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import a2gazb.hatenarssreader.R;
import a2gazb.hatenarssreader.m_DataObject.Article;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Article> articles;

    public MyAdapter(Context c, ArrayList<Article> articles) {
        this.c = c;
        this.articles = articles;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        Article article=articles.get(position);

        holder.titleTxt.setText(article.getTitle());
        holder.descTxt.setText(article.getDescription());
        holder.dateTxt.setText(article.getDate());
        Picasso.with(c).load(article.getImg()).into(holder.thumImg);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

}
