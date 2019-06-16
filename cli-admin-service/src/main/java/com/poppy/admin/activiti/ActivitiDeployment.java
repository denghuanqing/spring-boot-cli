package com.poppy.admin.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

public class ActivitiDeployment {
    /**
     * ACT_RE_DEPLOYMENT 部署信息
     * ACT_RE_PROCDEF   流程定义的信息
     * ACT_GE_BYTEARRAY  流程中的二进制文件（bpmn,png）
     *
     * @param args
     */
    public static void main(String[] args) {
        // 把bpmn流程部署到数据库
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();

        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("bpmn/apply.bpmn")
                .addClasspathResource("bpmn/apply.png")
                .name("请假申请流程")
                .deploy();

        System.out.println(deployment);
    }
}
