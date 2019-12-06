package montp.services;

import montp.data.dao.PersonDAO;
import montp.data.entity.PersonEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonService extends GenericService<PersonEntity, PersonDAO> {
    @Override
    public boolean canDelete(PersonEntity instance) {
        return super.canDelete(instance) && instance.getClients().isEmpty();
    }
}
