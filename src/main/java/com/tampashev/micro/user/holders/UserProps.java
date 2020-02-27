package com.tampashev.micro.user.holders;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProps {

    @Value("${project.user.page.size:20}")
    private int pageSize;

    public int getPageSize() {
        return pageSize;
    }
}
