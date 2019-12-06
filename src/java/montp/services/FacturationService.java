package montp.services;

import montp.data.dao.FacturationDAO;
import montp.data.entity.ClientEntity;
import montp.data.entity.FacturationEntity;
import montp.data.entity.ProjectEntity;
import montp.web.FacesTools;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FacturationService extends GenericService<FacturationEntity, FacturationDAO> {
    @Inject
    private ClientService clientService;

    @Override
    public void insert(FacturationEntity instance) {
        if (instance.getPayementMode().getOrderNum() == 3) {
            if (instance.getPayedAt() == null) {
                FacesTools.addMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Veuillez renseigner la date de payement"
                );
                return;
            } else if (instance.getPayedAt().getTime() > instance.getPayedAtMax().getTime()){
                FacesTools.addMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Veuillez renseigner une date de payement inférieure à la date limite"
                );
                return;
            }
        } else if (instance.getPayedAt() != null) {
            FacesTools.addMessage(
                    FacesMessage.SEVERITY_WARN,
                    "Vous ne pouvez renseigner la date de payement si le status de cette facture n'est pas \"payée\"."
            );
            instance.setPayedAt(null);
        }

        instance.setReference(instance.getProject().getClient().getFactureReference());

        super.insert(instance);

        clientService.incrementFacturation(instance.getProject().getClient());
        instance.getProject().getFacturations().add(instance);
    }

    public List<FacturationEntity> getByProject(ProjectEntity project) {
        return dao.findByProject(project);
    }

    @Override
    public boolean canDelete(FacturationEntity instance) {
        return super.canDelete(instance) && instance.getFacturationLines().isEmpty();
    }
}
