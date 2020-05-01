package me.surendra.learning.spring.boot.hello.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonAutoDetect
public final class ModelResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String response;

    private List<String> messages = Lists.newArrayList();

    private final boolean success;

    private ModelResponse(final String response, final boolean success) {
        this.response = response;
        this.success = success;
    }

    private ModelResponse(final String response) {
        this.response = response;
        this.success = true;
    }

    public static ModelResponse ok() {
        return new ModelResponse("OK", true);
    }

    public static ModelResponse failed() {
        return new ModelResponse("FAILED", false);
    }

    public static ModelResponse failed(final String message) {
        final ModelResponse failed = new ModelResponse("FAILED", false);
        failed.setMessages(Lists.newArrayList(message));
        return failed;
    }

    public static ModelResponse failed(final List<String> messages) {
        final ModelResponse failed = new ModelResponse("FAILED", false);
        failed.setMessages(messages);
        return failed;
    }

    @JsonCreator
    public static ModelResponse create(@JsonProperty("name") final String name) {
        return new ModelResponse(name);
    }

    public String getResponse() {
        return response;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(final List<String> messages) {
        this.messages = messages;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelResponse)) return false;
        final ModelResponse that = (ModelResponse) o;
        return isSuccess() == that.isSuccess() &&
            Objects.equals(getResponse(), that.getResponse()) &&
            Objects.equals(getMessages(), that.getMessages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResponse(), getMessages(), isSuccess());
    }

    @Override
    public String toString() {
        return "ModelResponse{" +
            "response='" + response + '\'' +
            ", messages=" + messages +
            ", success=" + success +
            '}';
    }
}
