package ucuenca.microservice.suenio.posicion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ucuenca.microservice.suenio.posicion.entity.PosicionEntity;

public interface PosicionRepository extends MongoRepository <PosicionEntity, String> {

}
