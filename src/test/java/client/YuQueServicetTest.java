package client;

import com.yuque.sdk.YuQueApplication;
import com.yuque.sdk.client.YuQueClient;
import com.yuque.sdk.domain.ReposData;
import com.yuque.sdk.exception.YuqueException;
import com.yuque.sdk.service.YuQueService;
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
public class YuQueServicetTest {
    
    @Autowired
    YuQueService yuQueService;

    //导出协作知识库文档
    @Test
    public void testExportCollaborateMd() throws YuqueException, InterruptedException {
        yuQueService.exportCollaborateMd("D:\\Desktop\\公司\\yuqueBackUp\\");
    }

    //导出我的知识库文档
    @Test
    public void testExportMyMd() throws YuqueException, InterruptedException {
        yuQueService.exportMyMd("D:\\Desktop\\公司\\yuqueBackUp\\");
    }
}
