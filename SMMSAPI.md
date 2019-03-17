# Upload API Document

## 1. 图片上传

| 功能          | 上传图片接口             |
| ------------- | ------------------------ |
| HTTP 请求方式 | POST                     |
| URL           | https://sm.ms/api/upload |

**请求参数**

| 参数名称 | 类型   | 是否必须 | 描述                                        |
| :------- | :----- | :------- | :------------------------------------------ |
| smfile   | File   | 是       | 表单名称。上传图片用到                      |
| ssl      | Bool   | 否       | 是否使用 https 输出，强制开启               |
| format   | String | 否       | 输出的格式。可选值有 json、xml。默认为 json |

**返回数据说明**

| 名称      | 类型   | 示例值                                           | 描述                                                     |
| :-------- | :----- | :----------------------------------------------- | :------------------------------------------------------- |
| code      | String | success                                          | 上传文件状态。正常情况为 `success`。出现错误时为 `error` |
| filename  | String | smms.jpg                                         | 上传文件时所用的文件名                                   |
| storename | String | 561cc4e3631b1.png                                | 上传后的文件名                                           |
| size      | Int    | 187851                                           | 文件大小                                                 |
| width     | Int    | 1157                                             | 图片的宽度                                               |
| height    | Int    | 680                                              | 图片的高度                                               |
| hash      | String | nLbCw63NheaiJp1                                  | 随机字符串，用于删除文件                                 |
| delete    | String | https://sm.ms/api/delete/nLbCw63NheaiJp1         | 删除上传的图片文件专有链接                               |
| url       | String | https://ooo.0o0.ooo/2015/10/13/561cfc3282a13.png | 图片服务器地址                                           |
| path      | String | /2015/10/13/561cfc3282a13.png                    | 图片的相对地址                                           |
| msg       | String | No files were uploaded.                          | 上传图片出错时将会出现                                   |

**错误列表**

| Access Denied.                                 |
| ---------------------------------------------- |
| Upload file count limit.                       |
| Upload file frequency limit.                   |
| Server error. Upload directory isn't writable. |
| No files were uploaded.                        |
| File is empty.                                 |
| File is too large.                             |
| File has an invalid extension.                 |
| Could not save uploaded file.                  |

**上传示例**

```
POST /api/upload HTTP/1.1
Host: sm.ms
Connection: keep-alive
Content-Length: 57398
Content-Type: multipart/form-data; boundary=----WebKitFormBoundarypAIqI1RWBfPWiOKq

------WebKitFormBoundarypAIqI1RWBfPWiOKq
Content-Disposition: form-data; name="smfile"; filename="1.png"
Content-Type: image/png


------WebKitFormBoundarypAIqI1RWBfPWiOKq
Content-Disposition: form-data; name="file_id"

0
------WebKitFormBoundarypAIqI1RWBfPWiOKq--
```

**响应示例**

```
{
"code": "success",
"data": {
    width: 1157,
    height: 680,
    filename: "image_2015-08-26_10-54-48.png",
    storename: "56249afa4e48b.png",
    size: 69525,
    path: "/2015/10/19/56249afa4e48b.png",
    hash: "nLbCw63NheaiJp1",
    timestamp: 1445239546,
    url: "https://ooo.0o0.ooo/2015/10/19/56249afa4e48b.png",
    delete: "https://sm.ms/api/delete/nLbCw63NheaiJp1"
}
}
```

**响应错误示例**

```
{
code: "error",
msg: "No files were uploaded."
}
```

## 2. 上传历史

| 功能          | 获得过去一小时内上传的文件列表 |
| ------------- | ------------------------------ |
| HTTP 请求方式 | GET                            |
| URL           | https://sm.ms/api/list         |

**请求参数**

| 参数名称 | 类型   | 是否必须 | 描述                                        |
| :------- | :----- | :------- | :------------------------------------------ |
| ssl      | Bool   | 否       | 是否使用 https 输出，默认开启。可用值 0, 1  |
| format   | String | 否       | 输出的格式。可选值有 json、xml。默认为 json |
| domain   | Int    | 否       | 图片域名。可选                              |

**请求示例**

```
GET /api/list HTTP/1.1
```

**响应示例**

```
{
code: "success",
data: [{
    width: 1157,
    height: 680,
    filename: "image_2015-08-26_10-54-48.png",
    storename: "56249afa4e48b.png",
    size: 69525,
    path: "/2015/10/19/56249afa4e48b.png",
    hash: "nLbCw63NheaiJpU",
    timestamp: 1445239546,
    url: "https://ooo.0o0.ooo/2015/10/19/56249afa4e48b.png",
    delete: "https://sm.ms/api/delete/nLbCw63NheaiJpU"
}]
}
```

## 3. 清除历史上传

| 功能          | 将历史上传的文件列表移除 |
| ------------- | ------------------------ |
| HTTP 请求方式 | GET                      |
| URL           | https://sm.ms/api/clear  |

**请求示例**

```
GET /api/clear HTTP/1.1
```

**响应示例**

```
{
code: "success",
msg: "Clear file success"
}
```