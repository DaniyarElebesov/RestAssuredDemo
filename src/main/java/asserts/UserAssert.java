package asserts;

import entities.BaseEntity;

public class UserAssert extends EntityAssert{

    public UserAssert(BaseEntity entity) {
        super(entity);
    }

    public static UserAssert assertThat(BaseEntity entity){
        return new UserAssert(entity);
    }
}
