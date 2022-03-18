package com.retailer.rewardpoints.service.impl;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.retailer.rewardpoints.service.RewardPointsCalculatorService;

@Service
public class RewardPointsCalculatorServiceImpl implements RewardPointsCalculatorService {
	
	@Value("${firstThreshold}")
	private Float firstThreshold;
	
	@Value("${firstThresholdMultiplier}")
	private Float firstThresholdMultiplier;
	
	@Value("${secondThreshold}")
	private Float secondThreshold;
	
	@Value("${secondThresholdMultiplier}")
	private Float secondThresholdMultiplier;

	@Override
	public Float calculateRewardPoints(Float dollarsSpent) {
		Float totalPoints = 0F;
		totalPoints += Math.max(dollarsSpent - secondThreshold, 0) * secondThresholdMultiplier; // Adding 2x points
		totalPoints += Math.min(Math.max(dollarsSpent - firstThreshold, 0) * 1, firstThreshold)
				* firstThresholdMultiplier; // Adding 1x points
		return Float.parseFloat(new DecimalFormat("##.##").format(totalPoints));
	}

}
