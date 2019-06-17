package com.poppy.admin.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 流程实例的生命周期演示
 */
public class ActivitiStartInstance {
    public static void main(String[] args) {
//        startProcess();
//        taskList();

    }

    /**
     * 02查询当前用户的任务列表
     */
    private static void taskList() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        //查询任务列表
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("小王")
                .list();

        list.forEach(m -> {
            System.out.println("流程实例ID" + m.getProcessInstanceId());
            System.out.println("任务ID" + m.getId());
            System.out.println("任务负责人名称" + m.getAssignee());
            System.out.println("任务名称" + m.getName());
        });
    }

    /**
     * 01开始启动一个流程实例
     */
    private static void startProcess() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 创建流程实例  需要流程定义的key
        ProcessInstance holiday = runtimeService.startProcessInstanceByKey("holiday");

        System.out.println(holiday.getDeploymentId());
        System.out.println(holiday.getProcessInstanceId());
    }


}