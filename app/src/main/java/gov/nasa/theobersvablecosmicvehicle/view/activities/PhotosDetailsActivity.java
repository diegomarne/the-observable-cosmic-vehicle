package gov.nasa.theobersvablecosmicvehicle.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import gov.nasa.theobersvablecosmicvehicle.R;
import gov.nasa.theobersvablecosmicvehicle.model.Photo;
import gov.nasa.theobersvablecosmicvehicle.presenter.PhotosDetailPresenter;
import gov.nasa.theobersvablecosmicvehicle.view.contracts.PhotosDetailsContract;
import io.reactivex.annotations.NonNull;

public class PhotosDetailsActivity extends AppCompatActivity implements PhotosDetailsContract {

    private static final String EXTRA_PHOTO_JSON = "photo_json";

    ImageView headerImgView;
    TextView roverNameTv;
    TextView cameraNameTv;
    TextView cameraFullNameTv;

    public static Intent buildIntent(Activity activityFrom, @NonNull String photoToJson){
        Intent intent = new Intent(activityFrom, PhotosDetailsActivity.class);
        intent.putExtra(EXTRA_PHOTO_JSON, photoToJson);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);

        headerImgView = findViewById(R.id.headerImgView);
        roverNameTv = findViewById(R.id.roverName);
        cameraNameTv = findViewById(R.id.cameraName);
        cameraFullNameTv = findViewById(R.id.cameraFullName);

        String jsonPhoto = getIntent().getStringExtra(EXTRA_PHOTO_JSON);
        Photo photo = new GsonBuilder().create().fromJson(jsonPhoto, Photo.class);

        PhotosDetailPresenter photosDetailPresenter = new PhotosDetailPresenter(this, photo);
        photosDetailPresenter.init();
    }


    @Override
    public void setImage(String uri) {
        Picasso.get()
                .load(uri)
                .fit()
                .centerCrop()
                .into(headerImgView);
    }

    @Override
    public void setRoverName(String roverName) {
        roverNameTv.setText(roverName);
    }

    @Override
    public void setCameraName(String cameraName) {
        cameraNameTv.setText(cameraName);
    }

    @Override
    public void setCameraFullName(String cameraFullName) {
        cameraFullNameTv.setText(cameraFullName);
    }
}
