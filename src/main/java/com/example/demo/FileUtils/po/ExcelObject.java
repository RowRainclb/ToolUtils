package com.example.demo.FileUtils.po;

import java.util.List;

/**
 * Created by cuilb3 on 2017/8/30.
 */
public     class ExcelObject {
    private String id;
    private String parentId;

    public String getParentIda() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;
    private String mark;
    private String type;
    private List<ExcelObject> children;
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ExcelObject> getChildren() {
        return children;
    }

    public void setChildren(List<ExcelObject> children) {
        this.children = children;
    }
}
