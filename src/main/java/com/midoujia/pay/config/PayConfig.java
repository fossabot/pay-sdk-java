package com.midoujia.pay.config;

import java.util.Objects;

/**
 * @author zfldiv@163.com
 */
public class PayConfig {

    /**
     * 支付完成后的异步通知地址.
     */
    private String notifyUrl;

    /**
     * 支付完成后的同步返回地址.
     */
    private String returnUrl;

    /**
     * 默认非沙箱测试
     */
    private boolean sandbox = false;

    public boolean isSandbox() {
        return sandbox;
    }

    public void setSandbox(boolean sandbox) {
        this.sandbox = sandbox;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public void check() {
        Objects.requireNonNull(notifyUrl, "config param 'notifyUrl' is null.");
        if (!notifyUrl.startsWith("http") && !notifyUrl.startsWith("https")) {
            throw new IllegalArgumentException("config param 'notifyUrl' does not start with http/https.");
        }
        if (notifyUrl.length() > 256) {
            throw new IllegalArgumentException("config param 'notifyUrl' is incorrect: size exceeds 256.");
        }
        if (returnUrl != null) {
            if (!returnUrl.startsWith("http") && !returnUrl.startsWith("https")) {
                throw new IllegalArgumentException("config param 'returnUrl' does not start with http/https.");
            }
            if (returnUrl.length() > 256) {
                throw new IllegalArgumentException("config param 'returnUrl' is incorrect: size exceeds 256.");
            }
        }
    }


}
