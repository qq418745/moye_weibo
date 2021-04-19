package top.moyeye.bean.common;

import lombok.Data;

/**
 * 通用返回类
 * @param <T>
 */
@Data
public class CommonResult<T> {

    private static int SUCCESS_CODE = 0;
    private static int ERROR_CODE = -1;
    private static String OK = "ok";
    private static String ERR = "err";

    /**
     * 返回code，0为正常
     */
    private Integer code = SUCCESS_CODE;

    /**
     * 错误信息描述
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult(SUCCESS_CODE, OK);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult(SUCCESS_CODE, "", data);
    }

    public static <T> CommonResult<T> failed(Integer code, String msg) {
        return new CommonResult(code, msg);
    }

    public static <T> CommonResult<T> failed(String msg) {
        return new CommonResult(ERROR_CODE, msg);
    }
    public static CommonResult failed(Integer code) {
        return new CommonResult(code, "");
    }

    public static <T> CommonResult<T> failed() {
        return new CommonResult(ERROR_CODE, ERR);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
