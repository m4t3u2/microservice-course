package br.dev.simon.hrworker.resources;

import br.dev.simon.hrworker.entities.Worker;
import br.dev.simon.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger logger = LoggerFactory.getLogger(WorkerRepository.class);

	//@Value("${test.config}")
	//private String testConfig;

	@Autowired
	private Environment env;

	// The service was not implemented because the reason for the course is just to implement microservices.
	@Autowired
	private WorkerRepository repository;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
	// Just a test.
	//		try {
	//			Thread.sleep(3000L);
	//		} catch (InterruptedException e) {
	//			e.printStackTrace();
	//		}
		logger.info("PORT = " + env.getProperty("local.server.port"));
		Worker worker = repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		//logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}

}
