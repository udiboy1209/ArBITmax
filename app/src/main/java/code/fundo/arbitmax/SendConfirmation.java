package code.fundo.arbitmax;

import com.google.gson.annotations.SerializedName;

/**
 * Created by udiboy on 10/1/16.
 */
public class SendConfirmation {
    @SerializedName("message")
    String message;

    @SerializedName("notice")
    String notice;
}
