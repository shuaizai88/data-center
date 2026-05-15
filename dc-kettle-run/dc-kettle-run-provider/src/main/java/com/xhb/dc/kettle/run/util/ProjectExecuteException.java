package com.xhb.dc.kettle.run.util;


import com.xhb.dc.kettle.run.server.trans.TransExecutor;

/**
 * 项目执行异常.
 *
 * @author gavin
 * @since 2020/9/2 2:26 下午
 */
public class ProjectExecuteException extends Exception {

    private final TransExecutor transExecutor;

    public ProjectExecuteException(TransExecutor transExecutor) {
        this.transExecutor = transExecutor;
    }

    public TransExecutor getTransExecutor() {
        return transExecutor;
    }
}
