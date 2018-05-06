package builder;

public class Director {
    private IBuilder builder;

    public Director(IBuilder builder) {
        this.builder = builder;
    }

    // 指挥生成对象的步骤与细节
    public Product create() {
        builder.createEntiy1();
        builder.createEntiy3();
        builder.createEntiy2();
        return builder.composite();
    }


}
