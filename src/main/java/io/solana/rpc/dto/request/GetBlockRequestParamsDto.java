package io.solana.rpc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@AllArgsConstructor
public class GetBlockRequestParamsDto {
    @Nullable
    public String commitment;
    @Nullable
    public String encoding;
    @Nullable
    public String transactionDetails;
    @Nullable
    public Long maxSupportedTransactionVersion;
    @Nullable
    public Boolean rewards;
}
