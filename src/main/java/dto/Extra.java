package dto;

import java.util.List;

public class Extra{
    private List<ExtraArray> extraArray;

    public Extra(List<ExtraArray> extraArray) {
        this.extraArray = extraArray;
    }

    public static ExtraBuilder builder() {
        return new ExtraBuilder();
    }

    public static class ExtraBuilder {
        private List<ExtraArray> extraArray;

        public ExtraBuilder extraArray(List<ExtraArray> extraArray) {
            this.extraArray = extraArray;
            return this;
        }

        public Extra build() {
            return new Extra(extraArray);
        }
    }
}