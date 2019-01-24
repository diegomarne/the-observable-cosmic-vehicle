package gov.nasa.theobersvablecosmicvehicle.view.contracts;

import android.view.View;

import io.reactivex.annotations.NonNull;

public interface PhotoRowContract {
    void setImage(@NonNull String uri);
    void setDate(@NonNull String date);
    void setOnRowClickListener(View.OnClickListener enabled);
}
