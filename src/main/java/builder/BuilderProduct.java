package builder;

public class BuilderProduct implements IBuilder {
    private Product product = new Product();

    @Override
    public Product composite() {
        return product;
    }

    @Override
    public void createEntiy1() {
        product.setEntiy1(new Entiy1());
    }

    @Override
    public void createEntiy2() {
        product.setEntiy2(new Entiy2());
    }

    @Override
    public void createEntiy3() {
        product.setEntiy3(new Entiy3());
    }
}
