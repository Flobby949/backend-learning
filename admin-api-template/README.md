# 后台管理系统 API 模板项目搭建
> 环境说明
> - JDK 17
> - Maven 3.9.0
> - IDEA 2023.1 (Ultimate Edition）
> - MySQL 8

## 插件化多模块 API 模版项目
主要包括：
1. api-base：基础核心模块
2. api-admin-core: 后台管理系统核心功能模块
3. api-admin-biz：后台管理系统业务功能模块
4. api-plugin: 扩展插件模块（如文件存储、短信发送、邮件服务、定时任务等）
5. api-app-core: 客户端接口核心功能模块
6. api-app-biz: 客户端接口业务功能模块
7. api-server：服务启动模块