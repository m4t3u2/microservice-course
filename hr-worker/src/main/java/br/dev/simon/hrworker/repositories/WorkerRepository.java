package br.dev.simon.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.simon.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
