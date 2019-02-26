package com.steve.http;

import com.squareup.okhttp.*;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class OkHttpDemo {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().setCookieHandler(new CookieHandler() {
            @Override
            public Map<String, List<String>> get(URI uri, Map<String, List<String>> requestHeaders) throws IOException {
                return null;
            }

            @Override
            public void put(URI uri, Map<String, List<String>> responseHeaders) throws IOException {

            }
        });
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\"pageSize\":60}");
        // DDJB_PASS_ID=4af9549f82690dd909109d9129b41604
        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://jinbao.pinduoduo.com/network/api/common/goodsList")
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
    }
}
