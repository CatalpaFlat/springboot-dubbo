package cn.catalpaflat.dubbo.consumer;

import cn.catalpaflat.dubbo.provider.service.ProviderService;
import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Reference
    private ProviderService providerService;

    @PostConstruct
    public void init() {
        log.info("studentService:" + providerService);
    }

    @GetMapping("admin")
    public HttpEntity<Object> obtainAdmin() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        String admin = providerService.obtainAdmin();
        log.info("admin:{}", admin);
        JSONObject response = new JSONObject();
        response.put("result", StringUtils.isEmpty(admin) ? "is empty" : admin);
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }
}
