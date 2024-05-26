package util;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpRequest {

//    public static <T> T getPost( String url, String json, Class<T> T){
//        OkHttpClient okHttpClient = new OkHttpClient();
//
//        try {
//            T t = new Gson().fromJson( okHttpClient.newCall( new Request.Builder()
//                    .url( AppConfig.url + url ).post( RequestBody.create( MediaType.parse("application/json;charset=utf-8"),json ) )
//                    .header( "Authorization",AppConfig.token).build()
//                ).execute().body().toString() , T ) ;
//
//            return t;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    public static <T> T getPost(String url, String json, Class<T> T) {

        OkHttpClient okHttpClient = new OkHttpClient();

        try {
            String string = okHttpClient.newCall(new Request.Builder()
                    .post(RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json))
                    .url(AppConfig.Address + url).header("Authorization", AppConfig.token).build()
            ).execute().body().string();

            T t = new Gson().fromJson(string, T);

            return t;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
