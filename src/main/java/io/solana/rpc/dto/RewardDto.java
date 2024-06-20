package io.solana.rpc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RewardDto {
    public String pubkey;
    public long lamports;
    public long postBalance;
    @Nullable
    public String rewardType;
    public int commission;
}