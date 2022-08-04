package ucuenca.microservice.suenio.posicion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ucuenca.microservice.suenio.posicion.entity.PosicionEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PosicionServiceImpl implements PosicionService{

    private final MongoOperations mongoOperations;

    @Autowired()
    @Qualifier(value = "mongoTemplate")
    MongoTemplate mongoTemplate;

    public PosicionServiceImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }


    @Override
    public List<PosicionEntity> findListPosicion(String ini, String fin) {
        Query query = new Query();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(ini, format);
        LocalDateTime end = LocalDateTime.parse(fin, format);
        query.addCriteria(Criteria.where("fecha").gt(start).lt(end));
        List <PosicionEntity> posicionDB = this.mongoOperations.find(query,PosicionEntity.class);
        return posicionDB;
    }

    @Override
    public List<PosicionEntity> findByIdUserPos(String id_usuario) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("id_usuario").is(id_usuario));
        List<PosicionEntity> users = mongoTemplate.find(query1, PosicionEntity.class);
        return users;
    }
}
