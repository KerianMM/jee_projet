package montp.services;

import montp.data.dao.FacturationDAO;
import montp.data.entity.ClientEntity;
import montp.data.entity.FacturationEntity;
import montp.data.entity.ProjectEntity;
import montp.web.FacesTools;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import java.util.List;

@ApplicationScoped
public class FacturationService extends GenericService<FacturationEntity, FacturationDAO> {
    @Override
    public void insert(FacturationEntity instance) {
        if (instance.getPayementMode().getOrderNum() == 3 && instance.getPayedAt() == null){
            FacesTools.addMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Veuillez renseigner la date de payement"
            );
            return;
        }

        ClientEntity client = instance.getProject().getClient();

        instance.setReference(client.getFactureReference());
        client.setFactureReference(client.getFactureReference()+1);

        super.insert(instance);
    }

    public List<FacturationEntity> getByProject(ProjectEntity project){
        return dao.findByProject(project);
    }
}
