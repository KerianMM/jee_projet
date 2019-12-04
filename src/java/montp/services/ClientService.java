package montp.services;

import montp.data.dao.ClientDAO;
import montp.data.entity.ClientEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientService extends GenericService<ClientEntity, ClientDAO> {}
