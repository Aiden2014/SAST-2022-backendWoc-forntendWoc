<<<<<<< HEAD
# SAST-2022-backendWoc
SAST 2022 寒假大作战前端+后端 demo

完成情况：

前端部分差数据统一接入完成，后端部分已完成（写的一拖四）。迟点再更新前端的

文件结构：
```
├─.idea                                   idea的文件夹，不用管
│  └─libraries                            
├─src           						
│  ├─main                                 main目录为主要编写代码的区域
│  │  ├─java                              用于存放代码
│  │  │  └─com
│  │  │      └─sast
│  │  │          └─woc
│  │  │              ├─config             存放设置
│  │  │              ├─controller         controller层
│  │  │              ├─entity             存放基础的实体类
│  │  │              ├─exception          管理token抛出的异常
│  │  │              ├─filter             过滤器
│  │  │              ├─interceptor        拦截器
│  │  │              ├─mapper             mapper层（也叫dao层）
│  │  │              ├─service            service层
│  │  │              └─util               创建和验证token
│  │  └─resources                         用于存放资源文件、配置文件等
│  │      ├─mapper                        存放mapper映射文件
│  │      ├─static                        存放js,css,image文件
│  │      └─templates
│  └─test                                 测试专用文件夹
│      └─java          
│          └─com
│              └─example
│                  └─demo
└─target                                  项目编译后生成的target文件夹
    ├─classes
    │  ├─com
    │  │  └─example
    │  │      └─demo
    │  │          ├─controller
    │  │          ├─mapper
    │  │          └─service
    │  └─mapper
    ├─generated-sources
    │  └─annotations
    ├─generated-test-sources
    │  └─test-annotations
    └─test-classes
        └─com
            └─example
                └─demo

```

数据库：
```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱（可选）',
  `role` tinyint NOT NULL COMMENT '用户角色 -1 游客 0 普通用户 1 管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;
```
=======
# SAST-2022-backendWoc
SAST 2022 寒假大作战前端+后端 demo

完成情况：

前端部分差数据统一接入完成，后端部分已完成（写的一拖四）。迟点再更新前端的

文件结构：
```
├─.idea                                   idea的文件夹，不用管
│  └─libraries                            
├─src           						
│  ├─main                                 main目录为主要编写代码的区域
│  │  ├─java                              用于存放代码
│  │  │  └─com
│  │  │      └─example
│  │  │          └─demo
│  │  │              ├─controller         controller层
│  │  │              ├─entity             存放基础的实体类
│  │  │              ├─mapper             mapper层（也叫dao层）
│  │  │              └─service            service层
│  │  └─resources                         用于存放资源文件、配置文件等
│  │      ├─mapper                        存放mapper映射文件
│  │      ├─static                        存放js,css,image文件
│  │      └─templates
│  └─test                                 测试专用文件夹
│      └─java          
│          └─com
│              └─example
│                  └─demo
└─target                                  项目编译后生成的target文件夹
    ├─classes
    │  ├─com
    │  │  └─example
    │  │      └─demo
    │  │          ├─controller
    │  │          ├─mapper
    │  │          └─service
    │  └─mapper
    ├─generated-sources
    │  └─annotations
    ├─generated-test-sources
    │  └─test-annotations
    └─test-classes
        └─com
            └─example
                └─demo

```

数据库：
```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱（可选）',
  `role` tinyint NOT NULL COMMENT '用户角色 -1 游客 0 普通用户 1 管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;
```
>>>>>>> ba1a4941081762c444b9c645cc86466562582114
