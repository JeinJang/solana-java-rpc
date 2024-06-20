package io.solana.rpc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructionDto {
    public long programIdIndex;
    public long[] accounts;
    public String data;
    @Nullable
    public long stackHeight;
}