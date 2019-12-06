package montp.data.dao;

import montp.data.entity.FacturationLineEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FacturationLineDAO extends GenericDAO<FacturationLineEntity> {
    public FacturationLineDAO() {
        super(FacturationLineEntity.class);
    }
}
