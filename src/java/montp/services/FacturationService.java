package montp.services;

import montp.data.dao.FacturationDAO;
import montp.data.entity.ClientEntity;
import montp.data.entity.FacturationEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FacturationService extends GenericService<FacturationEntity, FacturationDAO> {
    @Override
    public void insert(FacturationEntity instance) {
        ClientEntity client = instance.getProject().getClient();

        instance.setReference(client.getFactureReference());
        client.setFactureReference(client.getFactureReference()+1);

        super.insert(instance);
    }
}
