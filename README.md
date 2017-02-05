# Spring boot RESTful API 
## 概要
Spring bootでRESTful APIを作りました。
ユーザーは持っている商品のデータを`登録`・`検索`・`変更`・`削除`する。
後で商品の情報について詳しく説明します。

## 開発環境

* Java 1.8.0_40
* Eclipse Neon.2 Release (4.6.2)
* Spring boot 1.4.4
* Mysql  

## API仕様書
## ユーザのエンドポイント [/v1/products]

### 商品登録 [POST]　`products/`

#### 処理概要
 
* 商品情報を新しく登録する。
 
+ Request (application/json)
 
    + Headers
 
            Accept: application/json
 
    + Attributes
        + productName: Comic Book (string, required) 
        + productDescription: A superman story (string, required)
        + productProice: 3000 (double, required)
        + productImageURL: https://goo.gl/images/LJZXsG (string) 
        
+ Response

	+ Error : 400 Bad Request(JSON入力しなかった)
	+ Successed : 201 Created
	
	    {
            "updatedTime": "2017-02-05",  
            "createdTime": "2017-02-05",
            "id": 1,
            "productName": "Comic Book",
            "productDescription": "A superman story",
            "productImageURL": "https://goo.gl/images/LJZXsG",
            "productPrice": 3000,
            "deleteFlag": 0,
              "_links": {
                "self": {
                    "href": "http://localhost:8080/products/8"
                },
                "product": {
                    "href": "http://localhost:8080/products/8"
                }
              }

        }

     }
 	

### 商品検索 [GET]　`products/`

#### 処理概要

+ 商品を検索する
  + `products/`　 
    + 全て登録した商品を検索する（削除した商品もう見える）。
  + `products/all`
    + 全て商品を検索する（削除した商品を見えない）。
  + `products/{id}`
    + 商品idで検索する。
  + `products/createdTime/{from}/{to}`
    + 商品の作成時間で検索する。
  + `products/deletedTime/{from}/{to}`
    + 商品の削除時間で検索する。
 
+ Response (application/json)        

    [
      {
        "updatedTime": "2017-02-04",
        "createdTime": "2017-02-03",
        "id": 1,
        "productName": "ui",
        "productDescription": "marvel",
        "productImageURL": "www",
        "productPrice": 200,
        "deleteFlag": 0
      },
      {
        ...
      }
    ]	

### 商品削除 [DELETE]　`products/{id}`

#### 処理概要
+  商品を削除する
    * `products/{id}`
      + DB中で削除する。
    * `products/delete/{id}`
      + 商品を削除する、DBでデータが残ります。	
+ Response
Error
商品を存在していない
{
  "timestamp": 1486297334847,
  "status": 405,
  "error": "Method Not Allowed",
  "exception": "org.springframework.web.HttpRequestMethodNotSupportedException",
  "message": "Request method 'DELETE' not supported",
  "path": "/products/delete/1"
}
