package montp.services;

import montp.data.dao.FacturationLineDAO;
import montp.data.entity.FacturationLineEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FacturationLineService extends GenericService<FacturationLineEntity, FacturationLineDAO> {}
