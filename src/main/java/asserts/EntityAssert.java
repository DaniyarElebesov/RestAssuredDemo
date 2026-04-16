package asserts;

import entities.BaseEntity;
import org.assertj.core.api.Assertions;

public class EntityAssert {
    protected BaseEntity entity;

    public EntityAssert(BaseEntity entity) {
        this.entity = entity;
    }

    public void isEquals(BaseEntity expectedEntity){
        Assertions.assertThat(this.entity.isEquals(expectedEntity))
                .withFailMessage("Object is not equals, parameters is not match: %s",
                        this.entity.getClass().getName()).isTrue();

    }
}

