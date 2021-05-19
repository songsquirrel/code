import com.walker.powerdetail.PowerDetailApplication;
import com.walker.powerdetail.service.InitDataBaseSrv;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author song
 * @date 2021/5/16
 * @description ceshi
 */
@SpringBootTest(classes = PowerDetailApplication.class)
public class test {
    @Resource
    private InitDataBaseSrv initDataBaseSrv;

    @Test
    void test(){
        initDataBaseSrv.recoveryDataBase();
    }

}
