package com.wdt.ddshop.common.dto;

public class TreeNode {
    private Long id;//节点id
    private String  text;//节点标题
    private String state;//节点状态

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
