package cn.catalpaflat.dubbo.provider.service.impl;

import cn.catalpaflat.dubbo.provider.service.ProviderService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author CatalpaFlat
 * @date Created in 2019/8/12 9:02 AM
 */
@Service
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String obtainAdmin() {
        return "CatalpaFlat";
    }
}
