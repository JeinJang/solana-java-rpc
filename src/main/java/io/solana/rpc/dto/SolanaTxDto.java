package io.solana.rpc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolanaTxDto {
    public String[] signatures;
    public Message message;

    @NoArgsConstructor
    @AllArgsConstructor
    public static class Message {
        public String[] accountKeys;
        public MessageHeader header;
        public String recentBlockhash;
        public InstructionDto[] instructions;
        @Nullable
        public AddressTableLookup[] addressTableLookups;


        @NoArgsConstructor
        @AllArgsConstructor
        static class MessageHeader {
            public long numRequiredSignatures;
            public long numReadonlySignedAccounts;
            public long numReadonlyUnsignedAccounts;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        static class AddressTableLookup {
            public String accountKey;
            long[] writableIndexes;
            long[] readonlyIndexes;
        }
    }
}
