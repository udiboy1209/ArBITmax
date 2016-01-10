package code.fundo.arbitmax;

import com.google.gson.annotations.SerializedName;

/**
 * Created by udiboy on 10/1/16.
 */
public class TransactionsResponse {
    @SerializedName("txs")
    Transaction[] txs;

    class Transaction{
        @SerializedName("inputs")
        Input[] inputs;

        @SerializedName("out")
        Output[] outputs;

        class Input{
            @SerializedName("prev_out")
            Output prev_out;
        }

        class Output{
            @SerializedName("addr")
            String addr;

            @SerializedName("value")
            String value;
        }
    }
}
