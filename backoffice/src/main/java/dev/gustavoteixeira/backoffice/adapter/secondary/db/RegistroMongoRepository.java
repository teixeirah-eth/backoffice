package dev.gustavoteixeira.backoffice.adapter.secondary.db;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroMongoRepository extends ReactiveMongoRepository<RegistroDocument, String> {

}
