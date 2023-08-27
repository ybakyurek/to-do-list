package com.ybakyurek.assist;

public class PostmanPersist {
    //Project URL: http://localhost:4444
    //Swagger URL: http://localhost:4444/h2-console/
    //h2Db    URL: http://localhost:4444/swagger-ui/index.html

    //POSTMAN
    //CREATE
    /*
    POST /category/api/v1/create HTTP/1.1
    Host: localhost:4444
    Content-Type: application/json
    Content-Length: 36
    {
    "categoryName": "bilgisayar"
    }
    **/

    //LIST
    /*
    GET /category/api/v1/list HTTP/1.1
    Host: localhost:4444
    * */


    //FIND
    /*
    GET /category/api/v1/find/1 HTTP/1.1
    Host: localhost:4444
    * */

    //UPDATE
    /*
    PUT /category/api/v1/update/1 HTTP/1.1
    Host: localhost:4444
    Accept-Language: tr
    Content-Type: application/json
    Content-Length: 36

    {
        "categoryName": "FlameRank2"
    }
    **/


    //DELETE
    /*
    DELETE /category/api/v1/delete/1 HTTP/1.1
    Host: localhost:4444
    **/
}
