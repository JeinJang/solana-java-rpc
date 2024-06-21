package io.solana.rpc.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
// TODO: transaction이 encrypt 되어 있는 경우는 생각 안해도 되는지?
// 참고: https://solana.com/docs/rpc/http/getblock
@NoArgsConstructor
@AllArgsConstructor
public class TxDetailDto {
    public SolanaTxDto transaction;
    public MetaDto meta;
    @Nullable
    public Version version;

    static class Version {
        @Nullable
        public String legacy;
        @Nullable
        public long version;

        public Version(Object version) {
            if (version == "legacy") {
                this.legacy = "legacy";
            } else if (version instanceof Long) {
                this.version = (Long) version;
            }
        }
        @JsonCreator
        public static Version from(Object version) {
            return new Version(version);
        }
    }
}