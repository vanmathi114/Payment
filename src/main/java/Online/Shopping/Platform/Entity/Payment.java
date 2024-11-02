package Online.Shopping.Platform.Entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class Payment {
    private String id;
    private Double amount;
    private String currency;
}
