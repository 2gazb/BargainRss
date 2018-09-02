package a2gazb.hatenarssreader.m_UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import a2gazb.hatenarssreader.R;

public class MyHolder extends RecyclerView.ViewHolder {

    TextView titleTxt,descTxt,dateTxt;
    ImageView thumImg;

    public MyHolder(View itemView) {
        super(itemView);

        titleTxt= (TextView) itemView.findViewById(R.id.titleTxt);
        descTxt= (TextView) itemView.findViewById(R.id.descTxt);
        dateTxt= (TextView) itemView.findViewById(R.id.dateTxt);
        thumImg= (ImageView) itemView.findViewById(R.id.thumImg);

    }
}
