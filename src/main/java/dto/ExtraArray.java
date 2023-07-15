package dto;

public class ExtraArray{
    private Integer violin;
    private Integer cap;

    public ExtraArray(Integer violin, Integer cap) {
        this.violin = violin;
        this.cap = cap;
    }

    public static ExtraArrayBuilder builder() {
        return new ExtraArrayBuilder();
    }

    public static class ExtraArrayBuilder {
        private Integer violin;
        private Integer cap;

        public ExtraArrayBuilder violin(Integer violin) {
            this.violin = violin;
            return this;
        }

        public ExtraArrayBuilder cap(Integer cap) {
            this.cap = cap;
            return this;
        }

        public ExtraArray build() {
            return new ExtraArray(violin, cap);
        }
    }
}
