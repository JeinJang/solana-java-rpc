package io.solana.rpc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Getter
@AllArgsConstructor
public class GetTransactionRequestParamsDto {
    @Nullable
    public String commitment;
    @Nullable
    public long maxSupportedTransactionVersion;
    @Nullable
    public String encoding;
}
