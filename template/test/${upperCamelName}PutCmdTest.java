package ${config.java.package.cmd}.${table.prefix};

import ${config.java.package.cmd}.CmdSign;
import ${config.java.package.code}.CmdCode;
import ${config.java.package.vo}.${table.prefix}.${table.upperCamelName}VO;
import ${config.java.package.test}.ACmdTest;
import ${config.java.package.service}.${table.prefix}.service.I${table.upperCamelName}Service;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.mockito.Mock;


public class ${table.upperCamelName}PutCmdTest extends ACmdTest {

    @InjectMocks
    private ${table.upperCamelName}PutCmd ${table.lowerCamelName}PutCmd;

    @Mock
    private I${table.upperCamelName}Service ${table.lowerCamelName}Service;

    @BeforeClass
    public void setUp() throws Exception {
        //初始化测试用例类中由Mockito的注解标注的所有模拟对象
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void resetScheduler() {
        Mockito.reset(this.scheduler);
    }

    @Test
    public void testExecuteServer() throws Exception {
        CmdSign sign = CmdSign.Builder.newBuild(null)
                .setCmdCode(SysConstants.CMD_SERVER_SCOPE, CmdCode.${table.upperTableName}_PUT)
                .build();
        this.${table.lowerCamelName}PutCmd.executeServer(null, sign);
    }

    @Test
    public void testExecute() throws Exception {
        CmdSign sign = CmdSign.Builder.newBuild(null)
                .setCmdCode(CmdCode.${table.upperTableName}_PUT)
                .build();
        this.${table.lowerCamelName}PutCmd.execute(null, sign);
    }

    @Test
    public void testExecuteMop() throws Exception {
        CmdSign sign = CmdSign.Builder.newBuild(null)
                .setCmdCode(SysConstants.CMD_MOP_SCOPE, CmdCode.${table.upperTableName}_PUT)
                .build();
        this.${table.lowerCamelName}PutCmd.executeMop(null, sign);
    }


@Override
protected void testParameters() throws Exception {

        }

@Override
protected void testBoundaryValue() throws Exception {

        }
}
