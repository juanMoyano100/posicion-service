package ucuenca.microservice.suenio.posicion.service;

import ucuenca.microservice.suenio.posicion.entity.PosicionEntity;

import java.util.List;

public interface PosicionService {

    public List<PosicionEntity> findListPosicion(String ini, String fin);
    public List<PosicionEntity> findByIdUserPos(String id_usuario);

}
