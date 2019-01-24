package gov.nasa.theobersvablecosmicvehicle.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gov.nasa.theobersvablecosmicvehicle.R;
import gov.nasa.theobersvablecosmicvehicle.presenter.PhotosListPresenter;

public class PhotosAdapter extends RecyclerView.Adapter<PhotoRowViewHolder> {

    PhotosListPresenter photosPresenter;

    public PhotosAdapter(PhotosListPresenter photosPresenter) {
        this.photosPresenter = photosPresenter;
    }

    @Override
    public PhotoRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View rowLayout = inflater.inflate(R.layout.row_img_date, parent, false);

        return new PhotoRowViewHolder(rowLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoRowViewHolder viewHolder, int position) {
        photosPresenter.onBindRepositoryRowViewAtPosition(position, viewHolder);
    }

    @Override
    public int getItemCount() {
        return photosPresenter.getPhotoRowsCount();
    }


}