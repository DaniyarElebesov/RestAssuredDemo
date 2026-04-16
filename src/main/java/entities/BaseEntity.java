package entities;

import org.assertj.core.api.Assertions;

public class BaseEntity {

    public boolean isEquals(BaseEntity expectedEntity){
        try {
            Assertions.assertThat(this)
                    .usingRecursiveComparison()
                    .ignoringExpectedNullFields()
                    .isEqualTo(expectedEntity);
            return true;
        } catch (AssertionError e){
            return false;
        }
    }
}
