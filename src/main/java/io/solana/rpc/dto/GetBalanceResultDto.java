package io.solana.rpc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBalanceResultDto {
    public Context context;
    public long value;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Context {
    public String apiVersion;
    public long slot;
}