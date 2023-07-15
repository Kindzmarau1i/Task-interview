package dto;

public class Categories {
    private Integer categoryID;
    private String categoryName;
    private Extra extra;

    public Categories(Integer categoryID, String categoryName, Extra extra) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.extra = extra;
    }

    public static CategoriesBuilder builder() {
        return new CategoriesBuilder();
    }

    public static class CategoriesBuilder {
        private Integer categoryID;
        private String categoryName;
        private Extra extra;

        public CategoriesBuilder categoryID(Integer categoryID) {
            this.categoryID = categoryID;
            return this;
        }

        public CategoriesBuilder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public CategoriesBuilder extra(Extra extra) {
            this.extra = extra;
            return this;
        }

        public Categories build() {
            return new Categories(categoryID, categoryName, extra);
        }

    }
}
