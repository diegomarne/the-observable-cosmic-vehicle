package gov.nasa.theobersvablecosmicvehicle.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import gov.nasa.theobersvablecosmicvehicle.R;
import gov.nasa.theobersvablecosmicvehicle.model.Photo;
import gov.nasa.theobersvablecosmicvehicle.presenter.PhotosListPresenter;
import gov.nasa.theobersvablecosmicvehicle.view.PhotosAdapter;
import gov.nasa.theobersvablecosmicvehicle.view.contracts.PhotosListContract;

public class PhotosListActivity extends AppCompatActivity implements PhotosListContract{

    ArrayList<Photo> photoArrayList = new ArrayList<>();
    PhotosAdapter photosAdapter;
    ProgressBar pBarLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        pBarLoading = findViewById(R.id.pbarLoading);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        PhotosListPresenter photosListPresenter = new PhotosListPresenter(this);
        photosListPresenter.init();

        photosAdapter = new PhotosAdapter(photosListPresenter);
        recyclerView.setAdapter(photosAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showLoading() {
        pBarLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pBarLoading.setVisibility(View.GONE);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateList(List<Photo> photosList) {
        photoArrayList.addAll(photosList);
        photosAdapter.notifyDataSetChanged();
    }

    @Override
    public List<Photo> getList() {
        return photoArrayList;
    }

    @Override
    public void onClickRow(int position) {
        Photo photo = photoArrayList.get(position);
        String photoJson = new GsonBuilder().create().toJson(photo);
        Intent toDetails = PhotosDetailsActivity.buildIntent(this, photoJson);
        startActivity(toDetails);
    }
}
