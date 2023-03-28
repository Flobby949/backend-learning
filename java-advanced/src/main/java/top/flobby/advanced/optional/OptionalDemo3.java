package top.flobby.advanced.optional;

import java.util.Optional;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-29 00:47
 **/

public class OptionalDemo3 {
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
     * 获取商品的分类名称（使用 Optional 类包装）
     * @param goods 商品
     * @return 分类名称
     */
    static String getGoodsCategoryName(Goods goods) {
        // 将商品实例包装入 Optional 类，创建 Optional<Goods> 对象
        Optional<Goods> goodsOptional = Optional.ofNullable(goods);
        Goods goods1 = goodsOptional.orElse(new Goods("默认商品", new Category("默认分类")));
        // 此时 goods1 一定是非空，不会产生空指针异常
        Category category = goods1.getCategory();

        // 将分类实例包装入 Optional 类，创建 Optional<Category> 对象
        Optional<Category> categoryOptional = Optional.ofNullable(category);
        Category category1 = categoryOptional.orElse(new Category("默认分类"));
        // 此时 category1 一定是非空，不会产生空指针异常
        return category1.getName();
    }

    public static void main(String[] args) {
        // 实例化一个商品类
        Goods goods = null;
        // 获取商品的分类名称
        String categoryName = getGoodsCategoryName(goods);
        System.out.println(categoryName);
    }
}
