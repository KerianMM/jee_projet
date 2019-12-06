package montp.web.converters;

import montp.data.dao.FacturationLineDAO;
import montp.data.entity.FacturationEntity;
import montp.data.entity.FacturationLineEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = FacturationEntity.class)
public class FacturationLineConverter extends GenericConverter<FacturationLineEntity>{

    public FacturationLineConverter() {
        super(Tools.lookupBean(FacturationLineDAO.class));
    }
    
}
