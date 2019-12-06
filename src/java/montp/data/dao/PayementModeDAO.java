package montp.data.dao;

import montp.data.entity.PayementModeEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PayementModeDAO extends GenericDAO<PayementModeEntity> {
    public PayementModeDAO() {
        super(PayementModeEntity.class);
    }
}
