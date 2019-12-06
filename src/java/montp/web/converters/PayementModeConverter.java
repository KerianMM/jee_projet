package montp.web.converters;

import montp.data.dao.PayementModeDAO;
import montp.data.entity.PayementModeEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = PayementModeEntity.class)
public class PayementModeConverter extends GenericConverter<PayementModeEntity>{

    public PayementModeConverter() {
        super(Tools.lookupBean(PayementModeDAO.class));
    }
    
}
