package com.itauge.sport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryInfo {
    private String query;//查詢信息username
    private int pageNum = 1;//當前頁
    private int pageSize = 1;//每頁最大數
}
