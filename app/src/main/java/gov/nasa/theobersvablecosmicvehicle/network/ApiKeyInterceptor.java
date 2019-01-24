package gov.nasa.theobersvablecosmicvehicle.network;

import java.io.IOException;

import gov.nasa.theobersvablecosmicvehicle.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiKeyInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        HttpUrl url = chain.request().url().newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build();

        Request request = chain.request().newBuilder()
                .url(url)
                .build();

        return chain.proceed(request);
    }
}
