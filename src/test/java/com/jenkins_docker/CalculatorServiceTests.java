package com.jenkins_docker;

import com.jenkins_docker.services.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorServiceTests {

	@Test
	public void sumTwoNumbers() {
		CalculatorService service = new CalculatorService();
		int result = service.sum(2,3);
		Assertions.assertEquals(5, result);
	}

}