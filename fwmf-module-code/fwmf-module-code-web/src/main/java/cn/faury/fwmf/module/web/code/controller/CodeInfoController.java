package cn.faury.fwmf.module.web.code.controller;

import cn.faury.fwmf.module.api.code.service.CodeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
@ConditionalOnClass({RestController.class,RequestMapping.class})
public class CodeInfoController {

    @Autowired(required = false)
    private CodeInfoService codeInfoService;

}
