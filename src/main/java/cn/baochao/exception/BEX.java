package cn.baochao.exception;

/**
 * Created by huangbc on 2017/3/11.
 */
public class BEX extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 2332608236621015980L;

    private String code;

    public BEX() {
        super();
    }

    public BEX(String message) {
        super(message);
    }

    public BEX(String code, String message) {
        super(message);
        this.code = code;
    }

    public BEX(Throwable cause) {
        super(cause);
    }

    public BEX(String message, Throwable cause) {
        super(message, cause);
    }

    public BEX(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
