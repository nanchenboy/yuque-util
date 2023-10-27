package client;

import com.yuque.sdk.YuQueApplication;
import com.yuque.sdk.client.YuQueClient;
import com.yuque.sdk.exception.YuqueException;
import com.yuque.sdk.domain.ReposData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author nanchen
 * @Date 2023/10/26 9:51
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = YuQueApplication.class)
public class YuQueClientTest {
    
    @Autowired
    YuQueClient yuQueClient;

    //获取协作知识库信息
    @Test
    public void testListCollaborateBooks() throws YuqueException {
        List<ReposData> reposData = yuQueClient.listCollaborateBooks();
        System.out.println();
    }

    //获取协作知识库信息
    @Test
    public void testListMyBooks() throws YuqueException {
        List<ReposData> reposData = yuQueClient.listMyBooks();
        System.out.println();
    }
}
