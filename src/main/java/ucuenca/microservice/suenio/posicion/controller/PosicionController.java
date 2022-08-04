package ucuenca.microservice.suenio.posicion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucuenca.microservice.suenio.posicion.entity.PosicionEntity;
import ucuenca.microservice.suenio.posicion.repository.PosicionRepository;
import ucuenca.microservice.suenio.posicion.service.PosicionService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/posicion")
public class PosicionController {

    @Autowired
    private PosicionRepository posicionRepository;

    @Autowired
    private PosicionService posicionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PosicionEntity> getAllPosicion(){
        return posicionRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createPosicion(@RequestBody PosicionEntity posicionEntity){
        posicionRepository.save(posicionEntity);
    }

    @GetMapping (value = "/list/{fechaIni}/{fechaFin}")
    public ResponseEntity<List<PosicionEntity>> findListRespiracion(@PathVariable String fechaIni, @PathVariable String fechaFin){
        List<PosicionEntity> temp = new ArrayList<>();
        temp = posicionService.findListPosicion(fechaIni, fechaFin);
        return ResponseEntity.ok(temp);
    }

    @GetMapping(value = "/list/{id_user}")
    public ResponseEntity<List<PosicionEntity>> findListIdUserResp(@PathVariable String id_user){
        List<PosicionEntity> temp = new ArrayList<>();
        temp = posicionService.findByIdUserPos(id_user);
        return ResponseEntity.ok(temp);
    }


}
