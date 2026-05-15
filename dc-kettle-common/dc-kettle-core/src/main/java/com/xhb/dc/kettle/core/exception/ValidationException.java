package com.xhb.dc.kettle.core.exception;

import com.xhb.dc.kettle.core.util.StatusCode;
import org.springframework.http.HttpStatus;

/**
 * 参数以及数据格式校验异常.
 *
 * @author renhua.zhang
 * @since 2017-10-27 16:13
 */
public class ValidationException extends DpException {

    public ValidationException(final String statusCode, final String message) {
        super(statusCode, message);
    }

    public ValidationException(final StatusCode statusCode, final String message) {
        super(statusCode.getCode(), message);
    }

    public ValidationException(final String statusCode, final String message, final HttpStatus httpStatus) {
        super(statusCode, message, httpStatus);
    }

    public ValidationException(final String statusCode, final String message, final Throwable cause) {
        super(statusCode, message, cause);
    }
}
