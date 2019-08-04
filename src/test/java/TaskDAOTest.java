import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.spring.AppConfig;
import ru.geekbrains.spring.DAO.TaskDAO;
import ru.geekbrains.spring.Model.Task;


public class TaskDAOTest {
    @Test
    public void DAOTest(){
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final TaskDAO taskDAO = context.getBean(TaskDAO.class);
        taskDAO.removeAll();
        Assert.assertTrue(taskDAO.findAll().isEmpty());
        final Task task=new Task();
        taskDAO.persist(task);
        Assert.assertFalse(taskDAO.findAll().isEmpty());
        Assert.assertEquals(task,taskDAO.find(task.getId()));
        taskDAO.remove(task.getId());
        Assert.assertNull(taskDAO.find(task.getId()));
        taskDAO.removeAll();
    }
}
