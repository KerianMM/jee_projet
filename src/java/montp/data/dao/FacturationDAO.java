package montp.data.dao;

import montp.data.entity.FacturationEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FacturationDAO extends GenericDAO<FacturationEntity> {
    public FacturationDAO() {
        super(FacturationEntity.class);
    }
}
