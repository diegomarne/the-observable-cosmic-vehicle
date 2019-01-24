package gov.nasa.theobersvablecosmicvehicle.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import gov.nasa.theobersvablecosmicvehicle.R;
import gov.nasa.theobersvablecosmicvehicle.view.contracts.PhotoRowContract;

public class PhotoRowViewHolder extends RecyclerView.ViewHolder implements PhotoRowContract {

    private View rowLayout;
    private ImageView imageView;
    private TextView dateTv;

    public PhotoRowViewHolder(View itemView) {
        super(itemView);

        rowLayout = itemView.findViewById(R.id.row_layout);
        imageView = itemView.findViewById(R.id.row_image_view);
        dateTv = itemView.findViewById(R.id.tv_date);
    }

    @Override
    public void setImage(String uri) {
        Picasso.get()
                .load(uri)
                .fit()
                .centerCrop()
                .into(imageView);
    }

    @Override
    public void setDate(String date) {
        dateTv.setText(date);
    }

    @Override
    public void setOnRowClickListener(View.OnClickListener clickListener){
        rowLayout.setOnClickListener(clickListener);
    }
}