package com.christ.android_mvvm.model;

import java.util.List;

public class Famous {
    private String total;
    private List<Result> result;
    private String error_code;
    private String reason;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public class Result{
        private String famous_name;
        private String famous_saying;

        public String getFamous_name() {
            return famous_name;
        }

        public void setFamous_name(String famous_name) {
            this.famous_name = famous_name;
        }

        public String getFamous_saying() {
            return famous_saying;
        }

        public void setFamous_saying(String famous_saying) {
            this.famous_saying = famous_saying;
        }
    }
}
