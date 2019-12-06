package montp.web.controllers.facturations;

import montp.data.entity.FacturationEntity;
import montp.data.entity.PayementModeEntity;
import montp.data.entity.ProjectEntity;
import montp.data.entity.ProjectStatusEntity;
import montp.data.entity.security.UserEntity;
import montp.services.FacturationService;
import montp.services.PayementModeService;
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
public class ProjectFacturationsCRUDView extends CRUDController<FacturationEntity, FacturationService> {
    @Inject private ProjectService projectService;
    @Inject private ProjectStatusService projectStatusService;
    @Inject private PayementModeService payementModeService;
    @Inject private UserEntity user;

    private ProjectEntity project;
    private Integer projectId;
    private List<ProjectStatusEntity> statusList;
    private List<PayementModeEntity> payementModesList;

    @Override
    public void create() {
        entity = new FacturationEntity();
        entity.setProject(project);
    }

    @Override
    public void init() {
        statusList = projectStatusService.getAll();
        payementModesList = payementModeService.getAll();
        create();
    }

    @Override
    public void save() {
        super.save();
        initEntities();
    }

    private void initEntities() {
        entities = service.getByProject(project);
    }

    //region GETTERS / SETTERS
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
        project = projectService.get(projectId);

        if (!user.getPerson().equals(project.getClient().getPerson())) {
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

    public List<PayementModeEntity> getPayementModesList() {
        return payementModesList;
    }

    public void setPayementModesList(List<PayementModeEntity> payementModesList) {
        this.payementModesList = payementModesList;
    }
//endregion
}
