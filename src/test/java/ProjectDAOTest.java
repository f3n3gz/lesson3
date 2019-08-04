import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.spring.AppConfig;
import ru.geekbrains.spring.DAO.ProjectDAO;
import ru.geekbrains.spring.Model.Project;

public class ProjectDAOTest {

    @Test
    public void DAOTest(){
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final ProjectDAO projectDAO = context.getBean(ProjectDAO.class);
        projectDAO.removeAll();
        Assert.assertTrue(projectDAO.findAll().isEmpty());
        final Project project=new Project();
        projectDAO.persist(project);
        Assert.assertFalse(projectDAO.findAll().isEmpty());
        Assert.assertEquals(project,projectDAO.find(project.getId()));
        projectDAO.remove(project.getId());
        Assert.assertNull(projectDAO.find(project.getId()));
        projectDAO.removeAll();
    }

}
