package br.dev.simon.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.dev.simon.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	// There is no repository, only mocked data.

	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Bob", 200.0, days);
	}

}
