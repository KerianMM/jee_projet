package montp.web.converters;

import montp.data.dao.FacturationDAO;
import montp.data.entity.FacturationEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = FacturationEntity.class)
public class FacturationConverter extends GenericConverter<FacturationEntity>{

    public FacturationConverter() {
        super(Tools.lookupBean(FacturationDAO.class));
    }
    
}
