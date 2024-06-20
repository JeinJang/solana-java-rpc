package io.solana.rpc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@AllArgsConstructor
public class RequestParamsDto {
    @Nullable
    public String commitment;
    @Nullable
    public Long minContextSlot;
}
