package montp.web.converters;

import montp.data.dao.ProjectDAO;
import montp.data.entity.ProjectEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ProjectEntity.class)
public class ProjectConverter extends GenericConverter<ProjectEntity>{

    public ProjectConverter() {
        super(Tools.lookupBean(ProjectDAO.class));
    }
    
}
