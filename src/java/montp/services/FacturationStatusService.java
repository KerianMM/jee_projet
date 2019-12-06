package montp.services;

import montp.data.dao.FacturationStatusDAO;
import montp.data.entity.FacturationStatusEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FacturationStatusService extends GenericService<FacturationStatusEntity, FacturationStatusDAO> {}
