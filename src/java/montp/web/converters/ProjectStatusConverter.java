package montp.web.converters;

import montp.data.dao.ProjectStatusDAO;
import montp.data.entity.ProjectStatusEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ProjectStatusEntity.class)
public class ProjectStatusConverter extends GenericConverter<ProjectStatusEntity>{

    public ProjectStatusConverter() {
        super(Tools.lookupBean(ProjectStatusDAO.class));
    }
    
}
