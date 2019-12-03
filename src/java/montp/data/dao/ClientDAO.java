package montp.data.dao;

import montp.data.entity.ClientEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientDAO extends GenericDAO<ClientEntity> {
    public ClientDAO() {
        super(ClientEntity.class);
    }
}
