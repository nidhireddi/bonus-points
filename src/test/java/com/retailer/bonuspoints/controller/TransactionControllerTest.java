package com.retailer.bonuspoints.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

import com.retailer.bonuspoints.model.Transaction;
import com.retailer.bonuspoints.utils.TestUtils;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

	@Autowired
	private TransactionController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAllTransactions() throws Exception {

		String uri = "/retailer/getAllTransactions";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertTrue((status == 200));
		String content = mvcResult.getResponse().getContentAsString();
		Transaction[] productlist = TestUtils.mapFromJson(content, Transaction[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void testGetTransactionsbyCustomerId() throws Exception {
		String uri = "/retailer/customer-id/101";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertTrue((status == 200));
		String content = mvcResult.getResponse().getContentAsString();
		Transaction[] productlist = TestUtils.mapFromJson(content, Transaction[].class);
		assertTrue((productlist.length == 4));
	}

	@Test
	public void testGetBonusPointsByAmount() throws Exception {
		String uri = "/retailer/get-bonus-points";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).param("amount", "1400")).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertTrue((status == 200));
		String content = mvcResult.getResponse().getContentAsString();
		Double bonusPoints = TestUtils.mapFromJson(content, Double.class);
		assertTrue((bonusPoints == 2650));
	}

	@Test
	public void testGetBonusPointsByCustomerId() throws Exception {
		String uri = "/retailer/get-bonus-points-by-customer-id/101";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertTrue((status == 200));
		String content = mvcResult.getResponse().getContentAsString();
		Double bonusPoints = TestUtils.mapFromJson(content, Double.class);
		assertTrue((bonusPoints == 3440));
	}

	@Test
	public void testGetTransactionById() throws Exception {
		String uri = "/retailer/4";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertTrue((status == 200));
		String content = mvcResult.getResponse().getContentAsString();
		Transaction transaction = TestUtils.mapFromJson(content, Transaction.class);
		assertNotNull(transaction);
	}

	@Test
	public void testSaveTransaction() throws Exception {
		String uri = "/retailer/saveTransaction";
		Transaction transaction = TestUtils.builderTransactionInstance(1L, 100d, new Date(),
				TestUtils.builderCustomerInstance(100L, "fname1", "lname1", 23, "address1", 500d), "refid");
		String json = TestUtils.mapToJson(transaction);
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(json))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertTrue((status == 200));
	}

}