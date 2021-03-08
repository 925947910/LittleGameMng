package com.cointer.constant;

public interface StatusCode {

	int								FAILED		= 1;
	int								SUCC	         = 200;
	int								SIGN_ERROR	     = 201;
	int								GEN_ORDER_FAILED = 202;
	int								ORDER_REPEAT = 203;
	int								ORDER_ACC_ERROR = 204;
	int								CHARGE_COIN_ERROR = 205;
	int								FREEZE_FAILED = 206;
	int							    EXTRACT_FAILED = 207;
	int								COIN_NO_ENOUGH = 208;
	int								ORDER_QUERY_ERROR = 209;
	int							    CHECKFREEZE_ERROR = 210;
	int								EXTRACT_PWD_ERROR = 211;
	int								PHONE_OR_EMAIL_ERROR = 212;
	int							    SET_EXTRACT_PWD_ERROR = 213;
	int							    EXTRACT_IN_GAME = 214;
	int								LOGIN_AUTH_FAILED	= 215;
	int							    REGIST_FAILED	= 216;
	int								EXTRACT_OUT_LIMIT	= 217;
	int								NO_LOGIN		= 218;
	int								GEN_REMOTE_ORDER_FAILED = 219;
	int								ORDER_NOEXSIST = 220;
	int								DEAL_FAILED = 221;
	int								TRANS_ERROR = 222;
	int								LAID_FAILED = 223;
	int								GET_DRAW_FAILED = 224;
}
