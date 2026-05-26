package com.iwangjunhui.workflow.model;

import lombok.Data;

@Data
public class WorkflowStep {

    /**
     * 动作类型
     */
    private String action;

    /**
     * 页面元素 selector
     */
    private String selector;

    /**
     * 输入值
     */
    private String value;

    /**
     * 页面 URL
     */
    private String url;

    /**
     * 等待时间
     */
    private Long timeout;

    /**
     * 断言文本
     */
    private String expected;
}
