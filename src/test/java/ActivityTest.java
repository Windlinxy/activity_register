import com.bluemsun.entity.Activity;
import com.bluemsun.service.ActivityService;
import com.bluemsun.service.impl.ActivityServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: activity_register
 * @description:
 * @author: Windlinxy
 * @create: 2021-12-07 16:05
 **/
public class ActivityTest {
    @Test
    public void mapperTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
        ActivityService activityService = context.getBean("activityService",ActivityServiceImpl.class);
        activityService.addActivity(new Activity("2020012971","2021.12.06","madaima","4小时54分","参与方式","主办方","证明人",0));
        System.out.println(activityService.queryActivitiesByUsername("2020012971"));
        //activityService.changeActivity(new Activity(1,"2020012971","2021.12.06","madaima","4小时54分","参与方式","主办方","证明人",1));
        //activityService.deleteActivityById(1);
    }
}
