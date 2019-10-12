package com.diboot.shiro.authz.storage;

import com.diboot.core.util.V;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 权限入库
 * @author : wee
 * @version : v1.0
 * @Date 2019-08-28  10:44
 */
@Setter
@Getter
public class StorageListener implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorizationStorage authorizationStorage;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (V.isEmpty(event.getApplicationContext().getParent())) {
            authorizationStorage.autoStorage(event.getApplicationContext());
        }
    }
}
