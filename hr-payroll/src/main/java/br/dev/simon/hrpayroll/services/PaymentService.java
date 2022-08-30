package br.dev.simon.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.simon.hrpayroll.entities.Payment;
import br.dev.simon.hrpayroll.entities.Worker;
import br.dev.simon.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	// There is no repository, only mocked data.

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(Long workerId, Integer days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
