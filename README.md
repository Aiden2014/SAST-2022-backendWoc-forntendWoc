<<<<<<< HEAD
# SAST-2022-backendWoc
SAST 2022 寒假大作战前端+后端 demo

启动：从SAST-2022-backendWoc-forntendWoc\src\main\resources\login.html启动

后面有接口文档

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
# 全局

## POST 登录

POST /user/login

> Body 请求参数

```yaml
userName: xun
password: "123"

```

### 请求参数

| 名称       | 位置 | 类型   | 必选 | 说明 |
| ---------- | ---- | ------ | ---- | ---- |
| body       | body | object | 否   | none |
| » userName | body | string | 是   | none |
| » password | body | string | 是   | none |

> 返回示例

> 成功

```json
{
    "status": 200,
    "message": "操作成功",
    "data": {
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoxLCJpZCI6MTksInVzZXJOYW1lIjoiOCIsImVtYWlsIjoiMSJ9.SFuzoVjjvGmb9aZajTHomogNzfGHP_bGuboN0bGNfb8"
    },
    "timestamp": 1677412617633
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明             | 数据模型 |
| ------ | ------------------------------------------------------- | ---------------- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功             | Inline   |
| 401    | Unauthorized                                            | 用户名或密码错误 | Inline   |

### 返回数据结构

状态码 **200**

| 名称        | 类型    | 必选 | 约束 | 中文名 | 说明 |
| ----------- | ------- | ---- | ---- | ------ | ---- |
| » status    | integer | true | none |        | non  |
| » message   | string  | true | none |        | none |
| » data      | object  | true | none |        | none |
| »» role     | integer | true | none |        | none |
| »» id       | integer | true | none |        | none |
| »» userName | string  | true | none |        | none |
| »» password | string  | true | none |        | none |
| »» email    | string  | true | none |        | none |
| »» token    | string  | true | none |        | none |
| » timestamp | integer | true | none |        | none |

# 管理员

## POST 删除用户

POST /admin/del_user

根据用户名删除用户

> Body 请求参数

```yaml
userName: xun

```

### 请求参数

| 名称       | 位置   | 类型   | 必选 | 说明 |
| ---------- | ------ | ------ | ---- | ---- |
| token      | header | string | 是   | none |
| body       | body   | object | 否   | none |
| » userName | body   | string | 是   | none |

> 返回示例

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |

### 返回数据结构

状态码 **200**

| 名称        | 类型    | 必选 | 约束 | 中文名 | 说明 |
| ----------- | ------- | ---- | ---- | ------ | ---- |
| » status    | integer | true | none |        | none |
| » message   | string  | true | none |        | none |
| » data      | string  | true | none |        | none |
| » timestamp | integer | true | none |        | none |

## GET 查询用户信息

GET /admin/find_user_info

### 请求参数

| 名称     | 位置   | 类型   | 必选 | 说明 |
| -------- | ------ | ------ | ---- | ---- |
| userName | query  | string | 是   | none |
| token    | header | string | 是   | none |

> 返回示例

> 成功

```json
{
    "status": 200,
    "message": "操作成功",
    "data": {
        "id": 19,
        "userName": "Aiden",
        "password": "666",
        "email": "xxx@gmail.com",
        "role": 1
    },
    "timestamp": 1677413405871
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |

### 返回数据结构

状态码 **200**

| 名称        | 类型    | 必选 | 约束 | 中文名 | 说明 |
| ----------- | ------- | ---- | ---- | ------ | ---- |
| » status    | integer | true | none |        | none |
| » message   | string  | true | none |        | none |
| » data      | string  | true | none |        | none |
| »» id       | integer | true | none |        | none |
| »» userName | string  | true | none |        | none |
| »» password | string  | true | none |        | none |
| »» email    | string  | true | none |        | none |
| »» role     | integer | true | none |        | none |
| » timestamp | integer | true | none |        | none |



## POST 注册

POST /user/register

> Body 请求参数

```yaml
userName: xun
password: "123"
email: xxx@gmail.com

```

### 请求参数

| 名称       | 位置   | 类型   | 必选 | 说明 |
| ---------- | ------ | ------ | ---- | ---- |
| token      | header | string | 是   | none |
| body       | body   | object | 否   | none |
| » userName | body   | string | 是   | none |
| » password | body   | string | 是   | none |
| » email    | body   | string | 是   | none |

> 返回示例

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |

### 返回数据结构

状态码 **200**

| 名称        | 类型    | 必选 | 约束 | 中文名 | 说明 |
| ----------- | ------- | ---- | ---- | ------ | ---- |
| » status    | integer | true | none |        | none |
| » message   | string  | true | none |        | none |
| » data      | string  | true | none |        | none |
| » timestamp | integer | true | none |        | none |



## POST 修改个人信息

POST /admin/change

> Body 请求参数

```yaml
userName: string
password: string
email: string

```

### 请求参数

| 名称       | 位置   | 类型   | 必选 | 说明 |
| ---------- | ------ | ------ | ---- | ---- |
| token      | header | string | 是   | none |
| body       | body   | object | 否   | none |
| » userName | body   | string | 是   | none |
| » password | body   | string | 是   | none |
| » email    | body   | string | 是   | none |

> 返回示例

> 成功

```json
{
  "success": true,
  "errCode": null,
  "errMsg": null,
  "data": "success"
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |

### 返回数据结构

状态码 **200**

| 名称        | 类型    | 必选 | 约束 | 中文名 | 说明 |
| ----------- | ------- | ---- | ---- | ------ | ---- |
| » status    | integer | true | none |        | none |
| » message   | string  | true | none |        | none |
| » data      | string  | true | none |        | none |
| » timestamp | integer | true | none |        | none |



# 普通用户

## GET 查看个人信息

GET /user/info

查看用户本人信息

### 请求参数

| 名称  | 位置   | 类型   | 必选 | 说明 |
| ----- | ------ | ------ | ---- | ---- |
| token | header | string | 是   | none |

> 返回示例

> 成功

```json
{
    "status": 200,
    "message": "操作成功",
    "data": {
        "id": 19,
        "userName": "gg",
        "password": "888",
        "email": "xxx@gmail.com",
        "role": 1
    },
    "timestamp": 1677413405871
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |

### 返回数据结构

状态码 **200**

| 名称        | 类型    | 必选 | 约束 | 中文名 | 说明 |
| ----------- | ------- | ---- | ---- | ------ | ---- |
| » status    | integer | true | none |        | none |
| » message   | string  | true | none |        | none |
| » data      | string  | true | none |        | none |
| »» id       | integer | true | none |        | none |
| »» userName | string  | true | none |        | none |
| »» password | string  | true | none |        | none |
| »» email    | string  | true | none |        | none |
| »» role     | integer | true | none |        | none |
| » timestamp | integer | true | none |        | none |



# 数据模型

