package montp.web.converters;

import montp.data.dao.ClientDAO;
import montp.data.entity.ClientEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ClientEntity.class)
public class ClientConverter extends GenericConverter<ClientEntity>{

    public ClientConverter() {
        super(Tools.lookupBean(ClientDAO.class));
    }
    
}
