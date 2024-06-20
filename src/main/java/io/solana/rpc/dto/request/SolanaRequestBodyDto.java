package io.solana.rpc.dto.request;

import lombok.Getter;
import org.springframework.lang.Nullable;

@Getter
public class SolanaRequestBodyDto<T> {
    public final String jsonrpc = "2.0";
    public final long id = 1;
    public String method;
    @Nullable private T[] params;

    public SolanaRequestBodyDto(String method, @Nullable T[] params) {
        this.method = method;
        this.params = params;
    }
}