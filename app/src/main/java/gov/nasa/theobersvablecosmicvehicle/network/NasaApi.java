package gov.nasa.theobersvablecosmicvehicle.network;

import gov.nasa.theobersvablecosmicvehicle.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NasaApi {

    // Interceptors
    private static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new ApiKeyInterceptor())
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .build();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <T> T buildService(Class<T> type){
        return retrofit.create(type);
    }

}
