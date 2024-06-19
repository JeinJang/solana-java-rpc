package io.solana.rpc;

import io.solana.rpc.config.SolanaRequestService;
import io.solana.rpc.dto.GetBalanceResultDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootTest
class SolanaRpcTutorialApplicationTests {
	@Test
	void getBlocksTest() {
		RestTemplate restTemplate = new RestTemplate();
		SolanaRequestService solanaRequestService = new SolanaRequestService(restTemplate);

		long[] blocks = solanaRequestService.getBlocks(999000, 1000000);
		GetBalanceResultDto balance = solanaRequestService.getBalance("83astBRguLMdt2h5U1Tpdq5tjFoJ6noeGwaY3mDLVcri");
		System.out.println("blocks: " + Arrays.toString(blocks));
		System.out.println("balance: " + balance);
	}
}
