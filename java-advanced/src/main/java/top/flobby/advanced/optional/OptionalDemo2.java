package top.flobby.advanced.optional;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-29 00:47
 **/

public class OptionalDemo2 {
    static class Category {
        private String name;

        public Category(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Goods {
        private String name;

        private Category category;

        public Goods() {

        }

        public Goods(String name, Category category) {
            this.name = name;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return "Good{" +
                    "name='" + name + '\'' +
                    ", category=" + category +
                    '}';
        }
    }

    /**
     * 获取商品的分类名称
     * @param goods 商品
     * @return 分类名称
     */
    // static String getGoodsCategoryName(Goods goods) {
    //     return goods.getCategory().getName();
    // }
    static String getGoodsCategoryName(Goods goods) {
        if (goods != null) {
            Category category = goods.getCategory();
            if (category != null) {
                return category.getName();
            }
        }
        return "该商品无分类";
    }

    public static void main(String[] args) {
        // 实例化一个商品类
        Goods goods = new Goods();
        // 获取商品的分类名称
        String categoryName = getGoodsCategoryName(goods);
        System.out.println(categoryName);
    }
}
