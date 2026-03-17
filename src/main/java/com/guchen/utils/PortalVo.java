package com.guchen.utils;

import lombok.Data;

@Data
public class PortalVo {
    private Integer pageNum = 3;
    private Integer pageSize = 50;
    private Integer totalSize = 100;
    private String dimValue = "";
}
