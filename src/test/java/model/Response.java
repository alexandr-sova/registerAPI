package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("Result")
    private Boolean result;

    @JsonProperty("Details")
    private String details;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean Result) {
        this.result = Result;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String Details) {
        this.details = Details;
    }
}


