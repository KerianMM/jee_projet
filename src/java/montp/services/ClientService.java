package montp.services;

import montp.data.dao.ClientDAO;
import montp.data.entity.ClientEntity;
import montp.data.entity.security.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ClientService extends GenericService<ClientEntity, ClientDAO> {
    public List<ClientEntity> getByCurrentUser(UserEntity userEntity) {
        return dao.findByOwner(userEntity.getPerson());
    }

    public void incrementFacturation(ClientEntity client){
        client.setFactureReference(client.getFactureReference()+1);
        save(client);
    }

    @Override
    public void insert(ClientEntity instance) {
        super.insert(instance);
        instance.getPerson().getClients().add(instance);
    }

    @Override
    public boolean canDelete(ClientEntity instance) {
        return super.canDelete(instance) && instance.getProjects().isEmpty();
    }
}
