package me.shouheng.mvvm.http.interceptor;

import android.support.annotation.NonNull;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

/**
 * The http progress interceptor.
 *
 * @author <a href="mailto:shouheng2015@gmail.com">WngShhng</a>
 * @version 2019/7/18 22:43
 */
public class ProgressInterceptor implements Interceptor {

    private ProgressResponseCallback callback;

    public ProgressInterceptor(ProgressResponseCallback callback) {
        this.callback = callback;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .body(new ProgressResponseBody(originalResponse.body(), callback))
                .build();
    }
}
