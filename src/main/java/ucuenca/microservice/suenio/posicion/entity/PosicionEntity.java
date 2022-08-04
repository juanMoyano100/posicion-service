package ucuenca.microservice.suenio.posicion.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(value = "posicion")
@Getter
@Setter
@NoArgsConstructor
public class PosicionEntity {

    private String id;
    private String id_usuario;
    private LocalDateTime fecha;
    private String posicion;


}
