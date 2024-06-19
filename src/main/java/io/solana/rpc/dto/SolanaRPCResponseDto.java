package io.solana.rpc.dto;

public class SolanaRPCResponseDto<T> {
    public String jsonrpc;
    public long id;
    public T result;

    public SolanaRPCResponseDto(String jsonrpc, long id, T result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.result = result;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }
    public long getId() {
        return id;
    }
    public T getResult() {
        return result;
    }
}
