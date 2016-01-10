package code.fundo.arbitmax;

import com.google.gson.annotations.SerializedName;

/**
 * Created by udiboy on 10/1/16.
 */
public class Address {

        @SerializedName("address")
        String address;

        @SerializedName("balance")
        String balance;

        @SerializedName("label")
        String label;
}
