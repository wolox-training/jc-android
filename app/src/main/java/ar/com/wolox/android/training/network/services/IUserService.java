package ar.com.wolox.android.training.network.services;

import java.util.List;
import java.util.Map;

import ar.com.wolox.android.training.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * My <b>IUserService</b>.
 */
public interface IUserService {

    @GET("users")
    Call<List<User>> findUserByEmailAndPassword(@QueryMap Map<String, String> user);
}
