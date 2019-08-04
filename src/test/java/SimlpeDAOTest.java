import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.spring.AppConfig;
import ru.geekbrains.spring.DAO.SimpleDAO;
import ru.geekbrains.spring.Model.Simple;


public class SimlpeDAOTest {
    @Test
    public void DAOTest(){
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final SimpleDAO simpleDAO = context.getBean(SimpleDAO.class);
        simpleDAO.removeAll();
        Assert.assertTrue(simpleDAO.findAll().isEmpty());
        final Simple simple=new Simple();
        simpleDAO.persist(simple);
        Assert.assertFalse(simpleDAO.findAll().isEmpty());
        Assert.assertEquals(simpleDAO.findAll().size(),1);
        Assert.assertEquals(simple,simpleDAO.find(simple.getId()));
        simpleDAO.remove(simple.getId());
        Assert.assertNull(simpleDAO.find(simple.getId()));
        simpleDAO.removeAll();
        simpleDAO.merge(new Simple());
        simpleDAO.merge(new Simple());
        simpleDAO.merge(new Simple());
        simpleDAO.merge(new Simple());
        simpleDAO.merge(new Simple());
        Assert.assertEquals(simpleDAO.findAll().size(),5);
        simpleDAO.removeAll();
        Assert.assertTrue(simpleDAO.findAll().isEmpty());
    }
}
