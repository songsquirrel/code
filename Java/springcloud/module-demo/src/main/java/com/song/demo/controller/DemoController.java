package com.hnxt.sync.data.controller;

import com.hnxt.sync.data.service.SyncService;
import com.song.common.base.entity.ReturnValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Song.X
 * Date: 2020/12/15
 * Description:
 */
@RestController
@RequestMapping("/demo")
@Api("demo Controller")
public class DemoController {

    @PostMapping("/GZ")
    @ApiOperation(value = "故障记录同步")
    public ReturnValue<GZDTO> GzData(@RequestBody @Validated GZDTO gzdto) {
        int i = syncService.GzSync(gzdto);
        return ReturnValue.successOrFailed(i > 0, gzdto);
    }

    @PostMapping("/QX")
    @ApiOperation(value = "缺陷记录同步")
    public ReturnValue<QXDTO> QxData(@RequestBody @Validated QXDTO qxdto) {
        int i = syncService.QxSync(qxdto);
        return ReturnValue.successOrFailed(i > 0, qxdto);
    }

    @PostMapping("/XS")
    @ApiOperation(value = "巡视记录同步")
    public ReturnValue<XSDTO> XsData(@RequestBody @Validated XSDTO xsdto) {
        int i = syncService.XsSync(xsdto);
        return ReturnValue.successOrFailed(i > 0, xsdto);
    }

    @PostMapping("/YH")
    @ApiOperation(value = "隐患记录同步")
    public ReturnValue<YHDTO> YhData(@RequestBody @Validated YHDTO yhdto) {
        int i = syncService.YhSync(yhdto);
        return ReturnValue.successOrFailed(i > 0, yhdto);
    }
}
