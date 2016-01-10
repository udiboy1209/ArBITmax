package code.fundo.arbitmax;

/**
 * Created by udiboy on 9/1/16.
 */
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface BitClient {

    @FormUrlEncoded
    @POST("/balance/")
    void getBalance(@Field("wallet_id") String wallet_id,
                    @Field("password") String password,
                    Callback<BalanceResponse> cb);

    @FormUrlEncoded
    @POST("/addresslist/")
    void getAddressList(@Field("wallet_id") String wallet_id,
                    @Field("password") String password,
                    Callback<AddrListResponse> cb);

    @FormUrlEncoded
    @POST("/createaddress/")
    void createAddress(@Field("wallet_id") String wallet_id,
                        @Field("password") String password,
                        @Field("label") String label,
                        Callback<Address> cb);

    @FormUrlEncoded
    @POST("/pay/")
    void send(@Field("wallet_id") String wallet_id,
                       @Field("password") String password,
                       @Field("to_address") String to,
                       @Field("from_address") String from,
                       @Field("public_note") String public_note,
                       Callback<SendConfirmation> cb);

    @GET("/multiaddr")
    void getTransactions(@Field("active") String address, Callback<TransactionsResponse> cb);

    @GET("/ticker")
    void getTicker(Callback<TickerResponse> cb);
}
