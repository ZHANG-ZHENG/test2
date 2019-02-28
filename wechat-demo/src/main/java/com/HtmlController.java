package com;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.robot.HttpUtils;


@Controller
public class HtmlController {  
   
//	private String redirectUri="http://{0}/api/edu/weChat/wechatUser/getOpenId";
//	private String redirectUriAlarm="http://{0}/api/edu/weChat/tWechatUserAlarm/getOpenId";
//	private String eduWechatIndex="http://{0}/wechat/index.html";
//	private String eduWechatLogin="http://{0}/wechat/login.html";
//	private String oauthURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope={2}&state=123#wechat_redirect";
//	private String authAccesstokenURL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code";
	
	@GetMapping("/main")
	ModelAndView test(HttpServletRequest request) throws UnsupportedEncodingException {
		//逻辑处理
		
		
        //获取openid和access_token的连接
//		String  GetCodeRequest = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
//        String result = null;
//        GetCodeRequest  = GetCodeRequest.replace("APPID", urlEnodeUTF8("wxb2c8767dd7ed63a8"));
//        GetCodeRequest  = GetCodeRequest.replace("REDIRECT_URI",urlEnodeUTF8("55788866f78c132c99d447f257ef9b7d"));
//        //GetCodeRequest = GetCodeRequest.replace("SCOPE", Constants.SCOPE);
//        result = GetCodeRequest;
//        System.out.println("result "+result);
		//String serverName = request.getServerName();
		String redirectUri="http://1e484531y2.imwork.net/index";
		String redirecturiEncode = URLEncoder.encode(redirectUri, "UTF-8");
		String oauthURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope={2}&state=123#wechat_redirect";
		String url = MessageFormat.format(oauthURL, "wxb2c8767dd7ed63a8", redirecturiEncode, "snsapi_userinfo");//snsapi_base
		System.out.println("跳转到微信"+url);
		return new ModelAndView("redirect:"+url);
		
//		return "index";
	}  
	@GetMapping("/index")
	String index(HttpServletRequest request,String code) {
		try{
			System.out.println("index ");
			
			String authAccesstokenURL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code";
			String url = MessageFormat.format(authAccesstokenURL, "wxb2c8767dd7ed63a8", "55788866f78c132c99d447f257ef9b7d", code);
			String result = HttpUtils.sendGet(url);
			request.setAttribute("key", result);	
			
			return "index";			
		}catch(Exception e){
			
		}
		return "index";	
	}
    public static String urlEnodeUTF8(String str){
        String result = str;
        try {
            result = URLEncoder.encode(str,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
