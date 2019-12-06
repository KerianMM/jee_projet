package montp.services;

import montp.data.dao.ProjectDAO;
import montp.data.entity.ClientEntity;
import montp.data.entity.ProjectEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProjectService extends GenericService<ProjectEntity, ProjectDAO> {
    public List<ProjectEntity> getByClient(ClientEntity client) {
        return dao.findByClient(client);
    }

    @Override
    public void insert(ProjectEntity instance) {
        super.insert(instance);
        instance.getClient().getProjects().add(instance);
    }

    @Override
    public boolean canDelete(ProjectEntity instance) {
        return super.canDelete(instance) && instance.getFacturations().isEmpty();
    }
}
