package com.leeveg.note.api.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageInfo implements Serializable {
    private static final long serialVersionUID = -8412275150662179636L;
    private int pageIndex;
    private int pageSize;
}
