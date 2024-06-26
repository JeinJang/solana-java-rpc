package io.solana.rpc;

import io.solana.rpc.dto.SolanaBlockDto;
import io.solana.rpc.dto.request.GetBlockRequestParamsDto;
import io.solana.rpc.dto.request.RequestParamsDto;
import io.solana.rpc.dto.result.GetTransactionResult;
import io.solana.rpc.service.SolanaRequestService;
import io.solana.rpc.dto.GetBalanceResultDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootTest
class SolanaRpcTutorialApplicationTests {
	RestTemplate restTemplate = new RestTemplate();
	SolanaRequestService solanaRequestService = new SolanaRequestService(restTemplate);

	@Test
	void getBlocksTest() {
		long[] blocks = solanaRequestService.getBlocks(999000, 1000000);
		System.out.println("blocks: " + Arrays.toString(blocks));
	}

	@Test
	void getBalanceTest() {
		GetBalanceResultDto balance = solanaRequestService.getBalance("83astBRguLMdt2h5U1Tpdq5tjFoJ6noeGwaY3mDLVcri");
		System.out.println("balance: " + balance);
	}

	@Test
	void getBlockHeightTest() {
		long blockHeight = solanaRequestService.getBlockHeight(
				new RequestParamsDto(null, null)
		);
		System.out.println("block height: " + blockHeight);

		long finalized = solanaRequestService.getBlockHeight(
				new RequestParamsDto("finalized", null)
		);
		System.out.println("block height: " + finalized);

		long confirmed = solanaRequestService.getBlockHeight(
				new RequestParamsDto("confirmed", null)
		);
		System.out.println("block height: " + confirmed);

		long processed = solanaRequestService.getBlockHeight(
				new RequestParamsDto("processed", null)
		);
		System.out.println("block height: " + processed);
	}

	@Test
	void getBlockTest() {
		long slot = solanaRequestService.getSlot(null);
		SolanaBlockDto block = solanaRequestService.getBlock(slot, new GetBlockRequestParamsDto(null, "json", "full", (long) 0, false));
		System.out.println("slot number: " + slot);
		System.out.println("block: " + block);
	}

	@Test
	void getTransactionsTest() {
		GetTransactionResult transaction = solanaRequestService.getTransaction(
				"2VwVr1usBay22bNDb32ZDb1ZYcfHowSu5hRVMx2TEFXFtMdqDkL4z2H7Cj86RZ6kFFdKsUH3b7WkH2WPtxqW3fL8",
				null
		);
		System.out.println("transaction: " + transaction);
	}
}
