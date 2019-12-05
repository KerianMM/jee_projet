package montp.services;

import montp.data.dao.ProjectStatusDAO;
import montp.data.entity.ProjectStatusEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProjectStatusService extends GenericService<ProjectStatusEntity, ProjectStatusDAO> {}
