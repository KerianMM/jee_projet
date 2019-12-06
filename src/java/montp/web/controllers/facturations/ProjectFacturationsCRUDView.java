package montp.web.controllers.facturations;

import montp.data.entity.*;
import montp.data.entity.security.UserEntity;
import montp.services.*;
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
    @Inject private FacturationStatusService facturationStatusService;
    @Inject private PayementModeService payementModeService;
    @Inject private UserEntity user;

    private ProjectEntity project;
    private Integer projectId;
    private List<FacturationStatusEntity> statusList;
    private List<PayementModeEntity> payementModeList;

    @Override
    public void create() {
        entity = new FacturationEntity();
        entity.setProject(project);
    }

    @Override
    public void init() {
        statusList = facturationStatusService.getAll();
        payementModeList = payementModeService.getAll();
        create();
    }

    @Override
    public void save() {
        super.save();
        initEntities();
    }

    private void initEntities() {
        entities = project.getFacturations();
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

    public List<FacturationStatusEntity> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<FacturationStatusEntity> statusList) {
        this.statusList = statusList;
    }

    public List<PayementModeEntity> getPayementModeList() {
        return payementModeList;
    }

    public void setPayementModeList(List<PayementModeEntity> payementModeList) {
        this.payementModeList = payementModeList;
    }
//endregion
}
