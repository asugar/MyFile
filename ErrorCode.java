package com.unisound.client;

import com.unisound.sdk.USCError;

import cn.yunzhisheng.asr.JniUscClient;


/**
 * 错误码
 * @author unisound
 * Copyright (c) 2015, unisound.com All Rights Reserved.
 */
public class ErrorCode {
	
	/**
	 * TTS ERROR type</br>
	 * 合成错误
	 */
	public static final int TTS_SYNTHESIZE_ERROR = 10;
	
	/**
	 * TTS ERROR type</br>
	 * 播放错误
	 */
	public static final int TTS_PLAYING_ERROR = 11;

	public static final int RECOGNIZER_OK = 0;
	
	public static final int FAILED_START_RECORDING = -61001;
	public static final int RECORDING_EXCEPTION = -61002;

	public static final int RECOGNITION_EXCEPTION = -62001;
	public static final int RECOGNITION_TIMEOUT = -62002;

	public static final int UPLOAD_USER_DATA_SERVER_REFUSED = -63001;
	public static final int UPLOAD_USER_DATA_NETWORK_ERROR = -63002;
	public static final int UPLOAD_USER_DATA_EMPTY = -63003;
	public static final int UPLOAD_USER_TOO_LARGE = -63007;
	public static final int UPLOAD_USER_DATA_TOO_FAST = -63009;
	public static final int UPLOAD_USER_ENCODE_ERROR = -63010;

	public static final int UPLOAD_SCENE_DATA_SERVER_REFUSED = -63011;
	public static final int UPLOAD_SCENE_DATA_NETWORK_ERROR = -63012;
	public static final int UPLOAD_SCENE_DATA_EMPTY = -63013;
	public static final int UPLOAD_SCENE_OUT_MAX_COUNT = -63014;
	public static final int UPLOAD_SCENE_TOO_LARGE = -63017;
	public static final int UPLOAD_SCENE_DATA_TOO_FAST = -63019;
	public static final int UPLOAD_SCENE_ENCODE_ERROR = -63020;
	public static final int UPLOAD_SCENE_GENERAL_ERROR = -63021;
	public static final int UPLOAD_SCENE_INVALID_KEY = -63022;
	public static final int UPLOAD_SCENE_STREAM_IO_ERR = -63023;
	public static final int UPLOAD_SCENE_UNKNOWN_ERR = -63024;
	public static final int UPLOAD_SCENE_DATA_SIZE_IS_FORBIDDEN = -63025;
	public static final int UPLOAD_SCENE_INVALID_VER = -63026;
	public static final int NLU_SERVER_ERROR = -71001;
	public static final int NLU_REQUEST_EMPTY = -71002;

	public String toMessage(int code) {

		switch (code) {
		case FAILED_START_RECORDING:						return "启动录音失败";
		case RECORDING_EXCEPTION:							return "录音异常";
		case RECOGNITION_TIMEOUT:
		//HTTP REQ ERROR
		case  JniUscClient.ASRCLIENT_NO_SERVICE_CONNECT:
		case  JniUscClient.ASRCLIENT_NO_CARRY_KEY_INFO:
		case  JniUscClient.ASRCLIENT_NO_SUPPORT_SERVICE:
		case  JniUscClient.ASRCLIENT_REQ_INFO_LOSE:
		case  JniUscClient.ASRCLIENT_NO_CARRY_SESSIONID:
		case  JniUscClient.ASRCLIENT_TOKEN_VALIDATION_ERROR:
		case  JniUscClient.ASRCLIENT_SERVER_LOAD:
		case  JniUscClient.ASRCLIENT_NO_ENCRYPTION_NO_SESSIONID:
		case  JniUscClient.ASRCLIENT_REQUESTSERVICE_NO_SESSIONID:
		case  JniUscClient.ASRCLIENT_NO_SESSIONID:
		case  JniUscClient.ASRCLIENT_SERVER_ERROR:
		case JniUscClient.ASRCLIENT_INVALID_PARAMETERS:		return "服务器通讯错误";
		case JniUscClient.ASRCLIENT_COMPRESS_PCM_ERROR:		return "数据压缩错误";

		case JniUscClient.ASRCLIENT_MAX_SPEECH_TIMEOUT:		return "说话时间超出限制";
		case RECOGNITION_EXCEPTION:							return "识别异常";
		case UPLOAD_USER_DATA_SERVER_REFUSED:				return "上传个性化数据:服务器拒绝";
		case UPLOAD_USER_DATA_NETWORK_ERROR:				return "上传个性化数据:网络连接失败";
		case UPLOAD_USER_DATA_EMPTY:						return "上传个性化数据:不能为空";
		case UPLOAD_USER_TOO_LARGE:							return "上传个性化数据:内容太多";
		case UPLOAD_USER_ENCODE_ERROR:						return "上传个性化数据:编码失败";
		case UPLOAD_USER_DATA_TOO_FAST:						return "上传个性化数据:上传过于频繁";		
		
		case UPLOAD_SCENE_DATA_SERVER_REFUSED:				return "上传场景数据:服务器拒绝";
		case UPLOAD_SCENE_DATA_NETWORK_ERROR:				return "上传场景数据:网络连接失败";
		case UPLOAD_SCENE_DATA_EMPTY:						return "上传场景数据:不能为空";
		case UPLOAD_SCENE_TOO_LARGE:						return "上传场景数据:内容太多";
		case UPLOAD_SCENE_ENCODE_ERROR:						return "上传场景数据:编码失败";
		case UPLOAD_SCENE_DATA_TOO_FAST:					return "上传场景数据:上传过于频繁";
		case UPLOAD_SCENE_GENERAL_ERROR:                    return "上传场景数据:常见错误";
		case UPLOAD_SCENE_INVALID_KEY:                      return "上传场景数据无效的AppKey";
		case UPLOAD_SCENE_STREAM_IO_ERR:                    return "上传场景数据上传的数据流异常";
		case UPLOAD_SCENE_UNKNOWN_ERR:                      return "上传场景数据未知异常";
		case UPLOAD_SCENE_DATA_SIZE_IS_FORBIDDEN:           return "上传场景数据上传的数据体积异常";
		case UPLOAD_SCENE_INVALID_VER:                      return "上传场景数据无效的SDK版本号";
		case NLU_SERVER_ERROR:                              return "语义理解: 语义服务器访问失败";
		case NLU_REQUEST_EMPTY:                             return "语义理解:语义请求为空";
		
		case JniUscClient.ASRCLIENT_INIT_ERROR:     return "初始化错误";
		case JniUscClient.ASRCLIENT_NOT_INIT_ERROR:   return "未初始化错误";
		case JniUscClient.ASRCLIENT_REQ_INIT_ERROR:  return "请求初始化错误";
		case JniUscClient.ASRCLIENT_NETWORK_ERROR:  return "网络错误";
		case JniUscClient.ASRCLIENT_HTTP_REQ_ERROR:  return "HTTP 协议错误";
		case JniUscClient.ASRCLIENT_DECODE_ERROR:  return "解码错误";
		
		case JniUscClient.ASRCLIENT_APPKEY_ERROR:  return "无效的AppKey";
		
		}
		return null;
	}
	
	
	public String getMessage(int code) {

		String msg = toMessage(code);
		if(msg != null) {
			return msg;
		}
		return "错误:" + code;
	}
	

	
	public int toProfession(int code){
		
		return code;
	}

	public USCError createProfessionError(int error){
		
		if(error == 0){
			return null;
		}
		

		int code = toProfession(error);		
		return new USCError(error, getMessage(code) );
	}
	
	public USCError createPremiumError(int code) {
		
		if(code == 0){
			return null;
		}
		
		int c = toProfession(code);		
		return new USCError(code, getMessage(c) );
	}
	
	
	public USCError createBasicError(int code) {
		
		if(code == 0){
			return null;
		}
		
		code = toProfession(code);		
		return new USCError(code, getMessage(code) );
	}

	public static USCError createOralError(int code){
		
		switch(code){
		
		case FAILED_START_RECORDING:
			return new USCError(code, "启动录音失败");
		case RECORDING_EXCEPTION:
			return new USCError(code, "录音异常");
			
			
		case JniUscClient.ASRCLIENT_COMPRESS_PCM_ERROR:	
			return new USCError(code, "数据压缩错误");
			

			
		case JniUscClient.ASRCLIENT_MAX_SPEECH_TIMEOUT:	
			return new USCError(code, "说话时间超出限制");	
			
		case RECOGNITION_EXCEPTION:		
			return new USCError(code, "识别异常");
			
		default:
			return new USCError(-10001, "服务器连接错误");	
		
		}
	}
}