
lzb@ruijie.com.cn
ruijie_zhjs

appID
wxb2c8767dd7ed63a8
appsecret
55788866f78c132c99d447f257ef9b7d

获取access_token
https请求方式: GET
https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxb2c8767dd7ed63a8&secret=55788866f78c132c99d447f257ef9b7d
{"access_token":"19_CwhzSdhzef8D8lWs3LNm1F5SNl5AAUV4gRKmLOPBd3Z6qArdQt9eZK47LkPgx_EaXvfzdsv4nwMnwcFOtRCtB8OgY0n-mvNftXUdpoR-QSoOoVShY_8JTM--ERKh6cvsunvmesFYFBWO4WlxSGZaAHAJXQ","expires_in":7200}

https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxb0f1796198a51edd&secret=4bdcb1beec6fbf295e5771df72e7a090
{
    "access_token": "19_WxKuk1DhPBcdIrcxMLdESwN0jexLv4Jw1zzPAT9F9_B4B2lmAJK0zd0fzE-CyJipO-PoBktoaoS-1ptEyGLsmm9xRugukl6mQne58tYEIqctiKP9O_z0u3RC0nvfDQaoB1JATxGoAoMnkdsNTQCdAEAJGS",
    "expires_in": 7200
}

自定义菜单创建接口
https://api.weixin.qq.com/cgi-bin/menu/create?access_token=19_WxKuk1DhPBcdIrcxMLdESwN0jexLv4Jw1zzPAT9F9_B4B2lmAJK0zd0fzE-CyJipO-PoBktoaoS-1ptEyGLsmm9xRugukl6mQne58tYEIqctiKP9O_z0u3RC0nvfDQaoB1JATxGoAoMnkdsNTQCdAEAJGS
{
     "button":[
     {    
          "type":"view",
          "name":"教学",
          "url":"http://scuclass.ruijie.com.cn/analysis/#/"http://1e484531y2.imwork.net
      },     
      {    
          "type":"view",
          "name":"登陆",
          "url":"http://47.112.17.218/icmgr/rest/page/login"
      },
      {
           "name":"菜单",
           "sub_button":[
           {    
               "type":"view",
               "name":"搜索",
               "url":"http://www.soso.com/"
            },
            {
                 "type":"miniprogram",
                 "name":"小程序",
                 "url":"http://mp.weixin.qq.com",
                 "appid":"wx286b93c14bbf93aa",
                 "pagepath":"pages/lunar/index"
             },
            {
          "type":"view",
          "name":"教学分析",
          "url":"http://1e484531y2.imwork.net/main"
            }]
       }]
 }




 https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxb0f1796198a51edd&secret=55788866f78c132c99d447f257ef9b7d
{"access_token":"19_CwhzSdhzef8D8lWs3LNm1F5SNl5AAUV4gRKmLOPBd3Z6qArdQt9eZK47LkPgx_EaXvfzdsv4nwMnwcFOtRCtB8OgY0n-mvNftXUdpoR-QSoOoVShY_8JTM--ERKh6cvsunvmesFYFBWO4WlxSGZaAHAJXQ","expires_in":7200}

自定义菜单创建接口
https://api.weixin.qq.com/cgi-bin/menu/create?access_token=19_CwhzSdhzef8D8lWs3LNm1F5SNl5AAUV4gRKmLOPBd3Z6qArdQt9eZK47LkPgx_EaXvfzdsv4nwMnwcFOtRCtB8OgY0n-mvNftXUdpoR-QSoOoVShY_8JTM--ERKh6cvsunvmesFYFBWO4WlxSGZaAHAJXQ
{
     "button":[
     {    
          "type":"view",
          "name":"教学分析",
          "url":"http://scuclass.ruijie.com.cn/analysis/#/"
      },     
      {    
          "type":"view",
          "name":"登陆",
          "url":"http://47.112.17.218/icmgr/rest/page/login"
      },
      {
           "name":"菜单",
           "sub_button":[
           {    
               "type":"view",
               "name":"搜索",
               "url":"http://www.soso.com/"
            },
            {
                 "type":"miniprogram",
                 "name":"小程序",
                 "url":"http://mp.weixin.qq.com",
                 "appid":"wx286b93c14bbf93aa",
                 "pagepath":"pages/lunar/index"
             },
            {
               "type":"click",
               "name":"赞一下我们",
               "key":"V1001_GOOD"
            }]
       }]
 }
 
 如果开发者有在多个公众号，或在公众号、移动应用之间统一用户帐号的需求，需要前往微信开放平台（open.weixin.qq.com）绑定公众号后，才可利用UnionID机制来满足上述需求。