package code.fundo.arbitmax;

/**
 * Created by udiboy on 9/1/16.
 */

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("balance")
    long balance;

    @SerializedName("username")
    String username;

    @SerializedName("wallet_id")
    String wallet_id;

    @SerializedName("password")
    String password;

    @SerializedName("addresses")
    Address[] addresses;
}
