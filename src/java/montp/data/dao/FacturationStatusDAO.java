package montp.data.dao;

import montp.data.entity.FacturationStatusEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FacturationStatusDAO extends GenericDAO<FacturationStatusEntity> {
    public FacturationStatusDAO() {
        super(FacturationStatusEntity.class);
    }

    @Override
    public List<FacturationStatusEntity> findAll() {
        return em.createQuery(makeQLString("s", "ORDER BY s.orderNum"))
                .getResultList();
    }
}
