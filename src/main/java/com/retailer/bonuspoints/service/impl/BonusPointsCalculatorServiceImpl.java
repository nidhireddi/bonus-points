package com.retailer.bonuspoints.service.impl;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.retailer.bonuspoints.service.BonusPointsCalculatorService;

@Service
public class BonusPointsCalculatorServiceImpl implements BonusPointsCalculatorService {
	
	@Value("${firstThreshold}")
	private Double firstThreshold;
	
	@Value("${firstThresholdMultiplier}")
	private Double firstThresholdMultiplier;
	
	@Value("${secondThreshold}")
	private Double secondThreshold;
	
	@Value("${secondThresholdMultiplier}")
	private Double secondThresholdMultiplier;

	@Override
	public Double calculateBonusPoints(Double dollarsSpent) {
		Double totalPoints = 0d;
		totalPoints += Math.max(dollarsSpent - secondThreshold, 0) * secondThresholdMultiplier; // Adding 2x points
		totalPoints += Math.min(Math.max(dollarsSpent - firstThreshold, 0) * 1, firstThreshold)
				* firstThresholdMultiplier; // Adding 1x points
		return Double.parseDouble(new DecimalFormat("##.##").format(totalPoints));
	}

}
