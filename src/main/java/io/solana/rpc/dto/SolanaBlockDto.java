package io.solana.rpc.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
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
    public TxDetailDto[] transactions;
    @Nullable
    public String[] signatures;
    @Nullable
    public RewardDto[] rewards;
}
