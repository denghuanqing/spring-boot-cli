package com.poppy.admin.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 启动流程实例
 */
public class ActivitiStartInstance {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 创建流程实例  需要流程定义的key
        ProcessInstance holiday = runtimeService.startProcessInstanceByKey("holiday");

        System.out.println(holiday.getDeploymentId());
        System.out.println(holiday.getProcessInstanceId());
    }
}
