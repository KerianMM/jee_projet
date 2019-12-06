package montp.web.controllers.projects;

import montp.data.entity.ClientEntity;
import montp.data.entity.ProjectEntity;
import montp.data.entity.ProjectStatusEntity;
import montp.data.entity.security.UserEntity;
import montp.services.ClientService;
import montp.services.ProjectService;
import montp.services.ProjectStatusService;
import montp.web.FacesTools;
import montp.web.controllers.base.CRUDController;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ViewScoped
@Named
public class ClientProjectsCRUDView extends CRUDController<ProjectEntity, ProjectService> {
    @Inject private ClientService clientService;
    @Inject private ProjectStatusService projectStatusService;
    @Inject private UserEntity user;

    private ClientEntity client;
    private Integer clientId;
    private List<ProjectStatusEntity> statusList;

    @Override
    public void create() {
        entity = new ProjectEntity();
        entity.setClient(client);
    }

    @Override
    public void init() {
        statusList = projectStatusService.getAll();
        create();
    }

    @Override
    public void save() {
        super.save();
        initEntities();
    }

    private void initEntities() {
        entities = service.getByClient(client);
    }

    //region GETTERS / SETTERS
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
        client = clientService.get(clientId);

        if (!user.getPerson().equals(client.getPerson())) {
            FacesTools.redirect("errors/unauthorized.xhtml");
        }

        initEntities();
    }

    public List<ProjectStatusEntity> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<ProjectStatusEntity> statusList) {
        this.statusList = statusList;
    }
    //endregion
}
