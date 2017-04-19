package cn.baochao.model;

/**
 * Created by huangbc on 2017/4/19.
 */
public class JdPrice {

    private String skuId;

    private String jdPrice;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getJdPrice() {
        return jdPrice;
    }

    public void setJdPrice(String jdPrice) {
        this.jdPrice = jdPrice;
    }

    @Override
    public String toString() {
        return "JdPrice{" +
                "skuId='" + skuId + '\'' +
                ", jdPrice='" + jdPrice + '\'' +
                '}';
    }
}
