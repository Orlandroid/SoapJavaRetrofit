package com.example.soapcountry.api;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitInstance {

    private static Strategy strategy = new AnnotationStrategy();
    private static Serializer serializer = new Persister(strategy);
    private static String BASE_URL = "http://webservices.oorsprong.org/websamples.countryinfo/";
    private static String BASE_URL_NUMBERS_SERVICE = "https://www.dataaccess.com/webservicesserver/";

    public static CountrysService getCountryService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient client = getUnsafeOkHttpClient().addInterceptor(logging).build();
        client.retryOnConnectionFailure();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.baseUrl(BASE_URL).client(client).build();
        return retrofit.create(CountrysService.class);
    }


    public static NumbersService getNumbersService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient client = getUnsafeOkHttpClient().addInterceptor(logging).build();
        client.retryOnConnectionFailure();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.baseUrl(BASE_URL_NUMBERS_SERVICE).client(client).build();
        return retrofit.create(NumbersService.class);
    }

    //Client builder to read the sent and received body.
    public static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }};
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
