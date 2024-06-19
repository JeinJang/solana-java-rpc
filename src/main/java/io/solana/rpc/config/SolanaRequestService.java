package io.solana.rpc.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.solana.rpc.dto.GetBalanceResultDto;
import io.solana.rpc.dto.SolanaRPCResponseDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

public class SolanaRequestService {
    private final String rpcUrl = "https://api.devnet.solana.com";
    private final RestTemplate restTemplate;

    public SolanaRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public long[] getBlocks(long start, long end) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        GetBlocksResponseDto resonse = restTemplate.exchange(
                rpcUrl, HttpMethod.POST,
                new HttpEntity<>(
                        new HttpRequestBody<Long>(
                                "getBlocks",
                                new Long[]{start, end}
                        ), headers
                ), GetBlocksResponseDto.class
        ).getBody();

        assert resonse != null;
        return resonse.result;
    }

    public GetBalanceResultDto getBalance(String account) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        GetBalanceResponseDto resonse = restTemplate.exchange(
                rpcUrl, HttpMethod.POST,
                new HttpEntity<>(
                        new HttpRequestBody<String>(
                                "getBalance",
                                new String[] {account}
                        ), headers
                ), GetBalanceResponseDto.class
        ).getBody();

        assert resonse != null;
        return resonse.result;
    }

    public static class HttpRequestBody<T> {
        private final String jsonrpc = "2.0";
        private final long id = 1;
        private String method;
        private T[] params;

        public HttpRequestBody(String method, T[] params) {
            this.method = method;
            this.params = params;
        }

        // Getters for Jackson
        public String getJsonrpc() {
            return jsonrpc;
        }

        public long getId() {
            return id;
        }

        public String getMethod() {
            return method;
        }

        public T[] getParams() {
            return params;
        }
    }
}

class GetBlocksResponseDto extends SolanaRPCResponseDto<long[]> {
    public GetBlocksResponseDto(
            @JsonProperty("jsonrpc") String jsonrpc,
            @JsonProperty("id") long id,
            @JsonProperty("result") long[] result
    ) {
        super(jsonrpc, id, result);
    }
}


class GetBalanceResponseDto extends SolanaRPCResponseDto<GetBalanceResultDto> {
    public GetBalanceResponseDto(
            @JsonProperty("jsonrpc") String jsonrpc,
            @JsonProperty("id") long id,
            @JsonProperty("result") GetBalanceResultDto result
    ) {
        super(jsonrpc, id, result);
    }
}

