package ${config.java.package.cmd}.${table.prefix};

import ${config.java.package.core.cmd}.CmdSign;
import ${config.java.package.core.code}.CmdCode;
import ${config.java.package.bo}.${table.prefix}.${table.upperCamelName}BO;
import ${config.java.package}.${table.prefix}.service.I${table.upperCamelName}Service;
import ${config.java.package.core.cmd}.ACmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ${table.upperCamelName}DelCmd extends ACmd {

    @Override
    public CmdSign execute(HttpServletRequest request, CmdSign sign) throws Exception {
        CmdSign respSign = new CmdSign(sign);
        ${table.upperCamelName}BO ${table.lowerCamelName}BO = super.getData(sign, ${table.upperCamelName}BO.class);
        this.${table.lowerCamelName}Service.delete(${table.lowerCamelName}BO);
        return respSign;
    }

    @Override
    public String getCmdCode() {
        return CmdCode.${table.upperTableName}_DEL;
    }

    @Autowired
    private I${table.upperCamelName}Service ${table.lowerCamelName}Service;
}
