package io.solana.rpc.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaDto {
    @Nullable
    public Object err;
    public long fee;
    public long[] preBalances;
    public long[] postBalances;
    public InnerInstructionDto[] innerInstructions;
    @Nullable
    public TokenBalanceDto[] preTokenBalances;
    @Nullable
    public TokenBalanceDto[] postTokenBalances;
    @Nullable
    public String[] logMessages;
    @Nullable
    public RewardDto[] rewards;
    public Status status;
    @Nullable
    public LoadedAddresses loadedAddresses;
    @Nullable
    public ReturnData returnData;
    @Nullable
    public long computeUnitsConsumed;


    @NoArgsConstructor
    @AllArgsConstructor
    static class Status {
        @Nullable
        public Object Ok;
        @Nullable
        public Object Err;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    static class LoadedAddresses {
        public String[] writable;
        public String[] readonly;
    }

    static class ReturnData {
        public String programId;
        public String data;
        public String encoding;

        public ReturnData(String programId, Object[] data) {
            this.programId = programId;
            this.data = (String) data[0];
            this.encoding = (String) data[1];
        }
        @JsonCreator
        public static ReturnData from(
                @JsonProperty("programId") String programId,
                @JsonProperty("data") String[] data
        ) {
            return new ReturnData(programId, data);
        }
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class InnerInstructionDto {
    public long index;
    public InstructionDto[] instructions;
}