
import com.james.controller.SystemController;
import com.james.model.UserModel;
import com.james.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eronzen on 11/30/2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class SysControllerTest {

    @Mock
    private UserService userService;

    @Test
    public void test(){
        SystemController controller = new SystemController();
        List<UserModel> users = new ArrayList<UserModel>();
        UserModel userModel1 = new UserModel();
        userModel1.setUsername("james1");
        UserModel userMode2 = new UserModel();
        userMode2.setUsername("james2");
        users.add(userModel1);
        users.add(userMode2);
        when(userService.getUsers()).thenReturn(users);
        controller.setUserService(userService);

        List<UserModel> list = controller.test();

        Assert.assertNotNull(list);
        Assert.assertEquals(true, list.size() == users.size());

    }

}
