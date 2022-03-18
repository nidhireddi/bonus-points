package com.retailer.rewardpoints.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.retailer.rewardpoints.service.RewardPointsCalculatorService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RewardPointsCalculatorServiceImplTest {

	@Autowired
	RewardPointsCalculatorService rewardPointsCalculatorService;

	@Test
	public void test0Dollars() {
		Float res = rewardPointsCalculatorService.calculateRewardPoints(0f);
		assertEquals(0, res);
	}

	@Test
	public void test30Dollars() {
		Float res = rewardPointsCalculatorService.calculateRewardPoints(30f);
		assertEquals(0, res);
	}

	@Test
	public void test50Dollars() {
		Float res = rewardPointsCalculatorService.calculateRewardPoints(50f);
		assertEquals(0, res);
	}

	@Test
	public void test70Dollars() {
		Float res = rewardPointsCalculatorService.calculateRewardPoints(70f);
		assertEquals(20, res);
	}

	@Test
	public void test100Dollars() {
		Float res = rewardPointsCalculatorService.calculateRewardPoints(100f);
		assertEquals(50, res);
	}

	@Test
	public void test120Dollars() {
		/*
		 * float res = rewardPointsCalculatorService.calculateRewardPoints(120f);
		 * assertEquals(90, res);
		 */
	}
}