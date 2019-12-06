package montp.services;

import montp.data.dao.PayementModeDAO;
import montp.data.entity.PayementModeEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PayementModeService extends GenericService<PayementModeEntity, PayementModeDAO> {
}
