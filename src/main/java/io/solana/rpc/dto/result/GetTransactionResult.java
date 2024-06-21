package io.solana.rpc.dto.result;

import io.solana.rpc.dto.TxDetailDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTransactionResult extends TxDetailDto {
    public long slot;
    @Nullable
    public long blockTime;
}
