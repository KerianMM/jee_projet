package montp.data.dao;

import montp.data.entity.PayementModeEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PayementModeDAO extends GenericDAO<PayementModeEntity> {
    public PayementModeDAO() {
        super(PayementModeEntity.class);
    }

    @Override
    public List<PayementModeEntity> findAll() {
        return em.createQuery(makeQLString("s", "ORDER BY s.orderNum"))
                .getResultList();
    }
}
