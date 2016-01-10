package code.fundo.arbitmax;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kalpesh on 10/1/16.
 */
public class TickerResponse {
    @SerializedName("USD")
    TickerEntry arb;
    public class TickerEntry {
        @SerializedName("last")
        double last;
    }
}

