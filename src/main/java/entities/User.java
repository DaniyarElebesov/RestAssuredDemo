package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

public class User {
    int id;
    String name;
    String email;
    String gender;
    String status;
}
//POJO классы - Plain Old Java Object
//Термин Определение Пример
// Сериализация преобразование Java-объекта в JSON (или XML), чтобы отправить в запросе Java → JSON
// Десериализация преобразование JSON-ответа обратно в Java-объект JSON → Java
