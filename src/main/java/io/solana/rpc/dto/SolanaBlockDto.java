package io.solana.rpc.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolanaBlockDto {
    @Nullable
    public long blockHeight;
    @Nullable
    public long blockTime;
    public String blockhash;
    public long parentSlot;
    public String previousBlockhash;
    public Transaction[] transactions;
    @Nullable
    public String[] signatures;
    @Nullable
    public RewardDto[] rewards;


    // TODO: transaction이 encrypt 되어 있는 경우는 생각 안해도 되는지?
    // 참고: https://solana.com/docs/rpc/http/getblock
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Transaction {
        public SolanaTxDto transaction;
        public MetaDto meta;
        @Nullable
        public Version version;

        static class Version {
            @Nullable
            public String legacy;
            @Nullable
            public long version;

            public Version(Object version) {
                if (version == "legacy") {
                    this.legacy = "legacy";
                } else if (version instanceof Long) {
                    this.version = (Long) version;
                }
            }
            @JsonCreator
            public static Version from(Object version) {
                return new Version(version);
            }
        }
    }

    static class Tx {


    }
}
