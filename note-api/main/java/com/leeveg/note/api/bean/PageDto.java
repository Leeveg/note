package com.leeveg.note.api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author liz
 * @date 2020-10-26 14:59
 */
@Data
@ToString
@AllArgsConstructor
public class PageDto<T> {

    private long pageCurrent;

    private long pageSize;

    private long total;

    private long pages;

    private List<T> data;

    public PageDto() {

    }

    public PageDto(long pageCurrent, long pageSize) {
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
    }

    public PageDto(long pageCurrent, long pageSize, long total, long pages) {
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
    }
}
