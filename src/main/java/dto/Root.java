package dto;

import java.util.List;

public class Root{
    private final List<Detectives> detectives;
    private final Boolean success;

    public Root(List<Detectives> detectives, Boolean success) {
        this.detectives = detectives;
        this.success = success;
    }

    public static RootBuilder builder() {
        return new RootBuilder();
    }

    public static class RootBuilder {
        private List<Detectives> detectives;
        private Boolean success;

        public RootBuilder detectives(List<Detectives> detectives) {
            this.detectives = detectives;
            return this;
        }

        public RootBuilder success(Boolean success) {
            this.success = success;
            return this;
        }

        public Root build() {
            return new Root(detectives, success);
        }
    }
}