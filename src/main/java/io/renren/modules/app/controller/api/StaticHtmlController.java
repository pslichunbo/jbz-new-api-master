package io.renren.modules.app.controller.api;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/api/htmls")
public class StaticHtmlController {

    @ApiOperation(value="用户协议静态页面")
    @GetMapping(value="/protocols")
    public ModelAndView getProtocolHtml(){
        ModelAndView modelAndView = new ModelAndView( );
        modelAndView.setViewName("common/use-ragreement");
        return modelAndView;
    }
    @GetMapping(value="/helps")
    public ModelAndView getHelpHtml(){
        ModelAndView modelAndView = new ModelAndView( );
        modelAndView.setViewName("help");
        return modelAndView;
    }
}
