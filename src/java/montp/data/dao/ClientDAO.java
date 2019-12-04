package montp.data.dao;

import montp.data.entity.ClientEntity;
import montp.data.entity.PersonEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ClientDAO extends GenericDAO<ClientEntity> {
    public ClientDAO() {
        super(ClientEntity.class);
    }

    public List<ClientEntity> findByOwner(PersonEntity personEntity) {
        return em.createQuery(makeQLString("c", "WHERE c.person = :person"))
                .setParameter("person", personEntity)
                .getResultList();
    }
}
