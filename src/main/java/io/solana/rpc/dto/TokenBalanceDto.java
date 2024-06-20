package io.solana.rpc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenBalanceDto {
    public long accountIndex;
    public String mint;
    @Nullable
    public String owner;
    @Nullable
    public String programId;
    public UiTokenAccountDto uiTokenAmount;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class UiTokenAccountDto {
        public String amount;
        public long decimals;
        @Nullable
        public long uiAmount;
        public String uiAmountString;
    }
}