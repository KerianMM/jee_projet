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
}
