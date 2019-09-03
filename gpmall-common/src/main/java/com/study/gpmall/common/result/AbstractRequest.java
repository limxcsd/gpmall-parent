package com.study.gpmall.common.result;

import java.io.Serializable;

/**
 * @ClassName: AbstractRequest
 * @Description: 抽象请求封装
 * @author: limingxing
 * @Date: 2019-08-20 15:09
 */

public abstract class AbstractRequest implements Serializable {
    private static final long serialVersionUID = -5272665115777955631L;

    /**
     * 请求校验
     */
    public abstract void requestCheck();

    @Override
    public String toString() {
        return "AbstractRequest{}";
    }
}
