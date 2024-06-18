public class ProductDto {
    public double priceAfterDiscount;
//    public double priceWithoutDiscount;
    public String manufacturer;
    public String productName;

    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto comparableDto = (ProductDto) o;

        return this.priceAfterDiscount == comparableDto.priceAfterDiscount &&
                this.manufacturer.equals(comparableDto.manufacturer) && this.productName.equals(comparableDto.productName);
    }

}
