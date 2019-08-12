package cn.catalpaflat.dubbo.provider.idal;

import cn.catalpaflat.dubbo.provider.service.ProviderService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CatalpaFlat
 * @date Created in 2019/8/12 9:03 AM
 */
@RestController
@RequestMapping("provider")
public class ProviderIdal {

    @Reference
    private ProviderService providerService;


}
