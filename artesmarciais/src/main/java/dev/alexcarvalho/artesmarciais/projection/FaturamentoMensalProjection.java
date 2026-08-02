package dev.alexcarvalho.artesmarciais.projection;

import java.math.BigDecimal;

public interface FaturamentoMensalProjection {

    String getMes();
    BigDecimal getTotal();
}
