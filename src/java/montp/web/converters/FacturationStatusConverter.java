package montp.web.converters;

import montp.data.dao.FacturationStatusDAO;
import montp.data.entity.FacturationStatusEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = FacturationStatusEntity.class)
public class FacturationStatusConverter extends GenericConverter<FacturationStatusEntity>{

    public FacturationStatusConverter() {
        super(Tools.lookupBean(FacturationStatusDAO.class));
    }
    
}
