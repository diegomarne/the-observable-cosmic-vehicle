package gov.nasa.theobersvablecosmicvehicle.presenter;

import android.view.View;

import gov.nasa.theobersvablecosmicvehicle.model.MarsRover;
import gov.nasa.theobersvablecosmicvehicle.model.Photo;
import gov.nasa.theobersvablecosmicvehicle.model.wsresponse.PhotosResponse;
import gov.nasa.theobersvablecosmicvehicle.network.MarsRoverService;
import gov.nasa.theobersvablecosmicvehicle.network.NasaApi;
import gov.nasa.theobersvablecosmicvehicle.view.PhotoRowViewHolder;
import gov.nasa.theobersvablecosmicvehicle.view.contracts.PhotosListContract;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PhotosListPresenter {

    PhotosListContract photosListContract;
    private int photosPageNum = 1;

    public PhotosListPresenter(PhotosListContract photosListContract) {
        this.photosListContract = photosListContract;
    }


    public void init() {
        loadData();
    }

    private void loadData(){
        Single<PhotosResponse> photos = NasaApi.buildService(MarsRoverService.class)
                .getPhotos(MarsRover.CURIOSITY, MarsRover.LANDING_EARTH_DATE_CURIOSITY, photosPageNum);
        photos.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<PhotosResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        photosListContract.showLoading();
                    }

                    @Override
                    public void onSuccess(PhotosResponse photosResponse) {
                        photosListContract.hideLoading();
                        photosListContract.updateList(photosResponse.getPhotos().subList(0, 20));
                    }

                    @Override
                    public void onError(Throwable e) {
                        photosListContract.hideLoading();
                        photosListContract.showToast("Something went wrong, try again later.");
                    }
                });
    }

    public void onBindRepositoryRowViewAtPosition(final int position, PhotoRowViewHolder viewHolder) {
        Photo photo = photosListContract.getList().get(position);
        viewHolder.setImage(photo.getImgUri());
        viewHolder.setDate(photo.getEarthDate());
        viewHolder.setOnRowClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photosListContract.onClickRow(position);
            }
        });
    }

    public int getPhotoRowsCount(){
        return photosListContract.getList().size();
    }
}
