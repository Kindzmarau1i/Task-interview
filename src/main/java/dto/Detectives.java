package dto;

import java.util.List;

public class Detectives {
    private Integer mainId;
    private String firstName;
    private String lastName;
    private Boolean violinPlayer;
    private List<Categories> categories;

    public Detectives(Integer mainId, String firstName, String lastName, Boolean violinPlayer, List<Categories> categories) {
        this.mainId = mainId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.violinPlayer = violinPlayer;
        this.categories = categories;
    }

    public static DetectiveBuilder builder() {
        return new DetectiveBuilder();
    }

    public static class DetectiveBuilder {
        private Integer mainId;
        private String firstName;
        private String lastName;
        private Boolean violinPlayer;
        private List<Categories> categories;

        public DetectiveBuilder mainId(Integer mainId) {
            this.mainId = mainId;
            return this;
        }

        public DetectiveBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public DetectiveBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public DetectiveBuilder violinPlayer(Boolean violinPlayer) {
            this.violinPlayer = violinPlayer;
            return this;
        }

        public DetectiveBuilder categories(List<Categories> categories) {
            this.categories = categories;
            return this;
        }

        public Detectives build() {
            return new Detectives(mainId, firstName, lastName, violinPlayer, categories);
        }
    }
}
