package Model;


import javax.persistence.EntityManager;

public class PhoneNumberDao extends GenericDao<PhoneNumber, Integer> {
    public PhoneNumberDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<PhoneNumber> getentityClass() {
        return PhoneNumber.class;
    }


}