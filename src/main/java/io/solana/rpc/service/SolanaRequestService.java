package io.solana.rpc.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.solana.rpc.dto.GetBalanceResultDto;
import io.solana.rpc.dto.SolanaBlockDto;
import io.solana.rpc.dto.SolanaRPCResponseDto;
import io.solana.rpc.dto.request.GetBlockRequestParamsDto;
import io.solana.rpc.dto.request.RequestParamsDto;
import io.solana.rpc.dto.request.SolanaRequestBodyDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class SolanaRequestService {
    private final String rpcUrl = "https://api.devnet.solana.com";
    private final RestTemplate restTemplate;
    HttpHeaders headers = new HttpHeaders();

    public SolanaRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public long[] getBlocks(long start, long end) {
        GetBlocksResponseDto response = restTemplate.exchange(
                rpcUrl, HttpMethod.POST,
                new HttpEntity<>(
                        new SolanaRequestBodyDto<Long>(
                                "getBlocks",
                                new Long[]{start, end}
                        ), headers
                ), GetBlocksResponseDto.class
        ).getBody();

        assert response != null;
        return response.result;
    }

    public GetBalanceResultDto getBalance(String account) {
        GetBalanceResponseDto response = restTemplate.exchange(
                rpcUrl, HttpMethod.POST,
                new HttpEntity<>(
                        new SolanaRequestBodyDto<String>(
                                "getBalance",
                                new String[] {account}
                        ), headers
                ), GetBalanceResponseDto.class
        ).getBody();

        assert response != null;
        return response.result;
    }

    public Long getBlockHeight(@Nullable RequestParamsDto params) {
        GetBlockHeightResponseDto response = restTemplate.exchange(
                rpcUrl, HttpMethod.POST,
                new HttpEntity<>(
                        new SolanaRequestBodyDto<>(
                                "getBlockHeight",
                                params != null ? new RequestParamsDto[] { params } : null
                        ), headers
                ), GetBlockHeightResponseDto.class
        ).getBody();

        assert response != null;
        return response.result;
    }

    public SolanaBlockDto getBlock(Long slotNumber, @Nullable GetBlockRequestParamsDto params) {
        GetBlockResponseDto response = restTemplate.exchange(
                rpcUrl, HttpMethod.POST,
                new HttpEntity<>(
                        new SolanaRequestBodyDto<>(
                                "getBlock",
                                params != null ? new Object[] { slotNumber, params } : new Long[] { slotNumber }
                        ), headers
                ), GetBlockResponseDto.class
        ).getBody();

        assert response != null;
        return response.result;
    }

    public Long getSlot(@Nullable RequestParamsDto params) {
        GetSlotResponseDto response = restTemplate.exchange(
                rpcUrl, HttpMethod.POST,
                new HttpEntity<>(
                        new SolanaRequestBodyDto<>(
                                "getSlot",
                                params != null ? new RequestParamsDto[] { params } : null
                        ), headers
                ), GetSlotResponseDto.class
        ).getBody();

        assert response != null;
        return response.result;
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

class GetBlockHeightResponseDto extends SolanaRPCResponseDto<Long> {
    public GetBlockHeightResponseDto(
            @JsonProperty("jsonrpc") String jsonrpc,
            @JsonProperty("id") long id,
            @JsonProperty("result") Long result
    ) {
        super(jsonrpc, id, result);
    }
}

class GetBlockResponseDto extends SolanaRPCResponseDto<SolanaBlockDto> {
    public GetBlockResponseDto(
            @JsonProperty("jsonrpc") String jsonrpc,
            @JsonProperty("id") long id,
            @JsonProperty("result") SolanaBlockDto result
    ) {
        super(jsonrpc, id, result);
    }
}

class GetSlotResponseDto extends SolanaRPCResponseDto<Long> {
    public GetSlotResponseDto(
            @JsonProperty("jsonrpc") String jsonrpc,
            @JsonProperty("id") long id,
            @JsonProperty("result") Long result
    ) {
        super(jsonrpc, id, result);
    }
}